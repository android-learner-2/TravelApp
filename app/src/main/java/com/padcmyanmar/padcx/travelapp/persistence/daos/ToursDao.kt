package com.padcmyanmar.padcx.travelapp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcmyanmar.padcx.travelapp.data.vos.ToursVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/20/2020.
 */
@Dao
interface ToursDao {

    @Query("SELECT * FROM Tours WHERE Status = 0")
    fun getAllCountries() : LiveData<List<ToursVO>>

    @Query("SELECT * FROM Tours WHERE Status = 1")
    fun getAllPopularTours() : LiveData<List<ToursVO>>

    @Query("SELECT * FROM Tours WHERE Name = :toursName")
    fun getToursByName(toursName: String) : LiveData<ToursVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTours(tours: List<ToursVO>)
}