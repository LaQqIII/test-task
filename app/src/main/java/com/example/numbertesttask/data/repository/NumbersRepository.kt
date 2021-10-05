package com.example.numbertesttask.data.repository

import com.example.numbertesttask.data.Number

interface NumbersRepository {
    suspend fun numbers(): Result<List<Number>>
    suspend fun addNumber(number: Number)
}