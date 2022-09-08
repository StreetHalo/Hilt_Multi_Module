package ru.petshop.data.di

import ru.petshop.data.CapitalizeText
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class SharedModule() {
    @Provides
    fun provideStringHelper(): CapitalizeText {
        return CapitalizeText()
    }
}