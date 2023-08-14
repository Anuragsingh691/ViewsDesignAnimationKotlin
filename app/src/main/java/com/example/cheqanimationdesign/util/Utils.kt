package com.example.cheqanimationdesign.util

import android.animation.ValueAnimator
import android.widget.TextView
import com.example.cheqanimationdesign.BrandsData
import com.example.cheqanimationdesign.R


object Utils {

    fun getBrandsFeaturedDealList(): List<BrandsData> {
        val swiggyData = BrandsData(
            R.drawable.ic_swiggy,
            R.string.one_k,
            R.string.deals_coin_text,
            R.drawable.item_swiggy,
            R.color.swiggy_bg_color
        )
        val subwayData = BrandsData(
            R.drawable.ic_subway,
            R.string.one_fifty,
            R.string.deals_coin_text,
            R.drawable.subway_item,
            R.color.subway_bg_color
        )
        val swiggyData2 = BrandsData(
            R.drawable.ic_swiggy,
            R.string.one_k,
            R.string.deals_coin_text,
            R.drawable.item_swiggy,
            R.color.swiggy_bg_color
        )
        val subwayData2 = BrandsData(
            R.drawable.ic_subway,
            R.string.one_fifty,
            R.string.deals_coin_text,
            R.drawable.subway_item,
            R.color.subway_bg_color
        )
        val brandsList: ArrayList<BrandsData> = arrayListOf()
        brandsList.add(swiggyData)
        brandsList.add(subwayData)
        brandsList.add(swiggyData2)
        brandsList.add(subwayData2)
        return brandsList.toList()
    }

    fun startCountAnimation(textView: TextView) {
        val animator = ValueAnimator.ofInt(5000, 6000) //0 is min number, 600 is max number
        animator.duration = 6000 //Duration is in milliseconds
        val rupessSymbol = textView.context.getString(R.string.rupees)
        animator.addUpdateListener { animation -> textView.setText(rupessSymbol + animation.animatedValue.toString()) }
        animator.start()
    }
}