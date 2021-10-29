package com.example.jetpack_navigation_graph.advance.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.jetpack_navigation_graph.databinding.FragmentDashboardBinding
import com.example.jetpack_navigation_graph.fundamentals.SpecifyAmountFragmentArgs
import java.util.*

class DashboardFragment : Fragment() {

    private val args : DashboardFragmentArgs by navArgs()

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.textDash.text = args.text.uppercase()
        binding.btnnxt.setOnClickListener {
            val dt = Date().toString() + args.text
            findNavController().navigate(DashboardFragmentDirections.actionNavigationDashboardToNavigationNotifications(dt))
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}