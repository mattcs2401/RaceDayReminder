package com.mcssoft.racedayreminder.observer

import androidx.lifecycle.Observer
import com.mcssoft.racedayreminder.database.entity.RaceDetails
import com.mcssoft.racedayreminder.model.RaceViewModel

/**
 * Observer class for the RaceDetails LiveData.
 * @param raceViewModel: The view model. Gives access to the backing data.
 */
class RaceListObserver(private var raceViewModel: RaceViewModel) :
    Observer<MutableList<RaceDetails>> {

    /**
     * The observer's onChange method.
     * @param lRaces: The list of mutable RaceDetails objects.
     */
    override fun onChanged(lRaces: MutableList<RaceDetails>?) {
        if((lRaces != null) && (lRaces.size > 1)) {
//            // Sort (TBA by).
//            lRaces.sorted()
            // Set adapter backing data.
//            raceViewModel.setData(lRaces)
        }
    }

}