package com.example.cartonlist

import com.example.cartonlogintest.R
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class SimpleAdapter(context: Context) : ArrayAdapter<ColorDict.ColorName>(context, R.layout.row) {
    private var theInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Write me
        var returnView = convertView ?: theInflater.inflate(R.layout.row, parent, false)
        return bindView(position, returnView)
    }

    private fun bindView(position: Int, theView: View): View {

        val nameAndColor = getItem(position)
        if(nameAndColor == null) {
            Log.d(javaClass.simpleName, "Position ${position} is null!")
            return theView
        }
        val theTextView = theView.findViewById<TextView>(R.id.text)
        theTextView.text = nameAndColor.name;
        theTextView.setBackgroundColor(nameAndColor.color)
        return theView
    }

    fun moveToTop(position: Int) {
        val colorName = getItem(position)
        remove(colorName)
        insert(colorName, 0)
        notifyDataSetChanged()
    }
}
