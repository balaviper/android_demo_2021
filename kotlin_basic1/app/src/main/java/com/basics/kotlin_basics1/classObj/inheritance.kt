package com.basics.kotlin_basics1.classObj

/*In Kotlin, all the classes are final by default i.e. they can’t be inherited by default.
This is opposite to what we learned in Java. In Java, you have to make your class final explicitly.
So, to make a class inheritable to the other classes,
you must mark it with the open keyword otherwise you will get an error saying
“type is final so can’t be inherited”.*/

open class Inheritance (open val data :Int){

    open fun method(){
        println("Parent class $data")
    }
}

open class Sub1(override val data : Int ) : Inheritance(data){
    //override val data = super.data + 50
    override fun method(){
        println("***** sub1 class *****")
        println("sub1 class $data")
        println("sub1 class parent ${super.data}")
    }
}

class Sub2 : Sub1(50) {
    override fun method(){
        println("***** sub2 class *****")
        println("sub2 class $data")
        println("sub2 class parent ${super.data}")
        //println("sub2 class parent ${Inheritance.data}")
    }
}

fun main() {
    var obj1 = Inheritance(100)
    obj1.method()

    var obj2 = Sub1(70)
    obj2.method()

    var obj3 = Sub2()
    obj3.method()
    println()

    var obj4 : Inheritance = Sub1(20)
    obj4.method()
    /*Dynamic Binding  Method Overriding is a perfect example of dynamic binding as in overriding both parent and child classes have same method and in this case the type of the object determines which method is to be executed.
     The type of object is determined at the run time so this is known as dynamic binding.*/




}