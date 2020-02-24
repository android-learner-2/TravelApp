package com.padcmyanmar.padcx.travelapp.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/22/2020.
 */
class PhotoListTypeConverter {
    @TypeConverter
    fun toString(photoList: ArrayList<String>) : String {
        return Gson().toJson(photoList)
    }

    @TypeConverter
    fun toPhotoList(photoListJsonString: String) : ArrayList<String> {
        val photoListType = object : TypeToken<ArrayList<String>>() {}.type
        return Gson().fromJson(photoListJsonString,photoListType)
    }
}