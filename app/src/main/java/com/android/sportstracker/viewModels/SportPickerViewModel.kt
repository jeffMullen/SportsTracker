package com.android.sportstracker.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel

class SportPickerViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private lateinit var sportId: String

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

}