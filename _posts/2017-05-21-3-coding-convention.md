---
layout: post
title: Coding convention
tags: [kotlin, syntax, Android]
---

### Defining functions

Kotlin's basic syntax is very similar to swift.

In java, we are use to define mehtods. 

In Kotlin, we have to use `fun` -> Function for defining any method.

Example, if we want to do sum of 5 & 6, we use to define in Java as:

```javascript
public int sum(int a, int b) {
    return a + b;
}
```

If we want to define same thing in Kotlin, it will be like:

```javascript
fun sum(a: Int, b: Int): Int {
    return a + b
}
```

### Defining local variables

Assign-once (read-only) local variable:

```javascript
val a: Int = 100  // immediate assignment
val b = 1   // `Int` type is inferred
val c: Int  // Type required when no initializer is provided
c = 7       // deferred assignment
```

Mutable variable:

```javascript
var x = 5 // `Int` type is inferred
x += 1
```

### Using string templates

```javascript
var a = 100
// simple name in template:
val s1 = "a is $a" 

a = 200
// arbitrary expression in template:
val s2 = "${s1.replace("is", "was")}, but now is $a"
````

output will be:
```javascript
a was 1, but now is 2
```

### Using conditional expressions

```javascript
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}
```

* Using if as an expression:
```javascript
fun maxOf(a: Int, b: Int) = if (a > b) a else b
```

### Using type checks and automatic casts

The is operator checks if an expression is an instance of a type. If an immutable local variable or property is checked for a specific type, there's no need to cast it explicitly:

```javascript
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }

    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}
```

```javascript
fun getStringLength(obj: Any): Int? {
    if (obj !is String) return null

    // `obj` is automatically cast to `String` in this branch
    return obj.length
}
```

```javascript
fun getStringLength(obj: Any): Int? {
    // `obj` is automatically cast to `String` on the right-hand side of `&&`
    if (obj is String && obj.length > 0) {
        return obj.length
    }

    return null
}
```

### Using a for loop

```javascript
val items = listOf("apple", "banana", "kiwi")
for (item in items) {
    println(item)
}

*Output:*
apple
banana
kiwi
```

```javascript
val items = listOf("apple", "banana", "kiwi")
for (index in items.indices) {
    println("item at $index is ${items[index]}")
}

*Output:*
item at 0 is apple
item at 1 is banana
item at 2 is kiwi
```

### Using a while loop

```javascript
val items = listOf("apple", "banana", "kiwi")
var index = 0
while (index < items.size) {
    println("item at $index is ${items[index]}")
    index++
}
```
### Using when expression

This is really nice feature! 

In java, we are use to write switch case where switch must have same datatype as input, but here in Kotlin, you can use when and it can have different arguemnt as input and on based of that, it will identify and give you output. Let's take example:

```javascript
fun describe(obj: Any): String =
            when (obj) {
                1 -> "xyz"
                "Hello" -> "Hello World"
                is Long -> "Long"
                !is String -> "Not a string"
                else -> "Unknown"
            }
```

Here from any other function or from somewhere else, when you call describe(),

```javascript
Log.e("value", "output of when is: ${describe(1)}");

output:
output of when is: xyz
````

similar way,


```javascript
Log.e("value", "output of when is: ${describe(false)}");

output:
output of when is: Not a string
````

### Using ranges

Range expressions are formed with rangeTo functions that have the operator form .. which is complemented by in and !in. Range is defined for any comparable type, but for integral primitive types it has an optimized implementation. Here are some examples of using ranges

```javascript
if (i in 1..10) { // equivalent of 1 >= i && i <= 10
    println(i)
}
```

Integral type ranges (IntRange, LongRange, CharRange) have an extra feature: they can be iterated over. The compiler takes care of converting this analogously to Java's indexed for-loop, without extra overhead.

```javascript
for (i in 1..4) print(i) // prints "1234"

for (i in 4..1) print(i) // prints nothing
````

What if you want to iterate over numbers in reverse order? It's simple. You can use the `downTo()` function defined in the standard library

```javascript
for (i in 4 downTo 1) print(i) // prints "4321"
````

Is it possible to iterate over numbers with arbitrary step, not equal to 1? Sure, the `step()` function will help you

```javascript
for (i in 1..4 step 2) print(i) // prints "13"

for (i in 4 downTo 1 step 2) print(i) // prints "42"
```

To create a range which does not include its end element, you can use the `until` function:

```javascript
for (i in 1 until 10) { // i in [1, 10), 10 is excluded
     println(i)
}
```

### Using collections

* Iterating over a collection:

```javascript
fun main(args: Array<String>) {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }
}
```

* Checking if a collection contains an object using `in` operator:

```javascript
fun main(args: Array<String>) {
    val items = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
}
```

* Using `lambda` expressions to filter and map collections:

```javascript
fun main(args: Array<String>) {
    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits
    .filter { it.startsWith("a") }
    .sortedBy { it }
    .map { it.toUpperCase() }
    .forEach { println(it) }
}
```

Here from list, we are filtering fruits which starts with **a** and sorting it in ascending and print it. So 
final output will be like:

```javascript
Output:
APPLE
AVOCADO
```

### Naming Style

* Use of camelCase for names (and avoid underscore in names)
* Types start with upper case
* Methods and properties start with lower case
* Use 4 space indentation
* Public functions should have documentation such that it appears in Kotlin Doc

### Colon

There is a space before colon where colon separates type and supertype and there's no space where colon separates instance and type:

```javascript
interface Foo<out T : Any> : Bar {
    fun foo(a: Int): T
}
```

### Lambdas

In lambda expressions, spaces should be used around the curly braces, as well as around the arrow which separates the parameters from the body. Whenever possible, a lambda should be passed outside of parentheses.

```javascript
list.filter { it > 10 }.map { element -> element * 2 }
```

### Class header formatting

Classes with a few arguments can be written in a single line:

```javascript
class Person(id: Int, name: String)
```

Classes with longer headers should be formatted so that each primary constructor argument is in a separate line with indentation. Also, the closing parenthesis should be on a new line. If we use inheritance, then the superclass constructor call or list of implemented interfaces should be located on the same line as the parenthesis:

```javascript
class Person(
    id: Int, 
    name: String,
    surname: String
) : Human(id, name) {
    // ...
}
```

So, in above Example, we can see, class Person implementing Human interface. If we want to implement multiple interface, we can do same using comma.

### Unit

If a function returns Unit, the return type should be omitted:

```javascript
fun foo() { // ": Unit" is omitted here

}
```

