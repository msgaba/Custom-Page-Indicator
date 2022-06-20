package com.example.pageindicator.pager_indicator

import android.content.Context
import android.content.res.ColorStateList
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pageindicator.R
import com.example.pageindicator.data.Media
import com.example.pageindicator.databinding.ItemViewIndicatorBinding

class IndicatorViewHolder(private val viewBinding: ItemViewIndicatorBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

    var mSelectedPosition = -1
    var mCurrentPosition = -1

    fun bindData(context: Context, item: Media, pos: Int) {
        viewBinding.apply {
            if (item == Media.VIDEO) icon.setImageResource(R.drawable.ic_video)
            else icon.setImageResource(R.drawable.ic_image)
            icon.imageTintList = ColorStateList.valueOf(
                ContextCompat.getColor(
                    context,
                    if (mSelectedPosition == mCurrentPosition) R.color.red
                    else R.color.white
                )
            )
            val params = icon.layoutParams as ConstraintLayout.LayoutParams
            if (pos != 0) {
                params.setMargins(
                    context.resources.getDimensionPixelSize(R.dimen.dp_size_8),
                    0,
                    0,
                    0
                )
            }
            icon.layoutParams = params
        }
    }
}