package com.example.train

import java.text.SimpleDateFormat
import java.util.*

lateinit var format: SimpleDateFormat

fun main() {
    val list = mutableListOf<String>()
    val date = Date().time
//    format = DataFormat.returnFormat(Pattern.PATTERN2)
    for (i in 0..100) {
        list.add(format.format(date-i*1000000))
    }
    for (item in list) {
       println(item)
    }
}

object DataFormat {
    fun returnFormat(pattern: Pattern) = SimpleDateFormat(pattern.tittle)
}

object DataFormat2 {

}

enum class Pattern(val tittle: String) {
    PATTERN1("yyyy.MM.dd G 'at' HH:mm:ss z"),
    PATTERN2("EEE, MMM d, ''yy"),
    PATTERN3("h:mm a")
}