package com.samad_talukder.androidcleanarchitecturemvvm.data.datasourceimpl

import com.samad_talukder.androidcleanarchitecturemvvm.data.source.remote.StoriesApi
import com.samad_talukder.androidcleanarchitecturemvvm.data.datasource.StoriesDataSource
import com.samad_talukder.androidcleanarchitecturemvvm.data.source.response.StoriesData
import retrofit2.Response

/**
 * Created by Samad Talukder on 16, June, 2022.
 * github.com/samadtalukder
 **/

class StoriesDataSourceImpl(private var api: StoriesApi) : StoriesDataSource {

    override suspend fun getStoryLists(): Response<StoriesData> {
        return api.getStories()
    }

}