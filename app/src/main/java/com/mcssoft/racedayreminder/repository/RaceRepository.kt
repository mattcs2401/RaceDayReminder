package com.mcssoft.racedayreminder.repository

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.mcssoft.racedayreminder.database.RaceDatabase
import com.mcssoft.racedayreminder.database.entity.RaceDetails
import com.mcssoft.racedayreminder.interfaces.IRaceRepo

/**
 * Repository implementation. Manages data to/from the database and the UI through the RaceViewModel.
 * @param context: The context required for the database access.
 */
class RaceRepository /*@Inject constructor*/(private val context: Context) : IRaceRepo {

    // Database access.
    private var raceDetailsDao =
        RaceDatabase.getDatabase(context.applicationContext as Application).raceDetailsDao()
    // Backing data.
    private var lRaces: MutableLiveData<MutableList<RaceDetails>> = MutableLiveData()

//    /**
//     * Initialise the backing data.
//     * @Note: This must be the first call.
//     */
//    override fun initialise() {
//        lRaces.value = getRaces()
//    }

    //<editor-fold default state="collapsed" desc="Region: Observer related">
//    /**
//     * Get all the LiveData RaceDetails. Only used by the RaceListObserver.
//     */
//    override fun getRacesLD(): LiveData<MutableList<RaceDetails>> = raceDetailsDao.getRacesLD()

//    /**
//     * Get a LiveData RaceDetails. Only used by the RaceObserver.
//     */
//    override fun getRaceLD(id: Long): LiveData<RaceDetails> = raceDetailsDao.getRaceLD(id)
    //</editor-fold>

//    /**
//     * Insert a RaceDetails object.
//     * @param raceDetails: The RaceDetails object to insert.
//     * @return The database row id.
//     */
//    override fun insertRace(raceDetails: RaceDetails): Long {
//        var result: Long = -1
//        val asyncTask = InsertRace(raceDetailsDao)
//        try {
//            // Database insert (any exception is likely to happen here).
//            asyncTask.execute(raceDetails)
//            result = asyncTask.get()
//            // Update backing data.
//            lRaces.value!!.add(raceDetails)
//        } catch(ex: Exception) {
//            Log.d("TAG", "Exception in RaceRepository.insertRace(): $ex")
//        } finally {
//            return result
//        }
//    }

//    /**
//     * Update a RaceDetails object.
//     * @param ndx: The backing data index.
//     * @param raceDetails: The RaceDetails object to update.
//     * @return The number of rows updated.
//     */
//    override fun updateRace(ndx: Int, raceDetails: RaceDetails): Int {
//        var result = -1
//        val asyncTask = UpdateRace(raceDetailsDao)
//        try {
//            // Database update.
//            asyncTask.execute(raceDetails)
//            result = asyncTask.get()
//            // Update backing data.
//            lRaces.value!![ndx] = raceDetails
//        } catch (ex: Exception) {
//            Log.d("TAG", "Exception in RaceRepository.updateRace(): $ex")
//        } finally {
//            return result
//        }
//    }

//    /**
//     * Delete a RaceDetails object.
//     * @param ndx: The backing data index.
//     * @return The number of rows updated.
//     */
//    override fun deleteRace(ndx: Int): Int {
//        var result = -1
//        try {
//            val race = lRaces.value!![ndx]//lRaces[ndx]
//            // Database delete.
//            val asyncTask = DeleteRace(raceDetailsDao)
//            asyncTask.execute(race.id!!)
//            result = asyncTask.get()
//            // Update backing data.
////            lRaces.removeAt(ndx)
//            lRaces.value!!.removeAt(ndx)
//        } catch (ex: Exception) {
//            Log.d("TAG", "Exception in RaceRepository.deleteRace(): $ex")
//        } finally {
//            return result
//        }
//    }

//    /**
//     * Get a RaceDetails from the backing data.
//     * @param ndx: The index into the backing data list.
//     * @return A RaceDetails object.
//     */
//    override fun getRace(ndx: Int): RaceDetails = lRaces.value!![ndx]

//    /**
//     * Get the count of RaceDetails in the backing data list.
//     * @return The backing data getRaceDetailsCount (size).
//     */
//    override fun getRaceDetailsCount(): Int = lRaces.value!!.size

//    /**
//     * Replace the current backing data with that given in the parameter.
//     * @param listRaces: The data that replaces the current.
//     */
//    override fun setData(listRaces: MutableList<RaceDetails>) {
////        lRaces.setValue(listRaces)
//        lRaces.value = listRaces
//    }

//    /**
//     * Get a RaceDetails by it's database row id (not LiveData).
//     * @param id: The id.
//     * @return A RaceDetails object.
//     */
//    override fun getRace(id: Long): RaceDetails {
//        val asyncTask = GetRace(raceDetailsDao)
//        asyncTask.execute(id)
//        return asyncTask.get()
//    }

//    /**
//     * Flag to indicate if backing data exists or not.
//     * @return True - no backing data exists, else - false, i.e. some backing data exists.
//     */
//    override fun isEmpty(): Boolean = lRaces.value!!.size < 1

//    /**
//     * Delete all the RaceDetails.
//     * @Note: Used by the bulk delete functionality.
//     */
//    override fun deleteAll() {
//        // TODO - delete any RaceExtras (for deleteAll()).
//        // TODO - delete file metadata (for deleteAll()).
//        // TODO - delete downloaded files (for deleteAll()).
//        // Delete from the database.
//        val asyncTask = DeleteAllRaces(raceDetailsDao)
//        asyncTask.execute()
//        // Remove the backing data.
//        lRaces.value!!.clear()
//    }

//    /**
//     * Get all RaceDetails (not LiveData).
//     * @return A mutable list of RaceDetails objects.
//     */
//    override fun getRaces(): MutableList<RaceDetails> {
//        val asyncTask = GetAllRaces(raceDetailsDao)
//        asyncTask.execute()
//        return asyncTask.get()
//    }

}