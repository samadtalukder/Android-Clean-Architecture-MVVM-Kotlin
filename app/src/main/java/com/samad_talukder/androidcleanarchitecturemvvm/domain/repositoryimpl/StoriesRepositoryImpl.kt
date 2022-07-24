package com.samad_talukder.androidcleanarchitecturemvvm.domain.repositoryimpl


import com.samad_talukder.androidcleanarchitecturemvvm.common.utils.ApiResult
import com.samad_talukder.androidcleanarchitecturemvvm.data.datasource.StoriesDataSource
import com.samad_talukder.androidcleanarchitecturemvvm.domain.repository.StoriesRepository
import com.samad_talukder.androidcleanarchitecturemvvm.data.source.base.BaseApiResponse
import com.samad_talukder.androidcleanarchitecturemvvm.data.source.response.StoriesData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by Samad Talukder on 16, June, 2022.
 * github.com/samadtalukder
 **/

class StoriesRepositoryImpl(private val storiesDataSource: StoriesDataSource) :
    BaseApiResponse(), StoriesRepository {

    override suspend fun fetchStoryList(): Flow<ApiResult<StoriesData>> {
        return flow {
            emit(
                safeApiCall {
                    storiesDataSource.getStoryLists()
                }
            )
        }.flowOn(Dispatchers.IO)
    }
}