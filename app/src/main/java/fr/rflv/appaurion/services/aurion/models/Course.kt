package fr.rflv.appaurion.services.aurion.models

import kotlinx.datetime.LocalDateTime

interface Course {
    val start: LocalDateTime;
    val end: LocalDateTime;
    val teachers: Array<String>;
    val students: Array<String>;
    val courseType: String;
    val rooms: Array<String>;
    val groups: Array<String>
    val name: String;
}