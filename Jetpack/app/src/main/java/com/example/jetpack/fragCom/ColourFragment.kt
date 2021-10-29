package com.example.jetpack.fragCom

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.jetpack.R
import com.example.jetpack.databinding.FragmentColourBinding

class ColourFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<FragmentColourBinding>(
            inflater,
            R.layout.fragment_colour,
            container,
            false
        )
        binding.col = "#ff0000"
        binding.lifecycleOwner = this

        val viewModel: FragComViewModel by activityViewModels()

        viewModel.color.observe(this) {
            Log.i("@bala", "$it")
            binding.col = it
        }

        return binding.root
    }

}