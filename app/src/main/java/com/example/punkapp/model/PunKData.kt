package com.example.punkapp.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "punk_beer")
data class PunKData(
    val id: Int?,
    val name: String?,
    val first_brewed: String?,
    val description: String?,
    val image_url: String,
    val abv: Float,
    val ibu: Float,
    val targer_fg: Long,
    val target_og: Double,
    val ebc: Float,
    val srm: Float,
    val ph: Float,
    val attenuation_level: Float
) {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var uid: Int = 0
}