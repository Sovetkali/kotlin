fun main() {
    // Do not touch code below
    val inputList: MutableList<MutableList<String>> = mutableListOf()
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val strings = readLine()!!.split(' ').toMutableList()
        inputList.add(strings)
    }
    // write your code here
    println("${inputList[0][0]} ${inputList[0][inputList[0].size-1]}")
    println("${inputList[n-1][0]} ${inputList[n-1][inputList[n-1].size-1]}")
}