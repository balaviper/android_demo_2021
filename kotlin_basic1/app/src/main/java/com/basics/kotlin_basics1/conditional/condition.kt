package com.basics.kotlin_basics1.conditional

import android.icu.number.IntegerWidth
import java.util.Scanner
val os = Scanner(System.`in`);
fun ifElse() {
    val os = readLine()
    if(os.equals("10")){
        println("oreo")
    }else if(os.equals("9")){
        println("pie")
    }else{
        println("Other os")
    }
}
fun whenCheck() {
    //Scanner sc = new Scanner(System.`in`) wont work use as kotlin syntax
    //val os = Scanner(System.`in`);
    when(os.next()){
        "10" -> println("Oreo")
        "9" -> println("pie")
        "8","7" -> println("its 7 0r 8")
        else -> ifElse()
    }
}
fun assign(){
    val input = Integer.valueOf(readLine())
    println(input)
    val oppsys = when(os.next()){
        "10" -> "Oreo"
        "9" -> "pie"
        "8","7" -> "its 7 0r 8"
        else -> "other"
    }
    println(oppsys)
}

fun whenIn(){
    val num = os.nextInt()
    val arr= intArrayOf(50,60)
    when(num){
        in 1..10 -> println("single digit")
        !in 50..100 -> println("not in 50 to 100")
        in arr -> println("arr elements")
        else -> println("invalid")
    }
}
fun main() {
    //if_else()
    //whenCheck()
    assign()
    //whenIn()
}