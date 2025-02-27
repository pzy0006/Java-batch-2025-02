import sun.tools.jstat.Operator

fun main(){
    // class in kotlin

    val p = Person1("Matthew", 25)
    println(p.age)
    println(p.name)


    //lambda function in kotlin
    //Basic syntax
    // val/var lambdaName : (parameter type(s)) ->return type = {parameters: types  -> function body}

    val sum: (Int, Int) -> Int = {a,b -> a + b}
    println(sum(5,10))
    // lambda function without parameters
    val greeting: ()-> Unit = { println("hello kotlin")}
    greeting()

    // single parameter
    val square: (Int) -> Int ={ it * it}
    println(square(2))


    val result = operator(2,3) {x,y ->x *y}
    println(result)

    val re = getValue(2)
    println(getValue(5))
    println(re)


    // in java, we have method reference -> class::method
    // in kotlin, we also have "::" double colons -> reflection / function reference
    //
/// :: for function references
    val sayYourName : (String) -> Unit = :: myreferenceFun
    sayYourName("Matthew")


    //:: for property references
    val person = Person1("matthew", 12)
    val ref = person::name
    println(ref.set("Bob"))
    println(ref.get())

    //:: for constructor
    val studnet : (String, Int) -> Person1 = ::Person1

}
// in kotlin, a function can accept lambda function as its parameter
//this call higher order function
//a higher order function is a function that can take function as parameters or return a function
fun operator(a: Int, b:Int, operator: (Int,Int) -> Int):Int{
    return operator(a,b)
}
fun getValue(num : Int) : (Int) -> Int{
    return {number -> number * num}
}

fun myreferenceFun(name:String){
    println(name)
}

//class Person1{
//    var name: String
//    var age:Int
//
//    constructor(name: String, age : Int){// secondary constructor
//        this.age = age
//        this.name =name
//    }
//}

 class Driver(name: String, age: Int) : Person1(name, age) {
     override fun sayMyName() {
         super.sayMyName()
     }
}
open class Person1( name:String,  age: Int){ // this is called primary constructor
   // whenever you are using val or var for primary constructor parameters, this parameters
    // is consider as properties of this class, like field

     // by default, kotlin will make final to your class
     //

    var age: Int = age
        get() = field + 10
        set(value)  {
            if(value > 0){
                field = value
            }
        }
    // what is field keyword above?
    // it is a special keyword that allows you to store and retrieve value inside custom getter
    // and setter function
    //why do we need field?
    // to avoid infinite recursion
//    var age: Int = age
//        get() = age + 10
//        set(value)  {
//            if(value > 0){
//                field = value
//            }
//        }





    var name:String = name
        get() =  field.uppercase()


    open fun  sayMyName(){
        println("person1 class")
    }

    final fun sayMyAge(){

    }

}
//class Person1( name:String,  age: Int){ // this is called primary constructor
//  without val and var. name ane age are consider as parameter. not a field
//}
//
//abstract  class Animal{
//    abstract  fun makeSound();// no implementation
//}
//class Dog : Animal(){
//    override fun makeSound() {
//        TODO("Not yet implemented")
//    }
//
//}
//
//interface People{
//    fun myName()
//}
//
//class Teacher : People {
//    override fun myName() {
//        TODO("Not yet implemented")
//    }
//
//}