package com.example.projectecafeteria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectecafeteria.databinding.FragmentMenjarsBinding
import com.example.projectecafeteria.databinding.FragmentPostresBinding


class MenjarsFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: MenjarsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentMenjarsBinding.inflate(inflater)

        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

        val adapter = CustomAdapter(ProductesProvider.menjars) { item, position ->
            sharedViewModel.addOrUpdateMenjar(MenuModel(ProductesProvider.menjars[position].nom, 1,ProductesProvider.menjars[position].preu ))
            Toast.makeText(requireContext(), "Producte: ${item.nom}, Preu: ${item.preu}", Toast.LENGTH_SHORT).show()
        }
        binding.recyclerview.adapter = adapter

        binding.button.setOnClickListener {
                findNavController().navigate(R.id.action_menjarsFragment_to_begudesFragment, null)
        }



        return binding.root
    }
}