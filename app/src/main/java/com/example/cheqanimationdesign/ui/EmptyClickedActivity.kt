package com.example.cheqanimationdesign.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.example.cheqanimationdesign.R
import com.example.cheqanimationdesign.databinding.ActivityEmptyClickedBinding

class EmptyClickedActivity : AppCompatActivity() {
    lateinit var binding: ActivityEmptyClickedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmptyClickedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarColor(this, R.color.home_top_bg_color)
    }

    override fun onResume() {
        super.onResume()
        binding.icBack.setOnClickListener { view ->
            onBackPressed()
        }
    }

    private fun setStatusBarColor(context: Context, color: Int) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(context, color)
    }

    companion object {
        fun newInstance() = EmptyClickedActivity()
    }
}