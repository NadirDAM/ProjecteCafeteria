package com.example.projectecafeteria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.projectecafeteria.databinding.FragmentBegudesBinding

class BegudesFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: BegudesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentBegudesBinding.inflate(inflater)


        val begudesNoms = ProductesProvider.begudes.map { it.nom }
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, begudesNoms)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerBegudes.adapter = adapter

        binding.spinnerBegudes.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val price = viewModel.getSelectedItemPrice(position)
                binding.textView.text = price
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                binding.textView.text = "0€"
            }
        }
        binding.button.setOnClickListener {


            if (binding.editTextQuantitatBegudes.text.isNotEmpty()) {
                sharedViewModel.setBeguda(MenuModel(ProductesProvider.begudes[binding.spinnerBegudes.selectedItemPosition].nom, binding.editTextQuantitatBegudes.text.toString().toInt(),ProductesProvider.begudes[binding.spinnerBegudes.selectedItemPosition].preu ))
                findNavController().navigate(R.id.action_begudesFragment_to_postresFragment, null)

            }
        }

        return binding.root
    }
}