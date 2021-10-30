package extensions

//Mozemy rozszerzyc klase customowa
class Rectange(val a: Double, val b : Double) {
    fun area(): Double {
        return a*b;
    }
}

fun main() {

    //z jakiegos powodu, tymczasowo-lokalnie chcemy roszerzyc klase Rectangle
    fun Rectange.perimeter(): Double {
        return 2*(a+b)
    }

    fun Rectange.area(): Double {
        return 1.0
    }

    val rectange1 = Rectange(3.0, 10.0)
    println("Perimeter of rectangle is: ${rectange1.area()}")
    println("Perimeter of rectangle is: ${rectange1.perimeter()}")

    //Mozemy tez rozszerzyc klase z SDK
    fun String.evenLength(): Boolean {
        return this.length % 2 == 0
    }

    println("test".evenLength())
}

fun g(s: String): String
{
    fun h(t: String) : String {
        return t.capitalize()
    }

    return s + h(s) + s + h(s)
}