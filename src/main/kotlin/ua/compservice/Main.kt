package ua.compservice

val data = (1..100).toMutableList()

enum class Orientation {
    HORIZONTAL,
    VERTICAL
}

data class Layout(var orientation: Orientation)


object Main {

    @JvmStatic
    fun main(args: Array<String>) {

        data.filter { it % 2 == 0 }
                .forEach { println(it) }


        val oldLayout = Layout(Orientation.HORIZONTAL)

        println(oldLayout)

        val newLayout = oldLayout.apply {
            orientation = Orientation.VERTICAL
        }

        println(newLayout)

        val source = "The quick brown fox"
        val expected = "Hetay uickqay rownbay oxfay"

        val target = source.split(" ")
                .map { EnglishToPig.encode(it) }
                .joinToString(separator = " ")

        assert(expected.toLowerCase() == target.toLowerCase(), {"$expected == $target. Should be equal"})





    }
}