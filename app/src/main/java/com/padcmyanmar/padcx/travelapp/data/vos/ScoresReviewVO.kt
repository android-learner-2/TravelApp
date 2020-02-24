package com.padcmyanmar.padcx.travelapp.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/20/2020.
 */
data class ScoresReviewVO (
    @SerializedName("name") val name: String = "",
    @SerializedName("score") val score: Double = 0.0,
    @SerializedName("max_score") val maxScore: Int = 0,
    @SerializedName("total_reviews") val totalReviews: Int = 0
)