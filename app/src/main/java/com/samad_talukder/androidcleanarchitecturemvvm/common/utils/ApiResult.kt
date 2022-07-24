package com.samad_talukder.androidcleanarchitecturemvvm.common.utils

/**
 * Created by Samad Talukder on 16, June, 2022.
 * github.com/samadtalukder
 **/

sealed class ApiResult<T>(
    val data: T? = null,
    val message: String? = null,
    val responseCode: String? = null
) {

    class Success<T>(data: T) : ApiResult<T>(data)

    class Error<T>(message: String, data: T? = null) : ApiResult<T>(data, message)

    class Loading<T> : ApiResult<T>()

    class Nothing<T> : ApiResult<T>()

}