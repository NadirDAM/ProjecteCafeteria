package com.example.projectecafeteria

import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private var _menjarList = MutableLiveData<MutableList<MenuModel>>(mutableListOf())
    val menjarList: LiveData<MutableList<MenuModel>> = _menjarList

    private var _begudaList = MutableLiveData<MutableList<MenuModel>>(mutableListOf())
    val begudaList: LiveData<MutableList<MenuModel>> = _begudaList

    private var _postreList = MutableLiveData<MutableList<MenuModel>>(mutableListOf())
    val postreList: LiveData<MutableList<MenuModel>> = _postreList

    private val _total = MutableLiveData<Float>()
    val total: LiveData<Float> = _total


    fun updateTotal() {
        val totalMenjar = _menjarList.value?.sumByDouble { (it.preu * it.quantitat).toDouble() }?.toFloat() ?: 0f
        val totalBeguda = _begudaList.value?.sumByDouble { (it.preu * it.quantitat).toDouble() }?.toFloat() ?: 0f
        val totalPostre = _postreList.value?.sumByDouble { (it.preu * it.quantitat).toDouble() }?.toFloat() ?: 0f
        _total.value = totalMenjar + totalBeguda + totalPostre
    }

    fun addOrUpdateMenjar(menjar: MenuModel) {
        val currentMenjarList = _menjarList.value ?: mutableListOf()
        val existingMenjar = currentMenjarList.find { it.nom == menjar.nom }

        if (existingMenjar != null) {
            existingMenjar.quantitat += menjar.quantitat
        } else {
            currentMenjarList.add(menjar)
        }

        _menjarList.value = currentMenjarList
        updateTotal()
    }

    fun addOrUpdateBeguda(beguda: MenuModel) {
        val currentBegudaList = _begudaList.value ?: mutableListOf()
        val existingBeguda = currentBegudaList.find { it.nom == beguda.nom }

        if (existingBeguda != null) {
            existingBeguda.quantitat += beguda.quantitat
        } else {
            currentBegudaList.add(beguda)
        }

        _begudaList.value = currentBegudaList
        updateTotal()
    }

    fun addOrUpdatePostre(postre: MenuModel) {
        val currentPostreList = _postreList.value ?: mutableListOf()
        val existingPostre = currentPostreList.find { it.nom == postre.nom }

        if (existingPostre != null) {
            existingPostre.quantitat += postre.quantitat
        } else {
            currentPostreList.add(postre)
        }

        _postreList.value = currentPostreList
        updateTotal()
    }

    fun getMenjarList(): MutableList<MenuModel> {
        return _menjarList.value ?: mutableListOf()
    }

    fun getBegudaList(): MutableList<MenuModel> {
        return _begudaList.value ?: mutableListOf()
    }

    fun getPostreList(): MutableList<MenuModel> {
        return _postreList.value ?: mutableListOf()
    }
}
