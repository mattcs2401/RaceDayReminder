package com.mcssoft.racedayreminder.di

import com.mcssoft.racedayreminder.interfaces.IRaceRepo
import com.mcssoft.racedayreminder.model.RaceViewModel
import com.mcssoft.racedayreminder.repository.RaceRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val sharedPrefsModule = module {
    // TBA.
}

val repoModule = module {
    single<IRaceRepo> { RaceRepository(get()) }
}

val viewModelModule = module {
    viewModel { RaceViewModel(get()) }
}