package com.samad_talukder.androidcleanarchitecturemvvm.data.source.remote


import com.samad_talukder.androidcleanarchitecturemvvm.data.source.response.StoriesData
import retrofit2.Response
import retrofit2.http.*

/**
 * Created by Samad Talukder on 16, June, 2022.
 * github.com/samadtalukder
 **/

interface StoriesApi {

    @GET("browse/all/stories?format=json")
    suspend fun getStories(): Response<StoriesData>
}