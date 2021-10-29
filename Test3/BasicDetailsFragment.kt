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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BasicDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
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