package com.example.schedio.Login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.schedio.R
import com.example.schedio.databinding.ActivityLoginBinding

class LoginFragment : Fragment() {
    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityLoginBinding.inflate(inflater, container, false)

        binding.login.setOnClickListener{

        }

        binding.register.setOnClickListener{
            val intent = Intent(requireContext(), Register::class.java)
            startActivity(intent)
        }

        return binding.root



    }



}