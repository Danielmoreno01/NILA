package com.example.appnila.ui.theme.dao

// data/dao/CitaDao.kt

import androidx.room.*
import com.example.appnila.ui.theme.entities.Cita
import kotlinx.coroutines.flow.Flow
import java.util.Date

@Dao
interface CitaDao {

    @Query("SELECT * FROM CITAS WHERE id = :id")
    suspend fun getCitaById(id: Long): Cita?

    @Query("SELECT * FROM CITAS WHERE mascotaId = :mascotaId")
    suspend fun getCitasByMascota(mascotaId: Long): List<Cita>

    @Query("SELECT * FROM CITAS WHERE veterinarioId = :veterinarioId")
    suspend fun getCitasByVeterinario(veterinarioId: Long): List<Cita>

    @Query("SELECT * FROM CITAS")
    suspend fun getAllCitas(): List<Cita>

    @Insert
    suspend fun insertCita(cita: Cita): Long

    @Update
    suspend fun updateCita(cita: Cita): Int

    @Delete
    suspend fun deleteCita(cita: Cita): Int
}
