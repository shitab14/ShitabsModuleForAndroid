package com.mr_mir.shitabsmoduleforandroid.device

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * Created by Shitab Mir on 06,May,2020
 */
class DeviceUtil {

    companion object {

        //Check if app is installed
        fun isAppInstalled(context: Context, packageName: String): Boolean {
            return try {
                context.packageManager.getApplicationInfo(packageName, 0)
                true
            } catch (e: PackageManager.NameNotFoundException) {
                false
            }
        }

        //Device Information
        fun getDeviceName(): String? {
            val manufacturer = Build.MANUFACTURER
            val model = Build.MODEL
            return if (model.toLowerCase().startsWith(manufacturer.toLowerCase())) {
                model
            } else {
                "$manufacturer $model"
            }
        }


        //Android Screen
        fun dpFromPx(context: Context, px: Int): Float {
            return px / context.resources.displayMetrics.density
        }

        fun getScreenWidth(context: Context): Int {
            val wm =
                context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = wm.defaultDisplay
            val metrics = DisplayMetrics()
            display.getMetrics(metrics)
            val width = metrics.widthPixels
            return dpFromPx(context, width / 2).toInt()
        }


    }
}