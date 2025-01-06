package com.example.projectecafeteria

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private var _menjar = MutableLiveData<MenuModel>()
    val menjar: LiveData<MenuModel> = _menjar

    private var _beguda = MutableLiveData<MenuModel>()
    val beguda: LiveData<MenuModel> = _beguda

    private var _postre = MutableLiveData<MenuModel>()
    val postre: LiveData<MenuModel> = _postre

    private val _total = MutableLiveData<Float>()
    val total: LiveData<Float> = _total

    fun updateTotal() {
        val totalMenjar = _menjar.value?.preu?.times(_menjar.value?.quantitat ?: 0) ?: 0f
        val totalBeguda = _beguda.value?.preu?.times(_beguda.value?.quantitat ?: 0) ?: 0f
        val totalPostre = _postre.value?.preu?.times(_postre.value?.quantitat ?: 0) ?: 0f
        _total.value = totalMenjar + totalBeguda + totalPostre
    }

    fun setMenjar(menjar: MenuModel) {
        _menjar.value = menjar
        updateTotal()
    }

    fun setBeguda(beguda: MenuModel) {
        _beguda.value = beguda
        updateTotal()
    }

    fun setPostre(postre: MenuModel) {
        _postre.value = postre
        updateTotal()
    }
}
