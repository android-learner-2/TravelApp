package com.padcmyanmar.padcx.travelapp.data.vos

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/22/2020.
 */
data class ToursAndCountryVO (
     var countries: List<ToursVO> = arrayListOf(),
     var tours: List<ToursVO> = arrayListOf()
)