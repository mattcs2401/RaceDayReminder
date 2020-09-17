package com.mcssoft.racedayreminder.model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcssoft.racedayreminder.database.entity.Race
import com.mcssoft.racedayreminder.interfaces.IRaceRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Wrapper class for the ViewModel.
 * @param iRaceRepo: Repository interface.
 */
class RaceViewModel(private val iRaceRepo: IRaceRepo) : ViewModel() {

    init {
        initialise()
    }

    private fun initialise() {
        viewModelScope.launch {
            iRaceRepo.initialise()
        }
    }

    val races = iRaceRepo.getAllRaces()

    var count: Int = iRaceRepo.getRaceCount()

    var bp= ""

//    fun getCount() {
//        viewModelScope.launch {
//            count = iRaceRepo.getRaceCount()
//        }
//    }

//    suspend fun getRaceCount(): Int {
//      return withContext(Dispatchers.IO) {
//          val count = iRaceRepo.getRaceCount()
//          count
//      }
//    }

}