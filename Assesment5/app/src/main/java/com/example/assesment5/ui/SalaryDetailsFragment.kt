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
import com.example.assesment5.databinding.FragmentSalaryDetailsBinding
import com.google.android.material.snackbar.Snackbar

class SalaryDetailsFragment : Fragment() {
    private val viewModel: DetailsViewModel by activityViewModels()

    private var _binding: FragmentSalaryDetailsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSalaryDetailsBinding.inflate(inflater, container, false)

        viewModel.setSalaryDao(
            (requireActivity().application as SalaryApplication).db.salaryDao()
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.salSave.setOnClickListener {
            if (binding.edtsalary.text.isNullOrBlank() ||
                binding.edthra.text.isNullOrBlank() ||
                binding.edtta.text.isNullOrBlank() ||
                binding.edtctc.text.isNullOrBlank()
            ) {
                Snackbar.make(view, "Salary Details cant be Empty", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            } else {
                viewModel.onSaveBasic(
                    binding.edtsalary.text.toString().toDouble(),
                    binding.edthra.text.toString().toDouble(),
                    binding.edtta.text.toString().toDouble(),
                    binding.edtctc.text.toString().toDouble()
                )
                findNavController().popBackStack(R.id.dashboardFragment, false)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}