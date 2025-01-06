package com.example.projectecafeteria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.projectecafeteria.databinding.FragmentPagamentBinding

class PagamentFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPagamentBinding.inflate(inflater)

        sharedViewModel.menjar.observe(viewLifecycleOwner) { item ->
            binding.menjarName.text = item.nom
            binding.menjarQuantity.text = "x${item.quantitat}"
            binding.menjarPrice.text = "${item.preu * item.quantitat}€"
        }

        sharedViewModel.beguda.observe(viewLifecycleOwner) { item ->
            binding.begudaName.text = item.nom
            binding.begudaQuantity.text = "x${item.quantitat}"
            binding.begudaPrice.text = "${item.preu * item.quantitat}€"
        }

        sharedViewModel.postre.observe(viewLifecycleOwner) { item ->
            binding.postreName.text = item.nom
            binding.postreQuantity.text = "x${item.quantitat}"
            binding.postrePrice.text = "${item.preu * item.quantitat}€"
        }

        sharedViewModel.total.observe(viewLifecycleOwner) { total ->
            binding.totalPrice.text = "$total€"
        }



        return binding.root
    }
}
