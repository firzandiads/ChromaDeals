package com.example.schedio.Login.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.schedio.AppRepository
import com.example.schedio.data.local.AppDatabase
import com.example.schedio.data.local.UserEntity

class RegisterViewModel(application: Application): AndroidViewModel(application) {
    private val appRepository: AppRepository
    private val appDatabase: AppDatabase

    init {
        appDatabase = AppDatabase.getInstance(application)!!
        appRepository = AppRepository(appDatabase)
    }

    suspend fun insertUser(userEntity: UserEntity){
        appRepository.insertUser(userEntity)
    }
}