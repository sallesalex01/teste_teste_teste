package com.example.albumdacopa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.albumdacopa.models.Figurinha

class CopaViewModel: ViewModel() {

    private  val _listaFigurinhas: MutableLiveData<List<Figurinha>> by lazy {
        MutableLiveData<List<Figurinha>>()
    }
    val listaFigurinhas: LiveData<List<Figurinha>> = _listaFigurinhas

    fun setListaFigurinha(value: List<Figurinha>){
        _listaFigurinhas.postValue(value)
    }


}