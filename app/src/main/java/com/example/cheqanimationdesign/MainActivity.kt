package com.example.cheqanimationdesign

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import com.example.cheqanimationdesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        resizeTextView()
        setStatusBarColor(this, R.color.home_top_bg_color)
    }

    private fun resizeTextView() {
        val scaleAnimation =
            AnimationUtils.loadAnimation(this@MainActivity, R.anim.drop_down_animation)
        binding.welcomeTxt.startAnimation(scaleAnimation)
        binding.coinBar.startAnimation(scaleAnimation)
        binding.profileIcToolbar.startAnimation(scaleAnimation)
    }

    private fun setStatusBarColor(context: Context, color: Int) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(context, color)
    }
}