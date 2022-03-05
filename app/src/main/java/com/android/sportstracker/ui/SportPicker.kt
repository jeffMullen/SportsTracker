package com.android.sportstracker.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.sportstracker.R
import com.android.sportstracker.viewModels.SportPickerViewModel

class SportPicker : Fragment() {

    companion object {
        fun newInstance() = SportPicker()
    }

    private lateinit var viewModel: SportPickerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sport_picker_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SportPickerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}