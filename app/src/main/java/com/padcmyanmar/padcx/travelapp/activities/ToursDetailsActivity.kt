package com.padcmyanmar.padcx.travelapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.travelapp.R
import com.padcmyanmar.padcx.travelapp.adapters.PhotoListAdapter
import com.padcmyanmar.padcx.travelapp.adapters.ScoreReivewsAdapter
import com.padcmyanmar.padcx.travelapp.data.models.ToursModel
import com.padcmyanmar.padcx.travelapp.data.models.ToursModelImpl
import kotlinx.android.synthetic.main.activity_tours_details.*

class ToursDetailsActivity : BaseActivity() {
    private val mToursModel: ToursModel = ToursModelImpl(this)
    private lateinit var photoAdapter: PhotoListAdapter
    private lateinit var scoresReviewsAdapter: ScoreReivewsAdapter
    private lateinit var toursName : String

    companion object{
        const val IE_TOURS_NAME = "IE_TOURS_NAME"

        fun newIntent(context : Context, toursName : String ) : Intent {
            val intent = Intent(context,ToursDetailsActivity::class.java)
            intent.putExtra(IE_TOURS_NAME,toursName)
            Log.d("Tours Name",toursName)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setupRecyclerView()
        toursName = intent.getStringExtra(IE_TOURS_NAME)
        if(toursName!= null){
            bindData(toursName)
        }
    }

    private fun setupRecyclerView(){
        photoAdapter = PhotoListAdapter()
        val hLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvPhotos.layoutManager = hLayoutManager
        rvPhotos.adapter =  photoAdapter

        scoresReviewsAdapter = ScoreReivewsAdapter()
        rvScroeReview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvScroeReview.adapter = scoresReviewsAdapter
    }

    private fun bindData(name: String) {
        mToursModel.getToursByName(name)
            .observe(this,
                Observer {
                    tvName.text = it.name
                    tvDescription.text = it.description
                    //tvDetailsLocation.text = it.location
                    photoAdapter.setNewData(it.photos)
                    scoresReviewsAdapter.setNewData(it.scoresAndReviews)

                    /*Glide.with(this)
                        .load(it.photos[0])
                        .into(ivPhotosDetail)*/
            })
    }
}
