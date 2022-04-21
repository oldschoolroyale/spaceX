package com.brm.spacex.ui.ship

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.brm.spacex.data.model.ship.Ship

@StateStrategyType(SingleStateStrategy::class)
interface ShipView : MvpView {
    fun onLoading()
    fun onError()
    fun onLoaded(ship: Ship)
}
