/*
package com.example.schedio.UI.register

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.schedio.UI.login.LoginFragment
import com.example.schedio.data.local.UserEntity
import com.example.schedio.databinding.ActivityRegisterBinding
import org.koin.android.ext.android.inject


class RegisterFragment : AppCompatActivity() {
    private var _binding: ActivityRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RegisterViewModel by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityRegisterBinding.inflate(inflater, container, false)
        init()
        observeData()

*/
/*
        viewModel = RegisterViewModel(application = requireActivity().application)
*//*



*/
/*
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
*//*


        return binding.root
    }

    private fun observeData() {
        with(viewModel){
            observeIsRegister().observe(viewLifecycleOwner){
                it.let{ data ->
                    if(data){
                        */
/*findNavController().navigate(R.id.action_registerActivity_to_loginActivity)*//*

                        val intent = Intent(requireContext(), LoginFragment::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(requireContext(), "Email Sudah Terdaftar", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }


    }
    private fun init() {
        binding.register.setOnClickListener {
            val username = binding.username.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val user = UserEntity(0, username, email, password)
            viewModel.insertUser(user)

        }

    }


}*/
