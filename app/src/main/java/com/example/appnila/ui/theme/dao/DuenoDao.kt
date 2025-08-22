
// DuenoDao.kt - DAO corregido
package com.example.appnila.ui.theme.dao

import androidx.room.*
import com.example.appnila.ui.theme.entities.Dueno

@Dao
interface DuenoDao {

    @Query("SELECT * FROM duenos WHERE id = :id")
    suspend fun getDuenoById(id: Long): Dueno?

    @Query("SELECT * FROM duenos WHERE cedula = :cedula")
    suspend fun getDuenoByCedula(cedula: String): Dueno?

    @Query("SELECT * FROM duenos")
    suspend fun getAllDuenos(): List<Dueno>

    @Insert
    suspend fun insertDueno(dueno: Dueno): Long

    @Update
    suspend fun updateDueno(dueno: Dueno): Int

    @Delete
    suspend fun deleteDueno(dueno: Dueno): Int
}