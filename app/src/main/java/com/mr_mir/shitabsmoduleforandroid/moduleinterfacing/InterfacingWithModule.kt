package com.mr_mir.shitabsmoduleforandroid.moduleinterfacing

import android.content.Context
import com.mr_mir.uiuxdesign.moduleinterfacing.UXModuleInterface

/**
 * Created by Shitab Mir on 25,June,2020
 */
class InterfacingWithModule: UXModuleInterface {
    override fun connectToApp(context: Context, data: String) {
        //Do things using main app elements, receive command from module with the implemented interface
    }
}