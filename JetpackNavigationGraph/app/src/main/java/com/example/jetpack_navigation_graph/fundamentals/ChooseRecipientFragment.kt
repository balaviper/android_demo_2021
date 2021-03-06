package com.example.jetpack_navigation_graph.fundamentals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.jetpack_navigation_graph.databinding.FragmentChooseRecipientBinding

class ChooseRecipientFragment : Fragment() {

    private lateinit var binding: FragmentChooseRecipientBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseRecipientBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            val name = binding.editTextTextPersonName2?.text.toString()
            val action = ChooseRecipientFragmentDirections
                .actionChooseRecipientFragmentToSpecifyAmountFragment(name)
            findNavController().navigate(action)
        }
        binding.btnCancel.setOnClickListener {

            findNavController().popBackStack()
        }
    }
}