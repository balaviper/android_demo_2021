package com.basics.kotlin_basics1

fun objDemo(){
    val obj = object  {
        var a = 10;
        var str = "bala"
    }
    println("Data : ${obj.a} \n ${obj.str} ")
}
fun main() {
    objDemo()
}