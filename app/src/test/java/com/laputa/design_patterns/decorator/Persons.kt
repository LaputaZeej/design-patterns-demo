package com.laputa.design_patterns.decorator

import kotlin.coroutines.suspendCoroutine

abstract class Person {
    abstract fun dressed()
}

class Boy :Person(){
    override fun dressed() {
       println("穿了内衣内裤")
    }
}

abstract class ClothPerson(private val person: Person) :Person(){
    override fun dressed() {
       person.dressed()
    }
}

class BiggerClothRerson(person: Person):ClothPerson(person){
    override fun dressed() {
        super.dressed()
        dressShirt()
        dressKuzi()
        dressPixie()
    }

    private fun dressPixie() {
        println("穿皮鞋")
    }

    private fun dressKuzi() {
        println("穿裤子")
    }

    private fun dressShirt() {
        println("穿衬衣")
    }
}


class LowerClothRerson(person: Person):ClothPerson(person){
    override fun dressed() {
        super.dressed()
     dressCaomao()
    }

    private fun dressCaomao() {
        println("戴草帽")
    }
}


