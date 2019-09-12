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
import com.garagecoders.movies.models.Movie

class AdapterMovies(private val context: Context, private val dataSource: ArrayList<Movie>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService( Context.LAYOUT_INFLATER_SERVICE ) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = inflater.inflate(R.layout.list_item_movie, parent, false)

        val id = rowView.findViewById<TextView>(R.id.id)
        id.text = dataSource[position].id.toString()

        val title = rowView.findViewById<TextView>(R.id.title)
        title.text = dataSource[position].title

        val subtitle = rowView.findViewById<TextView>(R.id.subtitle)
        subtitle.text = dataSource[position].subtitle

        val year = rowView.findViewById<TextView>(R.id.year)
        year.text = dataSource[position].year.toString()

        val description = rowView.findViewById<TextView>(R.id.description)
        description.text = dataSource[position].description

        if(position%2==0) {
            rowView.setBackgroundColor(Color.GRAY)
        }

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