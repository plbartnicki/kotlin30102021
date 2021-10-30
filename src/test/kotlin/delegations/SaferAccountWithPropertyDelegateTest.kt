package delegations

import org.junit.Test
import kotlin.test.assertEquals

class SaferAccountWithPropertyDelegateTest {
    @Test
    fun testToPaySuccessWithoutUpdate() {
        //given
        val sa1 = SaferAccountWithPropertyDelegate(1)

        //when
        val updateCount = sa1.updateCount
        val posValue = sa1.toPay

        //then
        assertEquals(0, updateCount)
        assertEquals(0.0, posValue)
    }

    @Test
    fun testToPaySuccessWithUpdate() {
        //given
        val sa1 = SaferAccountWithPropertyDelegate(1)

        //when
        sa1.toPay = 10000.0

        //then
        assertEquals(10000.0, sa1.toPay)
        assertEquals(1, sa1.updateCount)
    }
}