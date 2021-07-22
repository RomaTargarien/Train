package com.example.train

import android.content.res.Resources
import android.graphics.Color
import java.util.*
enum class Person2 {
    NEWPERSON, GUEST, OLDPERSOn
}
enum class Scrin(val person: Person2) {
    LOGIN(person) {
        override fun theme(person: Person) =
            when (person) {
                is NewPerson -> Color.GREEN
                is Guest -> Color.RED
                is OldPerson -> Color.WHITE
                else -> Color.TRANSPARENT
            }
    },
    REGISTER() {
        override fun theme(person: Person) =
            when (person) {
                is NewPerson -> Color.GREEN
                is Guest -> Color.RED
                is OldPerson -> Color.WHITE
                else -> Color.TRANSPARENT
            }
    },
    DASHBOARD() {
        override fun theme(person: Person) =
            when (person) {
                is NewPerson -> Color.GREEN
                is Guest -> Color.RED
                is OldPerson -> Color.WHITE
                else -> Color.TRANSPARENT
            }
    };

    abstract fun theme(person: Person): Int

}

open class Person

class NewPerson : Person()
class Guest : Person()
class OldPerson : Person()

fun main() {
    val person = NewPerson()
    val loginColor = Scrin.LOGIN.theme(person)
    print(loginColor)
}
