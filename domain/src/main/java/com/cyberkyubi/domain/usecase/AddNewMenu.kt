package com.cyberkyubi.domain.usecase

import com.cyberkyubi.domain.model.MenuModel
import com.cyberkyubi.domain.repository.CoffeeRepository

class AddNewMenu(private val coffeeRepository: CoffeeRepository) {

    suspend fun execute(listMenu: List<MenuModel>) {
        coffeeRepository.insertAllMenu(listMenu)
    }
}