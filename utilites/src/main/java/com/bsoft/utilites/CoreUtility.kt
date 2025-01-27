package com.bsoft.utilites

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object CoreUtility {
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
}