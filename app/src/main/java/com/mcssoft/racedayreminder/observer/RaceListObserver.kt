package com.mcssoft.racedayreminder.observer

import androidx.lifecycle.Observer
import com.mcssoft.racedayreminder.entity.RaceDetails
import com.mcssoft.racedayreminder.model.RaceViewModel

class RaceListObserver(raceViewModel: RaceViewModel) : Observer<MutableList<RaceDetails>> {

    override fun onChanged(t: MutableList<RaceDetails>?) {
        // TBA
    }
}
