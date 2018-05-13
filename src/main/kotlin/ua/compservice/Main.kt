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

    }
}