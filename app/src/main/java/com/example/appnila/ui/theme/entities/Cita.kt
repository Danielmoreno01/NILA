package com.example.appnila.ui.theme.entities

// data/entities/Cita.kt

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import java.util.Date

@Entity(
    tableName = "citas",
    foreignKeys = [
        ForeignKey(entity = Mascota::class, parentColumns = ["id"], childColumns = ["mascotaId"]),
        ForeignKey(entity = Veterinario::class, parentColumns = ["id"], childColumns = ["veterinarioId"])
    ]
)
data class Cita(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val mascotaId: Long,
    val veterinarioId: Long,
    val fechaHora: Date,
    val motivo: String,
    val estado: String = "Programada", // Programada, Completada, Cancelada
    val observaciones: String = ""
)