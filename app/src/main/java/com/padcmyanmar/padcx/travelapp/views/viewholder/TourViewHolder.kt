package com.padcmyanmar.padcx.travelapp.views.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.travelapp.data.vos.ToursVO
import com.padcmyanmar.padcx.travelapp.delegates.ToursItemDelegate
import kotlinx.android.synthetic.main.item_tours.view.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/20/2020.
 */
class TourViewHolder(itemView: View,delegate: ToursItemDelegate) : BaseTravelViewHolder(itemView) {
    init{
        itemView.setOnClickListener {
            mData?.let {
               delegate.onTapToursItem(it.name)
            }
        }
    }

    override fun bindData(data: ToursVO) {
        mData = data
        itemView.tvLocation.text = data.location
        Glide.with(itemView.context)
            .load(data.photos[0])
            .into(itemView.ivTourPhoto)
    }
}