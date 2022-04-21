package com.brm.spacex.ui

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.arellomobile.mvp.MvpAppCompatActivity
import com.brm.spacex.R
import com.brm.spacex.databinding.ActivityMainBinding

class MainActivity : MvpAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActionBarWithNavController(findNavController(R.id.mainNavHost))
    }

    override fun onSupportNavigateUp(): Boolean {
        val bind= findNavController(R.id.mainNavHost)
        return super.onSupportNavigateUp() || bind.navigateUp()
    }
}