package com.padcmyanmar.padcx.travelapp.views.viewholder

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_photos.view.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/20/2020.
 */
class PhotoViewHolder(itemView: View) : BaseViewHolder<String>(itemView) {

    override fun bindData(data: String) {
        Glide.with(itemView.context)
            .load(data)
            .into(itemView.ivTourPhoto)
    }
}