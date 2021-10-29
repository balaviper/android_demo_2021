package com.example.assesment3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.assesment3.databinding.FragmentSalaryCardBinding
import com.example.assesment3.databinding.FragmentSalaryDetailsBinding

class SalaryCardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: SalaryViewModel by activityViewModels()

        val binding = DataBindingUtil.inflate<FragmentSalaryCardBinding>(
            inflater,
            R.layout.fragment_salary_card,
            container,
            false
        )
        binding.lifecycleOwner = this
        binding.vm = viewModel




        return binding.root
    }



}