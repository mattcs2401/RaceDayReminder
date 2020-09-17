package com.mcssoft.racedayreminder.repository

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mcssoft.racedayreminder.database.RaceDatabase
import com.mcssoft.racedayreminder.database.entity.Race
import com.mcssoft.racedayreminder.interfaces.IRaceRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository implementation. Manages data to/from the database and the UI through the RaceViewModel.
 * @param context: The context required for the database access.
 */
class RaceRepoImpl(private val context: Context) : IRaceRepo {

//    lateinit var lRaces: LiveData<List<Race>>

    // Database access.
    private var raceDao =
        RaceDatabase.getDatabase(context.applicationContext as Application).raceDao()

    /**
     * Initialise the backing data.
     */
    override suspend fun initialise() {
//        lRaces = getAllRaces()
        getAllRaces()
    }

    /**
     * Get all the Races.
     */
    override fun getAllRaces() : LiveData<List<Race>> = raceDao.getAllRaces()

//    override suspend fun getAllRaces(): LiveData<List<Race>> {
//        return withContext(Dispatchers.IO) {
//            val lRaces = raceDao.getRaces()
//            lRaces
//        }
//    }

//    /**
//     * Insert a new Race.
//     * // TBA - a return value Long ?
//     */
//    override suspend fun insertRace(race: Race) = raceDao.insertRace(race)

    /**
     * Get the current count of rows in the race_details table.
     */
    override fun getRaceCount(): Int = raceDao.getCount()

}