package com.example.schedio

import com.example.schedio.data.local.AppDatabase
import com.example.schedio.data.local.UserEntity

class AppRepository(private val appDatabase: AppDatabase) {
    suspend fun insertUser(user: UserEntity) {
        appDatabase.userDao().insertUser(user)

    }
}