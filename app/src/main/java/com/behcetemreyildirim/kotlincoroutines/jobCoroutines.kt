package com.behcetemreyildirim.kotlincoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {

        val myJob = launch { //launch'ı bir değişkene eşitlersek Job verisi döndürür ve launch'la ilgili işlem yaparız
            delay(2000)
            println("job")

            val secondJob = launch {
                println("job 2")
            }
        }

        myJob.invokeOnCompletion {  //launch bittiken sonra ne yapılacağını yazarız. launch'ı iptal etsekte çalışır
            println("my job end")
        }

        myJob.cancel() //launch'ı iptal eder. İçerisindeki hiç bir kod çalışmaz. Hatta launch içindeki launch'ta iptal olur
    }
}