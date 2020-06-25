package com.mr_mir.shitabsmoduleforandroid.activitycalls

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import java.io.Serializable

/**
 * Created by Shitab Mir on 30,March,2020
 */
class ActivityCallUtils {

    companion object {

        fun goToNextActivity(
            context: Context,
            targetActivity: Class<*>
        ) {
            val intent = Intent(context, targetActivity)
            context.startActivity(intent)
        }

        fun goToNextActivityWithBundle(
            context: Context,
            bundle: Bundle,
            targetActivity: Class<out Activity?>?
        ) {
            val intent = Intent(context, targetActivity)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }


        fun goToNextActivityWithId(
            context: Context,
            id: Int,
            targetActivity: Class<out Activity?>?
        ) {
            val `in` = Intent(context, targetActivity)
            `in`.putExtra("id", id)
            context.startActivity(`in`)
        }

        fun goToNextActivityWithSerialiazableObject(
            context: Context,
            `object`: Serializable,
            name: String,
            targetActivity: Class<out Activity?>?
        ) {
            val `in` = Intent(context, targetActivity)
            `in`.putExtra(name, `object`)
            context.startActivity(`in`)
        }

        fun goToNextActivityByClearingHistory(
            context: Context,
            targetActivity: Class<out Activity?>?
        ) {
            val `in` = Intent(context, targetActivity)
            `in`.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(`in`)
        }

        fun goToNextActivityWithBundleWithoutClearing(
            context: Context,
            bundle: Bundle?,
            targetActivity: Class<out Activity?>?
        ) {
            val `in` = Intent(context, targetActivity)
            `in`.putExtras(bundle!!)
            context.startActivity(`in`)
        }

        fun goToNextActivityWithBundleWithClearing(
            context: Context,
            bundle: Bundle?,
            targetActivity: Class<out Activity?>?
        ) {
            val `in` = Intent(context, targetActivity)
            `in`.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            `in`.putExtras(bundle!!)
            context.startActivity(`in`)
        }


        // GO TO PREVIOUS ACTIVITY
        fun goToPreviousActivity(
            context: Context,
            targetActivity: Class<out Activity?>?
        ) {
            (context as Activity).finish()
            val intent = Intent(context, targetActivity)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            context.startActivity(intent)
        }

        fun goToPreviousActivityWithBundle(
            context: Context,
            bundle: Bundle,
            targetActivity: Class<out Activity?>?
        ) {
            (context as Activity).finish()
            val intent = Intent(context, targetActivity)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            intent.putExtras(bundle)
            context.startActivity(intent)
        }

        //Share
        fun shareTextUrl(text: String, context: Context) {
            val share = Intent(Intent.ACTION_SEND)
            share.type = "text/plain"
            share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
            share.putExtra(Intent.EXTRA_TEXT, text)
            context.startActivity(Intent.createChooser(share, "Share $text"))
        }
    }
}