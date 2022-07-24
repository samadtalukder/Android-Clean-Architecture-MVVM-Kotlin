package com.samad_talukder.androidcleanarchitecturemvvm.data.source.base


import com.samad_talukder.androidcleanarchitecturemvvm.common.utils.ApiResult
import retrofit2.Response

/**
 * Created by Samad Talukder on 16, June, 2022.
 * github.com/samadtalukder
 **/

abstract class BaseApiResponse {
    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): ApiResult<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return ApiResult.Success(it)
                }
            }
            return error("${response.code()} ${response.message()}")
        } catch (ex: Exception) {
            return error(ex.message ?: ex.toString())
        }
    }

    private fun <T> error(errorMessage: String): ApiResult<T> = ApiResult.Error(errorMessage)
}