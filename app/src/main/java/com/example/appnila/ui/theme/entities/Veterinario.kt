package com.example.appnila.ui.theme.entities


// data/entities/Veterinario.kt

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "veterinarios")
data class Veterinario(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nombre: String,
    val apellido: String,
    val especialidad: String,
    val telefono: String,
    val email: String,
    val licencia: String
)
