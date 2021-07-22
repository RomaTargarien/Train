package com.example.train

import android.graphics.Color
import android.os.Parcelable
import com.google.android.material.chip.ChipDrawable
import java.io.Serializable
import kotlin.reflect.KProperty

fun main() {
    User("Romammmmaadd")
    User("Roma",23)
    SonOfUser("RRRRRRRRRRR")
    val cs = CountingSet<Int>()
    cs.add(2)
    cs.add(2)
    cs.add(3)
    val son = SonOfUser("Roma",21)
    println(son.age)
    val son2 = SonOfUser("Vanya",16)
    println(son2.age)
    print(Button().color)
    println(cs.objectsAdded)
    DayTime.DAY.printName()

    val vk = VK("new vk")
    val phone = SmartPhone("Samsung",vk)
    phone.send("Hello")
    


}

interface State

interface View {
    fun getCurrentState() : State
    fun restoreState(state: State) {}
}

class Button : View {
    private var i = 1
    val name = "Roma"
    val color: Int
        get() = when {
            (i > 10 && i < 20) -> Color.RED
            i > 20 -> Color.BLACK
            else -> Color.WHITE
        }
    private lateinit var view: View

    internal fun changeColor() {
        print(view)
    }

    private fun create() {

    }
    override fun getCurrentState(): State {
        return ButtonState()
    }

    override fun restoreState(state: State) {
        super.restoreState(state)

    }
    inner class ButtonState: State {
        fun get(): Button = this@Button
        val i = this@Button.i
        fun change() = this@Button.create()
    }
}

data class A(val name: String) {

}



open class User {
    constructor(name: String) {
        if (name.length > 10) println("Big name")
    }
    constructor(name: String, age: Int) {
        if (age < 10) println("small")
    }
}

class SonOfUser(name: String) : User(name) {
    private var _age = 18
    val age : Int get() = _age


    constructor(name: String, age: Int) : this(name) {
        this._age = age
    }

    fun calcTaxes(): Double {
        return age * 0.3
    }
}

class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet {
    var objectsAdded = 0
    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}

interface Printable {
    fun printName()
}

enum class DayTime: Printable {
    DAY {
        override fun printName() {
            println("День")
        }
    },
    NIGHT {
        override fun printName() {
            println("Ночь")
        }
    }
}


interface Messenger {
    fun send(message: String)
}

class Telegramm(val name: String) : Messenger {

    override fun send(message: String) {
        print("$message telegramm")
    }
}

class VK(val name: String) : Messenger {
    override fun send(message: String) {
        print("$message vk")
    }
}

class SmartPhone(val message: String, messenger: Messenger) : Messenger by messenger




