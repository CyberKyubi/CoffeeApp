package com.cyberkyubi.coffeeapp.di

import com.cyberkyubi.domain.usecase.GetBeveragesMenuUseCase
import com.cyberkyubi.domain.usecase.GetFoodMenuUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetBeveragesMenuUseCase> {
       GetBeveragesMenuUseCase()
    }

    factory<GetFoodMenuUseCase> {
        GetFoodMenuUseCase()
    }
}