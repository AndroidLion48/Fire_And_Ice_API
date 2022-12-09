package com.eaglewarrior.gameofthronesinfoapp.network

import com.eaglewarrior.gameofthronesinfoapp.repository.FireAndIceService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Clarence E Moore on 2022-10-16.
 *
 * Description:
 *
 *
 */
object NetworkLayer {

    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://thronesapi.com")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val fireAndIceService: FireAndIceService = retrofit.create(FireAndIceService::class.java)


    val apiClient = ApiClient(fireAndIceService)

}
