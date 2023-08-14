package com.example.cheqanimationdesign.util

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.cheqanimationdesign.ui.EmptyClickedActivity

fun View.onClick(context: Context,destination:AppCompatActivity) {
    this.setOnClickListener { view ->
        context.startActivity(Intent(context, destination::class.java))
    }
}