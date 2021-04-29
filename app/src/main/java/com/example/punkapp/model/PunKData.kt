package com.example.punkapp.model

import com.google.gson.annotations.SerializedName

data class PunKData(
    val id: Int?,
    val name: String?,
    @SerializedName("first_brewed")
    val originDate: String?,
    val description: String?,
    val image_url: String,
    val abv: Float,
    val ibu: Float,
    @SerializedName(" targer_fg")
    val fg: Long,
    val target_og: Double,
    val ebc: Float,
    val srm: Float,
    val ph: Float,
    val attenuation_level: Float
)