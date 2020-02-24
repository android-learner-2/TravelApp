package com.padcmyanmar.padcx.travelapp.data.models

import android.content.Context
import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.travelapp.data.vos.ToursAndCountryVO
import com.padcmyanmar.padcx.travelapp.data.vos.ToursVO
import com.padcmyanmar.padcx.travelapp.persistence.db.ToursDB
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/21/2020.
 */
class ToursModelImpl(var context: Context) : ToursModel,BaseModel() {
    private val mDB : ToursDB = ToursDB.getDBInstance(context)

    override fun getToursByName(toursName: String): LiveData<ToursVO> {
        return mDB.toursDao().getToursByName(toursName)
    }

    override fun getAllTours(onError: (String) -> Unit): Observable<ToursAndCountryVO> {
        return Observable.zip<List<ToursVO>, List<ToursVO>, ToursAndCountryVO>(
            getCountries(),
            getTours(),
            BiFunction { countries, tours ->
                return@BiFunction ToursAndCountryVO(
                    countries,tours
                )
            }
        )
            .doOnNext {
                val countriesList  = it.countries
                it.tours.forEach {data ->
                    data.status = 1
                }
                mDB.toursDao().insertAllTours(countriesList)
                mDB.toursDao().insertAllTours(it.tours)
            }
            .subscribeOn(Schedulers.io())
    }

    private fun getTours() : Observable<List<ToursVO>>{
        return mToursApi.getAllCountries()
            .map { it.data }
            .onErrorResumeNext(Observable.just(arrayListOf())) // data null from API >> set empty arraylist
            .subscribeOn(Schedulers.io())
    }

    private fun getCountries(): Observable<List<ToursVO>> {
        return mToursApi.getAllTours()
            .map { it.data }
            .onErrorResumeNext(Observable.just(arrayListOf()))
            .subscribeOn(Schedulers.io())
    }

    override fun getAllToursOffline(): LiveData<List<ToursVO>> {
        return mDB.toursDao().getAllPopularTours()
    }

    override fun getAllCountriesOffline(): LiveData<List<ToursVO>> {
        return mDB.toursDao().getAllCountries()
    }
}