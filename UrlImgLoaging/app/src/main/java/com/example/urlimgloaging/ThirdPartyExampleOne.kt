package com.example.urlimgloaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import eu.long1.spacetablayout.SpaceTabLayout

class ThirdPartyExampleOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_party_example_one)

        val pager = findViewById<ViewPager>(R.id.viewPager)

        val tabLayout = findViewById<SpaceTabLayout>(R.id.spaceTabLayout)

        tabLayout.initialize(
            pager,
            supportFragmentManager,
            mutableListOf<Fragment>(
                FirstFragment(),
                SecondFragment(),
                SecondFragment()
            ),
            null
        )

    }
}