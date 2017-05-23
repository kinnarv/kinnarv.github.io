---
layout: post
title: Hello World Using Kotlin
image: /img/kotlin.jpg
tags: [kotlin, Android studio]
---

It’s extremely easy to start using Kotlin for Android development. In this tutorial we’ll follow the warming up process with Android Studio. If using Intellij IDEA with Android, the process is almost the same.

First let's create a new project. Choose Start a new Android Studio project or File -> New project. The following dialogs walk you through the process of new project creation. You need to name the project and choose which Android SDK version you have installed. Most options can be left with their default values, so you can press 'Enter' several times.

![helloWorld](/img/kotlin_first_project.gif)

Once project configuration is done, you can see following class in project:

Classname: **MainActivity.kt**

**Note:** Here class extension will be .kt -> which stands for kotlin.

```javascript
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
```

