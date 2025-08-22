package com.example.appnila.ui.theme.viewmodels

// ui/viewmodels/MascotasViewModel.kt

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appnila.ui.theme.entities.Mascota
import com.example.appnila.ui.theme.Repository.VeterinariaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MascotasViewModel(private val repository: VeterinariaRepository) : ViewModel() {
    private val _mascotas = MutableStateFlow<List<Mascota>>(emptyList())
    val mascotas: StateFlow<List<Mascota>> = _mascotas.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        loadMascotas()
    }

    private fun loadMascotas() {
        viewModelScope.launch {
            _isLoading.value = true
            repository.getAllMascotas().collect {
                _mascotas.value = it
                _isLoading.value = false
            }
        }
    }

    fun insertMascota(mascota: Mascota) {
        viewModelScope.launch {
            repository.insertMascota(mascota)
        }
    }

    fun updateMascota(mascota: Mascota) {
        viewModelScope.launch {
            repository.updateMascota(mascota)
        }
    }

    fun deleteMascota(mascota: Mascota) {
        viewModelScope.launch {
            repository.deleteMascota(mascota)
        }
    }
}
