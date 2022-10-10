fun main() {
    // put your code here
    val squirel = readln().toInt()
    val nuts = readln().toInt()
    val portionEachSquirel = nuts % squirel
    println(portionEachSquirel)
}
