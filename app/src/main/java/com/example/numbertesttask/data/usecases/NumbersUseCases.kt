package com.example.numbertesttask.data.usecases

import com.example.numbertesttask.data.Number
import com.example.numbertesttask.data.Result
import com.example.numbertesttask.data.database.NumberDao
import javax.inject.Inject
import kotlin.random.Random

interface GetNumbers {
    suspend fun run(): Result<List<Number>>
}

class GetNumbersImpl @Inject constructor(private val localDatabase: NumberDao) : GetNumbers {

    override suspend fun run(): Result<List<Number>> {
        return Result.Success(localDatabase.getAllNumbers())
    }
}

interface AddNumbers {
    suspend fun run(): Result<List<Number>>
}

class AddNumbersImpl @Inject constructor(private val localDatabase: NumberDao) : AddNumbers {

    override suspend fun run(): Result<List<Number>> {
        localDatabase.insertNumber(number = Number(Random.nextInt()))
        return Result.Success(localDatabase.getAllNumbers())
    }
}