package com.brm.spacex.service

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.brm.spacex.data.model.latest.Latest
import com.brm.spacex.data.model.ship.Ship
import com.brm.spacex.data.network.HttpRetrofit
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ApiServiceImpl: ApiService{
    private val httpRetrofit: HttpRetrofit = HttpRetrofit

    override fun getLatest(): Observable<Latest> {
        return httpRetrofit.getHttpApi().getLatest()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getShipById(id: String): Observable<Ship> {
        return httpRetrofit.getHttpApi().getShipById(id)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
    }

    @SuppressLint("MissingPermission")
    override fun hasPing(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val nw = manager.activeNetwork ?: return false
        val actNw = manager.getNetworkCapabilities(nw)
        return actNw != null && (actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                    || actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
    }

}