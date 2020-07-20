package com.mcssoft.racedayreminder.observer

import androidx.lifecycle.Observer
import com.mcssoft.racedayreminder.database.entity.Race
import com.mcssoft.racedayreminder.model.RaceViewModel

class RaceListObserver(raceViewModel: RaceViewModel) : Observer<MutableList<Race>> {

    override fun onChanged(t: MutableList<Race>?) {
        // TBA
    }
}
