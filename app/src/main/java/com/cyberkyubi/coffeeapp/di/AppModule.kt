package com.cyberkyubi.coffeeapp.di

import com.cyberkyubi.coffeeapp.manager.IconManager
import com.cyberkyubi.coffeeapp.presentation.viewmodel.DrinkDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

import com.cyberkyubi.coffeeapp.presentation.viewmodel.MainViewModel
import com.cyberkyubi.coffeeapp.presentation.viewmodel.DrinksListViewModel

val appModule = module {

    single { IconManager() }

    viewModel {
        MainViewModel(
            getCategoriesUseCase = get(),
            getBeverageMenuUseCase = get(),
            getFoodMenuUseCase = get()
        )
    }

    viewModel {
        DrinksListViewModel(
            iconManager = get(),
            getMenuDetailsUseCase = get(),
            getDrinksListByMenuIdUseCase = get()
        )
    }

    viewModel {
        DrinkDetailsViewModel(

        )
    }

}