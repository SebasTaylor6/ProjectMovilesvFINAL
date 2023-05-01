package com.proyecto.proyectomovilesv2.data.utils

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import org.jetbrains.annotations.Nullable
import java.time.LocalDate
import java.util.*

class Converters {
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun fromLong(@Nullable epoch: Long?): LocalDate? {
        return if (epoch == null) null else LocalDate.ofEpochDay(epoch)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun localDateToEpoch(@Nullable localDate: LocalDate?): Long? {
        return localDate?.toEpochDay()
    }
}