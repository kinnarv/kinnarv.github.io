---
layout: post
title: Properties and Fields
tags: [kotlin, property, field]
---

### Declaring Properties

In Kotlin, property can be declared as mutable using `var` keyword or read-only using `val` keyword.

We can directly assign value to object and there is no `new` keyword in Kotlin.

```javascript
val name : String = "hello"
```

If you have any data class and you want to assign it to any variable, you can do like:

```javascript
class Address() {
    var name: String = "Name"
    var street: String = "Street"
    var city: String = "City"
}

fun copyAddress(address: Address): Address {
    val newAddress = Address() // here Address is data class.
    newAddress.name = address.name
    // set all param..
    return newAddress;
}
```

### Getters and Setters

When you are creating any data class, we don't need to override getter and setter for all objects in Kotlin.
That doesn't mean, you can't. You can, but you don't need to until you need customization for getter and setter.

Example:
```javascript
var allByDefault: Int? // error: explicit initializer required, default getter and setter implied
var initialized = 1 // has type Int, default getter and setter
```

The full syntax of a read-only property declaration differs from a mutable one in two ways: it starts with `val` instead of `var` and does not allow a setter:

```javascript
val simple: Int? // has type Int, default getter, must be initialized in constructor
val inferredType = 1 // has type Int and a default getter
```

We can write custom getter like:

```javascript
val isEmpty: Boolean
    get() = this.size == 0
```

If we want to override both getter and setter, we can do it like:

```javascript
var stringRepresentation: String
    get() = this.toString()
    set(value) {
        setDataFromString(value) // parses the string and assigns values to other properties
    }
```

From your code you can directly call this:
```javascript
stringRepresentation = "Hello" // this will call set(value).
println(stringRepresentation) // This will call get() to print value as "Hello"
```

If you need to change the visibility of an accessor or to annotate it, but don't need to change the default implementation, you can define the accessor without defining its body:

```javascript
var setterVisibility: String = "abc"
    private set // the setter is private and has the default implementation

var setterWithAnnotation: Any? = null
    @Inject set // annotate the setter with Inject
```

### Backing Fields

Classes in Kotlin cannot have fields. However, sometimes it is necessary to have a backing field when using custom accessors. For these purposes, Kotlin provides an automatic backing field which can be accessed using the field identifier:

```javascript
var counter = 0 // the initializer value is written directly to the backing field
    set(value) {
        if (value >= 0) field = value
    }
```

### Backing Properties

If you want to do something that does not fit into this "implicit backing field" scheme, you can always fall back to having a backing property:

```javascript
private var _table: Map<String, Int>? = null
public val table: Map<String, Int>
    get() {
        if (_table == null) {
            _table = HashMap() // Type parameters are inferred
        }
        return _table ?: throw AssertionError("Set to null by another thread")
    }
```