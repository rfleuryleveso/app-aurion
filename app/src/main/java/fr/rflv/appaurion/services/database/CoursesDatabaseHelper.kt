package fr.rflv.appaurion.services.database

import android.content.ContentValues
import android.content.Context
import fr.rflv.appaurion.services.aurion.data.Course
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonPrimitive

class CoursesDatabaseHelper(private val context: Context) {

    private val database = Database(context)

    // This method is for adding data in our database
    fun addCourse(course: Course) {
        val values = ContentValues()
        values.put("id", course.id)
        values.put("startDateTime", course.startDateTime.toString())
        values.put("endDateTime", course.endDateTime.toString())
        values.put("teachers", JsonArray(course.teachers.map { JsonPrimitive(it) }).toString())
        values.put("students", JsonArray(course.students.map { JsonPrimitive(it) }).toString())
        values.put("courseType", course.courseType)
        values.put("rooms", JsonArray(course.rooms.map { JsonPrimitive(it) }).toString())
        values.put("groups", JsonArray(course.groups.map { JsonPrimitive(it) }).toString())
        values.put("name", course.name)
        val db = this.database.writableDatabase
        db.insert("courses", null, values)
        db.close()
    }

    fun getCourses(): Array<Course> {
        val db = this.database.writableDatabase
        val coursesCursor = db.query("courses", null, null, null, null, null, null)
        val courses = arrayOf<Course>();
        coursesCursor!!.moveToFirst();
        if (coursesCursor.count > 0) {
            do {
                courses.plus(
                    Course(
                        id = coursesCursor.getString(coursesCursor.getColumnIndexOrThrow("id")),
                        startDateTime = LocalDateTime.parse(
                            coursesCursor.getString(
                                coursesCursor.getColumnIndexOrThrow(
                                    "startDateTime"
                                )
                            )
                        ),
                        endDateTime = LocalDateTime.parse(
                            coursesCursor.getString(
                                coursesCursor.getColumnIndexOrThrow(
                                    "endDateTime"
                                )
                            )
                        ),
                        teachers = arrayOf(),
                        students = arrayOf(),
                        courseType = coursesCursor.getString(coursesCursor.getColumnIndexOrThrow("courseType")),
                        rooms = arrayOf(),
                        groups = arrayOf(),
                        name = coursesCursor.getString(coursesCursor.getColumnIndexOrThrow("name")),
                    )
                )
                coursesCursor.moveToNext()
            } while (!coursesCursor.isAfterLast)
        }
        coursesCursor.close();
        return courses;
    }
}