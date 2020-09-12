package com.example.enigma_bank

fun main() {
    val mobilBensinku = Car()
    mobilBensinku.engine = GasolineEngine()
    mobilBensinku.startEngine()
}

class Car(var engine: Engine? = null) {

    fun startEngine() {
        engine?.start()
    }

}

abstract class Engine {
    abstract fun start()
}

class GasolineEngine : Engine() {
    override fun start() {
        println("GasolineEngine started")
    }
}

class ElectricEngine : Engine() {
    override fun start() {
        println("ElectricEngine engine started")
    }
}

class DieselEngine : Engine() {
    override fun start() {
        println("DieselEngine started")
    }
}

class SteamEngine : Engine() {
    override fun start() {
        println("SteamEngine started")
    }
}
