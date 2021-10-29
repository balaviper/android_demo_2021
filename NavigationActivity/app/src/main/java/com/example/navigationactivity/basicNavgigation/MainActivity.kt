package com.example.navigationactivity.basicNavgigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.navigationactivity.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        traditionalWayOfPassingData()
    }

    private fun traditionalWayOfPassingData() {

        supportFragmentManager.commit {
            replace(
                R.id.fragmentContainerView,
                TraditionalFragment.newInstance("green", "#00ff00")
            )
        }
    }
}