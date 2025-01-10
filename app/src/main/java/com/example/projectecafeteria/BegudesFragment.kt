package com.example.projectecafeteria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectecafeteria.databinding.FragmentBegudesBinding

class BegudesFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: BegudesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentBegudesBinding.inflate(inflater)

        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

        val adapter = CustomAdapter(ProductesProvider.begudes) { item, position ->
            sharedViewModel.addOrUpdateBeguda(MenuModel(ProductesProvider.begudes[position].nom, 1,ProductesProvider.begudes[position].preu ))
            Toast.makeText(requireContext(), "Producte: ${item.nom}, Preu: ${item.preu}", Toast.LENGTH_SHORT).show()
        }
        binding.recyclerview.adapter = adapter

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_begudesFragment_to_postresFragment, null)
        }

        return binding.root
    }
}