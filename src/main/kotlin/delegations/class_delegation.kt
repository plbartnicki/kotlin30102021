package delegations

import java.text.SimpleDateFormat
import java.util.*
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
    hasShet.add(1)

    //gdybysmy chcieli zrobic HashSet z obiektami naszej-customowej klasy, to trzeba sie upewnic ze w tej klasie jest
    //odpowiednia implementacja hashCode oraz equals

    val set2 = setOf(1,2,3) - setOf(2)
    print(set2)

    //jesli chcemy zeby kolejnosc dodawania do zbioru byla taka sama jak kolejnosc iteracji - to nalezy uzyc LinkedHashSet
    val linkedHashSet = LinkedHashSet<Int>()
    for(i in 1..100)
        linkedHashSet.add(i)

    linkedHashSet.forEach{print("${it} ")}
}
