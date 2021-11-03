package com.example.assesment5.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.assesment5.R
import com.example.assesment5.SalaryApplication
import com.example.assesment5.databinding.FragmentBasicDetailsBinding
import com.google.android.material.snackbar.Snackbar


class BasicDetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by activityViewModels()

    private var _binding: FragmentBasicDetailsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBasicDetailsBinding.inflate(inflater, container, false)

        viewModel.setBasicDao(
            (requireActivity().application as SalaryApplication).db.basicDao()
        )
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bsSave.setOnClickListener {
            if (binding.edtbsname.text.isNullOrBlank() ||
                binding.edtbsmob.text.isNullOrBlank() ||
                binding.edtbsage.text.isNullOrBlank() ||
                binding.edtbsmail.text.isNullOrBlank()
            ) {
                Snackbar.make(view, "Details cant be Empty", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            } else {
                viewModel.onSaveBasic(
                    binding.edtbsname.text.toString(),
                    binding.edtbsmob.text.toString(),
                    binding.edtbsage.text.toString().toInt(),
                    binding.edtbsmail.text.toString()
                )
                findNavController().navigate(R.id.salaryDetailsFragment)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}