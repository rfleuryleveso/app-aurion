package fr.rflv.appaurion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ScheduleActivity : AppCompatActivity() {
    private lateinit var deconnectionImage : ImageView
    private lateinit var gradesImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        deconnectionImage = findViewById(R.id.deconnection)
        gradesImage = findViewById(R.id.grades)

        deconnectionImage.setOnClickListener() {
            finish()
        }
        gradesImage.setOnClickListener() {
            changeToGradesActivity()
        }
    }

    private fun changeToGradesActivity() {
        val gradesIntent : Intent = Intent(this, GradesActivity::class.java)
        startActivity(gradesIntent)
        finish()
    }
}