package com.mr_mir.shitabsmoduleforandroid.mathsandcalculations

import android.util.Log
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs
import kotlin.math.roundToInt

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


        //TIME

        fun getCurrentMonthId(): Int {
            val cal =
                Calendar.getInstance(TimeZone.getTimeZone("GMT+5:54"))
            return cal[Calendar.MONTH] + 1
        }

        fun getCurrentYear(): Int {
            val cal =
                Calendar.getInstance(TimeZone.getTimeZone("GMT+5:54"))
            return cal[Calendar.YEAR]
        }

        fun getCurrentDay(): Int {
            val cal =
                Calendar.getInstance(TimeZone.getTimeZone("GMT+5:54"))
            return cal[Calendar.DAY_OF_MONTH]
        }


        fun getMonthName(month: Int): String? {
            var monthName: String = ""
            when (month) {
                1 -> monthName = "Jan"
                2 -> monthName = "Feb"
                3 -> monthName = "Mar"
                4 -> monthName = "Apr"
                5 -> monthName = "May"
                6 -> monthName = "Jun"
                7 -> monthName = "Jul"
                8 -> monthName = "Aug"
                9 -> monthName = "Sep"
                10 -> monthName = "Oct"
                11 -> monthName = "Nov"
                12 -> monthName = "Dec"
            }
            return monthName
        }


        fun getDayOfWeek(value: Float): String {
            when (value.toInt()) {
                0 -> return "Sat"
                1 -> return "Sun"
                2 -> return "Mon"
                3 -> return "Tue"
                4 -> return "Wed"
                5 -> return "Thu"
                6 -> return "Fri"
            }
            return ""
        }

        private fun getTimeDistanceInMinutes(time: Long): Int {
            val timeDistance: Long =currentDate().time - time
            return (abs(timeDistance) / 1000 / 60.toFloat()).roundToInt()
        }


        fun currentDate(): Date {
            val calendar = Calendar.getInstance()
            return calendar.time
        }

        fun getTimeAgo(timestamp: Long): String? {
            Log.e("TimeStamp:", timestamp.toString())
            val cal = Calendar.getInstance()
            val tz = cal.timeZone //get your local time zone.
            val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm a")
            sdf.timeZone = tz //set time zone.
            val localTime: String = sdf.format(Date(timestamp * 1000))
            var date: Date? = Date()
            try {
                date = sdf.parse(localTime) //get local date
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            if (date == null) {
                return null
            }
            val time = date.time
            Log.e("Timestamp time", time.toString())
            val curDate: Date = currentDate()
            val now = curDate.time
            Log.e("Local time", now.toString())
            if (time > now || time <= 0) {
                return null
            }
            val timeDIM: Int =
                getTimeDistanceInMinutes(time)
            Log.e("Time diff:", timeDIM.toString())
            var timeAgo: String? = null
            if (timeDIM == 0) {
                timeAgo = "less than a minute"
            } else if (timeDIM == 1) {
                return "1 minute"
            } else if (timeDIM in 2..44) {
                timeAgo = "$timeDIM minutes"
            } else if (timeDIM in 45..89) {
                timeAgo = "about an hour"
            } else if (timeDIM in 90..1439) {
                timeAgo = "about " + (timeDIM / 60.toFloat()).roundToInt() + " hours"
            } else if (timeDIM in 1440..2519) {
                timeAgo = "1 day"
            } else if (timeDIM in 2520..43199) {
                timeAgo = (timeDIM / 1440.toFloat()).roundToInt().toString() + " days"
            } else if (timeDIM in 43200..86399) {
                timeAgo = "about a month"
            } else if (timeDIM in 86400..525599) {
                timeAgo = (timeDIM / 43200.toFloat()).roundToInt().toString() + " months"
            } else if (timeDIM in 525600..655199) {
                timeAgo = "about a year"
            } else if (timeDIM in 655200..914399) {
                timeAgo = "over a year"
            } else if (timeDIM in 914400..1051199) {
                timeAgo = "almost 2 years"
            } else {
                timeAgo = "about " + (timeDIM / 525600.toFloat()).roundToInt() + " years"
            }
            return timeAgo
        }
    }
}