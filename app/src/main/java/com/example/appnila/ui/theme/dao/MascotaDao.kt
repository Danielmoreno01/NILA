package com.example.appnila.ui.theme.dao


import androidx.room.*
import com.example.appnila.ui.theme.entities.Mascota

@Dao
interface MascotaDao {
    @Query("SELECT * FROM mascota WHERE id = :id")
    suspend fun getMascotaById(id: Long): Mascota?

    @Insert
    suspend fun insertMascota(mascota: Mascota): Long

    @Update
    suspend fun updateMascota(mascota: Mascota): Int

    @Delete
    suspend fun deleteMascota(mascota: Mascota): Int
}