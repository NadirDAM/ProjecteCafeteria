package com.example.projectecafeteria

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.projectecafeteria.databinding.FragmentPostresBinding

class PostresFragment : Fragment() {


    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: PostresViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentPostresBinding.inflate(inflater)


        val postresNoms = ProductesProvider.postres.map { it.nom }
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, postresNoms)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPostres.adapter = adapter

        binding.spinnerPostres.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val price = viewModel.getSelectedItemPrice(position)
                binding.textView.text = price
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                binding.textView.text = "0€"
            }
        }

        binding.button.setOnClickListener {


            if (binding.editTextQuantitatPostres.text.isNotEmpty()) {
                sharedViewModel.setPostre(MenuModel(ProductesProvider.postres[binding.spinnerPostres.selectedItemPosition].nom, binding.editTextQuantitatPostres.text.toString().toInt(),ProductesProvider.postres[binding.spinnerPostres.selectedItemPosition].preu ))
                findNavController().navigate(R.id.action_postresFragment_to_pagamentFragment, null)

            }
        }

        return binding.root
    }
}