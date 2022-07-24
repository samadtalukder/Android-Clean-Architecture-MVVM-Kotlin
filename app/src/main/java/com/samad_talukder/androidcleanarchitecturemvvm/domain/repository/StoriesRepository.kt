package com.samad_talukder.androidcleanarchitecturemvvm.domain.repository

import com.samad_talukder.androidcleanarchitecturemvvm.common.utils.ApiResult
import com.samad_talukder.androidcleanarchitecturemvvm.data.source.response.StoriesData
import kotlinx.coroutines.flow.Flow

/**
 * Created by Samad Talukder on 16, June, 2022.
 * github.com/samadtalukder
 **/

interface StoriesRepository {
    suspend fun fetchStoryList(): Flow<ApiResult<StoriesData>>
}