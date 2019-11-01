package com.example.cartonlist

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.graphics.ColorUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.*;
import com.example.cartonlogintest.R

/**
 * Created by witchel on 1/29/18.
 */

class ColorAdapter(private val mContext: Context) : RecyclerView.Adapter<ColorAdapter.ViewHolder>() {
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // XXX Write me
        private var mTextView = v
        init {
            v.setOnClickListener{
                swapItem(adapterPosition)
            }
        }
        fun bind(colorName: ColorDict.ColorName) {
            // XXX Write me
            var luminance = getLuminance(colorName.color)
            val displayText = String.format("%s %1.2f", colorName.name, luminance)
            val theTextView = mTextView.findViewById<TextView>(R.id.tv)
            theTextView.text = displayText
            theTextView.setBackgroundColor(colorName.color)
            theTextView.setTextColor(Color.WHITE)
            if (luminance >= .3) {
                theTextView.setTextColor(Color.BLACK)
            }
        }
    }

    override fun getItemCount(): Int {
        return ColorDict.size()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorAdapter.ViewHolder {
        // Create a new View
        val v = LayoutInflater.from(mContext).inflate(R.layout.list_card, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(ColorDict.get(position))
    }

    fun swapItem(position: Int) {
        val swappedPosition = ColorDict.randomSwap(position)
        notifyItemChanged(position)
        notifyItemChanged(swappedPosition)
    }

    companion object {
        fun getLuminance(color: Int): Float {
            val red = Color.red(color)
            val green = Color.green(color)
            val blue = Color.blue(color)

            val hsl = FloatArray(3)
            ColorUtils.RGBToHSL(red, green, blue, hsl)
            return hsl[2]
        }
    }
}