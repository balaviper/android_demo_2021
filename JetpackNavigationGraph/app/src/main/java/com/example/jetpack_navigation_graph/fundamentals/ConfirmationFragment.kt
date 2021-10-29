package com.example.jetpack_navigation_graph.fundamentals


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.jetpack_navigation_graph.R
import com.example.jetpack_navigation_graph.databinding.FragmentConfirmationBinding


class ConfirmationFragment : Fragment() {
    private lateinit var binding : FragmentConfirmationBinding
    private val args : ConfirmationFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentConfirmationBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView6.text = "${args.amt} sent to ${args.nm}"
        binding.txtback.setOnClickListener {

            findNavController().popBackStack(R.id.mainFragment,false)
        }


    }

}