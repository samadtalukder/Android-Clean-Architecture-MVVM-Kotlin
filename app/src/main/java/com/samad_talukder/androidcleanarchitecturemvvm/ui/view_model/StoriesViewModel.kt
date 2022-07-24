package com.samad_talukder.androidcleanarchitecturemvvm.ui.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.samad_talukder.androidcleanarchitecturemvvm.common.utils.ApiResult
import com.samad_talukder.androidcleanarchitecturemvvm.data.source.response.StoriesData
import com.samad_talukder.androidcleanarchitecturemvvm.domain.usecase.StoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Samad Talukder on 20, June, 2022.
 * github.com/samadtalukder
 **/


@HiltViewModel
class StoriesViewModel @Inject constructor(
    application: Application,
    private val storiesUseCase: StoriesUseCase
) :
    AndroidViewModel(application) {

    private val responseStories: MutableLiveData<ApiResult<StoriesData>> = MutableLiveData()
    val storiesLiveData: LiveData<ApiResult<StoriesData>> = responseStories

    fun getStoriesData() = viewModelScope.launch {

        responseStories.value = ApiResult.Loading()

        storiesUseCase.callStoriesApi()
            .collect { values ->
                responseStories.value = values
            }
    }
}