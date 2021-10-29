package com.example.jetpack.instaActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.jetpack.R

class BasicInsta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_insta)

        findViewById<ImageView>(R.id.imgMsg).setOnClickListener {
            supportFragmentManager.commit {
                replace<Message>(R.id.fragInsta)
            }
        }

        findViewById<ImageView>(R.id.imgProfile).setOnClickListener {
            supportFragmentManager.commit {
                replace<Profile>(R.id.fragInsta)
            }
        }

        findViewById<ImageView>(R.id.imgSettings).setOnClickListener {
            supportFragmentManager.commit {
                replace<Settings>(R.id.fragInsta)
            }
        }
    }
}