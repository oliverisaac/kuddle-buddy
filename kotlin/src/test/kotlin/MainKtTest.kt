import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MainKtTest {
    @Test
    fun testXToContext() {
        val input = listOf<String>("-x")
        val output = FlagParser.setContextFlag(input)
        assertEquals(
            "--context",
            output[0]
        )
    }

    @Test
    fun testXToContextRandomPos() {
        val input = listOf<String>("-n", "example", "-x", "bob")
        var expected = input.toMutableList()
        expected[2] = "--context"

        val output = FlagParser.setContextFlag(input)
        assertArrayEquals(expected.toTypedArray(), output.toTypedArray())
    }

    @Test
    fun testMultipleContextFlagsShouldOnlyChangeFirst() {
        val input = listOf<String>("-x", "example", "-x", "example2")
        var expected = input.toMutableList()
        expected[0] = "--context"

        val output = FlagParser.setContextFlag(input)
        assertArrayEquals(expected.toTypedArray(), output.toTypedArray())
    }

    @Test
    fun testDoubleDashToStopParsing() {
        val input = listOf<String>("-n", "example", "--", "-x", "example2")

        val output = FlagParser.setContextFlag(input)
        assertArrayEquals(input.toTypedArray(), output.toTypedArray())
    }

    @Test
    fun testSingleRowSingleColumn(){
        val input = listOf<List<String>>(
            listOf<String>("a")
        )
        val expected = "a"
        assertEquals(expected, input.generateTable())
    }

    @Test
    fun testDoubleRowSingleColumn(){
        val input = listOf<List<String>>(
            listOf<String>("a"),
            listOf<String>("b")
        )
        val expected = "a\nb"
        assertEquals(expected, input.generateTable())

        val variedInput = listOf<List<String>>(
            listOf<String>("cat"),
            listOf<String>("b")
        )
        val variedExpected = "cat\nb"
        assertEquals(variedExpected, variedInput.generateTable())
    }

    @Test
    fun testMultipleColumns(){
        val input = listOf<List<String>>(
            listOf<String>("a", "a"),
            listOf<String>("b", "b")
        )
        val expected = "a a\nb b"
        assertEquals(expected, input.generateTable())

        val variedInput = listOf<List<String>>(
            listOf<String>("cat", "a"),
            listOf<String>("b", "bat")
        )
        val variedExpected = """
            cat a
            b   bat
        """.trimIndent()
        assertEquals(variedExpected, variedInput.generateTable())
    }
}