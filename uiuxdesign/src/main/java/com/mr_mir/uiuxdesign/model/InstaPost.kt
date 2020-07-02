package com.mr_mir.uiuxdesign.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.ArrayList

/**
 * Created by Shitab Mir on 30,June,2020
 */
data class InstaPost (

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("location")
    val location: String? = null,

    @field:SerializedName("profile_image")
    val profImage: Int? = null,

    @field:SerializedName("post_image")
    val postImage: Int? = null
): Serializable
