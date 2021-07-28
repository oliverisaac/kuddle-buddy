import org.apache.log4j.*;

import java.io.IOException
import java.util.concurrent.TimeUnit

object FlagParser {
    fun setContextFlag(args: List<String>): List<String> {
        var set = mutableMapOf<String, Boolean>()
        var endOfArgs: Boolean = false

        fun getSwapper(orig: String, new: String): (String) -> String {
            return swapper@{ flag ->
                if (endOfArgs || flag == "--") {
                    endOfArgs = true
                    return@swapper flag
                } else if (flag == orig && !set.containsKey(orig)) {
                    set[orig] = true
                    return@swapper new
                } else {
                    return@swapper flag
                }
            }
        }

        return args.map(
            getSwapper("-x", "--context")
        )
    }
}

fun runKubectl(args: List<String>) {
    val parts = listOf<String>("kubectl", *args.toTypedArray())
    ProcessBuilder(*parts.toTypedArray())
        .redirectOutput(ProcessBuilder.Redirect.INHERIT)
        .redirectError(ProcessBuilder.Redirect.INHERIT)
        .start()
        .waitFor(60, TimeUnit.MINUTES)
}

fun runKubectlAndGetOutput(args: List<String>): String? {
    try {
        val parts = listOf<String>("kubectl") + args
        val proc = ProcessBuilder(*parts.toTypedArray())
            .redirectOutput(ProcessBuilder.Redirect.PIPE)
            .redirectError(ProcessBuilder.Redirect.PIPE)
            .start()

        proc.waitFor(60, TimeUnit.MINUTES)
        return proc.inputStream.bufferedReader().readText()
    } catch (e: IOException) {
        e.printStackTrace()
        return null
    }
}

fun List<List<Any>>.generateTable(): String {
    var maxColumns = this.maxOf {
        it.count()
    }

    // Find the maximum length of a string in each column
    var lengths = IntArray(maxColumns)
    for (row in 0 until this.count()) {
        for (col in 0 until this[row].count()) {
            lengths[col] = Math.max(this[row][col].toString().length, lengths[col])
        }
    }

    val formats = lengths
        .mapIndexed { colNum, lineLength ->
            "%-${lineLength}s  "
        }

    // Print 'em out
    return this.map { row ->
        row.mapIndexed { j, col ->
            formats[j].format(col.toString())
        }.joinToString("").trimEnd()
    }.joinToString("\n")
}

fun String.print() {
    println(this)
}

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            BasicConfigurator.configure()
            Logger.getRootLogger().level = Level.WARN

            val normalizedArgs = FlagParser.setContextFlag(args.toList())
            if (normalizedArgs[0] == "containers") {
                val containerArgs = listOf<String>(
                    "get",
                    "pods",
                    *normalizedArgs.subList(1, normalizedArgs.count()).toTypedArray(),
                    "--output=json"
                )
                val output = runKubectlAndGetOutput(containerArgs).orEmpty()
                kubeContainers.Parse(output).toTable().generateTable().print()
            } else {
                runKubectl(normalizedArgs)
            }
        }
    }
}
