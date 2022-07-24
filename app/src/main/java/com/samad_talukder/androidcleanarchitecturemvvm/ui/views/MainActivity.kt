package com.samad_talukder.androidcleanarchitecturemvvm.ui.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.samad_talukder.androidcleanarchitecturemvvm.common.utils.ApiResult
import com.samad_talukder.androidcleanarchitecturemvvm.common.utils.CustomProgressBar.hideProgressBar
import com.samad_talukder.androidcleanarchitecturemvvm.common.utils.CustomProgressBar.isNull
import com.samad_talukder.androidcleanarchitecturemvvm.common.utils.CustomProgressBar.showProgressBar
import com.samad_talukder.androidcleanarchitecturemvvm.data.source.response.StoriesItem
import com.samad_talukder.androidcleanarchitecturemvvm.databinding.ActivityMainBinding
import com.samad_talukder.androidcleanarchitecturemvvm.ui.adapter.StoriesDataAdapter
import com.samad_talukder.androidcleanarchitecturemvvm.ui.view_model.StoriesViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Samad Talukder on 20, June, 2022.
 * github.com/samadtalukder
 **/

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val storiesViewModel by viewModels<StoriesViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: StoriesDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        storiesDataObserver()
        storiesViewModel.getStoriesData()
    }

    private fun storiesDataObserver() {
        storiesViewModel.storiesLiveData.observe(this) { response ->
            when (response) {

                is ApiResult.Loading -> {
                    showProgressBar(this)
                }

                is ApiResult.Success -> {

                    if (!isNull(response.data)){
                        response.data?.let {
                            setAdapter(it.items)
                        }
                    }
                    hideProgressBar()
                }

                is ApiResult.Error -> {
                    hideProgressBar()
                }

                is ApiResult.Nothing -> {
                    hideProgressBar()
                }
            }
        }
    }

    private fun setAdapter(products: List<StoriesItem>) {
        adapter = StoriesDataAdapter()
        adapter.submitData(products.toMutableList())
        binding.rvStories.layoutManager = GridLayoutManager(this, 2)
        binding.rvStories.adapter = adapter

    }
}