package com.cyberkyubi.domain.usecase

import com.cyberkyubi.domain.model.MenuModel
import com.cyberkyubi.domain.repository.CoffeeRepository

class GetFoodMenuUseCase(private val coffeeRepository: CoffeeRepository) {

    suspend fun execute(categoryId: Int): List<MenuModel> {
        return coffeeRepository.getMenuByCategoryId(categoryId)
    }
}