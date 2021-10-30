package nullandsafety

class TaskNullSafety {
    companion object {
        fun theSameLengthAndNonNull(word1: String?, word2: String?): Boolean {
            return word1?.length?.equals(word2?.length) ?: false
        }
    }
}

fun main() {
    println(TaskNullSafety.theSameLengthAndNonNull(null, null))
    println(TaskNullSafety.theSameLengthAndNonNull("abc", null))
    println(TaskNullSafety.theSameLengthAndNonNull(null, "abc"))
    println(TaskNullSafety.theSameLengthAndNonNull("xyz", "abc"))
    println(TaskNullSafety.theSameLengthAndNonNull("www", "monada"))
}