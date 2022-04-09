package com.example.darttrainer.homeScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.navigateToCategory.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                findNavController()
                    .navigate(
                        HomeFragmentDirections
                            .actionHomeFragmentToDisplayGamesFragment(viewModel.navigateToCategory.value!!)
                    )
                viewModel.onNavigateToCategoryComplete()
            }
        })

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent { HomeScreen() }
        }
    }
}