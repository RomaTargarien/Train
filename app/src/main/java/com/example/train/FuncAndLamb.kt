package com.example.train

import android.widget.Toast
import java.lang.Thread

fun main() {
    var list = (1..20).toList()
    var count = 0
    println(list.maxOf { it })
    list = list.removedPrinter {
        it % 2 == 0
    }
    onClick(5){ number ->
        for (i in 1..10) {
            println(i*number)
        }
    }
    val thread = Thread(Thread1())
    thread.start()
    val thread2 = Thread(Thread2())
    thread2.start()

    numbersMoreThan(list,10)

    val sum = {x: Int,y : Int -> x+y  }
    twoAnbThree { i,i2 -> i*i2  }



}

fun printer(vararg strings: String) {
    for (item in strings) {
        println(item)
    }
}

fun user() : Pair<Int,String> {
    return Pair(21,"Roma")
}

fun onClick(number: Int, count: (Int) -> Unit) {
    count(number)
}

fun List<Int>.removedPrinter(filterFunction: (Int) -> Boolean): List<Int> {
    val resultList = mutableListOf<Int>()
    for (number in this) {
        if (filterFunction(number)) {
            resultList.add(number)
        } else {
            print("$number ")
        }
    }
    return resultList
}

fun numbersMoreThan(list: List<Int>,limit: Int) {
    var count = 0
    fun go2(number: Int) {
        if ((number > limit)) {
            count++
        }
    }
    for (item in list) {
        go2(item)
    }
    print(count)
}

fun twoAnbThree(operation: (Int,Int) -> Int) {
    val result = operation(2,3)
    println("The result is $result")
}

class Thread1: Runnable {
    override fun run() {
        onClick(5){ number ->
            for (i in 1..1000) {
                println("Thread 1 - ${i*number}")
            }
        }
    }
}
class Thread2: Runnable {
    override fun run() {
        onClick(5){ number ->
            for (i in 1..1000) {
                println("Thread 2 - ${i*number}")
            }
        }
    }
}

