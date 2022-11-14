package fr.rflv.appaurion.services.aurion.mock

import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import fr.rflv.appaurion.services.aurion.models.Course
import fr.rflv.appaurion.services.aurion.models.Mark
import org.koin.core.annotation.Single


@Single
open class AurionMock : IAurion {

    override fun getAllCourses(): ArrayList<Course> {
        return ArrayList<Course>();
    }

    override fun getAllMarks(): ArrayList<Mark> {
        return ArrayList<Mark>();
    }
}