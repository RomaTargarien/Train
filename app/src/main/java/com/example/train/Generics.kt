package com.example.train

import android.graphics.Color


fun main() {
    val store1: Production<Clothes> = JeansStore()
    store1.produce()
    val srore2: Production<Jeans> = ShortStore()
    srore2.produce()
    val store3: Production<Jeans> = JeansStore()
    store3.produce()
    val store4: JeansStore = JeansStore()
    store4.produce()

    val consumer1: Consumer<Shorts> = Everybody()
    consumer1.consume(Shorts())


}

fun <T : Number> makeSomething(number: T) : Int {
    val sum = number.toInt() + number.toInt()
    return sum
}

fun <T> newInstance(instance: T) : Number where T : Int {
    return instance.toDouble()
}

interface Production<out T> {
    fun produce() : T
}
interface Consumer<in T> {
    fun consume(item: T)
}

open class Clothes
open class Jeans : Clothes()
class Shorts : Jeans()


class JeansStore : Production<Jeans> {
    override fun produce(): Jeans {
        println("Jeans production")
        return Jeans()
    }
    fun makeLabel() {

    }
}

class ShortStore : Production<Shorts> {
    override fun produce(): Shorts {
        println("Shorts production")
        return Shorts()
    }
}

class Everybody : Consumer<Clothes> {
    override fun consume(item: Clothes) {
        println("Clothes wearing")
    }
}
class YoungPeople : Consumer<Jeans> {
    override fun consume(item: Jeans) {
        println("Jeans wearing")
    }
    fun wear() {

    }
}

class Kids : Consumer<Shorts> {
    override fun consume(item: Shorts) {
        println("shorts wearing")
    }
}


