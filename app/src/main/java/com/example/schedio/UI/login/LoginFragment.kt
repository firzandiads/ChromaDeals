/*
package com.example.schedio.UI.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.schedio.UI.register.RegisterFragment
import com.example.schedio.databinding.ActivityLoginBinding
import org.koin.android.ext.android.inject

class LoginFragment : AppCompatActivity() {
    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by inject()
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityLoginBinding.inflate(inflater, container, false)
        init()
        observeData()

*/
/*        binding.login.setOnClickListener{

        }

        binding.register.setOnClickListener{
            val intent = Intent(requireContext(), Register::class.java)
            startActivity(intent)
        }*//*


        return binding.root
    }

    private fun observeData() {
        with(viewModel){
            observeIsLogin().observe(requireActivity()){
                it.let{ data ->
                    if (data != null){
                        //findnaccontroler
                        val intent = Intent(requireContext(), RegisterFragment::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }

    private fun init() {
        with(binding){
            login.setOnClickListener{
                if(email.text.isNullOrBlank()){
                    email.error = "Email Kosong"
                }

                if(password.text.isNullOrBlank()){
                    password.error = "Password Kosong"
                }

                if(!email.text.isNullOrBlank() && !password.text.isNullOrBlank()){
                    viewModel.getDataLogin(email.text.toString(), password.text.toString())
                }
            }

            register.setOnClickListener{
                val intent = Intent(requireContext(), RegisterFragment::class.java)
                startActivity(intent)
            }
        }
    }



}*/
