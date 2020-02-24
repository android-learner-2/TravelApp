package com.padcmyanmar.padcx.travelapp.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padcmyanmar.padcx.travelapp.data.vos.ToursVO
import com.padcmyanmar.padcx.travelapp.persistence.daos.ToursDao

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/20/2020.
 */
@Database(entities = [ToursVO::class], version = 5,exportSchema = false)
abstract class ToursDB : RoomDatabase(){

    companion object{
        val DB_NAME = "Tours.DB"
        var db_instance : ToursDB ?= null
        fun getDBInstance(context: Context) : ToursDB {
            when(db_instance){
                null -> {
                    db_instance = Room.databaseBuilder(context,ToursDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            val i = db_instance
            return i!!
        }
    }

    abstract fun toursDao() : ToursDao
}
