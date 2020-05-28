package com.laputa.design_patterns

import com.laputa.design_patterns.decorator.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_DecoratorPattern() {
        val component = ConcreteComponent()
        val concreteComponentA = ConcreteComponentA(component)
        concreteComponentA.operate()
        val concreteComponentB = ConcreteComponentB(component)
        concreteComponentB.operate()

        println("-----------------------------------------")

        val boy = Boy()
        val biggerClothRerson = BiggerClothRerson(boy)
        val lowerClothRerson = LowerClothRerson(boy)
        biggerClothRerson.dressed()
        lowerClothRerson.dressed()
    }
}
