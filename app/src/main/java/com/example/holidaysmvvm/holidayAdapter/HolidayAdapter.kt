package com.example.holidaysmvvm.holidayAdapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.holidaysmvvm.model.HolidayModel

class HolidayAdapter(
    private val context: Context): BaseAdapter() {
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    var holidayList: List<HolidayModel>

    init {
        holidayList = ArrayList()
    }

    fun addData(arrList: List<HolidayModel>){
        this.holidayList = arrList
    }

    override fun getCount(): Int {
        return holidayList.size
    }

    override fun getItem(position: Int): Any {
        return holidayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val cellView = inflater.inflate(android.R.layout.simple_list_item_2, parent, false)
        val holiday = getItem(position) as HolidayModel

        val title = cellView.findViewById<TextView>(android.R.id.text1)
        val subtitle = cellView.findViewById<TextView>(android.R.id.text2)

        title.text = holiday.name
        subtitle.text = holiday.date

        return cellView
    }
}