package com.cyberkyubi.coffeeapp.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

import com.cyberkyubi.coffeeapp.presentation.viewmodel.MainViewModel
import com.cyberkyubi.coffeeapp.presentation.viewmodel.DrinksViewModel

val appModule = module {

    viewModel {
        MainViewModel(
            getCategoriesUseCase = get(),
            getBeverageMenuUseCase = get(),
            getFoodMenuUseCase = get()
        )
    }

    viewModel {
        DrinksViewModel(
            getDrinkMenuByIdUseCase = get()
        )
    }
}