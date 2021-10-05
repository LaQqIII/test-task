package com.example.numbertesttask.data.repository

import com.example.numbertesttask.data.Number
import com.example.numbertesttask.data.database.NumberDao
import javax.inject.Inject

class NumbersRepositoryImpl
@Inject constructor(private val localDatabase: NumberDao) : NumbersRepository {

    override suspend fun numbers(): Result<List<Number>> {
        localDatabase.getAllNumbers()
        return Result.success(emptyList())
    }

    override suspend fun addNumber(number: Number) {
        localDatabase.insertNumber(number)
    }
}