package com.samad_talukder.androidcleanarchitecturemvvm.di

import com.samad_talukder.androidcleanarchitecturemvvm.domain.repository.StoriesRepository
import com.samad_talukder.androidcleanarchitecturemvvm.domain.usecase.StoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Samad Talukder on 20, June, 2022.
 * github.com/samadtalukder
 **/

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideStoriesUseCase(storiesRepository: StoriesRepository): StoriesUseCase {
        return StoriesUseCase(storiesRepository)
    }
}