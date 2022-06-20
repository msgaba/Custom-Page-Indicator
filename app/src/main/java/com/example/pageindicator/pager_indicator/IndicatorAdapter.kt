package com.example.pageindicator.pager_indicator

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pageindicator.data.Media
import com.example.pageindicator.databinding.ItemViewIndicatorBinding

class IndicatorAdapter(private val mContext: Activity) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var selectedPosition = 0
    private var mItemList: MutableList<Media> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemViewIndicatorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IndicatorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val indicatorViewHolder: IndicatorViewHolder = holder as IndicatorViewHolder
        indicatorViewHolder.mSelectedPosition = selectedPosition
        indicatorViewHolder.mCurrentPosition = position
        indicatorViewHolder.bindData(mContext, mItemList[position], position)
    }

    override fun getItemCount(): Int = mItemList.size

    fun list(itemList: MutableList<Media>) {
        mItemList = itemList
        notifyDataSetChanged()
    }

    fun selectedPos(pos: Int) {
        selectedPosition = pos
        notifyDataSetChanged()
    }
}