package fr.rflv.appaurion.services.aurion

import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import fr.rflv.appaurion.services.aurion.interfaces.IAurionRequest
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class TestAurionRunnable : Runnable, KoinComponent {
    private val aurionService: IAurion by inject();
    private val aurionRequest: IAurionRequest by inject();

    public override fun run() {
        val result = aurionRequest.Login("raphael.fleury-le-veso@student.junia.com", "PHOTO534@")
        aurionRequest.GetHomePage();
        aurionRequest.SwitchToPlanningView();
        aurionRequest.GetPlanningPartial();
    }
}