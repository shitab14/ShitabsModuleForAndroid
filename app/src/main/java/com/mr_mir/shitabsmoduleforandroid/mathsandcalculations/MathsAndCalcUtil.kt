package com.mr_mir.shitabsmoduleforandroid.mathsandcalculations

import java.lang.String
import java.util.*

/**
 * Created by Shitab Mir
 */

class MathsAndCalcUtil {

    companion object {

        //Adds an Array of Doubles
        fun addsThisArray(arrayList: ArrayList<Double>): Double {
            var result: Double = 0.0
            for (x in 0 until arrayList.size) {
                result += arrayList[x]
            }
            return result
        }

        fun limitDecimalPlaces(myDouble: Double, numbersAfterPoint: Int): kotlin.String {
            var formattedValue = String.format("%.$numbersAfterPoint+f", myDouble)
            return formattedValue
        }
    }
}