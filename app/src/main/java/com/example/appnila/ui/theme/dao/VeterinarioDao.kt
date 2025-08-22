package com.example.appnila.ui.theme.dao
import androidx.room.*
import com.example.appnila.ui.theme.entities.Mascota
import com.example.appnila.ui.theme.entities.Veterinario

@Dao
interface VeterinarioDao {

    @Query("SELECT * FROM VETERINARIOS WHERE id = :id")
    suspend fun getVeterinarioById(id: Long): Veterinario?

    @Query("SELECT * FROM VETERINARIOS")
    suspend fun getAllVeterinarios(): List<Veterinario>

    @Insert
    suspend fun insertVeterinario(veterinario: Veterinario): Long

    @Update
    suspend fun updateVeterinario(veterinario: Veterinario): Int

    @Delete
    suspend fun deleteVeterinario(veterinario: Veterinario): Int
}
