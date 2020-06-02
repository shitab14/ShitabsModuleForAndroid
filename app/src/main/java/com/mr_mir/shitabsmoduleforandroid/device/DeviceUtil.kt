package com.mr_mir.shitabsmoduleforandroid.device

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.browser.customtabs.CustomTabsIntent
import saschpe.android.customtabs.CustomTabsHelper
import saschpe.android.customtabs.WebViewFallback


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

        private const val SERVICE_ACTION = "android.support.customtabs.action.CustomTabsService"
        private const val CHROME_PACKAGE = "com.android.chrome"

        private fun isChromeCustomTabsSupported(context: Context): Boolean {
            val serviceIntent = Intent(SERVICE_ACTION)
            serviceIntent.setPackage(CHROME_PACKAGE)
            val resolveInfo =
                context.packageManager.queryIntentServices(serviceIntent, 0)
            return resolveInfo.isNotEmpty()
        }
        fun openUrlInCustomTab(context: Context?, url: String?) {
            try {
                val customTabsIntent: CustomTabsIntent = CustomTabsIntent.Builder()
                    .addDefaultShareMenuItem()
                    .setToolbarColor(Color.WHITE)
                    .setShowTitle(true)
                    .build()
                CustomTabsHelper.addKeepAliveExtra(context, customTabsIntent.intent)
                CustomTabsHelper.openCustomTab(
                    context, customTabsIntent,
                    Uri.parse(url), WebViewFallback()
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun openUrlInBrowser(context: Context, link: String?) {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(link)
            context.startActivity(openURL)
        }

    }
}