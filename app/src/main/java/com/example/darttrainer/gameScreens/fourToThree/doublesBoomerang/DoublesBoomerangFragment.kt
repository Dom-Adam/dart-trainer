package com.example.darttrainer.gameScreens.fourToThree.doublesBoomerang

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.darttrainer.databinding.DoublesBoomerangFragmentBinding

class DoublesBoomerangFragment : Fragment() {

    val viewModel: DoublesBoomerangViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DoublesBoomerangFragmentBinding.inflate(
            inflater,
            container,
            false,
        )

        binding.doublesBoomerangTargetGroup.let {
            it.scoreLabel.text = "Points"
            it.targetOneLabel.text = "Double"
            it.targetTwoLabel.text = "Double"
            it.targetThreeLabel.text = "Double"
        }

        viewModel.target1.observe(viewLifecycleOwner, {
            binding.doublesBoomerangTargetGroup.targetOne.text = it
        })

        viewModel.target2.observe(viewLifecycleOwner, {
            binding.doublesBoomerangTargetGroup.targetTwo.text = it
        })

        viewModel.target3.observe(viewLifecycleOwner, {
            binding.doublesBoomerangTargetGroup.targetThree.text = it
        })

        viewModel.dartsThrown.observe(viewLifecycleOwner, {
            binding.doublesBoomerangTargetGroup.score.text = it.toString()
        })

        viewModel.target1Hit.observe(viewLifecycleOwner, {
            binding.doublesBoomerangTargetGroup.targetOne.isSelected = it
            binding.doublesBoomerangButtonGroup.fourButtonOne.text = if (it) "Uncheck" else "Check"
        })

        viewModel.target2Hit.observe(viewLifecycleOwner, {
            binding.doublesBoomerangTargetGroup.targetTwo.isSelected = it
            binding.doublesBoomerangButtonGroup.fourButtonTwo.text = if (it) "Uncheck" else "Check"
        })

        viewModel.target3Hit.observe(viewLifecycleOwner, {
            binding.doublesBoomerangTargetGroup.targetThree.isSelected = it
            binding.doublesBoomerangButtonGroup.fourButtonThree.text =
                if (it) "Uncheck" else "Check"
        })

        binding.doublesBoomerangButtonGroup.let {
            it.fourButtonFour.text = "Enter"

            it.fourButtonOne.setOnClickListener { viewModel.clickHandler(1) }
            it.fourButtonTwo.setOnClickListener { viewModel.clickHandler(2) }
            it.fourButtonThree.setOnClickListener { viewModel.clickHandler(3) }
            it.fourButtonFour.setOnClickListener { viewModel.clickHandler(0) }
        }

        return binding.root
    }
}