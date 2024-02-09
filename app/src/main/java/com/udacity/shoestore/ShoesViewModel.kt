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

    fun addShoe(shoe: Shoe?) {
        val emptyShoe = Shoe("Not provided","undefined","Not provided","Empty")
        _shoesList.value?.add(shoe ?: emptyShoe)
    }

}
