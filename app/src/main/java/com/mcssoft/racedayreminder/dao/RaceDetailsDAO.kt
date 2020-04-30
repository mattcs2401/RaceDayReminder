package com.mcssoft.racedayreminder.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mcssoft.racedayreminder.database.entity.RaceDetails

@Dao
interface RaceDetailsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRace(race: RaceDetails): Long

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateRace(race: RaceDetails): Int

    @Query("select * from race_details where _id = :id")
    fun getRaceLD(id: Long): LiveData<RaceDetails>

    @Query("select * from race_details")
    fun getRacesLD(): LiveData<MutableList<RaceDetails>>

    @Query("delete from race_details where _id = :id")
    fun deleteRace(id: Long): Int

    @Query("delete from race_details")
    fun deleteAll(): Int

    @Query("select * from race_details where _id = :id")
    fun getRaceNoLD(id: Long): RaceDetails

    @Query("select * from race_details")
    fun getAllRacesNoLD(): MutableList<RaceDetails>

}