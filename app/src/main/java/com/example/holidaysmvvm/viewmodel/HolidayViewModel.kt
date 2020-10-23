package com.example.holidaysmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.holidaysmvvm.model.HolidayModel
import com.example.holidaysmvvm.repository.HolidayRepository

class HolidayViewModel {
    var holidayRepo: HolidayRepository? = null
    var mutableLiveData: MutableLiveData<List<HolidayModel>>? = null

    init {
        holidayRepo = HolidayRepository()
    }

    fun getHolidays(): LiveData<List<HolidayModel>> {
        if (mutableLiveData == null) {
            mutableLiveData = holidayRepo!!.fetchHolidays()
        }

        return mutableLiveData!!
    }
}