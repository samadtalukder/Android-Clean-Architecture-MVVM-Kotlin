package com.samad_talukder.androidcleanarchitecturemvvm.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Samad Talukder on 20, June, 2022.
 * github.com/samadtalukder
 **/

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext
}