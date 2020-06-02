package com.mr_mir.shitabsmoduleforandroid.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Build
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.view.View
import android.view.WindowManager
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable

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

        fun setBackgroundDrawable(view: View, drawable: Int, context: Context) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                view.background = getDrawable(context, drawable)
            } else {
                view.setBackgroundResource(drawable)
            }
        }

        fun scrollDownToBottom(scrollView: ScrollView) {
            scrollView.post {
                scrollView.fullScroll(View.FOCUS_DOWN)
            }
        }


        @SuppressLint("DefaultLocale")
        fun setHighLightedText(textView: TextView, textToHighlight: String) {

            val tth: String = textToHighlight.toLowerCase()

            val tvt = textView.text.toString().toLowerCase()
            var ofe = tvt.indexOf(tth, 0)
            val wordToSpan = SpannableString(textView.text)
            var ofs = 0
            while (ofs < tvt.length && ofe != -1) {
                ofe = tvt.indexOf(tth, ofs)
                if (ofe == -1)
                    break
                else {
                    // set color here
                    //wordToSpan.setSpan(BackgroundColorSpan(context.resources.getColor(R.color.contact_highlight_color)), ofe, ofe + textToHighlight.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    wordToSpan.setSpan(BackgroundColorSpan(-0x86c03f), ofe, ofe + textToHighlight.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    textView.setText(wordToSpan, TextView.BufferType.SPANNABLE)
                }
                ofs = ofe + 1
            }

        }

    }
}