package com.samad_talukder.androidcleanarchitecturemvvm.di

import com.samad_talukder.androidcleanarchitecturemvvm.data.datasource.StoriesDataSource
import com.samad_talukder.androidcleanarchitecturemvvm.data.datasourceimpl.StoriesDataSourceImpl
import com.samad_talukder.androidcleanarchitecturemvvm.data.source.remote.StoriesApi
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
class DataSourceModule {

    @Singleton
    @Provides
    fun provideStoriesDataSource(storiesApi: StoriesApi): StoriesDataSource {
        return StoriesDataSourceImpl(storiesApi)
    }
}