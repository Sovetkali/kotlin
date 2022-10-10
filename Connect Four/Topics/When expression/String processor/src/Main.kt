fun main() {
    // write your code here
    val str1 = readln()
    val operator = readln()
    val str2 = readln()

    when (operator) {
        "equals" -> print((str1 == str2))
        "plus" -> print(str1 + str2)
        "endsWith" -> print(str1.contains(str2))
        else -> print("Unknown operation")
    }

}