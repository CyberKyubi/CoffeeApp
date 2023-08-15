package com.cyberkyubi.domain.usecase

import com.cyberkyubi.domain.model.CategoriesModel
import com.cyberkyubi.domain.repository.CoffeeRepository

class GetCategoriesUseCase(private val coffeeRepository: CoffeeRepository) {

    suspend fun execute(): List<CategoriesModel> {
        return coffeeRepository.getCategories()
    }
}