package com.example.darttrainer.gameScreens.fourToOne.priestleysTrebles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.darttrainer.databinding.PriestleysTreblesFragmentBinding

class PriestleysTreblesFragment : Fragment() {

    val viewModel: PriestleysTreblesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = PriestleysTreblesFragmentBinding.inflate(
            inflater,
            container,
            false,
        )

        binding.priestleysTreblesTargetGroup.let {
            it.oneTargetMainLabel.text = "Treble"
            it.oneTargetSecondaryLabel.text = "Points"
        }

        viewModel.currentTarget.observe(viewLifecycleOwner, {
            binding.priestleysTreblesTargetGroup.oneTargetMain.text = it.toString()
        })

        viewModel.pointsScored.observe(viewLifecycleOwner, {
            binding.priestleysTreblesTargetGroup.oneTargetSecondary.text = it.toString()
        })

        binding.priestleysTreblesButtonGroup.let {
            it.fourButtonLabel.text = "Hits"
            it.fourButtonOne.text = "3"
            it.fourButtonTwo.text = "2"
            it.fourButtonThree.text = "1"
            it.fourButtonFour.text = "0"

            it.fourButtonOne.setOnClickListener { viewModel.clickHandler(3) }
            it.fourButtonTwo.setOnClickListener { viewModel.clickHandler(2) }
            it.fourButtonThree.setOnClickListener { viewModel.clickHandler(1) }
            it.fourButtonFour.setOnClickListener { viewModel.clickHandler(0) }
        }

        return binding.root
    }
}