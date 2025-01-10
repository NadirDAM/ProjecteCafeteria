package com.example.projectecafeteria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectecafeteria.databinding.FragmentPagamentBinding

class PagamentFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPagamentBinding.inflate(inflater)

        binding.recyclerViewMenjars.layoutManager = LinearLayoutManager(requireContext())
        val menjarAdapter = CustomAdapterMenu(sharedViewModel.menjarList.value ?: mutableListOf()) { item ->}
        binding.recyclerViewMenjars.adapter = menjarAdapter

        binding.recyclerViewBegudes.layoutManager = LinearLayoutManager(requireContext())
        val begudaAdapter = CustomAdapterMenu(sharedViewModel.begudaList.value ?: mutableListOf()) { item -> }
        binding.recyclerViewBegudes.adapter = begudaAdapter

        binding.recyclerViewPostres.layoutManager = LinearLayoutManager(requireContext())
        val postreAdapter = CustomAdapterMenu(sharedViewModel.postreList.value ?: mutableListOf()) { item -> }
        binding.recyclerViewPostres.adapter = postreAdapter

        sharedViewModel.menjarList.observe(viewLifecycleOwner) { list ->
            if (list.isNotEmpty()) {
                menjarAdapter.mList = list.toMutableList()
                menjarAdapter.notifyDataSetChanged()
            } else {
            }
        }

        sharedViewModel.begudaList.observe(viewLifecycleOwner) { list ->
            if (list.isNotEmpty()) {
                begudaAdapter.mList = list.toMutableList()
                begudaAdapter.notifyDataSetChanged()
            }
        }

        sharedViewModel.postreList.observe(viewLifecycleOwner) { list ->
            if (list.isNotEmpty()) {
                postreAdapter.mList = list.toMutableList()
                postreAdapter.notifyDataSetChanged()
            }
        }

        sharedViewModel.total.observe(viewLifecycleOwner) { total ->
            binding.totalPrice.text = "$total€"
        }

        return binding.root
    }
}
