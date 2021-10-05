package com.example.numbertesttask.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.numbertesttask.data.Number
import com.example.numbertesttask.data.database.DatabaseNumber.Companion.DB_VERSION

@Database(entities = [Number::class], version = DB_VERSION)
abstract class DatabaseNumber : RoomDatabase() {

    abstract fun numbersDao(): NumberDao

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "numbers-database"
    }
}