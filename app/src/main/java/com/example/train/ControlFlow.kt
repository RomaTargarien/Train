package com.example.train

import java.lang.Exception
import kotlin.random.Random

fun main() {
    val mutableListForSort1: MutableList<Int> = mutableListOf()
    val mutableListForSort2: MutableList<Int> = mutableListOf()
    for (i in 0..10000) {
        mutableListForSort1.add(Random.nextInt(100))
        mutableListForSort2.add(Random.nextInt(100))
    }

    val time1 = System.currentTimeMillis()
    bubbleSortFor(mutableListForSort1)
    val time2 = System.currentTimeMillis()
    println(time2 - time1)

    val time3 = System.currentTimeMillis()
    bubbleSortWhile(mutableListForSort2)
    val time4 = System.currentTimeMillis()
    println(time4 - time3)

    val listOfAny = mutableListOf<Any>(1,9,-9,"4")

    try {
        print(counter(listOfAny))
    } catch (ex : Error.ErrorBoolean) {
        print(ex.message)
    }
    catch (ex : Error.ErrorUnexpected) {
        print(ex.message)
    }
    catch (ex : Error.ErrorChar) {
        print(ex.message)
    }
    catch (ex : Error.ErrorString) {
        print(ex.message)
    }
}

fun bubbleSortFor(list : MutableList<Int>) {
    for (i in 0..list.size-1) {
        for (k in 0..list.size -2) {
            if (list[k] > list[k+1]) {
                swap(list,k,k+1)
            }
        }
    }
}

fun bubbleSortWhile(list: MutableList<Int>) {
    var i = 0
    while (i < list.size-1) {
        var k = 0
        while (k < list.size -1) {
            if (list[k] > list[k+1]) {
                swap(list,k,k+1)
            }
            k++
        }
        i++
    }
}

fun swap(list: MutableList<Int>, bigPosition: Int, smallPosition: Int) {
    val big = list[bigPosition]
    list[bigPosition] = list[smallPosition]
    list[smallPosition] = big
}

sealed class Error(override val message: String): Exception() {
    class ErrorBoolean(message: String) : Error(message)
    class ErrorString(message: String) : Error(message)
    class ErrorChar(message: String) : Error(message)
    class ErrorUnexpected(message: String) : Error(message)
}

fun counter(list: List<Any>): Int {
    var count = 0
    loop@ for (item in list) {
        when (item) {
            is Int,Double,Float,Byte,Long -> {
                count++
                continue@loop
            }
            is String -> throw Error.ErrorString("Can't handle string, position ${list.indexOf(item)}")
            is Boolean -> throw Error.ErrorBoolean("Can't hadle boolean, position ${list.indexOf(item)}")
            is Char -> throw  Error.ErrorChar("Can't handle chars, position ${list.indexOf(item)}")
            else -> throw Error.ErrorUnexpected("Don't know this, position ${list.indexOf(item)}")
        }
    }
    return count
}