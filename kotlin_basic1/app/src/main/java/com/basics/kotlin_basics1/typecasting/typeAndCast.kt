package com.basics.kotlin_basics1.typecasting

fun convert(){
    val str = "100"
    val cha = 'A'
    val doubleVal = 137252f.toDouble()
    val num1 = Integer.valueOf(str)
    val num2 = str.toString()
    val num3 = Integer.parseInt(str)
    val assci = cha.toInt()//deprecated
    val assci1 = 'B'.hashCode()
    println("num1 $num1 num2 $num2 num3 $num3 assci ${assci+num1} assci1 $assci1 double $doubleVal")
}
fun main() {
    convert()
}
