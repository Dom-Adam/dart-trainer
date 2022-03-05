package com.example.darttrainer.gameScreens.match.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.darttrainer.SharedViewModel
import com.example.darttrainer.databinding.MatchFragmentBinding

class MatchFragment : Fragment() {

    private lateinit var viewModelFactory: MatchViewModelFactory
    private lateinit var viewModel: MatchViewModel
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = MatchFragmentBinding.inflate(inflater, container, false)
        viewModelFactory = MatchViewModelFactory(sharedViewModel.matchSettings)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MatchViewModel::class.java)

        binding.apply {
            lifecycleOwner = this@MatchFragment
            viewModel = viewModel
        }

        return binding.root
    }
}