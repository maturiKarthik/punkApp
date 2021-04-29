package com.example.punkapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.punkapp.R
import com.example.punkapp.util.Repository


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Repository.plant(applicationContext) //As the name goes
        onNavigateUp()
        navController = setupBackButtonOnToolbar(this, R.id.fragment3)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }

    private fun setupBackButtonOnToolbar(activity: AppCompatActivity, container: Int): NavController {
        val navController = Navigation.findNavController(activity, container)
        NavigationUI.setupActionBarWithNavController(activity, navController)
        return navController
    }
}
