package com.mcssoft.racedayreminder.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mcssoft.racedayreminder.entity.RaceDetails
import com.mcssoft.racedayreminder.interfaces.IRaceRepo
import com.mcssoft.racedayreminder.repository.RaceRepository

/**
 * Wrapper class for the ViewModel.
 * @param iRaceRepo: Repository interface.
 */
class RaceViewModel(private val iRaceRepo: IRaceRepo) : ViewModel() {

    /**
     * Get all the RaceDetails from the LiveData.
     * @return A LiveData array of RaceDetails objects.
     */
    fun getRacesLD() : LiveData<MutableList<RaceDetails>> = iRaceRepo.getRacesLD()

//    /**
//     * Utility method, change the backing data.
//     * @param lRaces: The new/changed backing data.
//     */
//    fun setData(lRaces: MutableList<RaceDetails>) = iRaceRepo.setData(lRaces)

}