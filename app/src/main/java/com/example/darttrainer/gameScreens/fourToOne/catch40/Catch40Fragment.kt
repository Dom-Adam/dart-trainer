package com.example.darttrainer.gameScreens.fourToOne.catch40

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.darttrainer.databinding.Catch40FragmentBinding

class Catch40Fragment : Fragment() {

    val viewModel: Catch40ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = Catch40FragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel

        binding.catch40TargetGroup.let {
            it.oneTargetSecondaryLabel.text = "Points"
            it.oneTargetMainLabel.text = "Target"
            it.oneTargetTertiaryLabel.visibility = View.INVISIBLE
            it.oneTargetTertiary.visibility = View.INVISIBLE
        }

        viewModel.currentTarget.observe(viewLifecycleOwner, {
            binding.catch40TargetGroup.oneTargetMain.text = it.toString()
        })

        viewModel.currentScore.observe(viewLifecycleOwner, {
            binding.catch40TargetGroup.oneTargetSecondary.text = it.toString()
        })

        binding.catch40ButtonGroup.let {
            it.fourButtonLabel.text = "Finished in"
            it.fourButtonOne.text = "2 Darts"
            it.fourButtonTwo.text = "3 Darts"
            it.fourButtonThree.text = "4-6 Darts"
            it.fourButtonFour.text = "Not"
            it.fourButtonOne.setOnClickListener { viewModel.clickHandler(3) }
            it.fourButtonTwo.setOnClickListener { viewModel.clickHandler(2) }
            it.fourButtonThree.setOnClickListener { viewModel.clickHandler(1) }
            it.fourButtonFour.setOnClickListener { viewModel.clickHandler(0) }
        }

        return binding.root
    }
}