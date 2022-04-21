package com.brm.spacex.ui.ship

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.brm.spacex.R
import com.brm.spacex.data.model.ship.Ship
import com.brm.spacex.databinding.FragmentShipBinding
import com.squareup.picasso.Picasso


class ShipFragment : MvpAppCompatFragment(), ShipView {

    private var _binding: FragmentShipBinding? = null
    private val binding get() = _binding!!


    @InjectPresenter
    lateinit var shipPresenter: ShipPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShipBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getString("id", "")
        if (id != null)
            shipPresenter.getInfo(id)
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onLoading() {

    }

    override fun onError() {
        context?.let { Toast.makeText(it,
            getString(R.string.error), Toast.LENGTH_LONG).show() }
    }

    override fun onLoaded(ship: Ship) {
        Picasso.get().load(ship.image).into(binding.shipIv)
        binding.titleTv.text = ship.id
        binding.homePortTv.text = ship.home_port
        binding.typeTv.text = ship.type
        binding.weightTv.text = ship.weight_kg.toString()
        binding.yearBuildTv.text = ship.year_built.toString()
        binding.absTv.text = ship.abs.toString()
    }


}