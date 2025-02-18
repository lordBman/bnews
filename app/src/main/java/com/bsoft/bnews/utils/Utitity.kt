package com.bsoft.bnews.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.text.format.DateUtils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import kotlin.math.abs

object Utility {
    fun isInternetConnected(context: Context): Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager;

        val networkCapabilities = connectivityManager.activeNetwork ?: return  false;
        val actNetwork = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false;
        return when{
            actNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true;
            else -> false
        }
    }

    @SuppressLint("SimpleDateFormat")
    fun parseDate(dateString: String): Date{
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

        try {
            return formatter.parse(dateString) ?: throw Error("unable to parse ($dateString) to Date object")
        } catch (e: ParseException) {
            throw e
        }
    }

    @SuppressLint("SimpleDateFormat")
    fun parseCalendar(dateString: String): Calendar{
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        try {
            val date = formatter.parse(dateString) ?: throw Error("unable to parse ($dateString) to Date object")
            val calendar: Calendar = Calendar.getInstance()
            calendar.setTime(date)

            return  calendar;
        } catch (e: ParseException) {
            throw e;
        }
    }
}

fun String.localize(): String {
    if(this.isEmpty()){
        throw Error("String cannot be empty")
    }
    val char = this[0]
    return this.replaceFirst(char, char.uppercaseChar())
}

fun Date.duration(): String {
    val diff = abs((Date().time - this.time) / 1000) // Get time difference in seconds

    return when {
        diff < 60 -> "$diff seconds ago"
        diff < 3600 -> "${diff / 60} minutes ago"
        diff < 86400 -> "${diff / 3600} hours ago"
        else -> "${diff / 86400} days ago"
    }
}
