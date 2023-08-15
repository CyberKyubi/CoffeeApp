package com.cyberkyubi.coffeeapp.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

import com.cyberkyubi.coffeeapp.presentation.MainViewModel

val appModule = module {

    viewModel {
        MainViewModel(
            addNewCategoriesUseCase = get(),
            addNewMenu = get(),

            getCategoriesUseCase = get(),
            getBeveragesMenuUseCase = get(),
            getFoodMenuUseCase = get()
        )
    }
}