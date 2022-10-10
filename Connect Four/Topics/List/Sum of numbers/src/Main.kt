fun solution(numbers: List<Int>): Int {
    // put your code here
    var counter = 0

    for (num in numbers) {
        counter += num
    }

    return counter
}