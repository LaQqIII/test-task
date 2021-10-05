package com.example.numbertesttask

import android.app.Application
import com.example.numbertesttask.data.database.Database
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Database.init(this)
    }
}