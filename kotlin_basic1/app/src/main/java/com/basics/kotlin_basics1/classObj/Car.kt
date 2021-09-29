package com.basics.kotlin_basics1.classObj

class Car {
    var speed = 10 //state
    fun speedUp() = speed++ //behaviour
    var speedInc: (speed: Int) -> Int = { speed++ }
    fun gearUp(n: Int) {
        println("Speed is ${speedUp() * n}  ${speedInc(speed) * n}")
    }
}

fun main() {
    val c = Car()//Object creation
    c.speedUp()
    c.gearUp(4)
    //println(c.speed1)
}
