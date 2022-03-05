package com.example.darttrainer.displayGames

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.darttrainer.SharedViewModel
import com.example.darttrainer.adapters.DisplayGamesAdapter
import com.example.darttrainer.databinding.DisplayGamesFragmentBinding
import com.example.darttrainer.repository.gameList

class DisplayGamesFragment : Fragment(), DisplayGamesAdapter.OnItemClickListener {

    private val args: DisplayGamesFragmentArgs by navArgs()
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: DisplayGamesViewModel by lazy {
        ViewModelProvider(this).get(DisplayGamesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DisplayGamesFragmentBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        binding.gamesRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.gamesRecyclerView.adapter = DisplayGamesAdapter(
            this,
            gameList.filter { args.category in it.categories }
        )

        sharedViewModel.selectedGame.observe(viewLifecycleOwner, {
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
        })

        return binding.root
    }

    override fun onItemClick(game: String) {
        sharedViewModel.selectGame(game)
    }

}