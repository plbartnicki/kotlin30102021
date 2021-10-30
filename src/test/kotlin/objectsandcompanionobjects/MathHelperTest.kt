package objectsandcompanionobjects

import org.junit.Test
import kotlin.test.assertTrue
import kotlin.test.fail

class MathHelperTest {
    @Test
    fun testFShouldTrhowException() {  //test przejdzie jesli zostanie poprawnie rzucony wyjatek
        //give
//        var exThrown = false
        //when
//        val obj = MathHelper()

        try {
            MathHelper.f(0)
        } catch (e: IllegalArgumentException) {
            assertTrue { true }
            return
        }
        fail()
    }
}