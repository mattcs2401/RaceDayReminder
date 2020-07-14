package com.mcssoft.racedayreminder.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcssoft.racedayreminder.entity.RaceDetails
import com.mcssoft.racedayreminder.interfaces.IRaceRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Wrapper class for the ViewModel.
 * @param iRaceRepo: Repository interface.
 */
class RaceViewModel(private val iRaceRepo: IRaceRepo) : ViewModel() {

    // Backing data.
    private val racesList = mutableListOf<RaceDetails>()
    private lateinit var lRaces: LiveData<MutableList<RaceDetails>> //= MutableLiveData()

    /**
     * Get all the RaceDetails from the LiveData.
     * @return A LiveData array of RaceDetails objects.
     */
    fun getRacesLD() : LiveData<MutableList<RaceDetails>> {
        if(!::lRaces.isInitialized) {
            lRaces = MutableLiveData<MutableList<RaceDetails>>()
        }
//        viewModelScope.launch(Dispatchers.IO) {
            lRaces = iRaceRepo.getRacesLD()
//        }
        return lRaces
//        return iRaceRepo.getRacesLD()
    }

//    /**
//     * Utility method, change the backing data.
//     * @param lRaces: The new/changed backing data.
//     */
//    fun setData(lRaces: MutableList<RaceDetails>) = iRaceRepo.setData(lRaces)

}