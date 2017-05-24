---
layout: post
title: Basic Types
tags: [kotlin, Int, String, Double, Float, Long]
---

Similar to Java, Kotlin handles number almost same way.


### Numbers

Kotlin provides the following built-in types representing numbers (this is close to Java):

| Type | Bit width |
| ------ | ------ |
|Double  |    64 |
|Float   |    32 |
|Long   |    64 |
|Int    |    32 |
|Short  |    16 |
|Byte   |     8 |

### Literal Constants

There are the following kinds of literal constants for integral values:

 - Decimal  : 123
 - Float    : 12.5F
 - Long     : 12456L
 - Hexa     : 0xOF
 - Binaries : 0001101

 **NOTE** : Octal literals are not supported.

 ### Underscores in numeric literals

 You can use underscores to make number constants more readable:

 ```javascript
 val oneMillion = 1_000_000
val creditCardNumber = 1234_5678_9012_3456L
val socialSecurityNumber = 999_99_9999L
val hexBytes = 0xFF_EC_DE_5E
val bytes = 0b11010010_01101001_10010100_10010010
````

### Every number type supports the following conversions:

- toByte(): Byte
- toShort(): Short
- toInt(): Int
- toLong(): Long
- toFloat(): Float
- toDouble(): Double
- toChar(): Char

### Operations

| Java | Kotlin | Note |
| ------ | ------ |--------|
|  <<    | shl(bits) |signed shift left|
|  >>    | shr(bits) |signed shift right|
|  >>>   | ushr(bits)|unsigned shift right|
|  and   | and(bits) | bitwise and |
|  or    | or(bits)  | bitwise or |

### Booleans

The type Boolean represents booleans, and has two values: true and false.

Booleans are boxed if a nullable reference is needed.

Built-in operations on booleans include

- || – lazy disjunction
- && – lazy conjunction
- ! - negation

### Characters

Characters are represented by the type Char. They can not be treated directly as numbers

```javascript
fun check(c: Char) {
    if (c == 1) { // ERROR: incompatible types
        // ...
    }
    if (c == '1') { // No error
        // ...
    }
}
````

### Strings

Strings are represented by the type String. Strings are immutable. Elements of a string are characters that can be accessed by the indexing operation: s[i]. A string can be iterated over with a for-loop:

```javascript
for (c in str) {
    println(c)
}
```

A raw string is delimited by a triple quote ("""), contains no escaping and can contain newlines and any other characters:

```javascript
val text = """
    for (c in "foo")
        print(c)
"""
```

You can remove leading whitespace with **trimMargin()** function.










