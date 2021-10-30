package objectsandcompanionobjects

import sun.misc.resources.Messages_es
import java.text.SimpleDateFormat
import java.util.*

/*
   Dzieki object uzyskujemy Singletor (nie bedzie istniec wiecej niz 1 instancja tej klasy)
   Taki singleton jest thread safe
 */
object SimpleLogger {
    fun logInfo(message : String) {
        println(" INFO $message")
    }
    fun logError(message : String) {
        println(" ERROR $message")
    }
}

class SimpleTimer private constructor() {
    companion object Factory {
        fun create(): SimpleTimer = SimpleTimer()
    }

    fun currentTime(): String {
        return SimpleDateFormat("HH:mm:ss").format(Date())
    }
}

fun main() {
    val s1 = SimpleLogger
    val s2 = SimpleLogger
    println(s1.hashCode() == s2.hashCode())

    println(SimpleTimer.create().currentTime())
}
