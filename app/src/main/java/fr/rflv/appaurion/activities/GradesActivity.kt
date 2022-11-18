package fr.rflv.appaurion.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import fr.rflv.appaurion.R
import fr.rflv.appaurion.fragments.GradesRecycleViewFragment

class GradesActivity : AppCompatActivity() {
    private lateinit var deconnectionImage : ImageView
    private lateinit var scheduleImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grades)
        replaceFragment(GradesRecycleViewFragment())

        deconnectionImage = findViewById(R.id.deconnection)
        scheduleImage = findViewById(R.id.calendar)

        deconnectionImage.setOnClickListener() {
            finish()
        }

        scheduleImage.setOnClickListener() {
            changeToScheduleActivity()
        }
    }

    private fun replaceFragment(fragment: Fragment)
    {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout_grades, fragment)
        fragmentTransaction.commit()
    }

    private fun changeToScheduleActivity() {
        val scheduleIntent : Intent = Intent(this, ScheduleActivity::class.java)
        startActivity(scheduleIntent)
        finish()
    }
}