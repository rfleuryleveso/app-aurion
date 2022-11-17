package fr.rflv.appaurion.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class LoginViewModelState(
    val isLoading: Boolean = false,
    val isLoggedIn: Boolean = false,
)

class LoginViewModel(private val aurion: IAurion) : ViewModel() {
    // Expose screen UI state
    private val _uiState = MutableStateFlow(LoginViewModelState())
    val uiState: StateFlow<LoginViewModelState> = _uiState.asStateFlow()

    public fun Login(email: String, password: String) {
        _uiState.update { currentState ->
            currentState.copy(
                isLoading = true,
            )
        }
        val aurion = this.aurion;
        viewModelScope.launch(Dispatchers.IO) {
            val result = aurion.login(email, password);
            _uiState.update { currentState ->
                currentState.copy(
                    isLoading = false,
                    isLoggedIn = true
                )
            }
        }

    }
}