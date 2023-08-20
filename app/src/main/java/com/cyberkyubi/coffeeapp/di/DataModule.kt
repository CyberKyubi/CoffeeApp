package com.cyberkyubi.coffeeapp.di

import androidx.room.Room
import org.koin.dsl.module

import com.cyberkyubi.data.database.CoffeeDatabase
import com.cyberkyubi.data.repository.CoffeeRepositoryImpl
import com.cyberkyubi.domain.repository.CoffeeRepository

val dataModule = module {

    single {
        Room.databaseBuilder(get(), CoffeeDatabase::class.java, "coffee_app_01.db").build()
    }
    single {
        get<CoffeeDatabase>().getCoffeeDao()
    }

    single<CoffeeRepository> {
        CoffeeRepositoryImpl(
            coffeeDao = get()
        )
    }
}