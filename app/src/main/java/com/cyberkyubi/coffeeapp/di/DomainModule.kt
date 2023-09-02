package com.cyberkyubi.coffeeapp.di

import org.koin.dsl.module

import com.cyberkyubi.domain.usecase.GetBeverageMenuUseCase
import com.cyberkyubi.domain.usecase.GetCategoriesUseCase
import com.cyberkyubi.domain.usecase.GetDrinkMenuByIdUseCase
import com.cyberkyubi.domain.usecase.GetFoodMenuByIdUseCase
import com.cyberkyubi.domain.usecase.GetFoodMenuUseCase
import com.cyberkyubi.domain.usecase.GetMenuDetailsUseCase

val domainModule = module {

    // MainViewModel
    factory { GetCategoriesUseCase(coffeeRepository = get()) }
    factory { GetBeverageMenuUseCase(coffeeRepository = get()) }
    factory { GetFoodMenuUseCase(coffeeRepository = get()) }

    // Menu
    factory { GetMenuDetailsUseCase(coffeeRepository = get()) }

    // DrinksViewModel
    factory { GetDrinkMenuByIdUseCase(coffeeRepository = get()) }


    factory { GetFoodMenuByIdUseCase(coffeeRepository = get()) }


}