package fr.rflv.appaurion.services.aurion.impl

import android.content.Context
import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import fr.rflv.appaurion.services.aurion.models.ICourse
import fr.rflv.appaurion.services.aurion.models.IMark
import org.koin.core.annotation.Single


@Single
open class AurionImpl(private val appContext: Context) : IAurion {

    override fun getAllCourses(): ArrayList<ICourse> {
        return ArrayList<ICourse>();
    }

    override fun getAllMarks(): ArrayList<IMark> {
        return ArrayList<IMark>();
    }
}