package fr.rflv.appaurion.services.aurion.interfaces

interface IAurionState {
    fun setState(state: String);
    fun getState(): String;
}