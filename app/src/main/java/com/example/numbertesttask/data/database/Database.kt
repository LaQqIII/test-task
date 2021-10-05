package com.example.numbertesttask.data.database

import android.content.Context
import androidx.room.Room

object Database {

    lateinit var instance: DatabaseNumber
        private set

    fun init(context: Context) {
        instance = Room.databaseBuilder(
            context,
            DatabaseNumber::class.java,
            DatabaseNumber.DB_NAME
        ).build()
    }
}