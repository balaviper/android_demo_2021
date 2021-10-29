package com.example.jetpack.emicalLivemodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil

import com.example.jetpack.R
import com.example.jetpack.databinding.ActivityEmiCalBinding

class EmiCalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityEmiCalBinding>(
            this,
            R.layout.activity_emi_cal
        )

        val viewModel : EmiViewModel by viewModels()

        binding.lifecycleOwner = this
        binding.vm = viewModel
    }
}