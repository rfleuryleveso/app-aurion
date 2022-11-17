package fr.rflv.appaurion.services.aurion.impl

import android.content.Context
import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import fr.rflv.appaurion.services.aurion.interfaces.IAurionRequest
import fr.rflv.appaurion.services.aurion.models.ICourse
import fr.rflv.appaurion.services.aurion.models.IMark
import fr.rflv.appaurion.services.database.CoursesDatabaseHelper
import org.koin.core.annotation.Single


@Single
open class AurionImpl(
    private val appContext: Context,
    private val coursesDatabaseHelper: CoursesDatabaseHelper,
    private val aurionRequest: IAurionRequest
) : IAurion {
    override fun getAllCourses(): ArrayList<ICourse> {
        return ArrayList<ICourse>();
    }

    override fun getAllMarks(): ArrayList<IMark> {
        return ArrayList<IMark>();
    }

    override fun login(username: String, password: String): Boolean {
        this.aurionRequest.Login(username, password);
        return true
    }
}