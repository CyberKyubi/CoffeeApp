package com.cyberkyubi.domain.usecase

import com.cyberkyubi.domain.model.DrinkModel
import com.cyberkyubi.domain.repository.CoffeeRepository

class GetDrinksListByMenuIdUseCase(private val coffeeRepository: CoffeeRepository) {

    suspend fun execute(menuId: Int): List<DrinkModel> {
        return coffeeRepository.getDrinksListByMenuId(menuId = menuId)
    }
}
