package com.example.train

import android.util.Log
import com.example.train.Constants.TAG
import java.lang.Exception

object Constants {
    const val NAME = "Roma"
    const val URL = "https://kotlinlang.org/docs/basic-syntax.html"
    const val NUMBER = 100

    const val TAG = "Constants"
}

fun main() {
    var numberFloat = 10.0232244f
    var numberDouble = numberFloat.toDouble()
    println(numberDouble) // 10.023224830627441
    val numberInt = numberDouble.toInt()
    println(numberInt) // 10

    val numberDouble2 = 10.0232244
    val numberFloat2 = numberDouble2.toFloat()
    println(numberFloat2) // 10.023225

    numberDouble = numberInt.toDouble()
    println(numberDouble) // 10.0
    numberFloat = numberDouble.toFloat()
    println(numberFloat) // 10.0

    val number = "1.234653465".toDouble()
    println(number) //  1.234653465

    val number2 = "1.234653465".toFloat()
    println(number2) // 1.2346535



    try {
        val factorial = Factorial.getFactorial(-1)
        print(factorial)
    } catch (ex: FactorialException) {
        print(ex.message)
    }

}

class Factorial {
    companion object {
        fun getFactorial(num : Int): Int {
            var result = 1
            if (num < 0) throw FactorialException("This number is less than one: $num")
            else {
                for (i in 1..num){
                    result = result*i
                }
                return result
            }
        }
    }
}
class FactorialException(override val message: String) : Exception()

