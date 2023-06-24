package com.behcetemreyildirim.kotlincoroutines


import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(){


    runBlocking {
        delay(2000)
        println("runblocking")
        myFunc()
    }
}

suspend fun myFunc() { //suspend fonksiyonlar. suspend fonksiyonlar ya da coroutine dışında kullanılamaz
    coroutineScope {
        delay(4000)
        println("suspend func")
    }
}