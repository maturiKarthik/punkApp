package com.example.punkapp.Retrofit

import com.example.punkapp.model.PunKData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Singleton And Thread Protection
class RetrofitHelper {
    companion object {
        @Volatile
        private var instance: RetrofitHelper? = null
        private var punkApiService: PunkApiService? = null
        private const val BASE_URL = "https://api.punkapi.com/v2/"
        private val LOCK = Any()


        operator fun invoke(): RetrofitHelper = instance ?: synchronized(LOCK) {
            instance ?: buildRetrofit().also {
                instance = it
            }
        }


        private fun buildRetrofit(): RetrofitHelper {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            punkApiService = retrofit.create(PunkApiService::class.java)
            return RetrofitHelper()
        }
    }

    fun getAllBeersList(): Call<List<PunKData>>? {
        return punkApiService?.getAllBeers()
    }
}