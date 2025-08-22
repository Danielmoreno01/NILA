package com.example.appnila.ui.theme.entities

// data/entities/Mascota.kt
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "mascota")
data class Mascota(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nombre: String,
    val especie: String,
    val raza: String,
    val edad: Int,
    val peso: Double,
    val color: String,
    val duenoId: Long,
    val fechaRegistro: String,
)
