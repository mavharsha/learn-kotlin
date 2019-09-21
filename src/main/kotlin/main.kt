import java.util.Random;

fun main(args: Array<String>){
    println("hello world!")

    // immutable
    val name = "John"
    println(name)
    /*
       trying change name would not show a swiggley line, pointing that it cannot compile
    */

    // mutable
    var changeableName = "John"

    changeableName = "John D."
    println(changeableName)

    val smallInt = Int.MIN_VALUE
    val largeInt = Int.MAX_VALUE

    println("the small int is" + smallInt)
    println("the large int is $largeInt")

    // Long Double Float Boolean Short Byte
    // Floats looses precision after 15 digits after the decimal point

    // Boolean

    if(true is Boolean) println("True is boolean")
    // "is" keyword I think is similar to instanceOf

    var aCharacter = 'A'

    if(aCharacter is Char) println("$aCharacter is a character")


    // Typecasting
    println("Casting 3.14 to integer: " + 3.14.toInt())
    println("Casting 'A' to integer: " + 'A'.toInt())
    println("Casting 65 to Char: " + 65.toChar())


    // Working with strings
    val myName: String = "Sree Harsha Mamilla"
    val multiLineString = """
        Yay!!
        I can
        have multi-line
        strings"""
    println(multiLineString)

    println("The length of multi line string is ${multiLineString.length}")
    var string1 = "I am a string"
    var string2 = "i am a string"

    // String equals
    println("String equals: ${string1.equals(string2)}")
    println("String content equals: ${string1.contentEquals(string2)}")

    // String comparision
    println("Comparision: ${"A".compareTo("B")}")   // -1
    println("Comparision: ${"A".compareTo("A")}")   // 0
    println("Comparision: ${"B".compareTo("A")}")   // 1

    // Access characters at index
    println("The char at index 2 is ${string1[2]}")
    println("The char at index 2 is ${string1.get(2)}")

    // Substring and contains
    println("Substring with index 2 through 4: ${string1.subSequence(2, 4)}")
    println("The string contains: ${string1.contains("am")}")

    // stopped watching at 17 minutes
    // complete the video
    // use of kotlin in android
    // architecture components in android with kotlin before 5 - 6 November

    /*
    * Arrays
    * */
    var array = arrayOf(1, 3.14, "Array Element", 'A')

    println("the length of the array is: ${array.size}")
    println("the array contains 1: ${array.contains(1)}")

    var copyArray = array.copyOf()
    var anotherArrayCopy = array.copyOfRange(1,2)

    println("the first value of the array is ${array.first()}")
    println("the first value of the copyArray is ${copyArray.first()}")
    println("the first value of the anotherArrayCopy is ${anotherArrayCopy.first()}")

    // Index of element in an array
    println("index of element in the array: ${array.indexOf(3.14)}")    // -1 if it doesn't exist

    var squareArray = Array(5, {x-> x * x})
    println("the third element is ${squareArray[3]}")

    // Array of integers - type
    var arrayOfInts: Array<Int> = arrayOf(1,2,3)

    /*
    *  Ranges
    * */

    val oneToTen = 1..10;
    val alphabets = "A".."Z"

    println("H is in alphabet ${"H" in alphabets}")

    val tenToOne = 10.downTo(1)
    val twoToTwenty = 2.rangeTo(20)
    val oneToTenInSteps = oneToTen.step(3)

    for (x in oneToTen) print(x)
    for (x in oneToTen.reversed()) print(x)

    println("")


    /* Logical operators   > < => <= */

    /* When is similar to switch */
    var age = 10
    when(age){
        0,1,2,3,4 -> println("Age between 1-5")
        in 5..11 -> println("Age between 5-11")
        else -> println("Older than 11")
    }

    /* For Loop */
    var random = Random();
    for(x in 1..10) {
        var rand = x + random.nextInt(20)
        if(rand % 2 ==0) println("random value $rand is even")
        else println("random value $rand is odd")
    }

    println("- - - - - - - - - - - - - Loop with indices - - - - - - - - - - ")
    for((index, x) in (1..10).withIndex()) {
        var rand = x + random.nextInt(20)
        if(rand % 2 ==0) println("random value $rand  at index $index is even")
        else println("random value $rand at index $index is odd")
    }

    println("- - - - - - - - - - - - For loop functional - - - - - - - - - - - ")
    (1..10)
        .map { it + random.nextInt(20) }
        .forEach {
            if(it % 2 ==0) println("random value $it is even")
            else println("random value $it is odd")
        }

    /* Functions */
    println("- - - - - - - - - - - - Functions - - - - - - - - - - - - - - - - ")
    fun add(num1: Int, num2: Int): Int = num1 + num2
    println("The addition of 3, 4 is ${add(3,4)}")

    fun addDefaultWith10(num1: Int, num2: Int=10): Int = num1 + num2
    println("The addition of 3 and default value 10 is ${addDefaultWith10(3)}")

    fun noReturnSayHello(greeting: String): Unit = println("Hey ${greeting}! Hope your having a great day.")
    noReturnSayHello("Sree")

    fun nextTwo(value: Int): Pair<Int, Int> = Pair(value+1, value+ 2);
    val (two, three) = nextTwo(1);
    println("the values are 1 $two $three")

    fun getSum(vararg nums: Int): Int {
        var sum = 0
        nums.forEach { n -> sum += n }
        return sum;
    }

    println("The sum of 1,2 is ${getSum(1,2)}")
    println("The sum of 1,2,3,4,5 is ${getSum(1,2,3,4,5)}")

    val multiply = {num1: Int, num2: Int -> num1 * num2}
    println("3 multiplied with 4 is ${multiply(3,4)}")


    fun factorial(value: Int): Int {
        tailrec fun factTail(x: Int): Int {
            return if (x == 0) 1
            else x * factorial(x-1)
        }
        return factTail(value)
    }

    println("the factorial of 25 is ${factorial(25)}")

    /* Functional */
    println("- - - - - - - - - - - - Functional - - - - - - - - - - - - - - - - ")

    var evenList = oneToTen.filter { it % 2 ==0 }
    evenList.forEach { n -> print(n) }
    println("")

    fun returnAFunction(num1: Int): (Int) -> Int = { num2 -> num1 * num2}
    val multiply3 = returnAFunction(3)
    println("5 * 3 is ${multiply3(5)}")


    fun mathOnList(numList: Array<Int>, function: (num: Int) -> Int) {
        for (num in numList) {
            println("mathOnList ${function(num)}")
        }
    }

    val multiply2 = { number: Int -> number * 2 }
    mathOnList(arrayOfInts, multiply2)

    val sumOfItemsInList = arrayOfInts.reduce{ x, y -> x + y }
    println("Sum of items in the list with reduce $sumOfItemsInList")

    val sumOfItemsFold = arrayOfInts.fold(5){ x, y -> x + y }
    println("Sum of items in the list with reduce $sumOfItemsFold")

    val oneToTwenty = 1..20
    println("Are there any numbers between one to twenty even: ${oneToTwenty.any { it % 2 ==0 }}")
    println("Are all numbers from one to twenty even: ${oneToTwenty.all { it % 2 ==0 }}")
    println("All numbers greater than 11 in one to twenty: ${oneToTwenty.filter { it > 11 }}")
    println("Multiply all elements by 6: ${oneToTwenty.map { it * 6 }}")


    /* Exceptions*/
    println("- - - - - - - - - - - - Exceptions - - - - - - - - - - - - - - - - ")

    val divisor = 0
    try {
        if(divisor === 0) {
            throw IllegalArgumentException("Divisor cannot be zero")
        } else {
            println("Make division happen.")
        }
    } catch (e: IllegalArgumentException) {
        println("${e.message}")
    }

    /* Collections */
    println("- - - - - - - - - - - - Collections - - - - - - - - - - - - - - - - ")

    println("There are immutable lists and mutable lists")
    var mutableList: MutableList<Int> = mutableListOf(1,2,3,4,5)
    val immutableList: List<Int> = listOf(10,11,12,13,15)

    mutableList.add(6)
    println("You add items to mutable list $mutableList")
    println("The first element of mutable list is: ${mutableList.first()}")
    println("The last element of mutable list is: ${mutableList.last()}")
    println("The element at index  2 of mutable list is: ${mutableList[2]}")
    println("The size of mutable list is: ${mutableList.size}")
    mutableList.remove(7)
    println("List of items after removing item  $mutableList")
    println("The list of items after removing element at index 2 ${mutableList.removeAt(2)} is ${mutableList}")
    mutableList.clear()
    println("The elements in the list after clearing the items of the list are: $mutableList")

    println("There are immutable maps and mutable maps")

    var mutableMap = mutableMapOf<Int, Any>()
    var mutableMap2 = mutableMapOf(1 to "Sree Harsha", 2 to "Mamilla")
    mutableMap[1] = "Harsha"
    mutableMap[2] = "Mamilla"
    println("Elements in mutableMap: $mutableMap")
    println("Elements in mutableMap2: $mutableMap2 ")
    mutableMap.put(3, "Sree")
    mutableMap.remove(2)

    for ((x, y) in mutableMap){
        println("key: $x  value: $y")
    }

    val bear = Animal("BrownBear", 12.3, 420.0)
    bear.getInfo()

    val amber = Dog("amber", 4.4, 96.0, "Jackey")
    amber.getInfo()

    val rubberDuck: Flyable = Duck("rubberDuck", false)
    rubberDuck.fliesDistance(0)

    val realDuck: Flyable = Duck("realDuck")
    realDuck.fliesDistance(10)


    var nullableValue: String? = null

    /* If a function may return a null value you may specify that it could return null in the function signature */
    fun mayReturn(): String? = null

    var returnedValue = mayReturn()
    if(returnedValue != null) println("the returned value is not null and length is ${returnedValue.length}")

    /*
        !! is a force operator that asserts that value will not be null
        var nullVal = returnedValue!!.length  would throw an null pointer exception
     */

    /* Use elvis operator when the value maybe null */
    var nonNullVal = mayReturn() ?: "Default_String"
    println("The value returned after elvis operator is $nonNullVal")

}


