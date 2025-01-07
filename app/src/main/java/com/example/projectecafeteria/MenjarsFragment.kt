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
import androidx.navigation.fragment.findNavController
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


        val menjarsNoms = ProductesProvider.menjars.map { it.nom }
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, menjarsNoms)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerMenjars.adapter = adapter

        binding.spinnerMenjars.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val price = viewModel.getSelectedItemPrice(position)
                binding.textView.text = price
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                binding.textView.text = "0€"
            }
        }

        binding.button.setOnClickListener {


            if (binding.editTextQuantitatBeguda.text.isNotEmpty()) {
                sharedViewModel.setMenjar(MenuModel(ProductesProvider.menjars[binding.spinnerMenjars.selectedItemPosition].nom, binding.editTextQuantitatBeguda.text.toString().toInt(),ProductesProvider.menjars[binding.spinnerMenjars.selectedItemPosition].preu ))
                findNavController().navigate(R.id.action_menjarsFragment_to_begudesFragment, null)

            }
        }

        return binding.root
    }
}