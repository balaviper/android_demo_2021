package com.example.jetpack.archDemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.jetpack.R
import com.example.jetpack.databinding.ActivityVmDemoBinding
import java.util.*

class VmDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_vm_demo)
        val binding = ActivityVmDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var i=0
        binding.dateBtn.setOnClickListener {
            if(i==0) {
                binding.dateText.setText(Date().toString())
                binding.pg.visibility = View.INVISIBLE
                i+=1
            }
            else if(i==1){
                binding.pg.visibility = View.VISIBLE
                i=0
            }

        }
    }
}