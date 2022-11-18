package fr.rflv.appaurion

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Start Koin dependency injection
        startKoin {
            androidLogger() // Integrate with Android logger
            androidContext(this@MainApplication) // Inject application context
            modules(AppModule) // Inject modules, and bind their dependencies
        }
    }
}