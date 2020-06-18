package com.mr_mir.shitabsmoduleforandroid.input

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.text.NumberFormat
import java.util.*

/**
 * Created by Shitab Mir on 30,March,2020
 */
class InputUtils {

    companion object {

        fun doAfterDelay() {
            /*Handler().postDelayed({
                //Do something after 100ms
            }, 100)*/
        }

        fun isKeyboardShown(activity: Activity): Boolean {
            val imm =
                activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            return imm.isAcceptingText
        }

        fun showKeyboard(context: Context) {
            (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).toggleSoftInput(
                InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY
            )
        }

        fun hideKeyboard(activity: Activity) {
            val imm =
                activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            var view = activity.currentFocus
            if (view == null) {
                view = View(activity)
            }
            imm.hideSoftInputFromWindow(view.windowToken, 0)
//            activity.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
//            activity.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
//            activity.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
        }

        //Update Language
        fun updateLaguageDefault(context: Context, language: String?): Boolean {
            val locale = Locale(language)
            Locale.setDefault(locale)
            val resources = context.resources
            val configuration = resources.configuration
            configuration.locale = locale
            resources.updateConfiguration(configuration, resources.displayMetrics)
            return true
        }


        fun getEnglishUSLocale(): Locale? {
            return Locale("en", "US")
        }

        //Copies Text to Clipboard
        fun textCopy(
            context: Context,
            text: String?,
            textLabel: String?,
            toast: String?
        ) {
            val clipboard =
                context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText(textLabel, text)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(context, toast, Toast.LENGTH_SHORT).show()
        }

        fun currencyFormatterWithPoint(balance: String?): String? {
            return if (balance != null && !balance.trim { it <= ' ' }
                    .isEmpty() && balance.toDouble() != 0.0
            ) {
                val amount = balance.toDouble()
                val numberFormat =
                    NumberFormat.getCurrencyInstance(getEnglishUSLocale())
                var localeValue = numberFormat.format(amount)
                localeValue = localeValue.replace("-", "")

                localeValue
            } else {
                "০.০০"
            }
        }

        fun encodeToJSONString(obj: Any): String? {
            val gson = Gson()
            return gson.toJson(obj)
        }

        fun decodeFromJSONString(s: String?): Any {
            val gson = Gson()
            val type: Type = object : TypeToken<Any?>() {}.type
            return gson.fromJson(s, type)
        }

    }

}

