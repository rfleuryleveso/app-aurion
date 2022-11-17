package fr.rflv.appaurion

import android.app.Application
import fr.rflv.appaurion.services.aurion.UpdateCoursesDatabaseRunnable
import kotlinx.datetime.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(AppModule)
        }

        val nowInstant = Clock.System.now();
        val minus2Months =
            nowInstant.minus(2, DateTimeUnit.MONTH, TimeZone.UTC)
                .toLocalDateTime(
                    TimeZone.UTC
                );
        val plus2Months =
            nowInstant.plus(2, DateTimeUnit.MONTH, TimeZone.UTC)
                .toLocalDateTime(
                    TimeZone.UTC
                );

        val threadWithRunnable =
            Thread(UpdateCoursesDatabaseRunnable(this, minus2Months, plus2Months))
        threadWithRunnable.start()

    }
}