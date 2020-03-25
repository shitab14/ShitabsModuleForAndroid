package com.mr_mir.shitabsmoduleforandroid.dialogs

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable

/**
 * Created by Shitab Mir
 */

class DialogUtils {

    companion object {

        // Simple Dialog with No buttons
        fun showSimpleDialog(context: Context?, dialogLayout: Int?, cancelable: Boolean?, cancelableTouchOuside: Boolean? ) {
            val myDialog: Dialog = Dialog(context!!)
            myDialog.setContentView(dialogLayout!!)
            myDialog.setCancelable(cancelable!!)
            myDialog.setCanceledOnTouchOutside(cancelableTouchOuside!!)

            myDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.show()
        }

    }
}