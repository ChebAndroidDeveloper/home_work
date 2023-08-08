package com.example.homework.data

import androidx.room.*
import com.example.homework.domain.entities.CocktailDB

@Dao
interface CocktailDao {
    @Query("SELECT * FROM cocktails")
    fun getAll(): List<CocktailDB>

    @Query("SELECT * FROM cocktails WHERE id = :id")
    fun getById(id: Int): CocktailDB

    @Insert
    fun insert(cocktail: CocktailDB)

    @Update
    fun update(cocktail: CocktailDB)

    @Delete
    fun delete(cocktail: CocktailDB)
}
