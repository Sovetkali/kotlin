fun main() {
    // write your code here
    val number = readln().toInt()
    var list = mutableListOf<Int>()
    var tmp: Int
    var maxNum = 0
    var maxNumIndex = 0

    for (i in 0..number - 1) {
        tmp = readln().toInt()
        list.add(tmp)
    }

    for (i in 0..number - 1) {
        if (list[i] > maxNum) {
            maxNum = list[i]
            maxNumIndex = i
        }
    }

    println(maxNumIndex)
}