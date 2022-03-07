package com.android.sportstracker.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.android.sportstracker.databinding.ActivityMainBinding
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

        binding.baseballCard.setOnClickListener { setSearchString(binding.baseballText) }
        binding.footballCard.setOnClickListener { setSearchString(binding.footballText) }
        binding.hockeyCard.setOnClickListener { setSearchString(binding.hockeyText) }
        binding.basketballCard.setOnClickListener { setSearchString(binding.basketballText) }
        binding.soccerCard.setOnClickListener { setSearchString(binding.soccerText) }

    }

    fun setSearchString(view: TextView) {
        val sport = view.text
        sportPickerViewModel.setSport(sport as String)
        val returnedSport: String? = sportPickerViewModel.getSport()
        Log.i("VIEWMODEL RETURN SPORT", "${returnedSport}")

    }
}