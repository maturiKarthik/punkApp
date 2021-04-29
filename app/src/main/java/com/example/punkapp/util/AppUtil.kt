package com.example.punkapp.util

import android.content.Context
import com.example.punkapp.Retrofit.RetrofitHelper

object AppUtil {
    lateinit var retrofitHelper: RetrofitHelper

    fun plant(context: Context) {
        retrofitHelper = RetrofitHelper.invoke()
    }


}