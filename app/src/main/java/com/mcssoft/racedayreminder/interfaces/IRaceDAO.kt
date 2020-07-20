package com.mcssoft.racedayreminder.interfaces

import androidx.room.*
import com.mcssoft.racedayreminder.database.entity.Race

@Dao
interface IRaceDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRace(race: Race)//: Long

//    @Update(onConflict = OnConflictStrategy.IGNORE)
//    fun updateRace(race: Race): Int

//    @Query("select * from race_details where _id = :id")
//    fun getRaceLD(id: Long): LiveData<Race>

    @Query("select * from race_details where _id = :id")
    suspend fun getRace(id: Long): Race

//    @Query("select * from race_details")
//    fun getRacesLD(): LiveData<MutableList<Race>>

    @Query("select * from race_details")
    suspend fun getRaces(): List<Race>

    @Query("select count (*) from race_details")
    suspend fun getCount(): Int

//    @Query("delete from race_details where _id = :id")
//    fun deleteRace(id: Long): Int

//    @Query("delete from race_details")
//    fun deleteAll(): Int

}