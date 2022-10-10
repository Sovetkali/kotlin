// Implement your functions here
fun subtractTwoNumbers (a: Long, b: Long) {
    print(a - b)
}


fun sumTwoNumbers (a: Long, b: Long) {
    print(a + b)
}


fun divideTwoNumbers (a: Long, b: Long) {
    if (b.compareTo(0) == 0){
        print("Division by 0!")
    } else print (a / b)
}


fun multiplyTwoNumbers (a: Long, b: Long) {
    print (a * b)
}