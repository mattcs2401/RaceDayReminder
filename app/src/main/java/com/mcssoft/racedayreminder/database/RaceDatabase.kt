package com.mcssoft.racedayreminder.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mcssoft.racedayreminder.dao.RaceDetailsDAO
import com.mcssoft.racedayreminder.database.entity.RaceDetails

@Database(entities = [RaceDetails::class], version = 1, exportSchema = false)
abstract class RaceDatabase : RoomDatabase() {

    internal abstract fun raceDetailsDao(): RaceDetailsDAO

    companion object {
        @Volatile
        private var instance: RaceDatabase? = null

        fun getDatabase(context: Application): RaceDatabase {
            return instance ?: Room
                .databaseBuilder(context.applicationContext,
                    RaceDatabase::class.java, "Races.db")
//                .addCallback(db_callback)
                .build()
                .also { instance = it }
        }

        // TBA - callback can be used to prepopulate the database on create.
//        private val db_callback = object : RoomDatabase.Callback() {
//            override fun onCreate(db: SupportSQLiteDatabase) {
//                super.onCreate(db)
//                db.execSQL("TBA")
//            }
//        }
    }

}
