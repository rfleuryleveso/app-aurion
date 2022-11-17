package fr.rflv.appaurion.services.aurion.interfaces

import fr.rflv.appaurion.services.aurion.models.ICourse
import fr.rflv.appaurion.services.aurion.models.IMark

interface IAurion {
    fun login(username: String, password: String): Boolean;
    fun getAllCourses(): ArrayList<ICourse>;
    fun getAllMarks(): ArrayList<IMark>;
}