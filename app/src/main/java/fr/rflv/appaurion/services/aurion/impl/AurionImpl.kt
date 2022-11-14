package fr.rflv.appaurion.services.aurion.impl

import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import org.koin.core.annotation.Single


@Single
open class AurionImpl : IAurion {

    override fun getAllCourses(): Array<String> {
        TODO("Not yet implemented")
    }

    override fun getAllMarks(): Array<String> {
        TODO("Not yet implemented")
    }
}