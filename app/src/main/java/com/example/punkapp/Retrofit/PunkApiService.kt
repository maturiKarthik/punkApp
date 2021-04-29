package com.example.punkapp.Retrofit

import com.example.punkapp.model.PunKData
import retrofit2.Call
import retrofit2.http.GET

interface PunkApiService {
    @GET("beers")
    fun getAllBeers(): Call<List<PunKData>>
}