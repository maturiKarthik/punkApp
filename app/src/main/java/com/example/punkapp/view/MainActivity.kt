package com.example.punkapp.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.punkapp.R
import com.example.punkapp.model.PunKData
import com.example.punkapp.util.AppUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppUtil.plant(applicationContext)
        // Test ApiService
        AppUtil.retrofitHelper.getAllBeersList().let {
            it?.enqueue(object : Callback<List<PunKData>> {
                override fun onFailure(call: Call<List<PunKData>>, t: Throwable) {
                    Log.e("TAG", "Faliure $t")

                }

                override fun onResponse(
                    call: Call<List<PunKData>>,
                    response: Response<List<PunKData>>
                ) {
                    Log.e("TAG", "${response.body()}")
                }
            })
        }
    }
}