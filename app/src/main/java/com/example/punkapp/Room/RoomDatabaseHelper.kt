package com.example.punkapp.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.punkapp.model.PunKData


@Database(entities = [PunKData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): PunkDao
}

class RoomDatabaseHelper {
    companion object {
        private var instance: RoomDatabaseHelper? = null
        private var punkDao: PunkDao? = null
        private val Lock = Any()

        operator fun invoke(context: Context): RoomDatabaseHelper = instance ?: synchronized(Lock) {
            instance ?: buildRoomDatabase(context).also {
                instance = it
            }
        }

        private fun buildRoomDatabase(context: Context): RoomDatabaseHelper {
            punkDao =
                Room.databaseBuilder(context, AppDatabase::class.java, "beer-db").build().userDao()
            return RoomDatabaseHelper()
        }

    }

    suspend fun insertAll(punkData: List<PunKData>) {
        punkDao?.insertAllBeers(punkData)
    }

    suspend fun deleteAll() {
        punkDao?.deleteAll()
    }

    suspend fun getAll(): List<PunKData>? {
        return punkDao?.getAllBeers()
    }
}