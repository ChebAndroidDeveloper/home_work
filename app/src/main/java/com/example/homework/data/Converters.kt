package com.example.homework.data

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromIngredientsList(value: List<String>): String {
        return value.joinToString(",")
    }

    @TypeConverter
    fun toIngredientsList(value: String): List<String> {
        return value.split(",")
    }
}
