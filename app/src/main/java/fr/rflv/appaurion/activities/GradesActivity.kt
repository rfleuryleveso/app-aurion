package fr.rflv.appaurion.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import fr.rflv.appaurion.R

class GradesActivity : AppCompatActivity() {
    private lateinit var deconnectionImage : ImageView
    private lateinit var scheduleImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grades)

        deconnectionImage = findViewById(R.id.deconnection)
        scheduleImage = findViewById(R.id.calendar)

        deconnectionImage.setOnClickListener() {
            finish()
        }

        scheduleImage.setOnClickListener() {
            changeToScheduleActivity()
        }
    }

    private fun changeToScheduleActivity() {
        val scheduleIntent : Intent = Intent(this, ScheduleActivity::class.java)
        startActivity(scheduleIntent)
        finish()
    }
}