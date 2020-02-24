package com.padcmyanmar.padcx.travelapp.views.viewholder

import android.view.View
import com.padcmyanmar.padcx.travelapp.data.vos.ScoresReviewVO
import kotlinx.android.synthetic.main.item_scores_reviews.view.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/20/2020.
 */
class ScoreReviewsViewHolder(itemView: View) : BaseViewHolder<ScoresReviewVO>(itemView) {
    override fun bindData(data: ScoresReviewVO) {
        itemView.tvName.text = data.name
        itemView.tvScore.text = data.score.toString()
        itemView.tvMaxScore.text = data.maxScore.toString()
        itemView.tvReviews.text = data.totalReviews.toString()
    }
}