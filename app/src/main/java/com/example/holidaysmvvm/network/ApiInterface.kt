package com.example.holidaysmvvm.network

import com.example.holidaysmvvm.model.HolidayModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("PublicHolidays/2020/br")
    fun getHolidays(): Call<List<HolidayModel>>


}