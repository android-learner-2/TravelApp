package com.padcmyanmar.padcx.travelapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padcx.travelapp.R
import com.padcmyanmar.padcx.travelapp.data.vos.ToursVO
import com.padcmyanmar.padcx.travelapp.delegates.ToursItemDelegate
import com.padcmyanmar.padcx.travelapp.views.viewholder.BaseTravelViewHolder
import com.padcmyanmar.padcx.travelapp.views.viewholder.CountryViewHolder

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/20/2020.
 */
class CountryListAdapter(delegate: ToursItemDelegate) : BaseRecyclerAdapter<BaseTravelViewHolder,ToursVO>() {
    val mDelegate : ToursItemDelegate =delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseTravelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country,parent,false)
        return CountryViewHolder(view,mDelegate)
    }
}