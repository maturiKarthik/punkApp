package com.example.punkapp.ViewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.punkapp.model.PunKData
import com.example.punkapp.util.BaseViewModel
import com.example.punkapp.util.Repository
import kotlinx.coroutines.launch

class DetailFragmentViewModel(application: Application) : BaseViewModel(application) {

    val punkBeerData = MutableLiveData<PunKData>()

    fun onLoad(id: Int) {
        launch {
         punkBeerData.value =  Repository.roomDatabaseHelper.findById(id)
        }

    }
}