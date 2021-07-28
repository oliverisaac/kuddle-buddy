import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class kubeContainersTest {
    @Test
    fun testEmpty() {
        val input = ""
        val containerList = kubeContainers.Parse(input)
        val expected = listOf<kubeContainersRow>()
        assertArrayEquals(expected.toTypedArray(), containerList.toTypedArray())
    }

    @Test
    fun testOneContainer() {
        val expected = listOf<kubeContainersRow>(
            kubeContainersRow(
                namespace = "bitbucket-backup",
                pod = "bitbucket-backup-cronjob-1627160820-6fwwh",
                container = "cronjob",
                ready = false,
                isInitContainer = false,
                state = "Error(1)",
                restartCount = 0
            ),
            kubeContainersRow(
                namespace = "bitbucket-backup",
                pod = "bitbucket-backup-cronjob-1627160820-7ljsw",
                container = "cronjob",
                ready = false,
                isInitContainer = false,
                state = "Error(1)",
                restartCount = 0
            ),

            kubeContainersRow(
                namespace = "vault-cloudssl",
                pod = "vault-cloudssl-1627192800-v4zcp",
                container = "cloudssl",
                ready = false,
                isInitContainer = false,
                state = "Completed(0)",
                restartCount = 0
            ),
            kubeContainersRow(
                namespace = "vault-cloudssl",
                pod = "vault-cloudssl-1627214400-x29sc",
                container = "cloudssl",
                ready = false,
                isInitContainer = false,
                state = "Completed(0)",
                restartCount = 0
            ),
            kubeContainersRow(
                namespace = "vault-cloudssl",
                pod = "vault-cloudssl-1627236000-w6fsk",
                container = "cloudssl",
                ready = false,
                isInitContainer = false,
                state = "Completed(0)",
                restartCount = 0
            ),

            kubeContainersRow(
                namespace = "velero",
                pod = "velero-bbfcdb6b8-bf5vg",
                container = "vault-agent-init",
                ready = true,
                isInitContainer = true,
                state = "Completed(0)",
                restartCount = 0
            ),
            kubeContainersRow(
                namespace = "velero",
                pod = "velero-bbfcdb6b8-bf5vg",
                container = "velero-plugin-for-gcp",
                ready = true,
                isInitContainer = true,
                state = "Completed(0)",
                restartCount = 0
            ),
            kubeContainersRow(
                namespace = "velero",
                pod = "velero-bbfcdb6b8-bf5vg",
                container = "velero",
                ready = true,
                isInitContainer = false,
                state = "Running",
                restartCount = 46
            ),
        )

        val containerList = kubeContainers.Parse(exampleKubeContainersYAML)

        assertArrayEquals(expected.toTypedArray(), containerList.toTypedArray())
    }
}