package com.mcssoft.racedayreminder.observer

import androidx.lifecycle.Observer
import com.mcssoft.racedayreminder.database.entity.Race
import com.mcssoft.racedayreminder.model.RaceViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class RaceListObserver() : Observer<List<Race>>, KoinComponent {

    private val raceViewModel: RaceViewModel by inject()   // enabled by KoinComponent.

    override fun onChanged(t: List<Race>?) {
        // TBA

    }
}
