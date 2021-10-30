package delegations

import org.junit.Test
import kotlin.test.assertEquals

class BoxTest {

    @Test
    fun testSpecialValueForCorrectValue() {
        //given  //w tej sekcji przygotowuje dane wejsciowe, obiekty na podst. ktorych beda wykonywane testy
        val box = Box("box1", 2)   //1/1! + 1/2!

        //when   //w tej skecji wywoluje testowana funkcje
        val result : Double = box.specialValue

        //then  //zasadniczy test - tutaj piszemy asercje
        //test zostanie zaliczony jesli wszystkie asercje będą prawdziwe
        assertEquals(1.5, result)
    }
}