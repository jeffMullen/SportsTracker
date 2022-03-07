package com.android.sportstracker.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.sportstracker.network.SportsApi
import com.android.sportstracker.network.Team
import kotlinx.coroutines.launch

enum class SportsApiStatus { LOADING, ERROR, DONE }

class SportPickerViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val _status = MutableLiveData<SportsApiStatus>()
    val status: LiveData<SportsApiStatus> = _status

    private val _teams = MutableLiveData<List<Team>>()
    val teams: LiveData<List<Team>> = _teams

    private lateinit var sportId: String

    init {
        getTeams()
    }

    fun setSport(sport: String) {

        if (sport == "Baseball") {
            this.sportId = "MLB"
            Log.d("BASEBALL", sportId)
        } else if (sport == "Football"){
            this.sportId = "NFL"
            Log.d("FOOTBALL", sportId)
        } else if (sport == "Hockey") {
            this.sportId = "NHL"
            Log.d("HOCKEY", sportId)
        } else if (sport == "Basketball") {
            this.sportId = "NBA"
            Log.d("BASKETBALL", sportId)
        } else if (sport == "Soccer") {
            this.sportId = "American%20Major%20League%20Soccer"
            Log.d("SOCCER", sportId)
        }
    }


    fun getSport(): String { return this.sportId }

    override fun onCleared() {
        super.onCleared()
        Log.i("SPORTPICKER", "SportPickerViewModel onCleared()!!!!")
    }

    fun searchTeams() {
        getTeams()
    }

    private fun getTeams() {
        viewModelScope.launch {
            _status.value = SportsApiStatus.LOADING
            try {
                _teams.value = SportsApi.retrofitService.getTeams()
                _status.value = SportsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = SportsApiStatus.ERROR
                _teams.value = listOf()
            }
        }
    }

}