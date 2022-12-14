package fr.rflv.appaurion.services.database

import android.content.ContentValues
import android.content.Context
import fr.rflv.appaurion.services.aurion.data.Course
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonPrimitive
import org.koin.core.annotation.Single

@Single
class CoursesDatabaseHelper(private val context: Context) {

    private val database = Database(context)

    // This method is for adding data in our database
    fun addCourse(course: Course) {
        val db = this.database.writableDatabase
        try {
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

            db.insert("courses", null, values)
        } catch (e: Exception) {
            print("Error while inserting");
        } finally {
            db.close()
        }


    }

    fun getCourses(): List<Course> {
        val db = this.database.writableDatabase
        val coursesCursor = db.query("courses", null, null, null, null, null, null)
        val courses = mutableListOf<Course>();
        coursesCursor!!.moveToFirst();
        if (coursesCursor.count > 0) {
            do {
                courses.add(
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
                        teachers = Json.decodeFromString(
                            coursesCursor.getString(
                                coursesCursor.getColumnIndexOrThrow(
                                    "teachers"
                                )
                            )
                        ),
                        students = Json.decodeFromString(
                            coursesCursor.getString(
                                coursesCursor.getColumnIndexOrThrow(
                                    "students"
                                )
                            )
                        ),
                        courseType = coursesCursor.getString(coursesCursor.getColumnIndexOrThrow("courseType")),
                        rooms = Json.decodeFromString(
                            coursesCursor.getString(
                                coursesCursor.getColumnIndexOrThrow(
                                    "rooms"
                                )
                            )
                        ),
                        groups = Json.decodeFromString(
                            coursesCursor.getString(
                                coursesCursor.getColumnIndexOrThrow(
                                    "groups"
                                )
                            )
                        ),
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