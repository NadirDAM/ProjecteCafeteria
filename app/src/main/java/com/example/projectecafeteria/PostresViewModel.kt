package com.example.projectecafeteria

import androidx.lifecycle.ViewModel

class PostresViewModel : ViewModel() {

    fun getSelectedItemPrice(position: Int): String {
        val selectedItem = ProductesProvider.postres[position]
        return selectedItem.preu.toString() + "€"
    }
}