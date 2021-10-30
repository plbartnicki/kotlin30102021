package delegations

import java.lang.IllegalArgumentException

interface RandGenerator {
    fun rand(amount : Int, min: Int, max: Int) : List<Int>
}

class MainRandGenerator: RandGenerator {
    override fun rand(amount: Int, min: Int, max: Int): List<Int> {
        if(amount < 0 || max < 0 || min < 0 || max < min || amount > max - min +1) {
            throw IllegalArgumentException("Wrong argument[s]")
        }

        val numbers = ArrayList<Int>()
        for(i in 1 .. amount) {
            numbers.add((min..max).random())
        }

        return numbers
    }
}

class SpecialRandGenerator(randGenerator: MainRandGenerator): RandGenerator by randGenerator {
    override fun rand(amount: Int, min: Int, max: Int): List<Int> {
        if(amount < 0 || max < 0 || min < 0 || max < min || amount > max - min +1) {
            throw IllegalArgumentException("Wrong argument[s]")
        }

        val numbers = LinkedHashSet<Int>()  //dotychczasowo wylosowane liczby
        while(numbers.size < amount) {
            val rnd = (min..max).random()
            if(!numbers.contains(rnd)) {   //dla HashShet metoda contains zabiera O(1) czasu, a dla listy ma zlozonosc O(n)
                numbers.add(rnd) // dla HashSet add zabiera O(1)
            }
        }

        return numbers.toList()
    }
}

fun main() {
    val mainRandGenerator = MainRandGenerator()
    println(mainRandGenerator.rand(10, 1, 10))

    val specialRandGenerator = SpecialRandGenerator(mainRandGenerator)
    try {
        println(specialRandGenerator.rand(100, 1, 10))
    } catch (e : IllegalArgumentException) {
        //mozemy zareagowac
        //najczesciej sie zapisuje informacje do pliku loga
        println(e.message)
        throw e
    }
    finally {
        println("Finally section")
    }

    println("application is sill running")
    //Wyjatki w Kotlinie roznia sie od wyjatkow w Javie tym ze wszystkie sa unchecked (mozna lapac)

}