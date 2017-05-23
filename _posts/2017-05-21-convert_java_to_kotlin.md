---
layout: post
title: Convert Java To Kotlin
image: /img/convert-java-to-kotlin.png
tags: [kotlin, Java, Android studio]
---

If you have already class return in java, you can easily convert it in to Kotlin!!

Just follow following simple steps and you are ready to go.

Open java class file and **invoke action** (just double tap shift to open search window).

Type there: **Convert Java File to Kotlin File** 

![convert-java-to-kotlin](/img/convert-java-to-kotlin.png)

Alternatively you can call this option via the Code -> Convert Java File to Kotlin File menu entry or by using the corresponding shortcut (you can find it at the menu entry).

![javaToKotlin](/img/javaToKotlin.png)

So, if your code in java is like:

```javascript
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
````

After converting in **Kotlin**, it will looks like:
```javascript
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
```


