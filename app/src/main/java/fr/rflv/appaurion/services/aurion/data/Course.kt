package fr.rflv.appaurion.services.aurion.data

import fr.rflv.appaurion.services.aurion.models.ICourse
import kotlinx.datetime.LocalDateTime

data class Course(
    override val id: String,
    override val startDateTime: LocalDateTime,
    override val endDateTime: LocalDateTime,
    override val teachers: Array<String>,
    override val students: Array<String>,
    override val courseType: String,
    override val rooms: Array<String>,
    override val groups: Array<String>,
    override val name: String
) : ICourse {
    constructor(iCourse: ICourse) : this(
        id = iCourse.id,
        startDateTime = iCourse.startDateTime,
        endDateTime = iCourse.endDateTime,
        teachers = iCourse.teachers,
        students = iCourse.students,
        courseType = iCourse.courseType,
        rooms = iCourse.rooms,
        groups = iCourse.groups,
        name = iCourse.name
    )
}