package com.mcssoft.racedayreminder.common

import android.app.Application
import com.mcssoft.racedayreminder.adapter.RaceDayAdapter
import com.mcssoft.racedayreminder.database.RaceDatabase
import com.mcssoft.racedayreminder.interfaces.IRaceDAO
import com.mcssoft.racedayreminder.model.RaceViewModel
import com.mcssoft.racedayreminder.repository.IRaceRepo
import com.mcssoft.racedayreminder.repository.RaceRepoImpl
import com.mcssoft.racedayreminder.utility.BackPressCB
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class RaceReminderApp : Application() {

    private val koinModule = module {

        single<IRaceRepo> { RaceRepoImpl(get()) }

        viewModel { RaceViewModel(get()) }

        single { RaceDayAdapter() }

        single { BackPressCB() }

//        single { RaceDatabase.getDatabase(get()).raceDao() }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RaceReminderApp)
            modules(koinModule)
        }
    }
}
