package com.example.cheqanimationdesign

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import com.example.cheqanimationdesign.databinding.ActivityMainBinding
import com.robinhood.ticker.TickerUtils

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        setStatusBarColor(this,R.color.white)
    }

    private fun resizeTextView() {
        val scaleAnimation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.expand_x)
        binding.txtView.startAnimation(scaleAnimation)
    }

    private fun setStatusBarColor(context: Context, color: Int) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(context, color)
    }
}