package generics

class AbstractTrio<A, B, C>(val value1: A, val value2: B, val value3: C) {
    override fun toString(): String {
        return value1.toString() + value2.toString() + value3.toString()
    }
}

interface Producer<out T> {  //out oznacza ze w tym interfejsie T moze byc zadeklarowane jedynie jako typ zwracany
    fun produce(): T
//    fun consume(el: T)  //to jest niemozliwe ze wzgledu na deklaracje w linii 9
}

fun fun1(obj: Producer<String>) {
    val ref : Producer<Any> = obj //dzieki out jest mozliwe "podstawienie" za superklase(Any), klasy pochodnej - String
}

interface Consumer<in T> {
    fun consume(el: T)
//    fun produce(): T
}

interface Comparable<in T> {
     fun compareTo(other: T): Int
}

class ListHelper {
    companion object {
        fun <T : Number> allNumbersDuplicate(item: T, n: Int): List<T> {
            val result = ArrayList<T>()
            repeat(n) {
                result.add(item)
            }
            return result
        }
    }
}