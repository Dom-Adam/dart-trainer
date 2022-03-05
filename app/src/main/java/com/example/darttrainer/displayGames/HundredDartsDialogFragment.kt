package com.example.darttrainer.displayGames

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.darttrainer.R
import com.example.darttrainer.SharedViewModel
import com.example.darttrainer.databinding.FragmentHundredDartsDialogBinding

class HundredDartsDialogFragment : DialogFragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    companion object {
        const val TAG = "chooseTargetDialog"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentHundredDartsDialogBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.fragment_hundred_darts_dialog,
            null,
            false
        )

        binding.cancelButton.setOnClickListener {
            dismiss()
        }

        binding.submitButton.setOnClickListener {
            findNavController().navigate(
                HundredDartsDialogFragmentDirections
                    .actionHundredDartsDialogFragmentToHundredDartsFragment(
                        binding.spinner.selectedItem.toString()
                    )
            )
        }

        return binding.root
    }
}