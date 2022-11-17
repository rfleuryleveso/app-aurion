package fr.rflv.appaurion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import fr.rflv.appaurion.viewmodels.LoginViewModel
import fr.rflv.appaurion.viewmodels.ScheduleViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScheduleActivity : AppCompatActivity() {
    private lateinit var deconnectionImage : ImageView
    private lateinit var gradesImage : ImageView
    val scheduleViewModel by viewModel<ScheduleViewModel>()

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

        lifecycleScope.launch(){
            repeatOnLifecycle(Lifecycle.State.STARTED){
                scheduleViewModel.uiState.collect {
                    for (course in it.courses) {
                        //Create a fragment for each course
                    }
                }
            }
        }
    }

    private fun changeToGradesActivity() {
        val gradesIntent : Intent = Intent(this, GradesActivity::class.java)
        startActivity(gradesIntent)
        finish()
    }
}