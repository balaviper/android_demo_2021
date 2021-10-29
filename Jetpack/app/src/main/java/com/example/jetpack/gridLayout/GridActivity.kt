package com.example.jetpack.gridLayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.jetpack.R
import com.example.jetpack.stockApp.LoginFragment

class GridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        loadIcons()

    }

    private fun loadIcons() {
        supportFragmentManager.commit {
            replace<GridFragment>(R.id.gridFragmentContainer)
        }
    }

    private fun settingFrag(){
        supportFragmentManager.commit {
            replace<GridLoadSettings>(R.id.gridFragmentContainer)
        }
    }
}