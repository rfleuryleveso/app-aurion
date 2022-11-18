package fr.rflv.appaurion.activities

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import fr.rflv.appaurion.R
import fr.rflv.appaurion.fragments.ScheduleRecyclerViewFragment
import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import org.koin.android.ext.android.inject
import java.util.*


class ScheduleActivity() : AppCompatActivity() {
    private lateinit var deconnectionImage: ImageView
    private lateinit var gradesImage: ImageView
    private val aurion: IAurion by inject();

    private lateinit var dateOfWeek: TextView
    private lateinit var day: TextView
    private lateinit var monthAndYear: TextView
    private lateinit var monday: TextView
    private lateinit var tuesday: TextView
    private lateinit var wednesday: TextView
    private lateinit var thursday: TextView
    private lateinit var friday: TextView
    private lateinit var saturday: TextView
    private lateinit var sunday: TextView

    private lateinit var mondayCard: CardView
    private lateinit var tuesdayCard: CardView
    private lateinit var wednesdayCard: CardView
    private lateinit var thursdayCard: CardView
    private lateinit var fridayCard: CardView
    private lateinit var saturdayCard: CardView
    private lateinit var sundayCard: CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        replaceFragment(ScheduleRecyclerViewFragment())

        deconnectionImage = findViewById(R.id.deconnection)
        gradesImage = findViewById(R.id.grades)

        dateOfWeek = findViewById(R.id.dayDate)
        day = findViewById(R.id.day)
        monthAndYear = findViewById(R.id.month)
        monday = findViewById(R.id.mondayDate)
        tuesday = findViewById(R.id.tuesdayDate)
        wednesday = findViewById(R.id.wednesdayDate)
        thursday = findViewById(R.id.thursdayDate)
        friday = findViewById(R.id.fridayDate)
        saturday = findViewById(R.id.saturdayDate)
        sunday = findViewById(R.id.sundayDate)

        mondayCard = findViewById(R.id.mondayCard)
        tuesdayCard = findViewById(R.id.tuesdayCard)
        wednesdayCard = findViewById(R.id.wednesdayCard)
        thursdayCard = findViewById(R.id.thursdayCard)
        fridayCard = findViewById(R.id.fridayCard)
        saturdayCard = findViewById(R.id.saturdayCard)
        sundayCard = findViewById(R.id.sundayCard)

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

        var i = date.get(Calendar.DAY_OF_WEEK)
        var firstDAyOfWeek = date.get(Calendar.DAY_OF_MONTH)

        while (i > 1) {
            firstDAyOfWeek -= 1
            i -= 1
        }
        if (date.get(Calendar.DAY_OF_WEEK) == 1) {
            sunday.text = (firstDAyOfWeek).toString()
            monday.text = (firstDAyOfWeek - 6).toString()
            tuesday.text = (firstDAyOfWeek - 5).toString()
            wednesday.text = (firstDAyOfWeek - 4).toString()
            thursday.text = (firstDAyOfWeek - 3).toString()
            friday.text = (firstDAyOfWeek - 2).toString()
            saturday.text = (firstDAyOfWeek - 1).toString()
        } else {
            sunday.text = (firstDAyOfWeek + 7).toString()
            monday.text = (firstDAyOfWeek + 1).toString()
            tuesday.text = (firstDAyOfWeek + 2).toString()
            wednesday.text = (firstDAyOfWeek + 3).toString()
            thursday.text = (firstDAyOfWeek + 4).toString()
            friday.text = (firstDAyOfWeek + 5).toString()
            saturday.text = (firstDAyOfWeek + 6).toString()
        }

        var colorChange = listOf<CardView>(
            sundayCard,
            mondayCard,
            tuesdayCard,
            wednesdayCard,
            thursdayCard,
            fridayCard,
            saturdayCard
        )
        colorChange[date.get(Calendar.DAY_OF_WEEK) - 1].setBackgroundColor(Color.parseColor("#E03846"))

        var colorChangeText =
            listOf<TextView>(sunday, monday, tuesday, wednesday, thursday, friday, saturday)
        colorChangeText[date.get(Calendar.DAY_OF_WEEK) - 1].setTextColor(Color.parseColor("#FFFFFF"))

        deconnectionImage.setOnClickListener() {
            aurion.logout();
            val intent = Intent(applicationContext, LoginActivity::class.java)
            val mPendingIntentId: Int = 0xDEAD

            val mPendingIntent = PendingIntent.getActivity(
                applicationContext,
                mPendingIntentId,
                intent,
                PendingIntent.FLAG_CANCEL_CURRENT + PendingIntent.FLAG_IMMUTABLE
            )
            val mgr =
                applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            mgr[AlarmManager.RTC, System.currentTimeMillis() + 100] = mPendingIntent

            Runtime.getRuntime().exit(0)
        }
        gradesImage.setOnClickListener() {
            changeToGradesActivity()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout_schedule, fragment)
        fragmentTransaction.commit()
    }

    private fun changeToGradesActivity() {
        val gradesIntent: Intent = Intent(this, GradesActivity::class.java)
        startActivity(gradesIntent)
        finish()
    }
}