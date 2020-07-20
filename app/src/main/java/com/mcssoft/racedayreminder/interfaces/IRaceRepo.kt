package com.mcssoft.racedayreminder.interfaces

import com.mcssoft.racedayreminder.database.entity.Race

interface IRaceRepo {

//  /**
//   * Get all the Race.
//   * @return A mutable list of all Race wrapped in LiveData.
//   */
//  fun getRacesLD(): LiveData<MutableList<Race>>

  suspend fun getRaces(): List<Race>

  suspend fun getRace(id: Int): Race

//  /**
//   * Get a Race.
//   * @param id: The id of the object.
//   * @return A Race wrapped in LiveData.
//   */
//  fun getRaceLD(id: Long): LiveData<Race>

  suspend fun insertRace(race: Race)

  suspend fun getRaceCount(): Int

}
