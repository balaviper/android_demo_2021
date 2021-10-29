package com.example.jetpack.archDemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jetpack.R
import com.example.jetpack.databinding.ActivityDbDemoBinding

data class Invoice(
    val num: String = "#89565",
    val client: String = "Abc Copr Ltd",
    val amt : Double = 56.23,
    val date: String = "01-09-2021"
)

class DbDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityDbDemoBinding = DataBindingUtil
            .setContentView(this, R.layout.activity_db_demo)

        binding.inv = Invoice()
    }
}