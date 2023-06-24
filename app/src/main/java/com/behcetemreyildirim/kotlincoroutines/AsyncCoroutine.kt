package com.behcetemreyildirim.kotlincoroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    var userName = ""
    var userAge = 0

    runBlocking {

        val downloadedName = async {
            downloadName()
        }

        val downloadedAge = async {
            /*
            async -> launch'tan farkı geriye bir değer döndürür ve bunu bir değişkene eşitleyebiliriz. İnternetten bir veri
            indirirken bunu arkaplanda asenkron bir şekilde gerçekleştirir ve main thread'i bloklamaz.
            */
            downloadAge()
        }

        userName = downloadedName.await() //await -> değer alındıktan sonra içerisindeki veriyi çeker
        userAge = downloadedAge.await()

        println("$userName $userAge")

    }

}

suspend fun downloadName(): String{
    delay(2000)
    val username = "Atıl: "
    println("username download")
    return username
}

suspend fun downloadAge(): Int{
    delay(4000)
    val age = 20
    println("age download")
    return age
}