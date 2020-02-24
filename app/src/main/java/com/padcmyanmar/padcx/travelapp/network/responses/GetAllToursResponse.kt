package com.padcmyanmar.padcx.travelapp.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padcx.travelapp.data.vos.ToursVO
import com.padcmyanmar.padcx.travelapp.utils.SUCCESS_CODE_RESPONSE

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/20/2020.
 */
data class GetAllToursResponse (
    @SerializedName("code") val code : Int = 0,
    @SerializedName("message") val message : String = "",
    @SerializedName("data") val data : List<ToursVO> = arrayListOf()
){
    fun isResponseOk(): Boolean = (data != null) && (code == SUCCESS_CODE_RESPONSE)
}