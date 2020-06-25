package com.mr_mir.uiuxdesign.moduleinterfacing

import android.content.Context
import java.io.Serializable

/**
 * Created by Shitab Mir on 25,June,2020
 */
interface UXModuleInterface: Serializable {

    fun connectToApp(context: Context, data: String)

}