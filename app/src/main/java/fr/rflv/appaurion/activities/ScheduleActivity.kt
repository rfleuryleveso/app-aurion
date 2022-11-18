package fr.rflv.appaurion.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import fr.rflv.appaurion.R
import fr.rflv.appaurion.fragments.ScheduleRecyclerViewFragment
import fr.rflv.appaurion.viewmodels.ScheduleViewModel
import kotlinx.coroutines.launch
import kotlinx.datetime.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.ZoneId
import java.util.*


class ScheduleActivity : AppCompatActivity() {
    private lateinit var deconnectionImage: ImageView
    private lateinit var gradesImage: ImageView

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

        var days = listOf("Samedi","Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi")
        var months = listOf("Janv.","Févr.","Mars","Avr.","Mai","Juin","Juill.","Août","Sept.","Oct.","Nov.","Déc.")
        val date = Calendar.getInstance()
        dateOfWeek.text = date.get(Calendar.DAY_OF_MONTH).toString()
        day.text = days[date.get(Calendar.DAY_OF_WEEK)]
        monthAndYear.text = months[date.get(Calendar.MONTH)] + " " + date.get(Calendar.YEAR)

        var i = date.get(Calendar.DAY_OF_WEEK)
        var firstDAyOfWeek = date.get(Calendar.DAY_OF_MONTH)

        while (i > 1) {
            firstDAyOfWeek -= 1
            i -= 1
        }
        if (date.get(Calendar.DAY_OF_WEEK) == 1){
            sunday.text = (firstDAyOfWeek).toString()
            monday.text = (firstDAyOfWeek - 6).toString()
            tuesday.text = (firstDAyOfWeek - 5).toString()
            wednesday.text = (firstDAyOfWeek - 4).toString()
            thursday.text = (firstDAyOfWeek - 3).toString()
            friday.text = (firstDAyOfWeek - 2).toString()
            saturday.text = (firstDAyOfWeek - 1).toString()
        }
        else{
            sunday.text = (firstDAyOfWeek + 7).toString()
            monday.text = (firstDAyOfWeek + 1).toString()
            tuesday.text = (firstDAyOfWeek + 2).toString()
            wednesday.text = (firstDAyOfWeek + 3).toString()
            thursday.text = (firstDAyOfWeek + 4).toString()
            friday.text = (firstDAyOfWeek + 5).toString()
            saturday.text = (firstDAyOfWeek + 6).toString()
        }

        deconnectionImage.setOnClickListener() {
            finish()
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