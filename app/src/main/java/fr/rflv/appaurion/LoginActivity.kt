package fr.rflv.appaurion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    private lateinit var  loginButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton = findViewById(R.id.button)
        loginButton.setOnClickListener {
            connectionToAurion()
        }
    }

    private fun connectionToAurion() {
        val connectToAurionIntent : Intent = Intent(this, ScheduleActivity::class.java)
        startActivity(connectToAurionIntent)
    }
}