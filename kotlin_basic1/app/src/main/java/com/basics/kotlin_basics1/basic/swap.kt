package com.basics.kotlin_basics1.basic

fun swap(){
    var a = "abc"
    var b = "pqr"
    var c = "xyz"
    println("Before swaping\n a = $a b = $b c = $c")
    var temp = a
    a = c
    c= temp
    println("After swaping\n a = $a b = $b c = $c")
}

fun main() {

    swap()
}