/*Classes
*   Classes are final in nature unless open keyword is exist in the class signature
*
* */

open class Animal(val name: String, val height: Double, val weight: Double) {
    init {
        val regex = Regex(".*\\d+.*")
        require(!name.matches(regex)) {"Animal name cannot contain a number"}
        require(height > 0) {"Animal height must be greater than 0"}
        require(weight > 0) {"Animal weight must be greater than 0"}
    }

    open fun getInfo(): Unit {
        println("""The name of the animal is $name
            |it is  $height tall
            |and it weights $weight
        """.trimMargin())
    }
}

class Dog(name: String, height: Double, weight: Double, var owner: String): Animal (name, height, weight) {
    override fun getInfo(): Unit {
        println("""The name of the dog is $name
            |it is  $height tall
            |and it weights $weight
            |and the owner is $owner
        """.trimMargin())
    }
}


/*Interfaces
*  They are similar to java interfaces
* */

interface Flyable {
    var canFly: Boolean
    fun fliesDistance(distabceInMiles: Long): Unit
}

open class Duck(val name: String, override var canFly: Boolean = true): Flyable {
    override fun fliesDistance(distabceInMiles: Long) {
        if(canFly) {
            println("The $name can fly $distabceInMiles miles")
        }else {
            println("The bird $name cannot fly")
        }
    }
}