import kotlin.math.pow

fun f(x: Double): Double {
    // call your implemented functions here
    var result: Double = 0.0
    if (x <= 0){
        result = f1(x)
    } else if (x > 0 && x < 1) {
        result = f2(x)
    } else if (x >= 1) {
        result = f3(x)
    }
    return result
}

// implement your functions here
fun f1(x: Double): Double {
    return x.pow(2) + 1
}

fun f2(x: Double): Double {
    return 1 / x.pow(2)
}

fun f3(x: Double): Double {
    return x.pow(2) - 1
}