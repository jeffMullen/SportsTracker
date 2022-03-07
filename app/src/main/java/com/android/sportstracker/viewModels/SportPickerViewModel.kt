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

    private val _status = MutableLiveData<SportsApiStatus>()
    val status: LiveData<SportsApiStatus> = _status

    private val _teams = MutableLiveData<List<Team>>()
    val teams: LiveData<List<Team>> = _teams


    private var sportId: String = ""

    init {
        getTeams(this.sportId)
    }

    fun setSport(sport: String) {

        if (sport == "Baseball") {
            this.sportId = "MLB"
        } else if (sport == "Football"){
            this.sportId = "NFL"
        } else if (sport == "Hockey") {
            this.sportId = "NHL"
        } else if (sport == "Basketball") {
            this.sportId = "NBA"
        } else if (sport == "Soccer") {
            this.sportId = "American%20Major%20League%20Soccer"
        }
    }


    fun getSport(): String { return this.sportId }

    override fun onCleared() {
        super.onCleared()
        Log.i("SPORTPICKER", "SportPickerViewModel onCleared()!!!!")
    }

    fun searchTeams() {
        Log.i("VIEWMODEL", "IN VIEW MODEL")
        getTeams(this.sportId)
    }

    private fun getTeams(sportQuery: String) {
        Log.i("GET TEAMS", "GET TEAMS IN VIEW MODEL")
        viewModelScope.launch {
            _status.value = SportsApiStatus.LOADING
            try {
                Log.i("TRY BLOCK VIEW MODEL", "IN TRY BLOCK")
                _teams.value = SportsApi.retrofitService.getTeams(sportQuery)
                _status.value = SportsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = SportsApiStatus.ERROR
                _teams.value = listOf()
                Log.i("CATCH BLOCK VIEW MODEL", _status.value.toString())
            }
        }
    }

}