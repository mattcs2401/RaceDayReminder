package com.mcssoft.racedayreminder.observer

import androidx.lifecycle.Observer
import com.mcssoft.racedayreminder.database.entity.Race
import com.mcssoft.racedayreminder.model.RaceViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class RaceListObserver : Observer<List<Race>>, KoinComponent {

    private val raceViewModel: RaceViewModel by inject()   // enabled by KoinComponent.

    override fun onChanged(lRaces: List<Race>) {
        if(lRaces.size > 1) {
            // Sort (TBA by).
            lRaces.sorted()
            // Set adapter backing data.
            //raceViewModel.cache = lRaces as LiveData<List<Race>>// TBA
        }

    }
}
