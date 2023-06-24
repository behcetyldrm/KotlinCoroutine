package com.behcetemreyildirim.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Light Weightness -> hafiflik. Coroutines'in hafif bir yapısı vardır

        //Scope -> kapsam
        //GlobalScope -> tüm app'i kapsayarak çalışır ve içerisindeki kodları yazarken alt satırdaki kodları bloklamaz
        //runBlocking -> kapsam içerisindeki işlemler bitene kadar alt satırda bulunan kodları yazmaz
        //CoroutineScope -> global scope ile aynıdır. tek farkı tüm app'i kapsamaz. belli bir context'i kapsar

        //runBlocking
        println("runblocking start")
        runBlocking {
            launch { //coroutine işlemlerinde kodları yazacağımız alandır
                delay(5000) // bekleme süresi milisaniye cinsinden
                println("runblocking")
            }
        }
        println("runblocking end")

        //GlobalScope //start yazılır sonra 5 sn beklerken alt satırdaki end yazılır ve 5 sn bittikten sorna globalscope yazılır
        println("globalscope start")
        GlobalScope.launch{
            delay(5000)
            println("globalscope")
        }
        println("global scope end")

        //Coroutine Scope
        //coroutine scope tek başına kullanılamaz. ya suspend func.'larda ya da başka coroutine'ler içinde kullanılabilir
        println("coroutines scope start")
        CoroutineScope(Dispatchers.Default).launch {
            delay(5000)
            println("coroutine scope")
        }
        println("coroutine scope end")

        //Dispatchers

        //Dispatchers.Default -> CPU Intensive. yoğun işlemlerde yani işlemciyi yoracak işlerde kullanılır
        //Dispatchers.IO -> Input / Output. İntertten veri çekmek gibi işlemlerde kullanılabilir
        //Dispatchers.Main -> UI.
        //Dispatchers.Unconfined -> Inherited dispatcher. Miras alma devralma gibi işlemleri yapar

        runBlocking {
            launch(Dispatchers.Main) {
                println("Main Thread: ${Thread.currentThread().name}") //güncel Thread'in adını alır
            }

            launch(Dispatchers.IO) {
                println("IO Thread: ${Thread.currentThread().name}")
            }

            launch(Dispatchers.Default) {
                println("Default Thread: ${Thread.currentThread().name}")
            }

            launch(Dispatchers.Unconfined) {
                println("Unconfined Thread: ${Thread.currentThread().name}")
            }
        }
    }
}