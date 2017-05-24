---
layout: post
title: Control Flow
tags: [kotlin, Int, String, Double, Float, Long]
---

### Break

Any expression in Kotlin may be marked with a label. Labels have the form of an identifier followed by the @ sign, for example: abc@, fooBar@ are valid labels (see the grammar). To label an expression, we just put a label in front of it.

```javascript
abc@ fun labelLoop() {
        abc@ for( i in 1..100) {
            for(j in 1..100) {
                if (j == 2) {
                    break@abc
                }
            }
        }
    }
```