package com.cyberkyubi.coffeeapp.di

import com.cyberkyubi.domain.usecase.AddNewCategoriesUseCase
import com.cyberkyubi.domain.usecase.AddNewMenu
import org.koin.dsl.module

import com.cyberkyubi.domain.usecase.GetBeveragesMenuUseCase
import com.cyberkyubi.domain.usecase.GetCategoriesUseCase
import com.cyberkyubi.domain.usecase.GetFoodMenuUseCase

val domainModule = module {

    factory {
        GetCategoriesUseCase(
            coffeeRepository = get()
        )
    }

    factory {
        AddNewCategoriesUseCase(
            coffeeRepository = get()
        )
    }
    factory {
        AddNewMenu(
            coffeeRepository = get()
        )
    }

    factory {
       GetBeveragesMenuUseCase(
           coffeeRepository = get()
       )
    }

    factory {
        GetFoodMenuUseCase(
            coffeeRepository = get()
        )
    }
}