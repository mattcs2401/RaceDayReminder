package com.mcssoft.racedayreminder.di

import com.mcssoft.racedayreminder.model.RaceViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // TBA
}

val sharedPrefsModule = module {
    // TBA.
}

val repoModule = module {
    // TBA.
}

val viewModelModule = module {
    viewModel { RaceViewModel(get()) }
}