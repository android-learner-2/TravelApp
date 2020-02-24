package com.padcmyanmar.padcx.travelapp.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padcx.travelapp.persistence.typeconverters.PhotoListTypeConverter
import com.padcmyanmar.padcx.travelapp.persistence.typeconverters.ScoresReviewsListTypeConverter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/20/2020.
 */
@Entity(tableName = "Tours")
@TypeConverters(ScoresReviewsListTypeConverter::class,PhotoListTypeConverter::class)
data class ToursVO(
   /* @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="Id")
    var id: Int = 0,*/

    @PrimaryKey
    @ColumnInfo(name="Name")
    @SerializedName("name") var name: String = "",

    @ColumnInfo(name="Description")
    @SerializedName("description") var description : String = "",

    @ColumnInfo(name="Location")
    @SerializedName("location") var location : String = "",

    @ColumnInfo(name="AverageRating")
    @SerializedName("average_rating") var averageRating : Double = 0.0,

    @ColumnInfo(name="ScoresReviews")
    @SerializedName("scores_and_reviews") var scoresAndReviews : ArrayList<ScoresReviewVO> = arrayListOf(),

    @ColumnInfo(name="Photos")
    @SerializedName("photos") var photos: ArrayList<String> = arrayListOf(),

    @ColumnInfo(name="Status")
    var status: Int = 0  // 0 for country, 1 for popular tour
)