package com.example.schedio.di

import com.example.schedio.UI.login.LoginViewModel
import com.example.schedio.UI.register.RegisterViewModel
import org.koin.dsl.module

val viewModelModule = module{
    single { LoginViewModel(get()) }
    single { RegisterViewModel(get()) }
}