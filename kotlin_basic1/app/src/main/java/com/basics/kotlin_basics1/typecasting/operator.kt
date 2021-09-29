package com.basics.kotlin_basics1.typecasting

fun main() {
    val i = 50
    val j = 60

    println("Arithmetic operator ${i+j} ${i-j} ${i/j} ${i*j} ")
    println("Logical operator ${i == j} ${i != j} ${i is Int && (j==60)} ${i is Int || j == 50}")
    println("conditional operator ${i < j} ${i > j} etccc")
    println("bitwise operator ${i and j} ${i or j} ${(i==j).not()} ${i xor j}")



}