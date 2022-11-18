package fr.rflv.appaurion.services.aurion.interfaces

import fr.rflv.appaurion.services.aurion.impl.parsers.CoursesListCourse
import fr.rflv.appaurion.services.aurion.impl.parsers.ParseEventPartialResult
import kotlinx.datetime.LocalDateTime

interface IAurionRequest {
    fun Login(email: String, password: String): Boolean;
    fun GetHomePage(): Boolean;

    fun SwitchToPlanningView();
    fun GetPlanningPartial(start: LocalDateTime, end: LocalDateTime): ArrayList<CoursesListCourse>;
    fun GetPlanningEventDetail(eventId: String): ParseEventPartialResult;
    fun GetGrades(): ArrayList<CoursesListCourse>
    fun Clear()
}