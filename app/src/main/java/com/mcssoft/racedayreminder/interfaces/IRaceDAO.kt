package com.mcssoft.racedayreminder.interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mcssoft.racedayreminder.database.entity.Race

@Dao
interface IRaceDAO {

    @Query("select * from race_details")
    fun getAllRaces(): LiveData<List<Race>>

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertRace(race: Race): Long
//
//    @Query("select * from race_details where _id = :id")
//    fun getRace(id: Long): Race  //Note: Can't do a return of LiveData<Race>.

    @Query("select count (*) from race_details")
    fun getCount(): Int

//    @Query("delete from race_details where _id = :id")
//    fun deleteRace(id: Long): Int
//
//    @Query("delete from race_details")
//    fun deleteAll(): Int

}