package com.example.train

import java.lang.Exception
import kotlin.random.Random

fun main() {
    val list = listOf(1,2,3,4,5)
    val set = setOf("one","two","three","one","five")
    val mutableList = mutableListOf(5,9,3,5,2,4)
    val map = mapOf("one" to 1, "two" to 2, "three" to 3)

    for (i in 0..list.size-1) {
        print("${list[i]} ")
    }
    println()

    for (item in set) {
        print("$item ")
    }
    println()

    val iterator = mutableList.iterator()
    while (iterator.hasNext()) {
        print("${iterator.next()} ")
    }
    println()

    for (key in map.keys ) {
        println("$key - ${map[key]}  ")
    }
    val mapOfAnyType = mapOf<Any,Any>()
}




