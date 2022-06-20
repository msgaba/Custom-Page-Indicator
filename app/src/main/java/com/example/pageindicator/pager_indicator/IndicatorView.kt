package com.example.pageindicator.pager_indicator

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.pageindicator.data.Item
import com.example.pageindicator.data.Media
import com.example.pageindicator.databinding.ViewIndicatorBinding

class IndicatorView : ConstraintLayout {

    private var binding: ViewIndicatorBinding =
        ViewIndicatorBinding.inflate(LayoutInflater.from(context), this, true)

    private var mViewPager: ViewPager? = null
    private var mItemList: List<Any> = listOf()
    private lateinit var mAdapter: IndicatorAdapter
    private lateinit var mLayoutManager: LinearLayoutManager
    private var mContext: Context? = null

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    fun bind(activity: Activity, viewPager: ViewPager, itemList: List<Item>) {
        this.mContext = activity
        this.mViewPager = viewPager
        this.mItemList = itemList
        initSetup()
        listenerSetup()
    }

    private fun initSetup() {
        mAdapter = IndicatorAdapter(mContext as Activity)
        mLayoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        binding.list.apply {
            layoutManager = mLayoutManager
            adapter = mAdapter
        }
        mAdapter.list(mediaList())
    }

    private fun listenerSetup() {
        mViewPager?.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                mAdapter.selectedPos(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun mediaList(): MutableList<Media> {
        val mMediaList: MutableList<Media> = mutableListOf()
        mItemList.forEach {
            mMediaList.add((it as Item).type)
        }
        return mMediaList
    }
}