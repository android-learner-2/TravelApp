package com.padcmyanmar.padcx.travelapp.data.models

import com.padcmyanmar.padcx.travelapp.network.ToursApi
import com.padcmyanmar.padcx.travelapp.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/21/2020.
 */
abstract class BaseModel {

    protected var mToursApi : ToursApi

    init {
        val mokHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mokHttpClient)
            .build()

        mToursApi = retrofit.create(ToursApi::class.java)
    }
}