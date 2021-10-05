package com.example.numbertesttask.di

import com.example.numbertesttask.data.usecases.AddNumbers
import com.example.numbertesttask.data.usecases.AddNumbersImpl
import com.example.numbertesttask.data.usecases.GetNumbers
import com.example.numbertesttask.data.usecases.GetNumbersImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {

    @Binds
    abstract fun providesGetNumbersUseCase(impl: GetNumbersImpl): GetNumbers

    @Binds
    abstract fun providesAddNumbersUseCase(impl: AddNumbersImpl): AddNumbers
}