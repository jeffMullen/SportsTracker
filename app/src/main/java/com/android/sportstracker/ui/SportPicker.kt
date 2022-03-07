package com.android.sportstracker.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.android.sportstracker.adapter.TeamGridAdapter
import com.android.sportstracker.databinding.SportPickerFragmentBinding
import com.android.sportstracker.viewModels.SportPickerViewModel

class SportPicker : Fragment() {

    private val viewModel: SportPickerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = SportPickerFragmentBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.teamsGrid.adapter = TeamGridAdapter()

        return binding.root
    }
}