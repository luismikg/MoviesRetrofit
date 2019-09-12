package com.garagecoders.movies.Adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.garagecoders.movies.R
import com.garagecoders.movies.models.Data

class AdapterCategory(private val context: Context, private val dataSource: ArrayList<Data>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService( Context.LAYOUT_INFLATER_SERVICE ) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = inflater.inflate(R.layout.list_item_category, parent, false)

        val txtCategory = rowView.findViewById<TextView>(R.id.id)
        txtCategory.text = dataSource[position].category

        rowView.setBackgroundColor( Color.parseColor(dataSource[position].color) )

        return rowView
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return dataSource[position].id*1.0.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }
}