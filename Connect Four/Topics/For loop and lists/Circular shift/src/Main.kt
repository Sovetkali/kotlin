fun main() {
    // write your code here
    val number = readln().toInt()
    val listOfNumbers = mutableListOf<Int>()

    for (i in 0..number - 1) {
        listOfNumbers.add(readln().toInt())
    }

    var buffer = listOfNumbers[0]
    var tmp = 0

    for (i in 1..listOfNumbers.size - 1) {
        if (i != listOfNumbers.size - 1) {
            tmp = listOfNumbers[i]
            listOfNumbers[i] = buffer
            buffer = tmp    
        } else {
            tmp = listOfNumbers.first()
            listOfNumbers[0] = listOfNumbers.last()
            listOfNumbers[listOfNumbers.size - 1] = buffer
        } 
    }

    // 5 1 2 3 4
    // 5 5 2 3 4
    // 5 5 1 3 4
    // 5 5 1 2 4
    // 4 5 1 2 3

    for (i in 0..listOfNumbers.size - 1) {
        print(listOfNumbers[i].toString() + " ")
    }
}
