package com.example.projectecafeteria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.projectecafeteria.databinding.FragmentPagamentBinding
import com.example.projectecafeteria.databinding.FragmentPreuTotalBinding

class PreuTotalFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPreuTotalBinding.inflate(inflater)

        sharedViewModel.total.observe(viewLifecycleOwner) { item ->
            binding.textViewPreuTotal.text = "Total: ${item}€"
        }

        return binding.root
    }

}