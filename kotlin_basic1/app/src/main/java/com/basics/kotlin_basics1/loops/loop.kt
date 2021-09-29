package com.basics.kotlin_basics1.loops

fun forLoops(){
    val items = listOf("apple", "banana", "kiwifruit")
    println("**** for loop ****")
    for(i in 0..10 step 2){
        println("$i ${i*2}")
    }
    println("**** for loop decrement ****")
    for (i in 10 downTo 1 step 2) {
        println(i)
    }
    println("**** For each with index value****")
    for(i in items.indices){
        println("Item ${items[i]}")
    }
    println("**** For each with value****")
    for(i in items){
        println("Item $i")
    }

    for((index , value) in items.withIndex()){
        println("Index ${index}, value = $value")
    }
    for(i in 0 until (items.size)){
        println("$i")
    }

}

fun whileLoop(){
    var i = 0
    while(i<10){
        println(i)
        i++
    }
    do{
        println(i)
        i++
    }while(i<20)
}

fun main() {
    //forLoops()
    whileLoop()
}