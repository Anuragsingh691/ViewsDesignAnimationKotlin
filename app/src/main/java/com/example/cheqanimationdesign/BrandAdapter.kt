package com.example.cheqanimationdesign

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cheqanimationdesign.ui.EmptyClickedActivity
import com.example.cheqanimationdesign.util.onClick


class BrandAdapter() : RecyclerView.Adapter<BrandAdapter.ViewHolder>() {
    private var dataList: List<BrandsData> = emptyList()

    fun updateData(newList: List<BrandsData>) {
        dataList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.deal_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.brandCard.setBackgroundResource(data.bgColor)
        holder.productTitle.text = holder.productCoinBarText.context.getString(data.offerText)
        Glide.with(holder.productImage.context)
            .load(data.merchandiseIcon)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.productImage);
        Glide.with(holder.brandItemImg.context)
            .load(data.brandFoodImage)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.brandItemImg);
        holder.productCoinBarText.text =
            holder.productCoinBarText.context.getString(data.coinExchangeValue)
        holder.itemView.onClick(holder.itemView.context, EmptyClickedActivity.newInstance())
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.brand_logo)
        val productTitle: TextView = itemView.findViewById(R.id.one_k_txt)
        val productCoinBarText: TextView = itemView.findViewById(R.id.coin_bar_txt)
        val brandItemImg: ImageView = itemView.findViewById(R.id.brand_item_img)
        val brandCard: ConstraintLayout = itemView.findViewById(R.id.deal_item_root)
    }
}