package com.example.navigationactivity.nagvigationLvlOne

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationactivity.R
import com.example.navigationactivity.databinding.FragmentChooseRecipientBinding

class ChooseRecipientFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        requireActivity().title = "Choose Recipient"
        val binding = FragmentChooseRecipientBinding.inflate(
            inflater,
            container,
            false
        )

        binding.button4.setOnClickListener { requireActivity().onBackPressed()  }
        binding.button3.setOnClickListener {
            (requireActivity() as OldNavActivity).loadFragment(
                SpecifyAmountFragment.newInstance(
                    binding.editTextTextPersonName2.text.toString()
                )
            )
        }

        return binding.root
    }

    companion object {
        fun newInstance() = ChooseRecipientFragment()
    }
}