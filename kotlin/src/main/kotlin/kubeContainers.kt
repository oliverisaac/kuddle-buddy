import io.fabric8.kubernetes.api.model.*
import io.fabric8.kubernetes.client.ConfigBuilder
import io.fabric8.kubernetes.client.DefaultKubernetesClient


data class kubeContainersRow(
    val namespace: String,
    val pod: String,
    val container: String,
    val ready: Boolean,
    val isInitContainer: Boolean,
    val state: String,
    val restartCount: Int,
)

fun List<kubeContainersRow>.toTable(): List<List<String>> {
    return listOf(
        listOf<String>(
            "namespace",
            "pod",
            "container",
            "ready",
            "state",
            "restarts",
        ).map{
            it.capitalize()
        }
    ) +
            this.map {
                with(it) {
                    listOf<String>(
                        namespace,
                        pod,
                        container,
                        if (isInitContainer) "init" else ready.toString(),
                        state,
                        restartCount.toString(),
                    )
                }
            }
}

fun getContainerState(status: ContainerState?): String {
    if (status == null) {
        return "n/a"
    } else if (status.terminated != null) {
        val reason = status.terminated.reason
        val exitCode = status.terminated.exitCode
        return "$reason($exitCode)"
    } else if (status.running != null) {
        return "Running"
    }
    return "unknown"
}

fun getContainerStatuses(
    isInit: Boolean,
    containers: List<Container>,
    statuses: List<ContainerStatus>
): List<kubeContainersRow> {
    return containers.map { container: Container ->
        val containerStatus = statuses
            .orEmpty()
            .filter { status -> status.name == container.name }
            .firstOrNull()

        kubeContainersRow(
            namespace = "",
            pod = "",
            container = container.name,
            ready = containerStatus?.ready ?: false,
            isInitContainer = isInit,
            state = getContainerState(containerStatus?.state),
            restartCount = containerStatus?.restartCount ?: -1,
        )
    }
}

class kubeContainers {
    companion object {
        @JvmStatic
        fun Parse(input: String): List<kubeContainersRow> {
            val kubeConfig = ConfigBuilder().build()
            val client = DefaultKubernetesClient(kubeConfig)
            val inputList = client.lists().load(input.byteInputStream()).get()

            return inputList?.items
                .orEmpty()
                .filter { item -> item is Pod }
                .map { it as Pod }
                .flatMap { pod: Pod ->
                    val statuses = getContainerStatuses(
                        true,
                        pod.spec.initContainers,
                        pod.status.initContainerStatuses
                    ) + getContainerStatuses(false, pod.spec.containers, pod.status.containerStatuses)
                    statuses.map {
                        it.copy(
                            namespace = pod.metadata?.namespace.orEmpty(),
                            pod = pod.metadata?.name.orEmpty(),
                        )
                    }
                }
        }
    }
}