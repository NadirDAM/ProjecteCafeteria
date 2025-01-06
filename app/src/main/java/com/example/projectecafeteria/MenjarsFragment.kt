package com.example.projectecafeteria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.projectecafeteria.databinding.FragmentMenjarsBinding
import com.example.projectecafeteria.databinding.FragmentPostresBinding


class MenjarsFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentMenjarsBinding.inflate(inflater)


        val menjarsNoms = ProductesProvider.menjars.map { it.nom }
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, menjarsNoms)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerMenjars.adapter = adapter

        binding.button.setOnClickListener {


            if (binding.editTextQuantitatBeguda.text.isNotEmpty()) {
                sharedViewModel.setMenjar(MenuModel(ProductesProvider.menjars[binding.spinnerMenjars.selectedItemPosition].nom, binding.editTextQuantitatBeguda.text.toString().toInt(),ProductesProvider.menjars[binding.spinnerMenjars.selectedItemPosition].preu ))
                findNavController().navigate(R.id.action_menjarsFragment_to_begudesFragment, null)

            }
        }

        return binding.root
    }
}