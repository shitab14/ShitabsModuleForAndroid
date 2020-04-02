package com.mr_mir.shitabsmoduleforandroid.activitycalls

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

/**
 * Created by Shitab Mir on 30,March,2020
 */
class ActivityCallUtils {

    companion object {

        fun goToNextActivity(
            context: Context,
            targetActivity: Class<out Activity?>?
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
    }
}