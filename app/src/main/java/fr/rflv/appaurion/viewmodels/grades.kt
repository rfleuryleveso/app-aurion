package fr.rflv.appaurion.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.rflv.appaurion.services.aurion.data.Mark
import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


data class GradesViewModelState(
    val grades: Array<Mark> = arrayOf(),
)

class GradesViewModel(private val aurion: IAurion) : ViewModel() {
    private val _uiState = MutableStateFlow(GradesViewModelState())
    val uiState: StateFlow<GradesViewModelState> = _uiState.asStateFlow()


    public fun loadMarks() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { currentState ->
                currentState.copy(
                    grades = aurion.getAllMarks().map { Mark(it) }.toTypedArray()
                )
            }
        }

    }
}