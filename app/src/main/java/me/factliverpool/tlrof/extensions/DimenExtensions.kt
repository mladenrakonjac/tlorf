package me.factliverpool.tlrof.extensions

import android.content.res.Resources

/**
 * Created by mladenrakonjac on 05/12/2017.
 */
val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()