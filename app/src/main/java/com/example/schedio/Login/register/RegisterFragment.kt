package com.example.schedio.Login.register

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.schedio.Login.Login
import com.example.schedio.R
import com.example.schedio.data.local.UserEntity
import com.example.schedio.databinding.ActivityRegisterBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class RegisterFragment : Fragment() {
    private var _binding: ActivityRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityRegisterBinding.inflate(inflater, container, false)
        viewModel = RegisterViewModel(application = requireActivity().application)


        binding.register.setOnClickListener{
            val username = binding.username.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val user = UserEntity(0,username,email,password)
            CoroutineScope(viewModel.viewModelScope.coroutineContext).launch {
                viewModel.insertUser(user)
            }

            val intent = Intent(requireContext(), Login::class.java)
            startActivity(intent)
        }

        return binding.root
    }



}