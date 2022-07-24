package com.samad_talukder.androidcleanarchitecturemvvm.common.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Samad Talukder on 10, June, 2022.
 * github.com/samadtalukder
 **/

@HiltAndroidApp
class AndroidCleanArchitectureApp : Application() {
    override fun onCreate() {
        super.onCreate()

        // Initialize SharedPreference
        //SharedPreferenceManager(this)
    }
}