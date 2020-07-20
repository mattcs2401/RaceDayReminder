package com.mcssoft.racedayreminder.repository

import android.app.Application
import android.content.Context
import com.mcssoft.racedayreminder.database.RaceDatabase
import com.mcssoft.racedayreminder.database.entity.Race
import com.mcssoft.racedayreminder.interfaces.IRaceRepo

/**
 * Repository implementation. Manages data to/from the database and the UI through the RaceViewModel.
 * @param context: The context required for the database access.
 */
class RaceRepoImpl(private val context: Context) : IRaceRepo {

    // Database access.
    private var raceDao =
        RaceDatabase.getDatabase(context.applicationContext as Application).raceDao()

    override suspend fun getRaces(): List<Race> {
        TODO("Not yet implemented")
    }

    override suspend fun getRace(id: Int): Race {
        TODO("Not yet implemented")
    }

//    /**
//     * Get all the LiveData Race.
//     * @note: Must be called within a coroutine.
//     */
//    override fun getRacesLD(): LiveData<MutableList<Race>> = raceDetailsDao.getRacesLD()

//    /**
//     * Get a LiveData Race.
//     * @note: Must be called within a coroutine.
//     */
//    override fun getRaceLD(id: Long): LiveData<Race> = raceDetailsDao.getRaceLD(id)

    /**
     * Insert a new Race.
     * // TBA - a return value Long ?
     */
    override suspend fun insertRace(race: Race) = raceDao.insertRace(race)

    /**
     * Get the current count of rows in the race_details table.
     */
    override suspend fun getRaceCount(): Int = raceDao.getCount()

}