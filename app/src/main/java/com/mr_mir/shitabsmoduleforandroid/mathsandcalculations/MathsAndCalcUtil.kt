package com.mr_mir.shitabsmoduleforandroid.mathsandcalculations

import java.lang.String
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.NumberFormat
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
            val formattedValue = String.format("%.$numbersAfterPoint+f", myDouble)
            return formattedValue
        }

        fun lmitDecimalPlaces(){
            val nf = NumberFormat.getNumberInstance(Locale.US)
            val df = nf as DecimalFormat
            df.applyPattern("#.##")
            df.roundingMode = RoundingMode.CEILING
        }

        fun uptoTwoDecimalCeiling(d: Double): Double? {
            val result: BigDecimal =
                BigDecimal(d.toString()).setScale(2, BigDecimal.ROUND_HALF_UP)
            return result.toDouble()
        }
    }
}