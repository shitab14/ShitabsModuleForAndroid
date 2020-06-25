package com.mr_mir.shitabsmoduleforandroid.moduleinterfacing

import android.content.Context
import android.content.Intent
import com.mr_mir.uiuxdesign.activity.MainUIActivity
import com.mr_mir.uiuxdesign.moduleinterfacing.UXModuleInterface

/**
 * Created by Shitab Mir on 25,June,2020
 */
object Navigator {

    fun goToUXModule(context: Context) {
        val inter: UXModuleInterface = InterfacingWithModule()

        val intent = Intent(context, MainUIActivity::class.java)
        context.startActivity(intent)
    }

}