package com.example.kotlinwithjetpack.data

import androidx.room.TypeConverter
import java.util.*

/**
 * Type converters to allow Room to reference complex data types.
 */
class Converters {

    val separator = ","

    @TypeConverter
    fun calendarToDatestamp(calendar: Calendar): Long = calendar.timeInMillis

    @TypeConverter
    fun datestampToCalendar(value: Long): Calendar =
            Calendar.getInstance().apply { timeInMillis = value }

    @TypeConverter
    fun listToString(model: List<String>?): String {
        if (model == null || model.isEmpty())
            return ""
        else
            return model.joinToString(separator = separator) { it }
    }

    @TypeConverter
    fun stringToList(data: String?): List<String> {
        return data?.split(separator) ?: listOf()
    }
}