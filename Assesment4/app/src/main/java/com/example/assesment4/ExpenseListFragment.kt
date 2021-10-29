package com.example.assesment4

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assesment4.databinding.FragmentExpenseListBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExpenseListFragment : Fragment() {

    private val viewModel: ExpenseViewModel by activityViewModels()

    private var _binding: FragmentExpenseListBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentExpenseListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(requireContext(), "Called", Toast.LENGTH_SHORT).show()

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.SecondFragment)
        }

        val adapter = ExpenseListAdapter(
            requireContext(),
            viewModel.getExpenses()
        )
        Log.i("@data","${viewModel.getExpenses()}")
        binding.recExpLst.adapter = adapter

        val layoutManager = LinearLayoutManager(requireContext())
        binding.recExpLst.layoutManager = layoutManager
        binding.recExpLst.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                layoutManager.orientation
            )
        )
        adapter.clkPos.observe(viewLifecycleOwner){
            val item = viewModel.getExpenses()[it]
            findNavController().navigate(ExpenseListFragmentDirections.actionFirstFragmentToExpenseDetailsFragment(item.id))
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}