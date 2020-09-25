package com.mcssoft.racedayreminder.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcssoft.racedayreminder.database.entity.Race
import com.mcssoft.racedayreminder.repository.IRaceRepo
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

//    fun getAllRaces(): LiveData<List<Race>> {
//        lateinit var value: LiveData<List<Race>>
//
//        viewModelScope.launch {
//            val result = iRaceRepo.getAllRaces()//= async(Dispatchers.IO){ raceRepo.getAllRaces() }
//            value = result//.await()
//        }
//        return value
//    }

//    fun getRaceCount(): LiveData<Int> {
//        lateinit var count: LiveData<Int>
//        viewModelScope.launch {
//            val result = iRaceRepo.getRaceCount()// = async(Dispatchers.IO) { raceRepo.getRaceCount() }
//            count = result//.await()
//        }
//        return count
//    }

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

    fun isEmpty(): Boolean {
        return cache.value!!.isEmpty()
    }
}