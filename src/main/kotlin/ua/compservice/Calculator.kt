package ua.compservice

class Calculator {
    companion object {

        fun add(a: Int, b: Int): Int = a + b

        fun sub(a: Int, b: Int): Int = a - b

        fun mul(a: Int, b: Int): Int = a * b

        fun div(a: Int, b: Int): Int = a / b

        fun square(a: Int): Int = a * a
        fun squareRoot(a: Int): Int = Math.sqrt(a.toDouble()).toInt()
    }
}