package fr.rflv.appaurion.services.aurion

import android.content.Context
import fr.rflv.appaurion.services.aurion.data.Course
import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import fr.rflv.appaurion.services.aurion.interfaces.IAurionRequest
import fr.rflv.appaurion.services.database.CoursesDatabaseHelper
import kotlinx.datetime.LocalDateTime
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class UpdateCoursesDatabaseRunnable(
    private val context: Context,
    private val startDate: LocalDateTime,
    private val endDate: LocalDateTime
) : Runnable, KoinComponent {
    private val aurionService: IAurion by inject();
    private val aurionRequest: IAurionRequest by inject();

    public override fun run() {
        val result = aurionRequest.Login("raphael.fleury-le-veso@student.junia.com", "PHOTO534@")
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
            val eventType = details.attributes.find { it -> it.first == "Type d'enseignement" }
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
        val db = CoursesDatabaseHelper(this.context);
        mappedCourses.forEach { db.addCourse(it) }

        println("got result")
    }
}