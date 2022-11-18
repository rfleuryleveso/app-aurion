package fr.rflv.appaurion.services.aurion.interfaces

import fr.rflv.appaurion.services.aurion.data.Course
import fr.rflv.appaurion.services.aurion.data.Mark
import fr.rflv.appaurion.services.aurion.models.ICourse
import fr.rflv.appaurion.services.aurion.models.IMark

interface IAurion {
    fun login(username: String, password: String): Boolean;
    fun getAllCourses(): List<Course>;
    fun getAllMarks(): List<Mark>;
    fun hasSavedLogins(): Boolean;
    fun logout();
}