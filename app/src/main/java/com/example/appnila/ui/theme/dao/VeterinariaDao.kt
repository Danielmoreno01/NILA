package com.example.appnila.ui.theme.dao


// data/dao/VeterinariaDao.kt

import androidx.room.*
import com.example.appnila.ui.theme.entities.Veterinaria
import kotlinx.coroutines.flow.Flow

// Ejemplo de VeterinariaDao corregido
@Dao
interface VeterinariaDao {

    @Query("SELECT * FROM VETERINARIAS WHERE id = :id")
    suspend fun getVeterinariaById(id: Long): Veterinaria?

    @Query("SELECT * FROM VETERINARIAS")
    suspend fun getAllVeterinarias(): List<Veterinaria>

    @Insert
    suspend fun insertVeterinaria(veterinaria: Veterinaria): Long

    @Update
    suspend fun updateVeterinaria(veterinaria: Veterinaria): Int

    @Delete
    suspend fun deleteVeterinaria(veterinaria: Veterinaria): Int
}