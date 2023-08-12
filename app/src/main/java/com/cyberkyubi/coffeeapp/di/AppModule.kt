package com.cyberkyubi.coffeeapp.di

import com.cyberkyubi.coffeeapp.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(
            getBeveragesMenuUseCase = get(),
            getFoodMenuUseCase = get()
        )
    }
}