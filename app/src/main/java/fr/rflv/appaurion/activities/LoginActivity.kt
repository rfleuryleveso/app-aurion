package fr.rflv.appaurion.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import fr.rflv.appaurion.R
import fr.rflv.appaurion.viewmodels.LoginViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var loginButton: Button
    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var progress: ProgressBar
    val loginViewModel by viewModel<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton = findViewById(R.id.button)
        loginButton.setOnClickListener {
            connectionToAurion()
        }

        emailField = findViewById(R.id.editTextTextEmailAddress)
        passwordField = findViewById(R.id.editTextTextPassword)
        progress = findViewById(R.id.progressBar)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                loginViewModel.uiState.collect {
                    if (it.isLoggedIn) {
                        val connectToAurionIntent: Intent =
                            Intent(applicationContext, ScheduleActivity::class.java)
                        startActivity(connectToAurionIntent)
                    }
                    if (it.isLoading) {
                        loginButton.visibility = View.GONE
                        progress.visibility = View.VISIBLE
                    } else {
                        loginButton.visibility = View.VISIBLE
                        progress.visibility = View.GONE
                    }
                }
            }
        }
    }

    private fun connectionToAurion() {
        this.loginViewModel.Login(emailField.text.toString(), passwordField.text.toString());
    }
}