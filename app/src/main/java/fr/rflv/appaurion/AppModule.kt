package fr.rflv.appaurion

import fr.rflv.appaurion.services.aurion.AurionImporter
import fr.rflv.appaurion.services.aurion.impl.AurionImpl
import fr.rflv.appaurion.services.aurion.impl.AurionRequestImpl
import fr.rflv.appaurion.services.aurion.impl.AurionStateImpl
import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import fr.rflv.appaurion.services.aurion.interfaces.IAurionRequest
import fr.rflv.appaurion.services.aurion.interfaces.IAurionState
import fr.rflv.appaurion.services.database.CoursesDatabaseHelper
import fr.rflv.appaurion.services.database.MarksDatabaseHelper
import fr.rflv.appaurion.viewmodels.GradesViewModel
import fr.rflv.appaurion.viewmodels.LoginViewModel
import fr.rflv.appaurion.viewmodels.ScheduleViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


val AppModule = module {
    single { CoursesDatabaseHelper(androidContext()) }
    single { MarksDatabaseHelper(androidContext()) }
    single { AurionImporter(androidContext()) }
    single<IAurion> { AurionImpl(androidContext(), get(), get(), get(), get()) }
    single<IAurionRequest> { AurionRequestImpl(get()) }
    single<IAurionState> { AurionStateImpl() }
    viewModelOf(::GradesViewModel)
    viewModelOf(::LoginViewModel)
    viewModelOf(::ScheduleViewModel)
}