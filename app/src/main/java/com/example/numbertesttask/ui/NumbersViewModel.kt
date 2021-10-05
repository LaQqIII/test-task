package com.example.numbertesttask.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.numbertesttask.data.Number
import com.example.numbertesttask.data.Result
import com.example.numbertesttask.data.usecases.AddNumbers
import com.example.numbertesttask.data.usecases.GetNumbers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NumbersViewModel @Inject constructor(
    private val getNumbers: GetNumbers, private val addNumbers: AddNumbers
) : ViewModel() {

    private val _numbers = MutableLiveData(emptyList<Number>())
    val numbers: LiveData<List<Number>> = _numbers

    private val _failure = MutableLiveData<String>()
    val failure: LiveData<String> = _failure

    fun loadNumbers() = viewModelScope.launch {
        when (val result = getNumbers.run()) {
            is Result.Success -> _numbers.value = result.data
            is Result.Error -> _failure.value = result.exception.message
        }
    }

    fun addRandomNumbers() = viewModelScope.launch {
        when (val result = addNumbers.run()) {
            is Result.Success -> _numbers.value = result.data
            is Result.Error -> _failure.value = result.exception.message
        }
    }
}