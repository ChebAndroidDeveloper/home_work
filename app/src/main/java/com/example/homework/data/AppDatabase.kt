package com.example.homework.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.homework.domain.entities.CocktailDB

@Database(entities = [CocktailDB::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cocktailDao(): CocktailDao
}