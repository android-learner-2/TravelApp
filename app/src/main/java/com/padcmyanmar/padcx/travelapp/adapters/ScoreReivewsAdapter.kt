package com.padcmyanmar.padcx.travelapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padcx.travelapp.R
import com.padcmyanmar.padcx.travelapp.data.vos.ScoresReviewVO
import com.padcmyanmar.padcx.travelapp.views.viewholder.ScoreReviewsViewHolder

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/20/2020.
 */
class ScoreReivewsAdapter : BaseRecyclerAdapter<ScoreReviewsViewHolder,ScoresReviewVO>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreReviewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_scores_reviews,parent,false)
        return ScoreReviewsViewHolder(view)
    }
}