package com.udacity.shoestore;

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.udacity.shoestore.models.Shoe

class ShoesViewModel : ViewModel() {

    private var _shoesList = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList

    fun addShoe(shoe: Shoe) {
        Log.d("ShoesViewModel", "Called addShoes")
        Log.d("ShoesViewModel - shoesList", shoesList.value.toString())
        _shoesList.value?.add(shoe)
        //_shoesList.value = list
        Log.d("ShoesViewModel", "Shoes list updated: ${_shoesList.value}")
    }
}
