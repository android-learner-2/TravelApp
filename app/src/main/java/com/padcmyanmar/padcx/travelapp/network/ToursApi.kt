package com.padcmyanmar.padcx.travelapp.network

import com.padcmyanmar.padcx.travelapp.network.responses.GetAllToursResponse
import com.padcmyanmar.padcx.travelapp.utils.GET_COUNTRIES
import com.padcmyanmar.padcx.travelapp.utils.GET_TOURS
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/21/2020.
 */
interface ToursApi {

    @GET(GET_TOURS)
    fun getAllTours() : Observable<GetAllToursResponse>

    @GET(GET_COUNTRIES)
    fun getAllCountries() : Observable<GetAllToursResponse>
}