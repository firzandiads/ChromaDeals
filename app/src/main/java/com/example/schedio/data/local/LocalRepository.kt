package com.example.schedio.data.local

class LocalRepository(private val appDatabase: AppDatabase) {

    suspend fun insertUser(userEntity: UserEntity){
        appDatabase.userDao().insertUser(userEntity)
    }

    suspend fun getUser(email: String, password: String): UserEntity {
        return appDatabase.userDao().getUser(email, password)
    }



}