package fr.rflv.appaurion.services.aurion.interfaces

import fr.rflv.appaurion.services.aurion.models.Course
import fr.rflv.appaurion.services.aurion.models.Mark
import fr.rflv.appaurion.services.aurion.models.Student

interface IAurion {
    fun getAllCourses(): ArrayList<Course>;
    fun getAllMarks(): ArrayList<Mark>;
}