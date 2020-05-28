package com.laputa.design_patterns.decorator

// Decorator Pattern (Wrapper Pattern)
// 装饰模式

// 【抽象组件类】
abstract class Component {
    abstract fun operate()
}

// 【组件具体实现类】
class ConcreteComponent : Component() {
    override fun operate() {
        println("组件具体实现类")
    }
}

// 【抽象装饰类】
// 装饰我们的组件对象，其内部一定要有一个指向组件对象的引用
// 大多数情况下，该类为抽象类，需要根据不同的装饰逻辑实现不同的具体子类
// 如果装饰逻辑单一，则直接使用该类作为具体的装饰类

abstract class Decorator(private val component: Component) : Component() {
    override fun operate() {
        component.operate()
    }
}

// 【装饰者具体的实现类】
class ConcreteComponentA(component: Component) : Decorator(component){
    override fun operate() {
        // 不破坏原类（比如ConcreteComponent）层次结构的情况下为类增加一些功能 ⭐⭐⭐⭐⭐
        operateBefore()
        super.operate()
        operateAfter()
    }

    private fun operateAfter() {
        println("A装饰operateAfter")
    }

    private fun operateBefore() {
        println("A装饰operateAfter")
    }
}

class ConcreteComponentB(component: Component) : Decorator(component){
    override fun operate() {
        super.operate()
        operateWrapper()
    }

    private fun operateWrapper() {
        println("B装饰operateWrapper")
    }


}

fun main() {
    val component = ConcreteComponent()
    val concreteComponentA = ConcreteComponentA(component)
    concreteComponentA.operate()

    val concreteComponentB = ConcreteComponentB(component)
    concreteComponentB.operate()
}