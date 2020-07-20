package com.mcssoft.racedayreminder.di

import com.mcssoft.racedayreminder.interfaces.IRaceRepo
import com.mcssoft.racedayreminder.model.RaceViewModel
import com.mcssoft.racedayreminder.repository.RaceRepoImpl
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val sharedPrefsModule = module {
    // TBA.
}

val repoModule = module {
    single<IRaceRepo> { RaceRepoImpl(get()) }
}

val viewModelModule = module {
    viewModel { RaceViewModel(get(), androidContext()) }
}