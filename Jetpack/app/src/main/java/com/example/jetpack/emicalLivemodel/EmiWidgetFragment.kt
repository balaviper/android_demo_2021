package com.example.jetpack.emicalLivemodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.jetpack.R
import com.example.jetpack.databinding.FragmentEmiWidgetBinding


class EmiWidgetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<FragmentEmiWidgetBinding>(
            inflater,
            R.layout.fragment_emi_widget,
            container,
            false
        )
        binding.lifecycleOwner = this

        val viewModel: EmiViewModel by activityViewModels()
        binding.vm = viewModel
        binding.frag = getFragmentType()
        binding.hint = setHint()
        return binding.root
    }
    val obj = EmiViewModel()
    private fun getFragmentType() = when (id) {
        R.id.fragmentContainerView3 -> "P"
        R.id.fragmentContainerView4 -> "R"
        else -> "N"
    }

    private fun setHint() = when (id) {
        R.id.fragmentContainerView3 -> "Loan Amount"
        R.id.fragmentContainerView4 -> "Interest"
        else -> "Duration"
    }




}