package com.example.basicnavigationdrawer.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.basicnavigationdrawer.R
import com.example.basicnavigationdrawer.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {


    private val args : GalleryFragmentArgs by navArgs()

    private val galleryViewModel: GalleryViewModel by viewModels()

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        _binding?.vm = galleryViewModel

        galleryViewModel.setData(
            args.name,
            if(args.blb) ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_blb_on
            )!! else ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_light_bulb_off
            )!!
        )

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}