package com.mcssoft.racedayreminder.interfaces

import androidx.lifecycle.LiveData
import com.mcssoft.racedayreminder.database.entity.Race

interface IRaceRepo {

  /**
   * Establish the backing data in the repository.
   */
  suspend fun initialise()

  fun getAllRaces(): LiveData<List<Race>>

//  suspend fun insertRace(race: Race): Long

  fun getRaceCount(): Int

}
