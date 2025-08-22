package com.example.appnila.ui.theme.viewmodels

// ui/viewmodels/CitasViewModel.kt

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appnila.ui.theme.Repository.VeterinariaRepository
import com.example.appnila.ui.theme.entities.Cita
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CitasViewModel(private val repository: VeterinariaRepository) : ViewModel() {
    private val _citas = MutableStateFlow<List<Cita>>(emptyList())
    val citas: StateFlow<List<Cita>> = _citas.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        loadCitas()
    }

    private fun loadCitas() {
        viewModelScope.launch {
            _isLoading.value = true
            repository.getAllCitas().collect {
                _citas.value = it
                _isLoading.value = false
            }
        }
    }

    fun insertCita(cita: Cita) {
        viewModelScope.launch {
            repository.insertCita(cita)
        }
    }

    fun updateCita(cita: Cita) {
        viewModelScope.launch {
            repository.updateCita(cita)
        }
    }

    fun deleteCita(cita: Cita) {
        viewModelScope.launch {
            repository.deleteCita(cita)
        }
    }
}
