fun main() {
    // write your code here
    val listSize = readln().toInt()
    val listOfNumbers = mutableListOf<Int>()

    repeat(listSize) {
        listOfNumbers.add(readln().toInt())
    }

    val searchingNumber = readln().toInt()
    var isSearchingNum: Boolean = false
    
    for (i in 0..listSize - 1) {
        if (listOfNumbers[i] == searchingNumber) {
            isSearchingNum = true
        }
    }

    if (isSearchingNum == true) {
        print("YES")
    } else {
        print("NO")
    }
}
