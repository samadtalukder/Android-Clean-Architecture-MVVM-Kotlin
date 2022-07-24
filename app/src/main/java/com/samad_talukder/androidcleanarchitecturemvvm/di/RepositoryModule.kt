package com.samad_talukder.androidcleanarchitecturemvvm.di


import com.samad_talukder.androidcleanarchitecturemvvm.data.datasource.StoriesDataSource
import com.samad_talukder.androidcleanarchitecturemvvm.domain.repository.StoriesRepository
import com.samad_talukder.androidcleanarchitecturemvvm.domain.repositoryimpl.StoriesRepositoryImpl
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
class RepositoryModule {

    @Singleton
    @Provides
    fun providesStoriesRepository(storiesDataSource: StoriesDataSource): StoriesRepository {
        return StoriesRepositoryImpl(storiesDataSource)
    }
}