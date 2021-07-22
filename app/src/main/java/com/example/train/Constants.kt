package com.example.train

import android.util.Log
import java.io.ByteArrayInputStream
import java.lang.Exception
import java.nio.ByteBuffer
import java.nio.ByteOrder

object Constants {
    const val NAME = "Roma"
    const val URL = "https://kotlinlang.org/docs/basic-syntax.html"
    const val NUMBER: Double = 100.toDouble()
    const val float: Float = 100.toFloat()

}

fun main() {
    val floatNum: Float = 43443234.5f
    val list = floatNum.toBits()
    val array = ByteArray(8)
    for (i in 0..array.size-1) {
        array.set(i, (i+1).toByte())
    }
    val buffer = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).put(array)
    val buffer1 = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putInt(8)
    val buffer2 = ByteBuffer.allocate(8).putInt(8).order(ByteOrder.LITTLE_ENDIAN)
    print(buffer.get(0) )
    val x = buffer.getShort(0)
    val z = buffer.getFloat(2)
    val char = buffer.getChar(6)


    println(x)
    println(z)
    println(char)

    val float2 = Float.Companion.fromBits(1277540617)
    println(float2)
    val data = ByteArray(8)

    //val intNum: Int = floatNum as Int
    //println(intNum)
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

