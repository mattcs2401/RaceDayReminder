package com.mcssoft.racedayreminder.model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcssoft.racedayreminder.database.entity.Race
import com.mcssoft.racedayreminder.interfaces.IRaceRepo
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * Wrapper class for the ViewModel.
 * @param iRaceRepo: Repository interface.
 */
class RaceViewModel(private val iRaceRepo: IRaceRepo, uiContext: Context) : ViewModel() {

    // Backing data.
    // Note: if put assignment in an init{} block, editor says can join declaration and assignment.
    private lateinit var lRaces: MutableLiveData<MutableList<Race>>

    init {
        lRaces = MutableLiveData()//<MutableList<Race>>
    }
        /**
         * Get all the Race from the LiveData.
         * @return A list of Race objects wrapped in LiveData.
         */
        fun getRacesLD() : MutableLiveData<MutableList<Race>> = lRaces

        /**
         * Get all the Race from the LiveData.
         * @return A list of Race objects wrapped in MutableLiveData.
         */
        fun getRaces() = lRaces

        /**
         *
         */
        fun getRaceCount(): Job = viewModelScope.launch {
            val count = iRaceRepo.getRaceCount()
        }

}