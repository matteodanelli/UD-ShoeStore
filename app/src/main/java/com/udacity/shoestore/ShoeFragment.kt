package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeBinding
import com.udacity.shoestore.models.Shoe

class ShoeFragment : Fragment() {

    private lateinit var currentViewModel: ShoesViewModel
    private lateinit var binding: FragmentShoeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe, container, false)
        currentViewModel = ViewModelProvider(requireActivity())[ShoesViewModel::class.java]

        binding.viewmodel = currentViewModel
        binding.shoe = Shoe("","","","")
        binding.cancelButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeFragment_to_shoesFragment))
        binding.saveButton.setOnClickListener {
            val newShoe = binding.shoe
            currentViewModel.addShoe(newShoe)
            findNavController(it).navigate(R.id.action_shoeFragment_to_shoesFragment)

        }
        return binding.root
    }

}