package com.example.projectecafeteria

import androidx.lifecycle.ViewModel

class MenjarsViewModel() : ViewModel() {
    fun getSelectedItemPrice(position: Int): String {
        val selectedItem = ProductesProvider.menjars[position]
        return selectedItem.preu.toString() + "€"
    }
}
