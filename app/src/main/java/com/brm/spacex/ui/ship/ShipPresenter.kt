package com.brm.spacex.ui.ship

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.brm.spacex.service.ApiServiceImpl
import io.reactivex.disposables.Disposable
import java.util.*

@InjectViewState
class ShipPresenter: MvpPresenter<ShipView>() {

    private val apiService = ApiServiceImpl()

    fun getInfo(id: String){
        viewState.onLoading()
        val disposable = apiService.getShipById(id)
            .subscribe({
                       viewState.onLoaded(it)
            }, {
                viewState.onError()
            })
    }
}