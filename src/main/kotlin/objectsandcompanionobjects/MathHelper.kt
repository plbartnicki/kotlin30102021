package objectsandcompanionobjects
/*
  1 - co zwraca funkcja f ?
  2 - co jest zle wykonane w kontekscie designe'u
 */
class MathHelper {
    private constructor()

    companion object {
        //Zwraca  najwiekszy dzielnik liczby n.
        fun f(n: Int): Int {
            if (n == 0) {
                throw IllegalArgumentException("Argument value should be greater than 0")
            }
            var s = n / 2   //kandydat na najwiekszy dzielnik
            while (s >= 1) {
                if (n % s == 0) {
                    return s
                }
                s--;
            }

            return s;
        }
    }
}

fun main() {
    println(MathHelper.f(10))
    println(MathHelper.f(15))
}