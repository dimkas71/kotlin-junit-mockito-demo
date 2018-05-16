package ua.compservice

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

@DisplayName("A bunch of tests for better understanding nullable in kotlin")
@Tag("Active")
class NullableSafetyTest {

    @Test
    fun `when ask for any property or call any method on the null string then null should be returned`() {
        var aString: String? = "A string"
        aString = null

        Assertions.assertAll(
            Executable { Assertions.assertEquals(null, aString?.length, {"should be null"}) },
            Executable { Assertions.assertEquals(null, aString?.get(0), {"should be null"})}
        )
    }

    @Test
    fun `when call a method on a nullable string then default value should be returned`() {
        var str: String? = "something"
        str = null

        val expected = 'a'

        Assertions.assertEquals(expected, str?.get(0) ?: expected)
    }
}