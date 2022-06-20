package com.example.pageindicator

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.pageindicator.data.Item
import com.example.pageindicator.data.Media
import com.example.pageindicator.util.visibleOnCondition
import java.util.*

class ViewPagerAdapter(var context: Context, private var itemList: List<Item>) :
    PagerAdapter() {

    private var mLayoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private lateinit var videoView: VideoView
    private lateinit var mediaController: MediaController

    override fun getCount(): Int {
        return itemList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false)
        val imageView = itemView.findViewById<ImageView>(R.id.image)
        videoView = itemView.findViewById(R.id.video_player)
        mediaController = MediaController(context)
        imageView.visibleOnCondition(itemList[position].type == Media.IMAGE)
        videoView.visibleOnCondition(itemList[position].type == Media.VIDEO)
        if (itemList[position].type == Media.VIDEO) mediaController.show()
        else mediaController.hide()
        Objects.requireNonNull(container).addView(itemView)
        if (itemList[position].type == Media.VIDEO) {
            val uri: Uri = Uri.parse(itemList[position].url)
            videoView.setVideoURI(uri)
            videoView.setMediaController(mediaController)
        } else {
            Glide.with(context)
                .asBitmap()
                .load(itemList[position].url)
                .into(imageView)
        }
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    fun pause(pos: Int) {
        videoView.pause()
        if(itemList[pos].type == Media.IMAGE) mediaController.visibility = GONE
        else mediaController.visibility = VISIBLE
    }

}