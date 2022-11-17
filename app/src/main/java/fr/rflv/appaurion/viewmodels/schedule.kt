package fr.rflv.appaurion.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.rflv.appaurion.services.aurion.data.Course
import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.*
import java.time.ZoneId


data class ScheduleViewModelState(
    val courses: Array<Course> = arrayOf(),
)

class ScheduleViewModel(private val aurion: IAurion) : ViewModel() {
    // Expose screen UI state
    private val _uiState = MutableStateFlow(ScheduleViewModelState())
    val uiState: StateFlow<ScheduleViewModelState> = _uiState.asStateFlow()


    public fun getCoursesForDay(date: LocalDate) {
        viewModelScope.launch(Dispatchers.IO) {
            val allCourses = aurion.getAllCourses();
            val filteredCourses = allCourses.filter {
                it.startDateTime.toInstant(TimeZone.UTC).toJavaInstant().atZone(
                    ZoneId.systemDefault()
                ).toLocalDate().toKotlinLocalDate() == date
            }.map { Course(it) }.toTypedArray()

            _uiState.update { currentState ->
                currentState.copy(
                    courses = filteredCourses
                )
            }
        }


    }
}