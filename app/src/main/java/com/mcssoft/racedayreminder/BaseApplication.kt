package com.mcssoft.racedayreminder

import android.app.Application
import com.mcssoft.racedayreminder.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(appModule, sharedPrefsModule, roomModule, repoModule, viewModelModule))
        }
    }
}
