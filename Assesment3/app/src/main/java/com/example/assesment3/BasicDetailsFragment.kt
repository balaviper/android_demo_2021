package com.example.assesment3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.assesment3.databinding.FragmentBasicDetailsBinding
import com.example.assesment3.databinding.FragmentSalaryDetailsBinding

class BasicDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: SalaryViewModel by activityViewModels()

        val binding = DataBindingUtil.inflate<FragmentBasicDetailsBinding>(
            inflater,
            R.layout.fragment_basic_details,
            container,
            false
        )
        binding.lifecycleOwner = this
        binding.vm = viewModel



        return binding.root
    }
}