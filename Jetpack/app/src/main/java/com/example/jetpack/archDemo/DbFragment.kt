package com.example.jetpack.archDemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.databinding.DataBindingUtil
import com.example.jetpack.R
import java.util.*
import com.example.jetpack.databinding.FragmentDbBinding


class DbFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding =  DataBindingUtil.inflate<FragmentDbBinding>(
            inflater,
            R.layout.fragment_db,
            container,
            false
        )

        binding.dt = Date()

        binding.swNm = "Bala Viper"

        binding.swt = true

        binding.chkLsnr = CompoundButton.OnCheckedChangeListener{
                btn, sts -> binding.swNm = "$sts" }

        return binding.root
    }

}