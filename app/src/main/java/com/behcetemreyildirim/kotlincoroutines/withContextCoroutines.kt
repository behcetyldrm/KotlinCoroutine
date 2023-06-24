package com.behcetemreyildirim.kotlincoroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {

    runBlocking {

        launch(Dispatchers.Default) {
            println("Context: ${coroutineContext}")
            withContext(Dispatchers.IO) {
                //withContext -> launch içinde farklı context'te çalışmamızı sağlar
                println("Context: ${coroutineContext}")
            }
        }
    }
}