package com.example.train

class Test1 {
    var countEven = 0

    fun filter(list: List<Int>, filter2 : (Int) -> Boolean) {
        for (item in list) {
            if (filter2(item)) {
                countEven++
            }
        }
    }

    fun count(increase :(Int) -> Unit) {
        increase(countEven)
    }
}

class Test2 {
    var countTest2 = 0
    val lbmd = { number : Int -> Boolean
        countTest2++
        number % 2 == 0 }

    val t1 = Test1()

    fun test() {
        val list = listOf<Int>(1,2,3,4,5,6,7,8,9,10)
        countTest2++
        this.countTest2++

        t1.filter(list) {
            countTest2++
            it % 2 == 0
        }

        println("In list ${t1.countEven} even numbers and ${list.size - t1.countEven} odd numbers")

        t1.count { i: Int ->
            if (t1.countEven > 4) {
                t1.countEven = i*2
                println("${t1.countEven} - was increased ")
            }
        }
    }
}

fun main() {
    val t2 = Test2()
    t2.test()
    print(t2.countTest2)

    System.gc()
}



