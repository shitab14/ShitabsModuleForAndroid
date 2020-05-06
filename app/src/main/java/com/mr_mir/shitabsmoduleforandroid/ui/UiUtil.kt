package com.mr_mir.shitabsmoduleforandroid.ui

import android.app.Activity
import android.os.Build
import android.view.WindowManager

/**
 * Created by Shitab Mir on 06,May,2020
 */
class UiUtil {
    companion object {

        fun setStatusBarColor(context: Activity, color: Int) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window = context.window
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = color
            }
        }

    }
}