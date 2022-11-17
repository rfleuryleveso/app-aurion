package fr.rflv.appaurion.viewmodels

import androidx.lifecycle.ViewModel
import fr.rflv.appaurion.services.aurion.data.Course
import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.datetime.LocalDateTime


data class ScheduleViewModelState(
    val courses: Array<Course> = arrayOf(),
)

class ScheduleViewModel(private val aurion: IAurion) : ViewModel() {
    // Expose screen UI state
    private val _uiState = MutableStateFlow(ScheduleViewModelState())
    val uiState: StateFlow<ScheduleViewModelState> = _uiState.asStateFlow()


    public fun getCoursesForDay(date: LocalDateTime) {

    }
}