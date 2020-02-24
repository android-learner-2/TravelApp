package com.padcmyanmar.padcx.travelapp.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.empty_view_pod.view.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/20/2020.
 */
class EmptyViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setEmptyData(emptyMessage  :String, emptyImage: String){
        tvEmpty.text = emptyMessage
        Glide.with(context)
            .load(emptyImage)
            .into(ivEmptyImage)
    }
}