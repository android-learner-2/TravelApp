package com.padcmyanmar.padcx.travelapp.views.viewholder

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.travelapp.data.vos.ToursVO
import com.padcmyanmar.padcx.travelapp.delegates.ToursItemDelegate
import kotlinx.android.synthetic.main.item_country.view.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/20/2020.
 */
class CountryViewHolder(itemView: View,delegate: ToursItemDelegate) : BaseTravelViewHolder(itemView) {
    init{
        itemView.setOnClickListener {
            Log.d("M data is ",mData.toString())
            mData?.let {
                delegate.onTapToursItem(it.name)
            }
        }
    }

    override fun bindData(data: ToursVO) {
        mData = data
        Glide.with(itemView.context)
            .load(data.photos[0])
            .into(itemView.ivCountry)
        itemView.tvLocation.text = data.location
        itemView.tvMaxTour.text = data.averageRating.toString()
    }
}