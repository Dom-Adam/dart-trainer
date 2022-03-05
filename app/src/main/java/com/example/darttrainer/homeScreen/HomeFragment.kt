package com.example.darttrainer.homeScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.darttrainer.adapters.HomeAdapter
import com.example.darttrainer.databinding.HomeFragmentBinding
import com.example.darttrainer.repository.CategoryList

class HomeFragment : Fragment(), HomeAdapter.OnItemClickListener {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = HomeFragmentBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel

        binding.homeRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.homeRecyclerView.adapter = HomeAdapter(CategoryList.getCategories, this)

        viewModel.navigateToCategory.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                findNavController()
                    .navigate(
                        HomeFragmentDirections
                            .actionHomeFragmentToDisplayGamesFragment(viewModel.navigateToCategory.value!!)
                    )
                viewModel.onNavigateToCategoryComplete()
            }
        })

        return binding.root
    }

    override fun onItemClick(category: String) {
        viewModel.onNavigateToCategory(category)
    }


}