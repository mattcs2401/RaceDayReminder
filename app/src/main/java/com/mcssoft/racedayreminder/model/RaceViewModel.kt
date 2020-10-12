package com.mcssoft.racedayreminder.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcssoft.racedayreminder.database.entity.Race
import com.mcssoft.racedayreminder.repository.IRaceRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Wrapper class for the ViewModel.
 * @param iRaceRepo: Repository interface.
 */
class RaceViewModel(private val iRaceRepo: IRaceRepo) : ViewModel() {

    lateinit var count: LiveData<Int>
    lateinit var cache : LiveData<List<Race>>

    init {
        setRaces()
        setCount()
    }

    fun isEmpty(): Boolean {
        return cache.value!!.isEmpty()
    }

    fun insertRace(race: Race) {
        viewModelScope.launch(Dispatchers.IO) {
            iRaceRepo.insertRace(race)
        }
    }

    private fun setRaces() {
        viewModelScope.launch {
            cache = iRaceRepo.getAllRaces()
        }
    }

    private fun setCount() {
        viewModelScope.launch {
            count = iRaceRepo.getRaceCount()
        }
    }

}