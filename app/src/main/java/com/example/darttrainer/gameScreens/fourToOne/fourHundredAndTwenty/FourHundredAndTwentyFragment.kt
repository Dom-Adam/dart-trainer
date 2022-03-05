package com.example.darttrainer.gameScreens.fourToOne.fourHundredAndTwenty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.darttrainer.databinding.FragmentFourHundredAndTwentyBinding

class FourHundredAndTwentyFragment : Fragment() {

    val viewModel: FourHundredAndTwentyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentFourHundredAndTwentyBinding.inflate(
            inflater,
            container,
            false,
        )

        binding.fourHundredAndTwentyTargetGroup.let {
            it.oneTargetSecondaryLabel.text = "Points"
            it.oneTargetMainLabel.text = "Target"
        }

        viewModel.currentScore.observe(viewLifecycleOwner, {
            binding.fourHundredAndTwentyTargetGroup.oneTargetSecondary.text = it.toString()
        })

        viewModel.currentTarget.observe(viewLifecycleOwner, {
            binding.fourHundredAndTwentyTargetGroup.oneTargetMain.text = it
        })

        binding.fourHundredAndTwentyButtonGroup.let {
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