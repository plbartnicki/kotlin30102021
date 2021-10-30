package delegations

import kotlin.properties.Delegates

class Box(name: String, n: Int) {
    val name = name
        get() = field

    var n = n
        get() = field
        set(value) {
            field = value
        }

    //1/1! + 1/2! + .. 1/n!
    //1/1 + 1/1*2 + 1/1*2*3 + 1/1*2*3*4

    //leniwa propercja
    val specialValue: Double by lazy {  //dzieki lazy otrzymujemy gwarancje ze kod wykona sie raz i tylko i dopiero w momencie odwolania w tym przypadku do propercji
        println("computing has been started")
        var result = 0.0
        var fact = 1
        for(i in 1..n) {
            fact *= i
            result += 1/fact.toDouble()
        }
         result
    }

    //propercja ktora jest zwiazana z nasluchiwaniem oraz reagowaniem gdy jest wartosc sie zmieni
    var information: String by Delegates.observable("[no info]") {
        prop, old, new ->   //prop - informacje o propercji, old - wartosc przed updateem, new - wartosc nowa
        println("Sending email has been started")
        println("Email message: ${prop.name} has been updated from $old to $new")
        println("Sending email has been completed")
    }
}