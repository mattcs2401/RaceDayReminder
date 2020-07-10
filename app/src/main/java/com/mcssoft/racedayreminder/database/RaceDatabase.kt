package com.mcssoft.racedayreminder.database

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mcssoft.racedayreminder.dao.RaceDetailsDAO
import com.mcssoft.racedayreminder.entity.RaceDetails

@Database(entities = [RaceDetails::class], version = 1, exportSchema = false)
abstract class RaceDatabase : RoomDatabase() {

    internal abstract fun raceDetailsDao(): RaceDetailsDAO

    companion object {
        @Volatile
        private var instance: RaceDatabase? = null

        fun getDatabase(context: Application): RaceDatabase {
            //https://proandroiddev.com/sqlite-triggers-android-room-2e7120bb3e3a
            return instance ?: Room
                .databaseBuilder(context.applicationContext,
                    RaceDatabase::class.java, "Races.db")
                .addCallback(db_callback)
                .build()
                .also { instance = it }
        }
//        fun getInstance(context: Application?): RaceDatabase? {
//            if (instance == null) {
//                synchronized(RaceDatabase::class) {
//                    instance = Room.databaseBuilder(context!!.applicationContext,
//                        RaceDatabase::class.java, "Races.db")
//                        .fallbackToDestructiveMigration()
//                        .build()
//                }
//            }
//            return instance
//        }

        private val db_callback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
//                db.execSQL("TBA")
            }
        }
    }

}
