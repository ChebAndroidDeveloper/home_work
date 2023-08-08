package com.example.homework.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktails")
data class CocktailDB (
    @PrimaryKey(autoGenerate = true) val id : Int,
    val cocktailName : String,
    val description : String?,
    val recipe : String?,
    val ingredients : List<String>
)