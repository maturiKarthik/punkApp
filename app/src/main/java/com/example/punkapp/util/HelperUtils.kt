package com.example.punkapp.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide


private fun progressDrawable(context: Context): CircularProgressDrawable {
    val circularProgressDrawable = CircularProgressDrawable(context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()
    return circularProgressDrawable
}

fun ImageView.loadUrl(view: ImageView, url: String) {
    val context = view.context
    Glide.with(context).load(url).placeholder(progressDrawable(context)).into(view)

}