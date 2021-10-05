package com.example.numbertesttask.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.numbertesttask.data.Number

@Dao
interface NumberDao {

    @Insert
    suspend fun insertNumber(number: Number)

    @Query("SELECT * FROM ${NumberContract.TABLE_NAME}")
    suspend fun getAllNumbers(): List<Number>
}