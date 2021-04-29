package com.example.punkapp.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.punkapp.model.PunKData

@Dao
interface PunkDao {

    @Query("SELECT * FROM punk_beer")
    suspend fun getAllBeers(): List<PunKData>

    @Insert
    suspend fun insertAllBeers(punkBeers: List<PunKData>)

    @Query("SELECT  * FROM punk_beer WHERE  id = :uid")
    suspend fun findById(uid: Int): PunKData

    @Query("DELETE FROM punk_beer")
    suspend fun deleteAll()
}