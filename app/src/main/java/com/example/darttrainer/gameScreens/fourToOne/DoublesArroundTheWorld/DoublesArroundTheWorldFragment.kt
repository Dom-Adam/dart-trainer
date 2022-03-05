package com.example.darttrainer.gameScreens.fourToOne.DoublesArroundTheWorld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.darttrainer.databinding.FragmentDoublesArroundTheWorldBinding

class DoublesArroundTheWorldFragment : Fragment() {

    val viewModel: DoublesArroundTheWorldViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDoublesArroundTheWorldBinding.inflate(
            inflater,
            container,
            false,
        )

        binding.doublesArroundTheWorldTargetGroup.let {
            it.oneTargetMainLabel.text = "Double"
            it.oneTargetSecondaryLabel.text = "Points"
        }

        viewModel.currentTarget.observe(viewLifecycleOwner, {
            binding.doublesArroundTheWorldTargetGroup.oneTargetMain.text = it
        })

        viewModel.currentScore.observe(viewLifecycleOwner, {
            binding.doublesArroundTheWorldTargetGroup.oneTargetSecondary.text = it.toString()
        })

        binding.doublesArroundTheWorldButtonGroup.let {
            it.fourButtonOne.setOnClickListener { viewModel.clickHandler(3) }
            it.fourButtonTwo.setOnClickListener { viewModel.clickHandler(2) }
            it.fourButtonThree.setOnClickListener { viewModel.clickHandler(1) }
            it.fourButtonFour.setOnClickListener { viewModel.clickHandler(0) }

            it.fourButtonLabel.text = "Hits"
            it.fourButtonOne.text = "3"
            it.fourButtonTwo.text = "2"
            it.fourButtonThree.text = "1"
            it.fourButtonFour.text = "0"
        }

        return binding.root
    }
}