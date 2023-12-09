package com.example.schedio.UI.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schedio.AppRepository
import com.example.schedio.data.local.UserEntity
import kotlinx.coroutines.launch

class LoginViewModel(private val appRepository: AppRepository): ViewModel(){

    private val isLogin = MutableLiveData<UserEntity>()
    fun observeIsLogin(): LiveData<UserEntity> = isLogin

    fun getDataLogin(email: String, password: String){
        viewModelScope.launch {
            when(val result = appRepository.getUser(email, password)){
                is UserEntity -> {
                    isLogin.postValue(result)
                }
            }
        }
    }



}