package com.example.weathers.di.appMoudle

import com.example.weathers.domain.repositiry.Repository
import com.example.weathers.presentation.viewModel.MainViewModel
import org.koin.dsl.module

val appModule= module {

    single {
        Repository(get())
    }

    single { MainViewModel(get()) }
}