package com.mcssoft.racedayreminder.interfaces

import androidx.lifecycle.LiveData
import com.mcssoft.racedayreminder.entity.RaceDetails

interface IRaceRepo {

    /**
     * Get all the LiveData RaceDetails. Only used by the RaceListObserver.
     */
    fun getRacesLD(): LiveData<MutableList<RaceDetails>>
}
