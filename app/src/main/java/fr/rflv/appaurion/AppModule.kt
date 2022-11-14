package fr.rflv.appaurion

import fr.rflv.appaurion.services.aurion.impl.AurionImpl
import fr.rflv.appaurion.services.aurion.impl.AurionRequestImpl
import fr.rflv.appaurion.services.aurion.impl.AurionStateImpl
import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import fr.rflv.appaurion.services.aurion.interfaces.IAurionRequest
import fr.rflv.appaurion.services.aurion.interfaces.IAurionState
import org.koin.dsl.module


val AppModule = module {
    single<IAurion> { AurionImpl() }
    single<IAurionRequest> { AurionRequestImpl(get()) }
    single<IAurionState> { AurionStateImpl() }

}