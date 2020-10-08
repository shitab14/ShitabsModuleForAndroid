package com.mr_mir.uiuxdesign.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Shitab Mir on 27,July,2020
 */
data class PokeHomeOption (

    @field:SerializedName("image")
    val image: Int? = null,

    @field:SerializedName("name")
    val name: String? = null

)