package com.example.darttrainer.displayGames

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.darttrainer.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DisplayGamesFragment : Fragment() {

    private val args: DisplayGamesFragmentArgs by navArgs()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        sharedViewModel.selectedGame.observe(viewLifecycleOwner) {
            Log.d("navigation", "fragment ${it.name}")
            when (it.name) {
                "Catch 40" -> findNavController().navigate(
                    DisplayGamesFragmentDirections
                        .actionDisplayGamesFragmentToCatch40Fragment()
                )
                "Doubles Arround the World" -> findNavController().navigate(
                    DisplayGamesFragmentDirections
                        .actionDisplayGamesFragmentToDoublesArroundTheWorldFragment()
                )
                "420" -> findNavController().navigate(
                    DisplayGamesFragmentDirections
                        .actionDisplayGamesFragmentToFourHundredAndTwentyFragment()
                )
                "Priestley's Trebles" -> findNavController().navigate(
                    DisplayGamesFragmentDirections
                        .actionDisplayGamesFragmentToPriestleysTreblesFragment()
                )
                "Doubles Boomerang" -> findNavController().navigate(
                    DisplayGamesFragmentDirections
                        .actionDisplayGamesFragmentToDoublesBoomerangFragment()
                )
                "100 Darts" -> findNavController().navigate(
                    DisplayGamesFragmentDirections
                        .actionDisplayGamesFragmentToHundredDartsDialogFragment()
                )
            }
        }

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                DisplayGamesComposable(
                    category = args.category,
                    sharedViewModel = sharedViewModel
                )
            }
        }
    }

}