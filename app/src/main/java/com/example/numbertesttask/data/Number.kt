package com.example.numbertesttask.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.numbertesttask.data.database.NumberContract

@Entity(tableName = NumberContract.TABLE_NAME)
data class Number(@PrimaryKey val value: Int)
