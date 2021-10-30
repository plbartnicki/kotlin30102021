package delegations

import java.lang.IllegalArgumentException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap
import kotlin.streams.toList

interface DateTimeGenerator {
    fun generateDate(): String
    fun generateTime(): String
}

class StandardDateTimeGenerator(val messagePrefix: String) : DateTimeGenerator {
    override fun generateDate(): String {
        val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
        val currentDate = simpleDateFormat.format(Date())
        return "${messagePrefix} ${currentDate}"
    }

    override fun generateTime(): String {
        val simpleDateFormat = SimpleDateFormat("HH:mm:ss")
        val currentTime = simpleDateFormat.format(Date())
        return "${messagePrefix} ${currentTime}"
    }
}

/*
 chcemy dodac klase BasicDateTimeGenerator ktora bedzie dostarczala innego zachowania generateDate()
 tzn nie bedzie zwracala message jako prefixu
 Ale nie chcemy uzyc dziedziczenia
 */
class BasicDateTimeGenerator(dateTimeGenerator: DateTimeGenerator): DateTimeGenerator by dateTimeGenerator {
    override fun generateDate(): String {
        val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
        val currentDate = simpleDateFormat.format(Date())
        return "${currentDate}"
    }
}

fun div( a: Double,  b: Double) : Double {
    if(b.equals(0.0)) {
        throw IllegalArgumentException("b should not be equals 0")
    }

    return a /b;
}

fun main() {
    val standardDateTimeGenerator = StandardDateTimeGenerator("Current time: ")
    println(standardDateTimeGenerator.generateDate())

    val basicDateTimeGenerator = BasicDateTimeGenerator(standardDateTimeGenerator)
    println(basicDateTimeGenerator.generateDate())

    val list1 = ArrayList<String>()  //[a0,a1, .. an]
    val list2 = LinkedList<Double>()   //a0->a1 -> a2->   an -> null
    list2.add("123.0".toDouble())
    var list3 = listOf("abc", "def", "ww")  //w ten sposob deklaruje liste immutable / readonly
    val list0 = arrayListOf<Double>(-0.001, 1.0)

    //z list3 chcemy uzyskac liste, tylko tych elementow (dodatkowo z pierwsza wieksza litera) ktorych dlugosci sa > 2
    val res1 = list3.stream().filter{ it.length > 2}.map{ it.capitalize()}.toList()
    println(res1)

    //HashSet bazuje na hashowaniu: f: W -> N   f(x) = x mod 100   x nalezy do N  f(x) nalezy do <0 , 99 >
    //HashSet nie gwarantuje ze kolejnosc dodawania obiektow bedzie taka sama jak kolejnosc w wyniku iteracji
    val hasShet = HashSet<Int>()
    hasShet.add(1)  //szybkie (w czasie O(1) - stalym) dodawanie elementu
    hasShet.add(1)    //
    println(hasShet.size)
    hasShet.contains(1)   //szybkie (w czasie O(1) - stalym) sprawdzanie czy  element istnieje
    //{a,b,c} = {c, b, a}    {a,b,b} - to nie jest zbior
    //gdybysmy chcieli zrobic HashSet z obiektami naszej-customowej klasy, to trzeba sie upewnic ze w tej klasie jest
    //odpowiednia implementacja hashCode oraz equals - ktora dodajemy poprzez alt+ins (zostanie wygenerowana automatycznie)

    val set2 = setOf(1,2,3) - setOf(2)
    print(set2)

    //jesli chcemy zeby kolejnosc dodawania do zbioru byla taka sama jak kolejnosc iteracji - to nalezy uzyc LinkedHashSet
    val linkedHashSet = LinkedHashSet<Int>()
    for(i in 1..100)
        linkedHashSet.add(i)

    linkedHashSet.forEach{print("${it} ")}

    val map1 = HashMap<String, Int>()
    map1.put("one", 1)
    map1.put("two", 2)
    map1.contains("one")
    println()
    println("one".hashCode())
    println("two".hashCode())
    /*       numer komorki   wartosci
               ..
               110182             [1,14]
               115276             [2,..]
     */

    val map2 = mapOf("dog" to "pies", "cat" to "kot")
    println(map2)

    //losowanie
    println((1..100).random())
}
