fun main() {
    // put your code here
    val str = readln()

    for (i in 0 until str.length) {
        if (str[i].isDigit()) {
            print(str[i])
            break
        }
    }

}