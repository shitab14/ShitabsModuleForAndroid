package com.mr_mir.shitabsmoduleforandroid.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log

/**
 * Created by Shitab Mir on 26,March,2020
 */
class NetworkUtil {

    companion object {

        //INTERNET
        fun isNetworkConnected(context: Context): Boolean {
            //ADD ACCESS_NETWORK_STATE to the project Manifest

            val conMgr = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            // to get info of WIFI N/W :
            val wifi =  conMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI)

            // to get info of mobile N/W :
            val mobile = conMgr
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE)


            if (wifi.isAvailable && wifi.isConnected) {
                Log.e("Is Net work? 1", "isNetWork:in 'isNetWork_if' is N/W Connected:"
                        + NetworkInfo.State.CONNECTED)
                return true
            } else if (mobile != null && mobile.isAvailable && mobile.isConnected) {
                Log.e("Is Net work? 2", "isNetWork:in 'isNetWork_if' is N/W Connected:"
                        + NetworkInfo.State.CONNECTED)
                return true
            } else if (conMgr.activeNetworkInfo != null && conMgr.activeNetworkInfo.isAvailable
                && conMgr.activeNetworkInfo.isConnected) {
                Log.e("Is Net work? 3", "isNetWork:in 'isNetWork_if' is N/W Connected:"
                        + NetworkInfo.State.CONNECTED)
                return true
            }
            return false
        }

    }
}