package com.example.appnila.ui.theme.Repository

// ========== Repository ==========
// data/repository/VeterinariaRepository.kt

import com.example.appnila.ui.theme.Database.VeterinariaDatabase
import com.example.appnila.ui.theme.entities.Cita
import com.example.appnila.ui.theme.entities.Dueno
import com.example.appnila.ui.theme.entities.Mascota
import com.example.appnila.ui.theme.entities.Veterinaria
import com.example.appnila.ui.theme.entities.Veterinario
import kotlinx.coroutines.flow.Flow
import java.util.Date

class VeterinariaRepository(private val database: VeterinariaDatabase) {

    // Mascotas
    fun getAllMascotas(): Flow<List<Mascota>> = database.mascotaDao().getAllMascotas()
    suspend fun insertMascota(mascota: Mascota) = database.mascotaDao().insertMascota(mascota)
    suspend fun updateMascota(mascota: Mascota) = database.mascotaDao().updateMascota(mascota)
    suspend fun deleteMascota(mascota: Mascota) = database.mascotaDao().deleteMascota(mascota)

    // Dueños
    fun getAllDuenos(): Flow<List<Dueno>> = database.duenoDao().getAllDuenos()
    suspend fun insertDueno(dueno: Dueno) = database.duenoDao().insertDueno(dueno)
    suspend fun updateDueno(dueno: Dueno) = database.duenoDao().updateDueno(dueno)
    suspend fun deleteDueno(dueno: Dueno) = database.duenoDao().deleteDueno(dueno)

    // Veterinarios
    fun getAllVeterinarios(): Flow<List<Veterinario>> = database.veterinarioDao().getAllVeterinarios()
    suspend fun insertVeterinario(veterinario: Veterinario) = database.veterinarioDao().insertVeterinario(veterinario)
    suspend fun updateVeterinario(veterinario: Veterinario) = database.veterinarioDao().updateVeterinario(veterinario)

    // Citas
    fun getAllCitas(): Flow<List<Cita>> = database.citaDao().getAllCitas()
    suspend fun insertCita(cita: Cita) = database.citaDao().insertCita(cita)
    suspend fun updateCita(cita: Cita) = database.citaDao().updateCita(cita)
    suspend fun deleteCita(cita: Cita) = database.citaDao().deleteCita(cita)
    fun getCitasByFechas(fechaInicio: Date, fechaFin: Date) = database.citaDao().getCitasByFechas(fechaInicio, fechaFin)

    // Veterinarias
    fun getAllVeterinarias(): Flow<List<Veterinaria>> = database.veterinariaDao().getAllVeterinarias()
    suspend fun insertVeterinaria(veterinaria: Veterinaria) = database.veterinariaDao().insertVeterinaria(veterinaria)
}