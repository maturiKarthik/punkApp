package com.example.punkapp.util

import android.content.Context
import com.example.punkapp.Retrofit.RetrofitHelper
import com.example.punkapp.Room.RoomDatabaseHelper

object Repository {
    lateinit var retrofitHelper: RetrofitHelper
    lateinit var roomDatabaseHelper: RoomDatabaseHelper
    lateinit var sharedPrefHelper: SharedPrefHelper

    fun plant(context: Context) {
        retrofitHelper = RetrofitHelper.invoke()
        roomDatabaseHelper = RoomDatabaseHelper.invoke(context)
        sharedPrefHelper = SharedPrefHelper.invoke(context)
    }
}