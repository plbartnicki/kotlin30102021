package objectsandcompanionobjects

class TaskListHelper {
    companion object {
        fun containsDuplicate(words: List<String>) : Boolean {
            //a b b -> {b, a}
            return HashSet<String>(words).size != words.size
        }
    }
}