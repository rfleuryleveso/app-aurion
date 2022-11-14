package fr.rflv.appaurion.services.aurion.interfaces

import org.koin.core.component.KoinComponent

interface IAurionRequest {
    fun Login(email: String, password: String): Boolean;
    fun GetHomePage(): Boolean;

    fun SwitchToPlanningView();
    fun GetPlanningPartial();
}