package com.example.jetpack.stockApp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.jetpack.R
import com.example.jetpack.databinding.FragmentLoginBinding
import com.example.jetpack.databinding.FragmentStockBinding

class StockFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: StockViewModel by activityViewModels()

        val binding = DataBindingUtil.inflate<FragmentStockBinding>(
            inflater,
            R.layout.fragment_stock,
            container,
            false
        )
        binding.lifecycleOwner = this
        binding.vm = viewModel

        return binding.root
    }
}

