fun solution(strings: List<String>, str: String): Int {
    // put your code here
    var counter = 0
    for (word in strings) {
        if (word == str) counter++
    }
    return counter
}