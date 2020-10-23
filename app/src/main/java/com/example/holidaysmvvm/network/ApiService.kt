package com.example.holidaysmvvm.network

import com.example.holidaysmvvm.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class ApiService {
    companion object {
        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.baseUrl())
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }
}