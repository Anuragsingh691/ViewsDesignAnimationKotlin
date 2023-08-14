package com.example.cheqanimationdesign.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cheqanimationdesign.BrandAdapter
import com.example.cheqanimationdesign.R
import com.example.cheqanimationdesign.util.SpacesItemDecoration
import com.example.cheqanimationdesign.databinding.ActivityViewPressingBinding
import com.example.cheqanimationdesign.util.Utils
import com.example.cheqanimationdesign.util.onClick

class ViewPressingActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewPressingBinding
    private val adapter = BrandAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPressingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        setStatusBarColor(this, R.color.home_top_bg_color)
        setViews()
    }

    private fun setViews() {
        binding.dealsRvLayout.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.dealsRvLayout.recyclerView.adapter = adapter
        binding.dealsRvLayout.recyclerView.addItemDecoration(
            SpacesItemDecoration(10)
        )
        adapter.updateData(Utils.getBrandsFeaturedDealList())

        binding.otherDealsRvLayout.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.otherDealsRvLayout.recyclerView.adapter = adapter
        binding.otherDealsRvLayout.recyclerView.addItemDecoration(
            SpacesItemDecoration(10)
        )
        binding.bottomBar.homeIcon.setOnClickListener { view ->
            onBackPressed()
        }
        binding.chipCard.root.onClick(this, EmptyClickedActivity.newInstance())
        binding.voucherCard.root.onClick(this, EmptyClickedActivity.newInstance())
        binding.instantCashCard.root.onClick(this, EmptyClickedActivity.newInstance())
        binding.icFoodImg.onClick(this, EmptyClickedActivity.newInstance())
        binding.icTravelImg.onClick(this, EmptyClickedActivity.newInstance())
        binding.icShoppingImg.onClick(this, EmptyClickedActivity.newInstance())
        binding.icSeeAllImg.onClick(this, EmptyClickedActivity.newInstance())
    }

    private fun setStatusBarColor(context: Context, color: Int) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(context, color)
    }

    companion object {
        fun newInstance() = ViewPressingActivity()
    }
}