fun main() {
    // write your code here
    val house = readln()

    when (house) {
        "gryffindor" -> print("bravery")
        "hufflepuff" -> print("loyalty")
        "slytherin" -> print("cunning")
        "ravenclaw" -> print("intellect")
        else -> print("not a valid house")
    }
}