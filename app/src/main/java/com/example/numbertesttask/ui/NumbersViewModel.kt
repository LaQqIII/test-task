package com.example.numbertesttask.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.numbertesttask.data.Number
import com.example.numbertesttask.data.repository.NumbersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NumbersViewModel @Inject constructor(
    getNumbers: GetNumbers, addNumbers: AddNumbers
) : ViewModel() {

    private val _numbers = MutableLiveData(emptyList<Number>())
    val numbers: LiveData<List<Number>> = _numbers

    private val _failure = MutableLiveData<String>()
    val failure: LiveData<String> = _failure

    fun loadNumbers() {
        _numbers.value = listOf(Number(2), Number(3), Number(4))
    }

    fun addRandomNumbers() {

    }
}

class GetNumbers @Inject constructor(numbersRepository: NumbersRepository)

class AddNumbers @Inject constructor(numbersRepository: NumbersRepository)