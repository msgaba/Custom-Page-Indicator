package com.example.pageindicator.data

/**
 * Created by Ankita
 */
data class Item(
    var id: Int = 0,
    var type: Media = Media.IMAGE,
    var url: String = ""
)

val itemList: MutableList<Item> = arrayListOf(
    Item(0, Media.IMAGE, "https://picsum.photos/300/200.jpg"),
    Item(1, Media.IMAGE, "https://picsum.photos/500/300.jpg"),
    Item(2, Media.VIDEO, "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"),
    Item(3, Media.IMAGE, "https://picsum.photos/700/500.jpg"),
    Item(4, Media.VIDEO, "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"),
    Item(5, Media.IMAGE, "https://picsum.photos/900/700.jpg"),
)