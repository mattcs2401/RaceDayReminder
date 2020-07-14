package com.mcssoft.racedayreminder.interfaces

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mcssoft.racedayreminder.entity.RaceDetails

interface IRaceRepo {

  /**
   * Get all the RaceDetails.
   * @return A mutable list of all RaceDetails wrapped in LiveData.
   */
  fun getRacesLD(): LiveData<MutableList<RaceDetails>>

  /**
   * Get a RaceDetails.
   * @param id: The id of the object.
   * @return A RaceDetails wrapped in LiveData.
   */
  fun getRaceLD(id: Long): LiveData<RaceDetails>

  suspend fun insertRace(raceDetails: RaceDetails)


  // TODO - other interface IRaceRepo elements.
}
