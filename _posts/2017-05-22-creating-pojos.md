---
layout: post
title: Creating POJOs
tags: [kotlin, syntax, Android]
---

### Creating POJOs

We frequently create a class to do nothing but hold data. In such a class some standard functionality is often mechanically derivable from the data. In Kotlin, this is called a data class and is marked as data:

```javascript
data class User(val name: String, val age: Int)
```
The compiler automatically derives the following members from all properties declared in the primary constructor:

* getters (and setters in case of vars) for all properties
* equals()
* hashCode()
* toString()
* copy()

### Default values for function parameters

```javascript
fun foo(a: Int = 0, b: String = "") { ... }
```

### Filtering a list

```javascript
val positives = list.filter { x -> x > 0 }
```

OR

```javascript
val positives = list.filter { it > 0 }
```

### Instance Checks

```javascript
when (x) {
    is Foo -> ...
    is Bar -> ...
    else   -> ...
}
```

### Traversing a map/list of pairs

```javascript
for ((k, v) in map) {
    println("$k -> $v")
}
```