package ua.compservice

import org.junit.jupiter.api.*
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("Calculator test")
class CalculatorTest {

    private val squaresTestData = listOf(
            1 to 1,
            2 to 4,
            3 to 9,
            4 to 16,
            5 to 25
    )

    @Test
    fun `2 + 2  should b equal 4`() {
        Assertions.assertEquals(4, Calculator.add(2, 2), {"Should be equal 4"})
    }

    @Test
    fun `when dividing by 0 then exception occurs`() {
        val exception = Assertions.assertThrows(ArithmeticException::class.java) {
            Calculator.div(4, 0)
        }
        Assertions.assertEquals("/ by zero", exception.message)
    }

    @Test
    fun `when squaring numbers then correct answer given`() {
        Assertions.assertAll(
                Executable { Assertions.assertEquals(1, Calculator.square(1), {" 1 * 1 should be equal 1 but "}) },
                Executable { Assertions.assertEquals(4, Calculator.square(2), {" 2 * 2 should be equal 4 but "}) },
                Executable { Assertions.assertEquals(9, Calculator.square(3), {" 3 * 3 should be equal 9 but "}) }
        )
    }

    @Test
    fun `when empty list then list is empty`() {
        val list = listOf<String>()

        Assertions.assertTrue(list::isEmpty)
    }

    @TestFactory
    fun `test factory methods and dynamic testing`() = listOf(
        DynamicTest.dynamicTest("when calculate 1^2 then 1 should be the result", {Assertions.assertEquals(1, Calculator.square(1))}),
        DynamicTest.dynamicTest("when calculate 2^2 then 4 should be the result", {Assertions.assertEquals(4, Calculator.square(2))}),
        DynamicTest.dynamicTest("when calculate 3^3 then 9 should be the result", {Assertions.assertEquals(9, Calculator.square(3))})

    )

    @TestFactory
    fun `test squares`() = listOf(
          1 to 1,
          2 to 4,
          3 to 9,
          4 to 16,
          5 to 25)
         .map { (input, expected) ->
               DynamicTest.dynamicTest("when I calculate $input^2 then I get $expected") {
                   Assertions.assertEquals(expected, Calculator.square(input))
         }
    }

    @TestFactory
    fun `test square root`() = squaresTestData
            .map { (expected, input) ->
                DynamicTest.dynamicTest("when square of $input then $expected shoud be as result", {
                    Assertions.assertEquals(expected, Calculator.squareRoot(input))
                })
            }


    @ParameterizedTest
    @MethodSource("squares")
    fun `test squares`(input: Int, expected: Int) {
        Assertions.assertEquals(expected, Calculator.square(input))
    }

    @ParameterizedTest
    @CsvSource("1;1", "2;4", "3;9", delimiter = ';')
    fun `test squares with csv source example`(input: Int, expected: Int) {
        Assertions.assertEquals(expected, input * input)
    }


    companion object {
        @JvmStatic
        fun squares() = listOf(
                Arguments.of(1, 1),
                Arguments.of(2, 4)
        )
    }
}