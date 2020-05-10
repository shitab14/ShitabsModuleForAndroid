package com.mr_mir.shitabsmoduleforandroid.cache

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.lang.Exception

class CacheImageManager {

    companion object {
        fun getImage(context: Context, imageTag: String ): Bitmap {
            val fileName:String = context.cacheDir.toString()+"/"+imageTag
            val file = File(fileName)
            var bitmap: Bitmap? = null
            try {
                bitmap = BitmapFactory.decodeStream(FileInputStream(file))
            } catch (e: Exception) {
                Log.e("ERROR FETCHING BITMAP", " :$e")
            }
            return bitmap!!
        }

        fun putImage(context: Context, imageTag: String, bitmap: Bitmap, quality: Int) {
            val fileName = context.cacheDir.toString()+"/"+imageTag
            val file: File = File(fileName)
            var outputStream: FileOutputStream? = null
            try {
                outputStream = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close()
                    } catch (e: Exception) {

                    }
                }
            }
        }

    }
}