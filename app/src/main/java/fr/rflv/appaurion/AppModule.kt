package fr.rflv.appaurion

import fr.rflv.appaurion.services.aurion.Aurion
import fr.rflv.appaurion.services.aurion.AurionImpl
import org.koin.dsl.module

val appModule = module {
    single<Aurion> { AurionImpl() }
}