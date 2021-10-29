package com.example.jetpack.archDemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.jetpack.R
import com.example.jetpack.databinding.ActivityLvDtVwMdlBinding

class LvDtVwMdlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLvDtVwMdlBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_lv_dt_vw_mdl
        )

        val viewModel: LvDtVmViewModel by viewModels()
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }
}