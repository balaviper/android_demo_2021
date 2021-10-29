package com.example.jetpack.basics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.jetpack.R

class BestFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best_fragment)

        supportFragmentManager.commit {
            replace<TwoFragment>(R.id.fragCont)
        }
    }
}