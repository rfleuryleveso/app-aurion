package fr.rflv.appaurion

import fr.rflv.appaurion.services.aurion.impl.AurionImpl
import fr.rflv.appaurion.services.aurion.impl.AurionRequestImpl
import fr.rflv.appaurion.services.aurion.impl.AurionStateImpl
import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import fr.rflv.appaurion.services.aurion.interfaces.IAurionRequest
import fr.rflv.appaurion.services.aurion.interfaces.IAurionState
import fr.rflv.appaurion.services.aurion.mock.AurionMock
import fr.rflv.appaurion.services.aurion.mock.AurionRequestMock
import fr.rflv.appaurion.services.aurion.mock.AurionStateMock
import org.koin.dsl.module


val AppModule = module {
    single<IAurion> { AurionMock() }
    single<IAurionRequest> { AurionRequestMock(get()) }
    single<IAurionState> { AurionStateMock() }

}