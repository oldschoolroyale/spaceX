package com.brm.spacex.ui.latest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.brm.spacex.R
import com.brm.spacex.adapter.ShipsAdapter
import com.brm.spacex.data.model.ship.Ship
import com.brm.spacex.databinding.FragmentLatestBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class LatestFragment : MvpAppCompatFragment(), LatestView{

    private var _binding: FragmentLatestBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy { ShipsAdapter() }

    @InjectPresenter
    lateinit var latestPresenter: LatestPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentLatestBinding.inflate(layoutInflater)
        binding.recyclerView.adapter = adapter
        lifecycle.addObserver(binding.youtubePlayerView)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        latestPresenter.startInitialization(context)
    }

    override fun onUnknownError() {
        context.let { Toast.makeText(it,
            getString(R.string.error), Toast.LENGTH_LONG).show() }
    }

    override fun onVideoSetup(link: String) {
        binding.youtubePlayerView.addYouTubePlayerListener(object: AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                youTubePlayer.loadVideo(link.split("be/")[1], 0f)
            }
        })
    }

    override fun onListSetup(ships: List<Ship>) {
        adapter.newList(ships as ArrayList<Ship>)
    }

    override fun addShip(ship: Ship) {
        adapter.addShip(ship)
    }

    override fun onConnectionAbsence() {
        context.let { Toast.makeText(it,
            getString(R.string.error_connection_absence), Toast.LENGTH_LONG).show() }
    }

    override fun onDestroyView() {
        _binding = null
        latestPresenter.dispose()
        super.onDestroyView()
    }
}
