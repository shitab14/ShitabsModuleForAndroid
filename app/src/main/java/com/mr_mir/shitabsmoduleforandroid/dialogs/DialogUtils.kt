package com.mr_mir.shitabsmoduleforandroid.dialogs

import android.Manifest
import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.ProgressDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.pm.PackageManager
import android.content.pm.PackageManager.NameNotFoundException
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.drawable.ColorDrawable
import android.media.ExifInterface
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.text.Spannable
import android.text.SpannableString
import android.text.TextUtils
import android.text.format.DateUtils
import android.text.style.ForegroundColorSpan
import android.util.DisplayMetrics
import android.util.Log
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.mr_mir.shitabsmoduleforandroid.R
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.text.DateFormat
import java.text.DateFormatSymbols
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by Shitab Mir
 */

class DialogUtils {

    companion object {

        /*fun showNoInternetDialog(context: Context) {
            val myDialog = Dialog(context)
            val noInternetLayout: Int = R.layout.no_internet_connection_popup
            myDialog.setContentView(noInternetLayout)
            myDialog.setCancelable(false)
            myDialog.setCanceledOnTouchOutside(false)
            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.show()
            val tvTryInternetConnectionAgain =
                myDialog.findViewById<TextView>(R.id.noInternetConnection)
            tvTryInternetConnectionAgain.setOnClickListener {
                try {
                    myDialog.dismiss()
                    (context as Activity).finish()
                } catch (e: Exception) {
                    Log.e("ERROR: ", " $e")
                }
            }
        }*/

        // Simple Dialog with No buttons
        fun showSimpleDialog(context: Context?, dialogLayout: Int?, cancelable: Boolean?, cancelableTouchOuside: Boolean?, cancelViewId:Int? ) {
            try {
                val myDialog: Dialog = Dialog(context!!)
                myDialog.setContentView(dialogLayout!!)
                myDialog.setCancelable(cancelable!!)
                myDialog.setCanceledOnTouchOutside(cancelableTouchOuside!!)
                myDialog.findViewById<View>(cancelViewId!!)

                myDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                myDialog.show()
            } catch (e: java.lang.Exception) {
                Log.e("DialogUtil Error", ": Unable to show simple dialog")
            }
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

        fun showSnackbar(context: Context?, view: View, msg: String) {
            val bar: Snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG)
                .setAction("Cancel", View.OnClickListener { })
                .setActionTextColor(Color.WHITE)
            bar.show()
        }

        fun showLoadingDialog(context: Context?): ProgressDialog? {
            val progressDialog = ProgressDialog(context)
            progressDialog.setMessage("Loading...")
            progressDialog.isIndeterminate = true
            progressDialog.setCancelable(false)
            progressDialog.setCanceledOnTouchOutside(false)
            return progressDialog
        }

// Types of Dialogs
        /*
        val filterDialogFragment = SuggestionDialogFragment()
        //filterDialogFragment.show(activity!!.supportFragmentManager, "suggestion_dialog")

        /*val builder = AlertDialog.Builder(activity as Context)
        val inflater = LayoutInflater.from(activity as Context)
        val dialogView = inflater.inflate(R.layout.fragment_bottomsheet_suggestion_dialog, null)
        builder.setView(dialogView)
        builder.setCancelable(false)
        val dialog = builder.create()
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()*/

        val dialog= BottomSheetDialog(activity as Context);
        dialog.setContentView(R.layout.fragment_bottomsheet_suggestion_dialog)

        dialog.setCanceledOnTouchOutside(false)
        //dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        dialog.show()
         */

    }
}