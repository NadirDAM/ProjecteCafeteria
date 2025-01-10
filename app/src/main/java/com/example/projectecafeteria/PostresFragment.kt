package com.example.projectecafeteria

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectecafeteria.databinding.FragmentPostresBinding

class PostresFragment : Fragment() {


    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: PostresViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentPostresBinding.inflate(inflater)


        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

        val adapter = CustomAdapter(ProductesProvider.postres) { item, position ->
            sharedViewModel.addOrUpdatePostre(MenuModel(ProductesProvider.postres[position].nom, 1,ProductesProvider.postres[position].preu ))
            Toast.makeText(requireContext(), "Producte: ${item.nom}, Preu: ${item.preu}", Toast.LENGTH_SHORT).show()
        }
        binding.recyclerview.adapter = adapter

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_postresFragment_to_pagamentFragment, null)
        }

        return binding.root
    }
}