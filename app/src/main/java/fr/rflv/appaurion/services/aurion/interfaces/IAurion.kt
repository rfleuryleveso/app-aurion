package fr.rflv.appaurion.services.aurion.interfaces

import org.koin.core.component.KoinComponent

interface IAurion  {
    fun getAllCourses(): Array<String>;
    fun getAllMarks(): Array<String>;
}