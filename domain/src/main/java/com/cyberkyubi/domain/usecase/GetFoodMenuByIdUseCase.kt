package com.cyberkyubi.domain.usecase

import com.cyberkyubi.domain.model.FoodModel
import com.cyberkyubi.domain.repository.CoffeeRepository

class GetFoodMenuByIdUseCase(private val coffeeRepository: CoffeeRepository) {

    suspend fun execute(menuId: Int) : List<FoodModel> {
        return coffeeRepository.getFoodMenuById(menuId = menuId)
    }
}