package com.mr_mir.shitabsmoduleforandroid.dialogs

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.DatePicker
import java.util.*

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

        fun openDatePicker(clickView: View, context: Context){

            clickView.setOnClickListener(View.OnClickListener {
                val c = Calendar.getInstance()
                val mYear = c[Calendar.YEAR]
                val mMonth = c[Calendar.MONTH]
                val mDay = c[Calendar.DAY_OF_MONTH]

                var date: String? = null
                val mDatePicker =
                    DatePickerDialog(context,
                        DatePickerDialog.OnDateSetListener { datePicker: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int
                            ->
                            val month = monthOfYear + 1
                            date =  "$year-$month-$dayOfMonth"
                        }, mYear, mMonth, mDay)
                mDatePicker.setTitle(null)
                mDatePicker.datePicker.maxDate = Calendar.getInstance().timeInMillis
                mDatePicker.show()
            })

        }

    }
}