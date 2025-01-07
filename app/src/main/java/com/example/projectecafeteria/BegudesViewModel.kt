package com.example.projectecafeteria

import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.ViewModel

class BegudesViewModel : ViewModel() {

    fun getSelectedItemPrice(position: Int): String {
        val selectedItem = ProductesProvider.begudes[position]
        return selectedItem.preu.toString() + "€"
    }

}