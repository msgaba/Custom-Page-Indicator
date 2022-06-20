package com.example.pageindicator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.pageindicator.data.itemList
import com.example.pageindicator.databinding.ActivityMainBinding
import com.example.pageindicator.util.visibleOnCondition

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewPagerSetup()
    }

    private fun viewPagerSetup() {
        mAdapter = ViewPagerAdapter(this, itemList)
        binding.apply {
            viewpager.adapter = mAdapter
            viewpager.addOnPageChangeListener(object : OnPageChangeListener {
                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

                override fun onPageSelected(position: Int) {
                    mAdapter.pause(position)
                }

                override fun onPageScrollStateChanged(state: Int) {}
            })
            indicator.bind(this@MainActivity, binding.viewpager, itemList)
            indicator.visibleOnCondition(itemList.size > 1)
        }
    }
}