package com.padcmyanmar.padcx.travelapp.data.models

import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.travelapp.data.vos.ToursAndCountryVO
import com.padcmyanmar.padcx.travelapp.data.vos.ToursVO
import io.reactivex.Observable

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/21/2020.
 */
interface ToursModel {
    fun getAllTours(onError: (String) -> Unit) : Observable<ToursAndCountryVO>

    fun getToursByName(toursName: String) : LiveData<ToursVO>

    fun getAllToursOffline() : LiveData<List<ToursVO>>

    fun getAllCountriesOffline(): LiveData<List<ToursVO>>
}