package com.brm.spacex.ui.latest

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.brm.spacex.data.model.ship.Ship

@StateStrategyType(SingleStateStrategy::class)
interface LatestView : MvpView{
    fun onVideoSetup(link: String)
    fun onListSetup(ships: List<Ship>)
    fun addShip(ship: Ship)
    fun onConnectionAbsence()
    fun onUnknownError()
}