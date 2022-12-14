package fr.rflv.appaurion.services.aurion

import android.content.Context
import fr.rflv.appaurion.services.aurion.data.Course
import fr.rflv.appaurion.services.aurion.data.Mark
import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import fr.rflv.appaurion.services.aurion.interfaces.IAurionRequest
import fr.rflv.appaurion.services.database.CoursesDatabaseHelper
import kotlinx.datetime.LocalDateTime
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class AurionImporter(
    private val context: Context
) : KoinComponent {
    private val aurionService: IAurion by inject();
    private val aurionRequest: IAurionRequest by inject();

    fun importScheduleFromAurion(
        login: String, password: String,
        startDate: LocalDateTime,
        endDate: LocalDateTime
    ): List<Course> {
        aurionRequest.Clear();
        val result = aurionRequest.Login(login, password)
        aurionRequest.GetHomePage();
        aurionRequest.SwitchToPlanningView();
        val courses = aurionRequest.GetPlanningPartial(
            startDate,
            endDate
        );
        val mappedCourses = courses.map {
            val courseDetails = aurionRequest.GetPlanningEventDetail(it.id);
            val details = courseDetails.details;
            val description = details.attributes.find { it -> it.first == "Description" }
            val eventType =
                details.attributes.find { it -> it.first == "Type d'enseignement" }
            val name: String;
            if (description!!.second.length != 0) {
                name = description.second;
            } else if (details.modules.count() > 0) {
                name = details.modules[0].first;
            } else if (details.teachers.count() > 0) {
                name = details.teachers.map { "${it.first} ${it.second}" }.joinToString();
            } else {
                name = "${it.startDate().toString()} ${it.endDate().toString()}";
            }

            println(
                "${details.students.count()} students for ${name} ${
                    it.startDate().toString()
                }"
            );

            val teachers = details.teachers.map { "${it.first} ${it.second}" };
            val students = details.students.map { "${it.first} ${it.second}" };

            return@map Course(
                id = it.id,
                startDateTime = it.startDate(),
                endDateTime = it.endDate(),
                teachers = teachers.toTypedArray(),
                students = students.toTypedArray(),
                courseType = eventType!!.second,
                rooms = details.rooms.toTypedArray(),
                groups = details.groups.toTypedArray(),
                name = name
            )
        }
        val db = CoursesDatabaseHelper(context);
        mappedCourses.forEach { db.addCourse(it) }
        return mappedCourses;

    }

    fun importGradesFromAurion(
        login: String, password: String
    ): List<Mark> {
        aurionRequest.Clear();
        val result = aurionRequest.Login(login, password)
        aurionRequest.GetHomePage();
        val grades = aurionRequest.GetGrades();
        return listOf();

    }
}