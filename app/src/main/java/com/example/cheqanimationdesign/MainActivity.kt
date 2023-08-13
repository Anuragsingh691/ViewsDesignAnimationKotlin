package com.example.cheqanimationdesign

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.appcompat.content.res.AppCompatResources
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
        setStatusBarColor(this, R.color.home_top_bg_color)
        setViews()
        //resizeTextView()
    }

    private fun setViews() {

        // Axis card
        binding.repaymentCard.icAxis.bankImg.setImageDrawable(
            AppCompatResources.getDrawable(
                this,
                R.drawable.ic_axis
            )
        )
        binding.repaymentCard.icAxis.axisHeadlineTxt.text = getString(R.string.axis_platinum_title)
        binding.repaymentCard.icAxis.axisDescTxt.text = getString(R.string.credit_card_text)
        binding.repaymentCard.icAxis.axisAmountHeadlineTxt.text =
            getString(R.string.axis_due_amount)
        binding.repaymentCard.icAxis.axisAmountOverdueTxt.text =
            getString(R.string.overdue_by_1_day)

        // Sbi card
        binding.repaymentCard.icSbi.bankImg.setImageDrawable(
            AppCompatResources.getDrawable(
                this,
                R.drawable.ic_sbi
            )
        )
        binding.repaymentCard.icSbi.axisHeadlineTxt.text = getString(R.string.sbi_simply_title)
        binding.repaymentCard.icSbi.axisDescTxt.text = getString(R.string.credit_card_text)
        binding.repaymentCard.icSbi.axisAmountHeadlineTxt.text = getString(R.string.axis_due_amount)
        binding.repaymentCard.icSbi.axisAmountOverdueTxt.text = getString(R.string.due_in_3_days)

        // BOB card
        binding.repaymentCard.icBob.bankImg.setImageDrawable(
            AppCompatResources.getDrawable(
                this,
                R.drawable.ic_bob
            )
        )
        binding.repaymentCard.icBob.axisHeadlineTxt.text = getString(R.string.bob_credit_title)
        binding.repaymentCard.icBob.axisDescTxt.text = getString(R.string.credit_card_text)
        binding.repaymentCard.icBob.noBillTxt.visibility = View.VISIBLE
        binding.repaymentCard.icBob.noBillTxt.text = getString(R.string.no_bill_found)
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