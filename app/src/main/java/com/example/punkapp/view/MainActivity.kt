package com.example.punkapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.punkapp.R
import com.example.punkapp.util.Repository


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Repository.plant(applicationContext)
    }
}