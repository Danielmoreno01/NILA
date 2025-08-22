package com.example.appnila.ui.theme.viewmodels

// ui/viewmodels/DuenosViewModel.kt


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appnila.ui.theme.Repository.VeterinariaRepository
import com.example.appnila.ui.theme.entities.Dueno
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DuenosViewModel(private val repository: VeterinariaRepository) : ViewModel() {
    private val _duenos = MutableStateFlow<List<Dueno>>(emptyList())
    val duenos: StateFlow<List<Dueno>> = _duenos.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        loadDuenos()
    }

    private fun loadDuenos() {
        viewModelScope.launch {
            _isLoading.value = true
            repository.getAllDuenos().collect {
                _duenos.value = it
                _isLoading.value = false
            }
        }
    }

    fun insertDueno(dueno: Dueno) {
        viewModelScope.launch {
            repository.insertDueno(dueno)
        }
    }

    fun updateDueno(dueno: Dueno) {
        viewModelScope.launch {
            repository.updateDueno(dueno)
        }
    }

    fun deleteDueno(dueno: Dueno) {
        viewModelScope.launch {
            repository.deleteDueno(dueno)
        }
    }
}