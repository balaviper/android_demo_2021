package com.example.navigationactivity.nagvigationLvlOne

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationactivity.R
import com.example.navigationactivity.databinding.FragmentViewTxnBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ViewTxnFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        requireActivity().title = "View Transaction"

        val binding: FragmentViewTxnBinding = FragmentViewTxnBinding.inflate(
            inflater,
            container,
            false
        )

        binding.txtDt.text = "Data : INR. 1500"
        binding.txtFd.text = "Food : INR. 3000"

        return binding.root
    }

    companion object {
        fun newInstance() = ViewTxnFragment()
    }
}