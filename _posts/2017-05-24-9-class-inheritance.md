---
layout: post
title: Classes and Inheritance
tags: [kotlin, classes, Inheritance, Overriding]
---

### Classes

Classes in Kotlin are declared using the keyword `class`

```javascript
class Employee {
}
```

Here class body can have class name, class header, class body.

if the class has no body, curly braces can be omitted.

```javascript
class Empty
```

You can define class with constructor like this:

```javascript
class Employees constructor(empId: Int) {

}
```

You can omit keyword: constructor here as well.

```javascript
class Employee1(empId: Int) {

}
```

In one class, if you have multiple constructor with different argument, you can use it like:

```javascript
class Employee2 {
    constructor(empId: Int) {

    }

    constructor(empId: Int, empName: String) {

    }
}
```

Initialization code can be placed in initializer blocks, `init` is keyword for same.

```javascript
class Employee3(empId: Int) {
    init {
        println("Employee initialized with id: ${empId}")
    }
}
```

To use value of constructor, you can do it like:

```javascript
class Employee4(empId: Int) {
    val employeeId = empId;
}
```

If a non-abstract class does not declare any constructors (primary or secondary), it will have a generated primary constructor with no arguments. The visibility of the constructor will be public. If you do not want your class to have a public constructor, you need to declare an empty primary constructor with non-default visibility:

```javascript
class DontCreateMe private constructor () {
}
```

Creating instances of classes:

To create an instance of a class, we call the constructor as if it were a regular function:

```javascript
val employee = Employee()
```

Class can contains:

- Constructors and initializer blocks
- Functions
- Properties
- Nested and Inner Classes
- Object Declarations

### Superclass

All classes in Kotlin have a default superclass `Any`.

`Any` is not `java.lang.Object`; in particular, it does not have any members other than `equals()`, `hashCode()` and `toString()`.

The `open` annotation on a class is the opposite of Java’s `final`, it allows others to inherit from this class.

So, when you want to create any super class, you can define it like:

```javascript
open class Base(p: Int)
```

So, now in derived class, you can use super class like:

```javascript
class Derived(p: Int) : Base(p)
```

If the class has no primary constructor, then each secondary constructor has to initialize the base type using the super keyword.

```javascript
class MyView : View {
    constructor(ctx: Context) : super(ctx)

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
}
```

### Overriding Methods

Kotlin requires explicit annotations for overridable members which called as `open`.

```javascript
open class Base {
    open fun v() {}
    fun nv() {}
}
class Derived() : Base() {
    override fun v() {}
}
```

In Kotlin, default all methods are `final` and if you want to override any method, we need to use keyword `open` in base class and need to use `override` in derived class for that method.

If we try to override any other method except `open` in base class, it will give compiletime error, ex. if we try to override `fun nv()` from base class in to Derived class, it will give compile time error as `fun nv()` is final and we can't override any final method in subclass.

In above example, we have override `fun v()` in Derived class, now if Derived class itself is base class for some other class and in that, if we don't want to allow override `fun v()`, we can do it by defining `final`.

```javascript
open class DerivedClass() : BaseClass() {
    final override fun v() {}
}

class AnotherDerived() : DerivedClass() {
    override fun v() {}  // This will give compile time error.
}
```

### Overriding Rules

Now take example, if there is one Base() class which has fun v() and there is one interface which has also fun v(), in Derived class, when you override fun v() -> whose property it will override?

The solution is here:

```javascript
open class Base {
    open fun f() { print("A") }
    fun a() { print("a") }
}

interface B {
    fun f() { print("B") } // interface members are 'open' by default
    fun b() { print("b") }
}

class Derived() : Base(), B {
    override fun f() {
		super<Base>.f()
        super<B>.f()
    }
}
```

So, here using keyword `super` you can define whose property you want to override.

