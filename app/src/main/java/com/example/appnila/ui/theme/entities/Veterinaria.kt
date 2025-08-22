package com.example.appnila.ui.theme.entities


// data/entities/Veterinaria.kt

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "veterinarias")
data class Veterinaria(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nombre: String,
    val direccion: String,
    val telefono: String,
    val email: String,
    val horarioAtencion: String,
    val latitud: Double = 0.0,
    val longitud: Double = 0.0,
    val servicios: String // JSON string de servicios
)