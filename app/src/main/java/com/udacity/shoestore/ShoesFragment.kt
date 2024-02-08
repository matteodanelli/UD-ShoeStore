package com.udacity.shoestore

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeBinding
import com.udacity.shoestore.databinding.FragmentShoesBinding
import com.udacity.shoestore.databinding.FragmentShoesListItemBinding
import com.udacity.shoestore.models.Shoe

class ShoesFragment : Fragment() {

    private lateinit var binding: FragmentShoesBinding
    private lateinit var currentViewModel: ShoesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setBackCallback()

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes, container, false)
        binding.floatingActionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoesFragment_to_shoeFragment))
        currentViewModel = ViewModelProvider(requireActivity())[ShoesViewModel::class.java]
        binding.viewModel = currentViewModel
        currentViewModel.shoesList.observe(viewLifecycleOwner) { shoesList ->
            Log.d("ShoesFragment", "Called observer")
            Log.d("ShoesFragment", shoesList.toString())
            initShoeList(shoesList)
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(R.id.action_shoesFragment_to_loginFragment)
        return super.onOptionsItemSelected(item)
    }

    private fun initShoeList(listShoes: MutableList<Shoe>) {
        val parentLayout = binding.shoeElementList

        var index = 0
        while (index < listShoes.size) {
            val shoeBinding: FragmentShoesListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoes_list_item, parentLayout, false)
            val shoe = listShoes[index]
            shoeBinding.nameListItem.text = shoe.name
            shoeBinding.companyListItem.text = shoe.company
            shoeBinding.sizeListItem.text = shoe.size.toString()
            shoeBinding.descriptionListItem.text = shoe.description
            parentLayout.addView(shoeBinding.root)
            index++
        }
    }

}