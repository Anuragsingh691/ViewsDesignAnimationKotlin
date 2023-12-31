package com.example.cheqanimationdesign.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.cheqanimationdesign.R
import com.example.cheqanimationdesign.databinding.ActivityMainBinding
import com.example.cheqanimationdesign.util.Utils
import com.example.cheqanimationdesign.util.onClick
import com.example.cheqanimationdesign.util.show
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

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
        animateViews()
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

        binding.bottomBar.rewardsIconLayout.onClick(this, ViewPressingActivity.newInstance())
    }

    private fun animateViews() {
        lifecycleScope.launch {
            async { animateDropDownViews() }.await()
            async { animateComplexViews() }.await()
            async {
                delay(1.seconds)
                binding.repaymentCard.totalDueAmountTxt.setValue(60000)
            }.await()
        }
    }

    private fun setStatusBarColor(context: Context, color: Int) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(context, color)
    }

    private fun animateDropDownViews() {
        val dropDownAnimation =
            AnimationUtils.loadAnimation(this@MainActivity, R.anim.combine_drop_down_fade_in)
        binding.welcomeTxt.startAnimation(dropDownAnimation)
        binding.toolBarCoinCard.startAnimation(dropDownAnimation)
        binding.profileIcToolbar.startAnimation(dropDownAnimation)
        binding.repaymentCard.root.startAnimation(dropDownAnimation)
        val translateUpAnimation =
            AnimationUtils.loadAnimation(this@MainActivity, R.anim.combine_translate_up_fade_in)
        binding.yourCreditScore.startAnimation(translateUpAnimation)
        binding.creditScoreCard.scoreCardRoot.startAnimation(translateUpAnimation)
        binding.actionRecommended.startAnimation(translateUpAnimation)
        binding.neverMissCard.startAnimation(translateUpAnimation)
        binding.bottomBar.root.startAnimation(translateUpAnimation)
    }

    private fun animateComplexViews() {
        binding.repaymentCard.totalDueLayout.show()
        val dropDownAnimation =
            AnimationUtils.loadAnimation(this@MainActivity, R.anim.combine_drop_down_fade_in)
        binding.repaymentCard.totalDueLayout.startAnimation(dropDownAnimation)
        val expandAnimation =
            AnimationUtils.loadAnimation(this@MainActivity, R.anim.combine_expand_x_fade_in)
        binding.repaymentCard.payUsingCheqBtn.root.show()
        binding.repaymentCard.payUsingCheqBtn.root.startAnimation(expandAnimation)
    }

}