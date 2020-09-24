package com.mcssoft.racedayreminder.utility

import androidx.activity.OnBackPressedCallback

class BackPressCB() : OnBackPressedCallback(true) {

    override fun handleOnBackPressed() {
        // do nothing
//        Log.d("tag","BackPressCB.handleOnBackPressed")
    }

    fun removeCallback() {
        super.remove()
//        Log.d("tag","BackPressCB.removeCallback")
    }
}