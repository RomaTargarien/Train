package com.example.train

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun main() {
    val phone = Phone()
    phone.str3 = "first"
    phone.str3 = "second"
}

class Phone {
    var str: String by Delegate()
    val str2 by lazy {
        println("computed")
        "Hello"
    }
    var str3: String by Delegates.observable("<name>") {
        property, oldValue, newValue ->
        println("$oldValue - $newValue")
    }
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank yoy for ${property.name}"
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value было присвоено значению ${property.name} в $thisRef")
    }
}

