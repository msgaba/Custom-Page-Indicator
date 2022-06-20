package com.example.pageindicator.util

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE

/**
 * Created by Ankita
 */
/** key constants to be used throughout project **/

fun View.visibleOnCondition(isVisible: Boolean) {
    visibility = if (isVisible) VISIBLE
    else GONE
}