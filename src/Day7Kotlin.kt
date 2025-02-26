
    fun main(){
        println("Hello Kotlin")
        // define int here
        // int i = 0; Integer i = 0;

        // in kotlin, if you have initial value, you don't have to give type
        var i:Int = 1
        // in kotlin, if you donot have initial value, you have to give type
        var a:Int
        // you can the first char is upper case, it does not means you are using wrapper type
        // it is a primitive type
        var myDouble:Double = 1.5
        var myFloat:Float = 1.3f
        var myLong:Long = 1L

        myLong = 2L
        myFloat = 1.5f


        // in java, we have to use final keyword to define a constant

        //in kotlin, how can we define a constant?
        val myConstantDouble : Double = 1.4
        //var vs val: the value with var allows you to change(mutable)
        // the value wit val does not allow you to change (immutable)

        // in java:
        // == and equals(): they are different in java
        //in kotli
        // == and equals(): they are same!!!!

        val myInt = 10
        val b = 10
        println(myInt == b)
        println(myInt.equals(b))
        // what if you want to compare two objects' reference
        // you can use "===" to compare reference
        val str1:String = "kotlin"
        val str2:String = "kotlin"
        println(str1 === str2)

        val str3 = String("Kotlin".toCharArray())
        println(str3 === str1)

        //how can we define a wrapper type in kotlin
        // we can use question mark ("?") after your type to define a wrapper type
        // with ? mark, you can assign null value to your variable
        // kotlin will automaticlly change primitive type to wrapper type
        val mystr:String? = "asldukfhlas"
        val myInteger:Int? = 19234
        val myInteger1:Int? = 19234
        // kotlin automatically caches small integer values (-128,127) just like java
        // but for large integer, it might have different reference
        println(myInteger === myInteger1)
        println(myInteger == myInteger1)


        var kod:Any = 123.3f
        // Any class vs ? mark
        // any is the root type of all non-nullable types in kotlin
        //equivalent to Object in java, but does  allow null
        // ? allows you to assign null value to a variable
        // this can be applied to any type String, Float, Int, Double...

        // can we use Any and ? toghter to have null value for our variable
        // YES!
        var myAnyString:Any? = null


        //define an array
        val numbers = arrayOf(1,2,4,5,6,7,8)
        //accessing items in numbers
        println(numbers.get(0))
        println(numbers[0])


        val intArr = intArrayOf(1,3,4,5,6)
        val longArr = longArrayOf(1L,2L,3L)
        val doubleArr = doubleArrayOf(1.2,1.5)

        val mixedArray = arrayOf(1,"kotlin", 2,3.14,true)
        println(mixedArray.joinToString())

        val myemptyArray = emptyArray<Int>()
        // this immutable list
        // you cannot modify: numbersList[0] = 10
        val numbersList:List<Int> = listOf(1,13,4,5)
        numbersList.size;
        numbersList.contains(13)
        //how can we make mutable list
        // with mutable list, you can change everything
        // in java, List<Integer> list = new ArrayLIst<>();
        val myfruits:MutableList<String> = mutableListOf("apple", "cherry")
        myfruits.add("Orange")
        myfruits.remove("apple")
        myfruits[0] = "banana"

        //do we have stream api in kotlin, No, but we have equivalent things
        //eager one - this code will be executed immediately
        val result = numbersList.filter {  it % 2 == 0 }
            .map { it * 2 }
        println(result)
        // lazy evaluation: this code will not be executed immediately
        val res = numbersList.asSequence().filter { it % 2 ==0 }
            .map { it * 2 }.toList();


        // hashMap
        // syntax: key  to value
        val studentCode = mapOf(
            "1" to "Matthew",
            "2" to "John",
            "3" to "Alice"
        )

        println(studentCode["1"])
        println(studentCode.get("1"))
        println(studentCode["4"])// null

        //how can we define mutable hashmap
        // same as mutable list
        val users = mutableMapOf( 1 to "Matthew", 2 to "John")
        users[3] = "Alice"
        users[2] = "Bob"
        users.remove(1)
        println(users)

        // iterating over a map
        for ((key , value) in studentCode){
            println("$key -> $value")
        }
        studentCode.forEach {(key, value) -> println("$key -> $value")  }

        println(studentCode.containsKey("3"))
        println(studentCode.containsValue("Alice"))
        println("3" in studentCode)

        studentCode.getOrElse("Mango"){"Not Found"}
        studentCode.filter { it.value == "Alice" }

        val scores = mapOf("Alice" to 80, "Matthew" to 100, "John" to 79)
        val sortedByKey = scores.toSortedMap()
        println(sortedByKey)

        val sortedByValue = scores.entries.sortedBy { it.value }.associate { it.key to it.value }
        println(sortedByValue)
        val sortedByKeyReverse = scores.toSortedMap(reverseOrder())
        println(sortedByKeyReverse)

        val scores2 = mapOf("Bob" to 100, "Matthew" to 90, "Tom" to 100)
        val mergedMap = scores2 + scores
        println(mergedMap)

        // pair vs triple vs data class
        // pair can hold two values, triple can hold three values, data class can hold more than one

        val pair = Pair("Alice", 25)
        println(pair.first)
        println(pair.second)

        val triple = Triple("Alice", 25, "Chicago")
        println(triple.first)
        println(triple.second)
        println(triple.third)

        val person = Person("Alice", 34,"Chicago", "11111")

        val numberD = 1;
        val resultD = if(numberD > 0){
            "Posititve"
        }else if(numberD < 0){
            "Negative"
        }else{
            "Zero"
        }
        println(resultD)
        // in java ternary operator (condition ? value : value 2)
        // in kotlin, we do not ternary operator
        val aa = 10;
        val bb = 20;
        val max = if(aa>bb) aa else bb

        //when statement -> similar to switch in java but cleaner
        // in java we need break for switch statement. but in kotlin, we do not need break
        val day = 3;
        when(day){
            1 -> println("Monday")
            2 -> println("Tuesday")
            3 -> println("Wednesday")
            4 -> println("Thursday")
            5 -> println("Friday")
            else -> println("Weekend")
        }
        // you can return it
        val resultDay = when(day){
            1 -> println("Monday")
            2 -> println("Tuesday")
            3 -> println("Wednesday")
            4 -> println("Thursday")
            5 -> println("Friday")
            else -> println("Weekend")
        }

        when(numberD){

            in 1..10 -> println("less than 10")
            else -> println("else")
        }

        //range syntax in kotlin:
        // greater than and equal to 1 and less than and equal to 10: 1..10 -> 'a' .. 'z'
        //greater than and equal to 1 and less than 10 : 1..<10 -> 'a' ..< 'z'
        // decreasing order -> 10 >= downTo >= 1


        // in kotlin we have "is" operator
        // this is operator will help you to check the type of value



        // this function only allows integer to use

        println(numberD.sum(1, 3))
        print(numberD add 9)
        println(10 add 9)

    }
    //syntax: fun functionName(param:param type....):return type{method body}
    fun checkNumber(n:Int):String{
        return  if(n > 0){
            "Posititve"
        }else if(n < 0){
            "Negative"
        }else{
            "Zero"
        }
    }

    // in java, if we do not have return value, we need void keyword
    // in kotlin, if we do not have return value, we need Unit\
    // Unit in kotlin == void in java
    fun checkType(value: Any):Unit{ // our Unit type is gray out
        when(value){
            is Int -> println("it is int")
            is String -> println("it is  string")
            else -> println("else")
        }
    }
    // whawt is infix function
    // in general, obj.function
    // with infix funciton-> obj function obj
    // must be a member function or an extension function
    // must be exactly one parameter
    // must  have infix keyword
    infix fun Int.add(other:Int):Int{
        return this + other
    }
//    fun Int.sum(a:Int, b:Int):Int{
//        return a + b + this;
//    }
    // type.function name
fun Int.sum(a:Int, b:Int):Int = a + b + this


    data class  Person(val name:String, val age:Int, val city:String, val zipcode: String)

