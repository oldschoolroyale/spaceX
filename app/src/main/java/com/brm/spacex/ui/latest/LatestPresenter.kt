package com.brm.spacex.ui.latest

import android.content.Context
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.brm.spacex.data.model.ship.Ship
import com.brm.spacex.data.network.HttpRetrofit
import com.brm.spacex.service.ApiServiceImpl
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

@InjectViewState
class LatestPresenter : MvpPresenter<LatestView>() {
    private val apiService = ApiServiceImpl()
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun startInitialization(context: Context?) {
        if (dataList.isNotEmpty()) {
            viewState.onListSetup(dataList)
            return
        }
        context?.let { if (!apiService.hasPing(context)){viewState.onConnectionAbsence()}}
        compositeDisposable.add(
            apiService.getLatest()
                .subscribe({ latest ->
                    run {
                        viewState.onVideoSetup(latest.links.video_link)
                        getEachShip(latest.ships)
                    }
                },
                    { viewState.onUnknownError() }
                )
        )
    }

    private fun getEachShip(shipList: List<com.brm.spacex.data.model.latest.Ship>) {
        shipList.forEach{ each ->
            compositeDisposable.add(apiService.getShipById(each.id)
                .subscribe({viewState.addShip(it)},{}))
        }
    }

    fun dispose() {
        compositeDisposable.dispose()
    }

    companion object {
        private val dataList = ArrayList<Ship>()
    }

}