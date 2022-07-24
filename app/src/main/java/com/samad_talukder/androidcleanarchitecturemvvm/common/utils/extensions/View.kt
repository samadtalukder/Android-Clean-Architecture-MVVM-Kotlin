package com.samad_talukder.androidcleanarchitecturemvvm.common.utils.extensions

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.samad_talukder.androidcleanarchitecturemvvm.R

/**
 * Created by Samad Talukder on 25, July, 2022.
 * github.com/samadtalukder
 **/

fun ImageView.loadImage(
    imgUrl: String,
    @DrawableRes placeholder: Int = R.drawable.ic_launcher_foreground
) {
    Glide
        .with(this)
        .load(imgUrl)
        .placeholder(placeholder)
        .into(this)

}

