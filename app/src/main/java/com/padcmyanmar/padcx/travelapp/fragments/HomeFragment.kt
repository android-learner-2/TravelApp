package com.padcmyanmar.padcx.travelapp.fragments


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.padcx.travelapp.R
import com.padcmyanmar.padcx.travelapp.activities.ToursDetailsActivity
import com.padcmyanmar.padcx.travelapp.adapters.CountryListAdapter
import com.padcmyanmar.padcx.travelapp.adapters.ToursListAdapter
import com.padcmyanmar.padcx.travelapp.data.models.ToursModel
import com.padcmyanmar.padcx.travelapp.data.models.ToursModelImpl
import com.padcmyanmar.padcx.travelapp.delegates.ToursItemDelegate
import com.padcmyanmar.padcx.travelapp.views.viewpods.EmptyViewPod
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.fragment_home.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment(), ToursItemDelegate{
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var tourAdapter: ToursListAdapter
    private lateinit var countryAdapter: CountryListAdapter
    private lateinit var mToursModel : ToursModel
    private lateinit var viewPodEmpty : EmptyViewPod
    private val compositeDisposable : CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mToursModel = ToursModelImpl(requireContext())
        setupViewPod()
        setupSwipeRefresh()
        hideEmptyView()
        setupRecyclerView()
        requestData()
    }

    private fun setupSwipeRefresh(){
        swipeRefreshLayout.setOnRefreshListener {
            requestData()
        }
    }

    @SuppressLint("CheckResult")
    private fun requestData(){
        /*  swipeRefreshLayout.isRefreshing = true
         mToursModel.getAllTours(onError = {
                 swipeRefreshLayout.isRefreshing = false
             }).observeOn(AndroidSchedulers.mainThread())
                 .subscribe({
                 swipeRefreshLayout.isRefreshing = false
                 if(it.countries.isNotEmpty() && it.tours.isNotEmpty()){
                     countryAdapter.setNewData(it.countries.toMutableList())
                     tourAdapter.setNewData(it.tours.toMutableList())
                 }else{
                     Log.d("Something wrong","Array List is empty")
                 }
             },{
                 swipeRefreshLayout.isRefreshing = false
                 Log.d("Country Error",it.localizedMessage)
             })
                 .addTo(compositeDisposable)*/

        // data take from database
        swipeRefreshLayout.isRefreshing = true
         mToursModel.getAllToursOffline()
             .observe(this,
                 Observer {
                     swipeRefreshLayout.isRefreshing = false
                     tourAdapter.setNewData(it.toMutableList())
                 })

        mToursModel.getAllCountriesOffline()
            .observe(this,
                Observer {
                    swipeRefreshLayout.isRefreshing = false
                    countryAdapter.setNewData(it.toMutableList())
                })
}

    private fun setupRecyclerView(){
        countryAdapter = CountryListAdapter(this)
        val hLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        rvCountry.layoutManager = hLayoutManager
        rvCountry.adapter =  countryAdapter

        tourAdapter = ToursListAdapter(this)
        rvTour.layoutManager = LinearLayoutManager(activity)
        rvTour.adapter = tourAdapter
    }

    private fun showEmptyView(){
        vpEmpty.visibility = View.VISIBLE
    }

    private fun hideEmptyView(){
        vpEmpty.visibility = View.GONE
    }

    private fun setupViewPod(){
        viewPodEmpty = vpEmpty as EmptyViewPod
        viewPodEmpty.setEmptyData(
            "There are no tours available",
            "https://icons8.com/icon/46107/empty-box")
    }

    override fun onTapToursItem(toursName: String) {
        startActivity(ToursDetailsActivity.newIntent(requireContext(),toursName))
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}
