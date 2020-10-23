package com.example.holidaysmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.lifecycle.Observer
import com.example.holidaysmvvm.holidayAdapter.HolidayAdapter
import com.example.holidaysmvvm.model.HolidayModel
import com.example.holidaysmvvm.viewmodel.HolidayViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var holidayAdapter: HolidayAdapter
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        holidayAdapter = HolidayAdapter(this)
        listView = findViewById(R.id.list_view)
        listView.adapter = holidayAdapter

        val holidayVM = HolidayViewModel()
        holidayVM.getHolidays().observe(this, object: Observer<List<HolidayModel>> {
            override fun onChanged(t: List<HolidayModel>?) {
                holidayAdapter.addData(t!!)
                holidayAdapter.notifyDataSetChanged()
            }
        })
    }
}