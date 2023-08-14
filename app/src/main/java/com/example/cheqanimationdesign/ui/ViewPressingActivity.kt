package com.example.cheqanimationdesign.ui

import android.content.Context
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
    }

    private fun setStatusBarColor(context: Context, color: Int) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(context, color)
    }
}