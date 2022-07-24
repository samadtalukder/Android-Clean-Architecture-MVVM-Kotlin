package com.samad_talukder.androidcleanarchitecturemvvm.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.samad_talukder.androidcleanarchitecturemvvm.common.utils.extensions.loadImage
import com.samad_talukder.androidcleanarchitecturemvvm.data.source.response.StoriesItem
import com.samad_talukder.androidcleanarchitecturemvvm.databinding.ItemStoriesDataBinding

/**
 * Created by Samad Talukder on 20, June, 2022.
 * github.com/samadtalukder
 **/

class StoriesDataAdapter : RecyclerView.Adapter<StoriesDataAdapter.StoriesViewHolder>() {

    fun submitData(data: MutableList<StoriesItem>) = differ.submitList(data)

    private val diffCallBack = object : DiffUtil.ItemCallback<StoriesItem>() {
        override fun areItemsTheSame(oldItem: StoriesItem, newItem: StoriesItem): Boolean {
            return oldItem.title == newItem.title
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: StoriesItem, newItem: StoriesItem): Boolean {
            return oldItem.title == newItem.title && oldItem.author == newItem.authorID
        }

    }
    private val differ = AsyncListDiffer(this, diffCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemStoriesDataBinding.inflate(layoutInflater, parent, false)
        return StoriesViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        val data = differ.currentList[position]
        holder.bindData(data)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    class StoriesViewHolder(private val dataBinding: ItemStoriesDataBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {

        fun bindData(data: StoriesItem?) {
            dataBinding.ivItemImage.loadImage(data?.thumbnail.toString())
            dataBinding.tvItemName.text = data?.title.toString()
            dataBinding.tvAuthor.text = data?.author.toString()

        }

    }
}