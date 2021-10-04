package com.example.numbertesttask.di

import com.example.numbertesttask.data.repository.NumbersRepository
import com.example.numbertesttask.data.repository.NumbersRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun providesNumbersRepository(impl: NumbersRepositoryImpl): NumbersRepository = impl
}