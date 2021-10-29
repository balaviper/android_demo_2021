package com.example.assesment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DashboardLoader()


    }


    private fun DashboardLoader() {
        supportFragmentManager.commit {
            replace<DashboardFragment>(R.id.fragmentContainerView)
        }
    }
}