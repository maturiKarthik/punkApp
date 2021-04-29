package com.example.punkapp.ViewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.punkapp.model.PunKData
import com.example.punkapp.util.BaseViewModel
import com.example.punkapp.util.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListFragmentViewModel(application: Application) : BaseViewModel(application) {

    val loadingData = MutableLiveData<Boolean>()
    val listOfData = MutableLiveData<List<PunKData>>()
    val errorMessage = MutableLiveData<Boolean>()

    fun refresh() {
        //loadDataFromServer()
        loadDataFromDb()
    }

    private fun loadDataFromServer() {
        Repository.retrofitHelper.getAllBeersList()?.enqueue(object : Callback<List<PunKData>> {
            override fun onFailure(call: Call<List<PunKData>>, t: Throwable) {
                loadingData.value = false
                errorMessage.value = true
                Log.e("error", t.toString())
            }

            override fun onResponse(
                call: Call<List<PunKData>>,
                response: Response<List<PunKData>>
            ) {
                insertInToDb(response.body()!!)
                listOfData.value = response.body()
                loadingData.value = false
                errorMessage.value = false
            }

        })
    }

    private fun insertInToDb(punk_beer: List<PunKData>) {
        launch {
            Repository.roomDatabaseHelper.deleteAll()
            Repository.roomDatabaseHelper.insertAll(punk_beer)
        }
    }

    private fun loadDataFromDb() {
        launch {
            listOfData.value = Repository.roomDatabaseHelper.getAll()
            loadingData.value = false
            errorMessage.value = false
            Toast.makeText(getApplication(), "Loading Form Db", Toast.LENGTH_SHORT).show()
        }
    }


}