package com.example.schedio

import com.example.schedio.data.local.AppDatabase
import com.example.schedio.data.local.LocalRepository
import com.example.schedio.data.local.UserEntity
import com.example.schedio.data.remote.RemoteRepository

class AppRepository(private val localRepository: LocalRepository, private val remoteRepository: RemoteRepository) {
    suspend fun insertUser(userEntity: UserEntity) {
        localRepository.insertUser(userEntity)

    }

    suspend fun getUser(email: String, password: String): UserEntity{
        return localRepository.getUser(email, password)
    }
}