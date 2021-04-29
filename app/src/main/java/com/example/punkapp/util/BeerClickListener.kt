package com.example.punkapp.util

import android.view.View

/**
 * Every time we click on Some
 * item in the ListView we can
 * get the Even in ViewModel to Which it subscribe
 */
interface BeerClickListener {

    fun onBeerClicked(view: View) // It must always take view as parameter
}