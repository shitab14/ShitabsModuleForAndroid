package com.mr_mir.shitabsmoduleforandroid.input

import android.app.Activity
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager

/**
 * Created by Shitab Mir on 30,March,2020
 */
class InputUtils {

    companion object {
        fun hideSoftKeyboard(activity: Activity) {
            try {
                val inputMethodManager = activity.getSystemService(
                    Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(activity.currentFocus?.windowToken, 0)
                activity.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}

