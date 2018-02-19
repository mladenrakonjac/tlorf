package me.factliverpool.tlrof.custom.base

import android.annotation.SuppressLint
import dagger.android.support.DaggerAppCompatActivity

@SuppressLint("Registered")
open
/**
 * Created by mladenrakonjac on 26/12/2017.
 */
class BaseActivity : DaggerAppCompatActivity() {

    var isBackButtonAllowed = true

    override fun onBackPressed() {
        if (isBackButtonAllowed) {
            super.onBackPressed()
        }
    }

}