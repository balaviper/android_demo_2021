package com.basics.kotlin_basics1.classObj

class getterSetter(
    private var x: Int,
    private var y: Int
) {
    var data: Int
        set(value) {this.x = value}
        get() = this.x
    var data2: Int
        set(value) {this.y = value}
        get() = this.y
}
fun main() {
    val obj = getterSetter(10,20)
    println("${obj.data} ,${obj.data2}")
    obj.data = 100
    obj.data2 = 200
    println("${obj.data} ,${obj.data2}")


}