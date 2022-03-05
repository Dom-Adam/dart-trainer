package com.example.darttrainer.gameScreens.match.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.darttrainer.SharedViewModel
import com.example.darttrainer.databinding.MatchSettingsFragmentBinding

class MatchSettingsFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = MatchSettingsFragmentBinding.inflate(
            inflater,
            container,
            false
        )

        binding.button.setOnClickListener {
            sharedViewModel.getMatchSettings(
                binding.player1Points.selectedItem as Int?,
                binding.legs.text.toString().toInt(),
                binding.sets.text.toString().toInt(),
                binding.player1In.selectedItem as String?,
                binding.player1Out.selectedItem as String?,
                binding.player2Points.selectedItem as Int?,
                binding.player2In.selectedItem as String?,
                binding.player2Out.selectedItem as String?,
            )
//            if (binding.numberOfPlayer.selectedItem == "1") {
//                findNavController().navigate(
//                    MatchSettingsFragmentDirections
//                        .actionMatchSettingsFragmentToTenToOneFragment()
//                )
//            } else {
//                findNavController().navigate(
//                    MatchSettingsFragmentDirections
//                        .actionMatchSettingsFragmentToMatchFragment()
//                )
//            }
        }

        binding.numberOfPlayer.setOnClickListener {
            if (binding.numberOfPlayer.selectedItem == "1") {
                binding.player2Points.isEnabled = false
                binding.player2In.isEnabled = false
                binding.player2Out.isEnabled = false
            } else {
                binding.player2Points.isEnabled = true
                binding.player2In.isEnabled = true
                binding.player2Out.isEnabled = true
            }
        }

        return binding.root
    }
}