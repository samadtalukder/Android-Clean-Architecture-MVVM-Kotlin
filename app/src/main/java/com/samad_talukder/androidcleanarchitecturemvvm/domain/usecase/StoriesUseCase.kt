package com.samad_talukder.androidcleanarchitecturemvvm.domain.usecase

import com.samad_talukder.androidcleanarchitecturemvvm.domain.repository.StoriesRepository

/**
 * Created by Samad Talukder on 16, June, 2022.
 * github.com/samadtalukder
 **/

class StoriesUseCase(private val storiesRepository: StoriesRepository) {

    suspend fun callStoriesApi() = storiesRepository.fetchStoryList()
}