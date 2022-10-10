import java.util.*

fun main() {
    // put your code here
    var num = 0
    var sum = 0

    do {
       num = readln().toInt()
       sum += num
    } while (num !=0)

    println(sum)

}