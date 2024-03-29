package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.login.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment))
        binding.register.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment))
        return binding.root
    }

}