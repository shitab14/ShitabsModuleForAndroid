package com.mr_mir.shitabsmoduleforandroid.view

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mr_mir.shitabsmoduleforandroid.R

/**
 * Created by Shitab Mir on 04,May,2020
 */
class BottomSheetDialogFragment: BottomSheetDialogFragment() {
    private var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.bottomsheet_dialog_01, container, false)
        initClickListeners()
        return rootView
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
    }

    private fun initClickListeners() {

    }

}