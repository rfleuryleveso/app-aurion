package fr.rflv.appaurion.activities

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import fr.rflv.appaurion.R
import fr.rflv.appaurion.fragments.GradesRecycleViewFragment
import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import org.koin.android.ext.android.inject
import java.util.*


class GradesActivity() : AppCompatActivity() {
    private lateinit var deconnectionImage: ImageView
    private lateinit var scheduleImage: ImageView
    private val aurion: IAurion by inject();

    private lateinit var dateOfWeek: TextView
    private lateinit var day: TextView
    private lateinit var monthAndYear: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grades)
        replaceFragment(GradesRecycleViewFragment())

        deconnectionImage = findViewById(R.id.deconnection)
        scheduleImage = findViewById(R.id.calendar)

        dateOfWeek = findViewById(R.id.dayDate)
        day = findViewById(R.id.day)
        monthAndYear = findViewById(R.id.month)

        var days = listOf("Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi")
        var months = listOf(
            "Janv.",
            "Févr.",
            "Mars",
            "Avr.",
            "Mai",
            "Juin",
            "Juill.",
            "Août",
            "Sept.",
            "Oct.",
            "Nov.",
            "Déc."
        )
        val date = Calendar.getInstance()
        dateOfWeek.text = date.get(Calendar.DAY_OF_MONTH).toString()
        day.text = days[date.get(Calendar.DAY_OF_WEEK) - 1]
        monthAndYear.text = months[date.get(Calendar.MONTH)] + " " + date.get(Calendar.YEAR)


        deconnectionImage.setOnClickListener() {
            aurion.logout();
            val intent = Intent(applicationContext, LoginActivity::class.java)
            val pendingIntentId: Int = 0xDEAD

            val pendingIntent = PendingIntent.getActivity(
                applicationContext,
                pendingIntentId,
                intent,
                PendingIntent.FLAG_CANCEL_CURRENT + PendingIntent.FLAG_IMMUTABLE
            )
            val alarmManager =
                applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager[AlarmManager.RTC, System.currentTimeMillis() + 100] = pendingIntent

            Runtime.getRuntime().exit(0)
        }

        scheduleImage.setOnClickListener() {
            changeToScheduleActivity()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout_grades, fragment)
        fragmentTransaction.commit()
    }

    private fun changeToScheduleActivity() {
        val scheduleIntent: Intent = Intent(this, ScheduleActivity::class.java)
        startActivity(scheduleIntent)
        finish()
    }
}