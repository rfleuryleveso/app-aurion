package fr.rflv.appaurion.services.aurion.mock

import fr.rflv.appaurion.services.aurion.interfaces.IAurionState
import org.koin.core.annotation.Single

@Single
class AurionStateMock: IAurionState {
    var aurionState = "";

    override fun setState(state: String) {
        this.aurionState = state;
    }

    override fun getState(): String {
        return this.aurionState;
    }
}