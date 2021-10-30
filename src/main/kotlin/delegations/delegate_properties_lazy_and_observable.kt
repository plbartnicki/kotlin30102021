package delegations

fun main() {

    //przyklad 1 - lazy
    val b1 = Box("box2", 3)
    println(b1.n)
    println(b1.name)
    println(b1.specialValue)
    println(b1.specialValue)

    //przyklad 2 - observable
    println(b1.information)
    b1.information = "this Box contains important information"
}
