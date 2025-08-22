package com.example.appnila.ui.theme.Database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.example.appnila.ui.theme.converters.DateConverter
import com.example.appnila.ui.theme.dao.CitaDao
import com.example.appnila.ui.theme.dao.DuenoDao
import com.example.appnila.ui.theme.dao.MascotaDao
import com.example.appnila.ui.theme.dao.VeterinariaDao
import com.example.appnila.ui.theme.dao.VeterinarioDao
import com.example.appnila.ui.theme.entities.Cita
import com.example.appnila.ui.theme.entities.Dueno
import com.example.appnila.ui.theme.entities.Mascota
import com.example.appnila.ui.theme.entities.Veterinaria
import com.example.appnila.ui.theme.entities.Veterinario

@Database(
    entities = [Mascota::class, Dueno::class, Veterinario::class, Cita::class, Veterinaria::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(DateConverter::class)
abstract class VeterinariaDatabase : RoomDatabase() {
    abstract fun mascotaDao(): MascotaDao
    abstract fun duenoDao(): DuenoDao
    abstract fun veterinarioDao(): VeterinarioDao
    abstract fun citaDao(): CitaDao
    abstract fun veterinariaDao(): VeterinariaDao

    companion object {
        @Volatile
        private var INSTANCE: VeterinariaDatabase? = null

        fun getDatabase(context: Context): VeterinariaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VeterinariaDatabase::class.java,
                    "veterinaria_nila_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

