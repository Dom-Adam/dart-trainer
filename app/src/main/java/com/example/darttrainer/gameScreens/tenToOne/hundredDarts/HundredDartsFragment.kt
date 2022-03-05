package com.example.darttrainer.gameScreens.tenToOne.hundredDarts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.darttrainer.databinding.HundredDartsFragmentBinding

class HundredDartsFragment : Fragment() {

    val viewModel: HundredDartsViewModel by viewModels()
    private val args: HundredDartsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = HundredDartsFragmentBinding.inflate(
            inflater,
            container,
            false,
        )

        binding.hundredDartsTargetGroup.let {
            it.oneTargetMainLabel.text = "Points"
            it.oneTargetSecondaryLabel.text = "Darts left"
            it.oneTargetTertiaryLabel.text = "Target"
            it.oneTargetTertiary.text = args.target
        }

        viewModel.currentScore.observe(viewLifecycleOwner, {
            binding.hundredDartsTargetGroup.oneTargetMain.text = it.toString()
        })

        viewModel.dartsLeft.observe(viewLifecycleOwner, {
            binding.hundredDartsTargetGroup.oneTargetSecondary.text = it.toString()
        })

        viewModel.firstSingleSelected.observe(viewLifecycleOwner, {
            binding.hundredDartsButtonGroup.tenButtonOne.isSelected = it
        })

        viewModel.secondSingleSelected.observe(viewLifecycleOwner, {
            binding.hundredDartsButtonGroup.tenButtonTwo.isSelected = it
        })

        viewModel.thirdSingleSelected.observe(viewLifecycleOwner, {
            binding.hundredDartsButtonGroup.tenButtonThree.isSelected = it
        })

        viewModel.firstDoubleSelected.observe(viewLifecycleOwner, {
            binding.hundredDartsButtonGroup.tenButtonFour.isSelected = it
        })

        viewModel.secondDoubleSelected.observe(viewLifecycleOwner, {
            binding.hundredDartsButtonGroup.tenButtonFive.isSelected = it
        })

        viewModel.thirdDoubleSelected.observe(viewLifecycleOwner, {
            binding.hundredDartsButtonGroup.tenButtonSix.isSelected = it
        })

        viewModel.firstTrebleSelected.observe(viewLifecycleOwner, {
            binding.hundredDartsButtonGroup.tenButtonSeven.isSelected = it
        })

        viewModel.secondTrebleSelected.observe(viewLifecycleOwner, {
            binding.hundredDartsButtonGroup.tenButtonEight.isSelected = it
        })

        viewModel.thirdTrebleSelected.observe(viewLifecycleOwner, {
            binding.hundredDartsButtonGroup.tenButtonNine.isSelected = it
        })

        binding.hundredDartsButtonGroup.let {
            it.tenLabel1.text = "1st Dart"
            it.tenLabel2.text = "2nd Dart"
            it.tenLabel3.text = "3rd Dart"

            it.tenButtonOne.text = "Single"
            it.tenButtonTwo.text = "Single"
            it.tenButtonThree.text = "Single"
            it.tenButtonFour.text = "Double"
            it.tenButtonFive.text = "Double"
            it.tenButtonSix.text = "Double"
            it.tenButtonSeven.text = "Treble"
            it.tenButtonEight.text = "Treble"
            it.tenButtonNine.text = "Treble"
            it.tenButtonTen.text = "Enter"

            it.tenButtonOne.setOnClickListener { viewModel.clickHandler(1) }
            it.tenButtonTwo.setOnClickListener { viewModel.clickHandler(2) }
            it.tenButtonThree.setOnClickListener { viewModel.clickHandler(3) }
            it.tenButtonFour.setOnClickListener { viewModel.clickHandler(4) }
            it.tenButtonFive.setOnClickListener { viewModel.clickHandler(5) }
            it.tenButtonSix.setOnClickListener { viewModel.clickHandler(6) }
            it.tenButtonSeven.setOnClickListener { viewModel.clickHandler(7) }
            it.tenButtonEight.setOnClickListener { viewModel.clickHandler(8) }
            it.tenButtonNine.setOnClickListener { viewModel.clickHandler(9) }
            it.tenButtonTen.setOnClickListener { viewModel.clickHandler(0) }
        }

        return binding.root
    }
}