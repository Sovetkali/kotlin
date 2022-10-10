import kotlin.math.abs

fun main() {
    val (xOne, yOne) = readln().split(" ")
    val (xTwo, yTwo) = readln().split(" ")
    
    val val1 = Math.abs(xOne.toInt() - xTwo.toInt())
    val val2 = Math.abs(yOne.toInt() - yTwo.toInt())
    
    println(
        if (val1 == 1 && val2 == 2) {
            "YES"
        } else if (val1 == 2 && val2 == 1) {
            "YES"
        } else {
            "NO"
        }
    )
}
