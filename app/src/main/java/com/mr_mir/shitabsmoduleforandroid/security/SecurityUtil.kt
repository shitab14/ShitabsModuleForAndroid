package com.mr_mir.shitabsmoduleforandroid.security

import android.app.Activity
import android.content.Context
import android.view.WindowManager

/**
 * Created by Shitab Mir on 11,May,2020
 */
class SecurityUtil {
    companion object{
        fun disableScreenshot(context: Context) { // Call before setContentView()
            (context as Activity).window.setFlags(
                WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);
        }
    }
}