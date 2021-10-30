package nullandsafety

import java.lang.Exception

fun main() {
    var nimber1: Int = 999  //defaultowo nie mozna podstawic null
    nimber1.equals(2)

    var number2: Int? = null   //mozliwosc podstawienia null dzieki znakowi ?

//   val res =  number2.equals(1)  //tak nie moze byc bo wczesniej zadeklarowalismy ze number2 moze byc null
    //1 spodob
    val res = if(number2 != null) number2.equals(1) else false
    println(res)

    //2 sposob
    val res2 = number2?.equals(1) ?: false
    println(res2)

    //obiekt A ktory moze zawierac obiekt B, obiekt B moze zawierac obiekt C, obiekt C moze zawierac obiekt D
    //majac obiekt A chcemy odwolac sie byc moze istniejacego obiektu D
    //val exists = objectA?.objectB?.objectC?.objectD?   //jesli np. objectB jest nullem  to exists bedzie null

    val names : List<String?> = listOf("Kasia", null, "Zosia")
    for(name in names)  {
        name?.let { println(it) }
    }


    try {
        f(-0.01)
    } catch (e : NullPointerException) {
        //cos tu mozna zrobic
    } catch (e : WrongArgumentException) {
        print(e.message)
//        e.stackTrace
    }

    println("app is still runnning")
}

class WrongArgumentException(message: String?) : Exception(message)

fun f(x: Double?) : Double {
    if(x!! <= 0.0)   //jesli x bedzie nullem to poleci wyjatek  (dzieki !!)
        throw WrongArgumentException("Argument's value should be positive")

    return Math.log(x!!) * Math.E + Math.E
}