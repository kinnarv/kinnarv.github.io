package io.kinnarv.codingconvention

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class CodingConvention : AppCompatActivity() {

    val finalValue: Int = 100 //This is final value.

    var b = 1 //This way we can define int value, it will auto detect based on value.

    val array = arrayListOf<String>() //You can define array of string like this.

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_coding_convention)

        val sumExample = findViewById(R.id.sumExample) as TextView

        sumExample.setText("Sum of 5 + 7 = ${sum(5, 7)}")

//        finalValue += 1; -> This can't be reassign - as it is final!!!

        (findViewById(R.id.finalValueExample) as TextView).setText("Final Value: ${finalValue}")

        b += 5;

        (findViewById(R.id.intValue) as TextView).setText("Integer value of b + 5 is: ${b}")

        (findViewById(R.id.multiplyValue) as TextView).setText("Multiplication of 5 X 7 =  ${multiplyValue(5, 7)}")

        addArrayList()

        (findViewById(R.id.stringTemplate) as TextView).setText("Using string templates: ${getStringTemplate()}")

        (findViewById(R.id.conditionalExpression) as TextView).setText("Using conditional expressions: ${maxOf(5, 7)}")

        (findViewById(R.id.autoCast) as TextView).setText("Using type checks and automatic casts: ${getStringLength("Hello World!")}")

        testForLoop() // This will print log in console

        testWhileLoop() // This will print log for while loop in console

        (findViewById(R.id.whenTest) as TextView).setText("Using when expression: when object = 1: ${testWhen(1)}")

        testRanges() //This will print log for test ranges

        testCollection() //This will print log for collection.

    }

    /**
     * Default this function is public. If you want to define this as privete, do like:
     * internal fun sum(a: Int, b: Int): Int {
     */
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * Here you can see 'c' is defined as int and assign after that.
     */
    fun multiplyValue(a: Int, b: Int): Int {
        val c: Int
        c = a * b;
        return c;
    }

    fun addArrayList() {
        array.add("apple")
        array.add("banana")
        array.add("kiwi")
    }

    /**
     * Using string templates
     */
    fun getStringTemplate(): String {
        var a = 100
        // simple name in template:
        val s1 = "a is $a"

        a = 200
        // arbitrary expression in template:
        val s2 = "${s1.replace("is", "was")}, but now is $a"

        return s2;
    }

    /**
     * Using conditional expressions
     */
    fun maxOf(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    /**
     * Using type checks and automatic casts
     */
    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            // `obj` is automatically cast to `String` in this branch
            return obj.length
        }

        // `obj` is still of type `Any` outside of the type-checked branch
        return null
    }

    /*
    You can Try following functions as well!!!

    fun getStringLength(obj: Any): Int? {
        if (obj !is String) return null

        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }

    fun getStringLength(obj: Any): Int? {
        // `obj` is automatically cast to `String` on the right-hand side of `&&`
        if (obj is String && obj.length > 0) {
            return obj.length
        }

        return null
    }
    */

    /**
     * Using a for loop
     */

    fun testForLoop() {
        println("Test of For Loop")

        println("Example 1:")
        for (item in array) {
            println(item)
        }

        println("Example 2:")
        for (index in array.indices) {
            println("item at $index is ${array[index]}")
        }

        println("Example 3")
        for (i in 1..4) print(i)

        println("Example 4: print in reverse order")
        for (i in 4 downTo 1) print(i)

        println("Example 5: prints as step 2")
        for (i in 1..4 step 2) print(i)

        println("Example 6: use of downTo and steps together:")
        for (i in 4 downTo 1 step 2) print(i)

        println("Example 7: use of until")
        for (i in 1 until 10) { // i in [1, 10), 10 is excluded
            println(i)
        }


    }

    fun testWhileLoop() {
        println("Test of while Loop")

        var index = 0
        while (index < array.size) {
            println("item at $index is ${array[index]}")
            index++
        }
    }

    /**
     * Using when expression
     */
    fun testWhen(obj: Any): String =
            when (obj) {
                1 -> "xyz"
                "Hello" -> "Hello World"
                is Long -> "Long"
                !is String -> "Not a string"
                else -> "Unknown"
            }


    /**
     * Using ranges
     */
    fun testRanges() {
        println("Test Ranges:")
        var i = 3
        if (i in 1..10) { // equivalent of 1 >= i && i <= 10
            println("In Range: ${i}")
        }
    }

    /**
     * Using collections
     */
    fun testCollection() {
        println("Checking if a collection contains an object using in operator:")
        when {
            "orange" in array -> println("juicy")
            "apple" in array -> println("apple is fine too")
        }

        println("Using lambda expressions to filter and map collections:")

        val fruits = listOf("banana", "avocado", "apple", "kiwi")
        fruits
                .filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { println(it) }
    }
}
