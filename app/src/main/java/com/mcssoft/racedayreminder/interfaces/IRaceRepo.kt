package com.mcssoft.racedayreminder.interfaces

import androidx.lifecycle.LiveData
import com.mcssoft.racedayreminder.database.entity.RaceDetails

interface IRaceRepo {
    /**
     * Initialise the backing data.
     * @Note: This must be the first call.
     */
    fun initialise()

    //<editor-fold default state="collapsed" desc="Region: Observer related">
    /**
     * Get all the LiveData RaceDetails. Only used by the RaceListObserver.
     */
    fun getRacesLD(): LiveData<MutableList<RaceDetails>>

    /**
     * Get a LiveDta RaceDetails. Only used by the RaceObserver.
     */
    fun getRaceLD(id: Long): LiveData<RaceDetails>
    //</editor-fold>

    /**
     * Insert a RaceDetails object.
     * @param raceDetails: The RaceDetails object to insert.
     * @return The database row id.
     */
    fun insertRace(raceDetails: RaceDetails): Long

    /**
     * Update a RaceDetails object.
     * @param ndx: The backing data index.
     * @param raceDetails: The RaceDetails object to update.
     * @return The number of rows updated.
     */
    fun updateRace(ndx: Int, raceDetails: RaceDetails): Int

    /**
     * Delete a RaceDetails object.
     * @param ndx: The backing data index.
     * @return The number of rows updated.
     */
    fun deleteRace(ndx: Int): Int

    /**
     * Get a RaceDetails from the backing data.
     * @param ndx: The index into the backing data list.
     * @return A RaceDetails object.
     */
    fun getRace(ndx: Int): RaceDetails

    /**
     * Get the count of RaceDetails in the backing data list.
     * @return The backing data getRaceDetailsCount (size).
     */
    fun getRaceDetailsCount(): Int

    /**
     * Replace the current backing data with that given in the parameter.
     * @param listRaces: The data that replaces the current.
     */
    fun setData(listRaces: MutableList<RaceDetails>)

    /**
     * Get a RaceDetails by it's database row id (not LiveData).
     * @param id: The id.
     * @return A RaceDetails object.
     */
//    fun getRace(id: Long): RaceDetails

    /**
     * Flag to indicate if backing data exists or not.
     * @return True - no backing data exists, else - false, i.e. some backing data exists.
     */
    fun isEmpty(): Boolean

    /**
     * Delete all the RaceDetails.
     * @Note: Used by the bulk delete functionality.
     */
    fun deleteAll()

    /**
     * Get all RaceDetails (not LiveData).
     * @return A mutable list of RaceDetails objects.
     */
//    fun getRaces(): MutableList<RaceDetails>
}
