package fr.rflv.appaurion.services.aurion.impl

import android.content.Context
import fr.rflv.appaurion.R
import fr.rflv.appaurion.services.aurion.AurionImporter
import fr.rflv.appaurion.services.aurion.data.Course
import fr.rflv.appaurion.services.aurion.data.Mark
import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import fr.rflv.appaurion.services.aurion.interfaces.IAurionRequest
import fr.rflv.appaurion.services.aurion.mock.AurionMock
import fr.rflv.appaurion.services.database.CoursesDatabaseHelper
import fr.rflv.appaurion.services.database.MarksDatabaseHelper
import kotlinx.coroutines.delay
import kotlinx.datetime.*
import org.koin.core.annotation.Single


@Single
open class AurionImpl(
    private val appContext: Context,
    private val coursesDatabaseHelper: CoursesDatabaseHelper,
    private val marksDatabaseHelper: MarksDatabaseHelper,
    private val aurionRequest: IAurionRequest,
    private val aurionImporter: AurionImporter,

) : IAurion {
    override fun getAllCourses(): List<Course> {
        var courses = this.coursesDatabaseHelper.getCourses();
        if (courses.isEmpty()) {
            val nowInstant = Clock.System.now();
            val minus2Months =
                nowInstant.minus(1, DateTimeUnit.WEEK, TimeZone.UTC)
                    .toLocalDateTime(
                        TimeZone.UTC
                    );
            val plus2Months =
                nowInstant.plus(1, DateTimeUnit.WEEK, TimeZone.UTC)
                    .toLocalDateTime(
                        TimeZone.UTC
                    );
            val sharedPref = appContext.getSharedPreferences(
                appContext.getString(R.string.shared_preferences_file),
                Context.MODE_PRIVATE
            )
            val email =
                sharedPref.getString(appContext.getString(R.string.pref_email_key), "")
            val password =
                sharedPref.getString(appContext.getString(R.string.pref_password_key), "")

            if (email != null && password != null) {
                courses =
                    aurionImporter.importScheduleFromAurion(
                        email,
                        password,
                        minus2Months,
                        plus2Months
                    )
                        .toList()
            };
        }
        return courses;
    }

    override fun getAllMarks(): List<Mark> {
        var marks = this.marksDatabaseHelper.getMarks();
        if (marks.isEmpty()) {
            marks = AurionMock().getAllMarks()
            /* val sharedPref = appContext.getSharedPreferences(
                appContext.getString(R.string.shared_preferences_file),
                Context.MODE_PRIVATE
            )
            val email =
                sharedPref.getString(appContext.getString(R.string.pref_email_key), "")
            val password =
                sharedPref.getString(appContext.getString(R.string.pref_password_key), "")

            if (email != null && password != null) {
                marks =
                    aurionImporter.importGradesFromAurion(email, password)
                        .toList()
            };*/
        }
        return marks;
    }

    override fun hasSavedLogins(): Boolean {
        val sharedPref = appContext.getSharedPreferences(
            appContext.getString(R.string.shared_preferences_file),
            Context.MODE_PRIVATE
        )
        val email =
            sharedPref.getString(appContext.getString(R.string.pref_email_key), "")
        val password =
            sharedPref.getString(appContext.getString(R.string.pref_password_key), "")

        return email != null && password != null && email.length > 0 && password.length > 0;

    }

    override fun logout() {
        val sharedPref = appContext.getSharedPreferences(
            appContext.getString(R.string.shared_preferences_file),
            Context.MODE_PRIVATE
        )
        with(sharedPref.edit()) {
            clear()
            commit()
        }

    }

    override fun login(username: String, password: String): Boolean {
        val result = this.aurionRequest.Login(username, password);
        if (result) {
            val sharedPref = appContext.getSharedPreferences(
                appContext.getString(R.string.shared_preferences_file),
                Context.MODE_PRIVATE
            )
            with(sharedPref.edit()) {
                putString(appContext.getString(R.string.pref_email_key), username)
                putString(appContext.getString(R.string.pref_password_key), password)
                apply()
            }
        }
        return result
    }
}