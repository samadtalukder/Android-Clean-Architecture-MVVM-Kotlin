package com.samad_talukder.androidcleanarchitecturemvvm.data.source.response

/**
 * Created by Samad Talukder on 16, June, 2022.
 * github.com/samadtalukder
 **/

data class StoriesItem(
    val thumbnail: String,
    val contentLevel: String,
    val id: String,
    val title: String,
    val author: String,
    val authorID: String,
    val link: String,
    val postTime: String,
    val tags: String,
    val description: String? = null
)