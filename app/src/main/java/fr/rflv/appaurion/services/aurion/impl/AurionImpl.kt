package fr.rflv.appaurion.services.aurion.impl

import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import fr.rflv.appaurion.services.aurion.models.ICourse
import fr.rflv.appaurion.services.aurion.models.Mark
import org.koin.core.annotation.Single


@Single
open class AurionImpl : IAurion {

    override fun getAllCourses(): ArrayList<ICourse> {
        return ArrayList<ICourse>();
    }

    override fun getAllMarks(): ArrayList<Mark> {
        return ArrayList<Mark>();
    }
}