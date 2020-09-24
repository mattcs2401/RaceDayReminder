package com.mcssoft.racedayreminder.common

import android.app.Application
import com.mcssoft.racedayreminder.adapter.RaceDayAdapter
import com.mcssoft.racedayreminder.model.IRaceViewModel
import com.mcssoft.racedayreminder.model.RaceViewModel
import com.mcssoft.racedayreminder.observer.RaceListObserver
import com.mcssoft.racedayreminder.repository.IRaceRepo
import com.mcssoft.racedayreminder.repository.RaceRepoImpl
import com.mcssoft.racedayreminder.utility.BackPressCB
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class RaceReminderApp : Application() {

    private val koinModule = module {

        // Notes: class RaceRepoImpl implements interface IRaceRepo.
        single<IRaceRepo> {
            RaceRepoImpl(get())
        }

        // Notes: class RaceViewModel parameter is IRaceRepo.
        viewModel {
            RaceViewModel(get())
        }

        // Notes: class RaceListObserver implements KoinComponent to enable inject of RaceViewModel.
        single {
            RaceListObserver()
        }

        // Notes: TBA
        single { RaceDayAdapter() }

        single { BackPressCB() }

    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RaceReminderApp)
            modules(koinModule)
        }
    }
}
