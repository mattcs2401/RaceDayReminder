package com.mcssoft.racedayreminder.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.mcssoft.racedayreminder.database.RaceDatabase
import com.mcssoft.racedayreminder.database.entity.Race

interface IRaceRepo {
    // Here for DI. Can't seem to get it to work when in a separate file.
    suspend fun getAllRaces() : LiveData<List<Race>>
    suspend fun getRaceCount(): LiveData<Int>
}

/**
 * Repository implementation. Manages data to/from the database and the UI through the RaceViewModel.
 * @param context: The context required for the database access.
 */
class RaceRepoImpl(private val context: Context) : IRaceRepo {

    //Database access.
     private var iRaceDao = RaceDatabase.getDatabase(context).raceDao()

    /**
     * Get all the Races.
     */
    override suspend fun getAllRaces() : LiveData<List<Race>> = iRaceDao.getAllRaces()

    /**
     * Get the current count of rows in the race_details table.
     */
    override suspend fun getRaceCount(): LiveData<Int> = iRaceDao.getCount()

//    /**
//     * Insert a new Race.
//     * // TBA - a return value Long ?
//     */
//    override suspend fun insertRace(race: Race) = raceDao.insertRace(race)

}