package com.brm.spacex.service

import android.content.Context
import com.brm.spacex.data.model.latest.Latest
import com.brm.spacex.data.model.ship.Ship
import io.reactivex.Observable

interface ApiService {
    fun hasPing(context: Context): Boolean
    fun getLatest(): Observable<Latest>
    fun getShipById(id: String): Observable<Ship>
}