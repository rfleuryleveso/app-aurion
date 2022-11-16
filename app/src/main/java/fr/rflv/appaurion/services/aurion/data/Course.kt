package fr.rflv.appaurion.services.aurion.data

import fr.rflv.appaurion.services.aurion.models.ICourse
import kotlinx.datetime.LocalDateTime

data class Course(
    override val start: LocalDateTime,
    override val end: LocalDateTime,
    override val teachers: Array<String>,
    override val students: Array<String>,
    override val courseType: String,
    override val rooms: Array<String>,
    override val groups: Array<String>,
    override val name: String
) : ICourse