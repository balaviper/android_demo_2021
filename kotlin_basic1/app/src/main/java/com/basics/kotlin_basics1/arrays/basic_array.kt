package com.basics.kotlin_basics1.arrays

import java.util.*

fun arrIni() {
    val arr1 = intArrayOf(1, 2, 3, 4, 5)
    println("0 th ->${arr1.get(0)}")

    val arr2 = IntArray(5)
    val n = arr2.size - 1
    println(n)
    for (i in 0..(n)) {
        arr2[i] = i
    }
    println(arr2.contentToString())

    var arr3 = IntArray(5) { 50 }
    var arr4 = IntArray(5, { 60 })
    var arr5 = IntArray(5, fun(n: Int): Int {
        return n
    })
    //var arr6 = IntArray(5, (n : Int)-> Int = {n->50})
    println(arr3.contentToString())
    println(arr4.contentToString())
    println("arr5 ${arr5.contentToString()}")

}

fun demo2() {
    val dates = Array<Date>(5) { Date() }
    println("0th -> ${dates[0]}")
    println("0th -> ${dates.get(0)}")
    println(dates.contentToString())

    val arrBools = BooleanArray(5) { true }
    println(arrBools.contentToString())

    val names = arrayOf<String>("android", "iOS", "Linux", "Windows")
    println(names.contentToString())
}

fun main() {
    arrIni()
    demo2()
}