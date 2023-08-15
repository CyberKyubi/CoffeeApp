package com.cyberkyubi.domain.usecase

import com.cyberkyubi.domain.model.CategoriesModel
import com.cyberkyubi.domain.repository.CoffeeRepository

class AddNewCategoriesUseCase(private val coffeeRepository: CoffeeRepository) {

    suspend fun execute(listCategories: List<CategoriesModel>) {
        coffeeRepository.insertAllCategories(listCategories)
    }
}