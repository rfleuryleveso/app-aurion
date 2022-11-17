package fr.rflv.appaurion.services.aurion.interfaces

import fr.rflv.appaurion.services.aurion.models.ICourse
import fr.rflv.appaurion.services.aurion.models.IMark

interface IAurion {
    fun getAllCourses(): ArrayList<ICourse>;
    fun getAllMarks(): ArrayList<IMark>;
}