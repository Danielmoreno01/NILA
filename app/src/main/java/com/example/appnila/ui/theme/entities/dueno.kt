// Dueno.kt - Entidad corregida
package com.example.appnila.ui.theme.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "duenos")
data class Dueno(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nombre: String,
    val apellido: String,
    val telefono: String,
    val email: String,
    val direccion: String,
    val cedula: String
)