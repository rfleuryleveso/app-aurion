package fr.rflv.appaurion.services.aurion


interface Aurion {
    fun sayHello();
}

class AurionImpl : Aurion {
    override fun sayHello() {
        println("Hello world")
    }
}