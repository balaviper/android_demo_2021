package com.example.jetpack_navigation_graph.advance.ui.notifications

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
import com.example.jetpack_navigation_graph.R
import com.example.jetpack_navigation_graph.advance.ui.dashboard.DashboardFragmentArgs

import com.example.jetpack_navigation_graph.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private val args : NotificationsFragmentArgs by navArgs()

    private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentNotificationsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.txtNot.text = args.dt

        binding.btnHm.setOnClickListener {
            findNavController().popBackStack(R.id.navigation_home,false)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}