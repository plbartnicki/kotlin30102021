package extensions

import java.util.*

class SimpleLogger {
    fun log(message : String) {
        val currentTime = Calendar.getInstance().time
        println("$currentTime -- $message")
    }
}

fun main() {
    val simpleLogger = SimpleLogger()
    simpleLogger.log("Connection to database has been interrupted")

    //TODO: let's extend SimpleLogger class adding surroundedLog function
    fun SimpleLogger.surroundedLog(message : String) {
        fun separators(n: Int) {
            for(i in 1..n) {
                print("-")
            }
            println()
        }
        val messageLength = message.length
        separators(messageLength)
        println(message)
        separators(messageLength)
    }

    simpleLogger.surroundedLog("Connection to database has been interrupted")
}