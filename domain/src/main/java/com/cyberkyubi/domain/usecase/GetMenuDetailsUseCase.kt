package com.cyberkyubi.domain.usecase

import com.cyberkyubi.domain.model.MenuDetailsModel
import com.cyberkyubi.domain.repository.CoffeeRepository

class GetMenuDetailsUseCase(private val coffeeRepository: CoffeeRepository) {

    suspend fun execute(menuId: Int): MenuDetailsModel {
        return coffeeRepository.getMenuDetailsById(menuId = menuId)
    }
}