package objectsandcompanionobjects

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TaskListHelperTest {
    @Test
    fun testContainsDuplicateWithoutDuplicate() {
        //given
        val wods = listOf("asercja", "aksjomat")

        //when
        val result = TaskListHelper.containsDuplicate(wods)

        //then
        assertFalse(result)
    }

    @Test
    fun testContainsDuplicateWithDuplicate() {
        //given
        val wods = listOf("asercja", "aksjomat", "asercja")

        //when
        val result = TaskListHelper.containsDuplicate(wods)

        //then
        assertTrue(result)
    }
}