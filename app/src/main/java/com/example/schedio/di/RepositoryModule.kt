package com.example.schedio.di

import com.example.schedio.AppRepository
import com.example.schedio.data.local.LocalRepository
import com.example.schedio.data.remote.RemoteRepository
import org.koin.dsl.module

val RepositoryModule = module {
    single { LocalRepository(get()) }
    single { RemoteRepository(get()) }
    single { AppRepository(get(), get()) }
}