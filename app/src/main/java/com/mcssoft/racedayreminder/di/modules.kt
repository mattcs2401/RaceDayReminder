package com.mcssoft.racedayreminder.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.mcssoft.racedayreminder.database.RaceDatabase
import com.mcssoft.racedayreminder.interfaces.IRaceRepo
import com.mcssoft.racedayreminder.model.RaceViewModel
import com.mcssoft.racedayreminder.repository.RaceRepository
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // TBA
}

val sharedPrefsModule = module {
    single<SharedPreferences> {
        androidContext().getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)
    }
}

val roomModule = module {
    single {
        Room.databaseBuilder(get(),
            RaceDatabase::class.java, "Race.db").build()
    }

    single {
        get<RaceDatabase>().raceDetailsDao()
    }
}

val repoModule = module {
    single {
        RaceRepository(get())
    }
}
val viewModelModule = module {
    viewModel { RaceViewModel() }
}