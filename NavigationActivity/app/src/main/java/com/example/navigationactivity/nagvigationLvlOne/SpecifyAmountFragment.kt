package com.example.navigationactivity.nagvigationLvlOne

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationactivity.R
import com.example.navigationactivity.databinding.FragmentSpecifyAmountBinding

class SpecifyAmountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        requireActivity().title = "Specify Amount"
        val binding = FragmentSpecifyAmountBinding.inflate(
            inflater,
            container,
            false
        )

        binding.textView5.text = "Sending Money to ${arguments?.getString(KEY_RECIPIENT)}"

        binding.button6.setOnClickListener { requireActivity().onBackPressed() }

        binding.button5.setOnClickListener {
            (requireActivity() as OldNavActivity).loadFragment(
                ConfirmationFragment.newInstance(
                    arguments?.getString(KEY_RECIPIENT) ?: "",
                    binding.editTextTextPersonName3.text.toString().toInt()
                )
            )
        }

        return binding.root
    }

    companion object {
        const val KEY_RECIPIENT = "recipient";
        fun newInstance(recipient : String) = SpecifyAmountFragment().apply {
            val bundle = Bundle()
            bundle.putString(KEY_RECIPIENT, recipient)
            arguments = bundle
        }
    }
}