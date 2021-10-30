package delegations

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class PositiveValueDelegate: ReadWriteProperty<Any?, Double> {
    private var postiveValue: Double = 0.0

    override fun getValue(thisRef: Any?,  //referencja na obiekt klasy, ktorej dotyczy propercja
                          property: KProperty<*>  //informacje o propercji
    ): Double {
        return postiveValue
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Double) {
        if(thisRef is SaferAccountWithPropertyDelegate) {
            thisRef.updateCount++
        }
        if(value > 0) {
            postiveValue = value
        }
    }
}