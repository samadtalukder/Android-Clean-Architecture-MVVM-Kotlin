package com.samad_talukder.androidcleanarchitecturemvvm.data.datasource

import com.samad_talukder.androidcleanarchitecturemvvm.data.source.response.StoriesData
import retrofit2.Response

/**
 * Created by Samad Talukder on 16, June, 2022.
 * github.com/samadtalukder
 **/

interface StoriesDataSource {
    suspend fun getStoryLists(): Response<StoriesData>
}