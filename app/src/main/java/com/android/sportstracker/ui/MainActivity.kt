package com.android.sportstracker.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.android.sportstracker.databinding.ActivityMainBinding
import com.android.sportstracker.network.SportsApiService
import com.android.sportstracker.viewModels.SportPickerViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sportPickerViewModel: SportPickerViewModel
//    private val mLifecycleRegistry mLifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        Log.i("VIEW MODEL", "Called ViewModelProvider.get()")
        sportPickerViewModel = ViewModelProvider(this).get(SportPickerViewModel::class.java)
        setContentView(binding.root)

        // Set the current sport when card is clicked
        binding.baseballCard.setOnClickListener { setSearchString(binding.baseballText) }
        binding.footballCard.setOnClickListener { setSearchString(binding.footballText) }
        binding.hockeyCard.setOnClickListener { setSearchString(binding.hockeyText) }
        binding.basketballCard.setOnClickListener { setSearchString(binding.basketballText) }
        binding.soccerCard.setOnClickListener { setSearchString(binding.soccerText) }

        // Search for teams of the selected sport when button is clicked
        binding.seeTeams.setOnClickListener {
//            new SportsApiService()
        }
    }


    fun setSearchString(view: TextView) {
        val sport = view.text
        sportPickerViewModel.setSport(sport as String)
        val returnedSport: String? = sportPickerViewModel.getSport()
        Log.i("VIEWMODEL RETURN SPORT", "${returnedSport}")

    }
}