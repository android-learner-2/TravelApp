package com.padcmyanmar.padcx.travelapp.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.padcx.travelapp.data.vos.ScoresReviewVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/22/2020.
 */
class ScoresReviewsListTypeConverter {
    @TypeConverter
    fun toString(scoresList: ArrayList<ScoresReviewVO>) : String {
        return Gson().toJson(scoresList)
    }

    @TypeConverter
    fun toScoesList(scoesListJsonString: String) : ArrayList<ScoresReviewVO> {
        val scoesListType = object : TypeToken<ArrayList<ScoresReviewVO>>() {}.type
        return Gson().fromJson(scoesListJsonString,scoesListType)
    }
}