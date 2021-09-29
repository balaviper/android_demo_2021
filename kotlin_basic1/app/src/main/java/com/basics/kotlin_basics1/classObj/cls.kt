package com.basics.kotlin_basics1.classObj

class Class1 constructor(private val str : String){
    private val name =  str
    //fun setName(name :String) { this.name = name}
    fun getName() = name


}

class Class2(val str : String){
    //private val id : Int
    //private val name : String
    constructor(s1 : String, id1 : Int): this(s1){

    }
    constructor(str : String, d : Double):this(str){

    }

}
class Cls5 {
    val dt : String

    constructor(d: String) { // secondary constructor
        dt = d
    }
}
class Cls6(val dt : String) { // primary
    private var d : String
    constructor(d: String,  n: Int): this(d) { // secondary -> `this` will point to primary
        // here d is for satisfying primary constructor
        // integer n is used to perform some logic
        println("Secondary 1")
    }
    constructor(d: String,  n: Float): this(d) {// secondary -> `this` will point to primary
        // here d is for satisfying primary constructor
        // double n is used to perform some logic
        println("Secondary 2")
    }

    init {
        println("Init 1")
        d = "ini"
    }
    init {
        println("Init 2")
    }
}

fun main() {
    println("Primary Constructor")
    val obj = Class1("Bala")
    obj.getName()
    println("Secondary Constructor")
    val obj2 = Class2("bala1")
    //println(obj2.getId())
    val obj3 = Cls6("Prime")
    val obj4 = Cls6("prime",101)
    val obj5 = Cls6("prime",101068906f)

}