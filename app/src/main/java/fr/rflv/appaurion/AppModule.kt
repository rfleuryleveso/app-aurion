package fr.rflv.appaurion

import fr.rflv.appaurion.services.aurion.Aurion
import fr.rflv.appaurion.services.aurion.AurionImpl
import fr.rflv.appaurion.services.aurion.AurionRequest
import fr.rflv.appaurion.services.aurion.AurionRequestImpl
import org.koin.core.scope.get
import org.koin.dsl.module

val appModule = module {
    single<Aurion> { AurionImpl() }
    single<AurionRequest> { AurionRequestImpl() }
}