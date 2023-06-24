package com.behcetemreyildirim.kotlincoroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){

    println("start")
    runBlocking {
        launch {
            delay(5000)
            println("runblocking")
        }

        coroutineScope {  //başka bir coroutine içinde kullanım
            delay(3000)
            println("coroutine scope")
        }
    }
    println("end")
}