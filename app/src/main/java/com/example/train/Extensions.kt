package com.example.train

import android.graphics.Color

interface CatActions {
    fun voice()
    fun run()
    fun hide()
}
fun CatActions.voice(title: String) {
    voice()
    println(title)
}

open class Cat : CatActions {
    val color = Color.BLACK

    override fun voice() {
        println("Cat voice")
    }

    override fun run() {
        println("Cat run")
    }

    override fun hide() {
        println("Cat hide")
    }

}

class Kitty : Cat() {
    override fun hide() {
        println("Kitty hide")
    }

    override fun run() {
        println("Kitty run")
    }

    override fun voice() {
        println("Kitty voice")
    }
}

fun Cat.voice() {
    println("Cat voice extension")
}
fun Kitty.play() {

}

fun main() {
    val cat = Cat()
    val kitty = Kitty()
    val kitty2: Cat = Kitty()
    kitty2.voice()
    cat.voice("BOOO")

    kitty.voice()
}