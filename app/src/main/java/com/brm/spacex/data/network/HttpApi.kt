package com.brm.spacex.data.network

import com.brm.spacex.data.model.latest.Latest
import com.brm.spacex.data.model.ship.Ship
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface HttpApi {

    @GET("/rest/launch-latest")
    fun getLatest(): Observable<Latest>

    @GET("/rest/ship/{id}")
    fun getShipById(@Path("id") id: String): Observable<Ship>
}