package com.basics.kotlin_basics1

import kotlin.math.pow


fun void(): Unit{
    println("Unit function")
}
fun defaultVal( //default values
    num1 : Int =30,
    num2 : Int =20
) {
    println("\nNum1 = $num1 num2 = $num2\n")
}

fun inLine() = println("\nThis is in line functions\n") // inline

infix fun Unit.square(num : Double) = Math.pow(num, 2.0) // infix

fun multiArg(vararg str : String) : Int{ // vararg => use when no of arg is unknown
    for(i in str){
        println(i)
    }
    return str.size
}
fun main() {
    inLine()

    defaultVal()
    defaultVal(80,10)
    defaultVal(10)

    println("Infix function : ${Unit square 4.0}")
    println("Infix function : ${Unit.square(4.0)}")

    println("Multiple arguments as array without knowing the no of arg \nSize of :"+multiArg("bala","kamal","java","kotlin"))

}