package com.example.basicnavigationdrawer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basicnavigationdrawer.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val dataSource = listOf(
            HomeData("Abc", "11:00", false),
            HomeData("Pqr", "11:15", false),
            HomeData("Lmn", "12:15", false),
            HomeData("Tuv", "12:30", false),
            HomeData("Xyz", "07:09", false)
        )
        val linearLayoutManager = LinearLayoutManager(requireContext())
        val adapter = HomeAdopter(
            requireContext(),
            dataSource
        )

        adapter.clkPos.observe(viewLifecycleOwner) {
            val item = dataSource[it]
            findNavController().navigate(HomeFragmentDirections.actionNavHomeToNavGallery(
                item.name,
                item.blb
            ))
        }
        binding.recView.layoutManager = linearLayoutManager
        binding.recView.adapter = adapter
        binding.recView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                linearLayoutManager.orientation
            )
        )
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}