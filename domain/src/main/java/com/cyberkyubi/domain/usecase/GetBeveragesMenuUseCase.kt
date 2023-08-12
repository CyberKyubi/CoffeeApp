package com.cyberkyubi.domain.usecase

import com.cyberkyubi.domain.model.CardOfProductMenuModel

class GetBeveragesMenuUseCase {

    fun execute(): List<CardOfProductMenuModel> {
        return listOf(
            CardOfProductMenuModel(title = "Холодные"),
            CardOfProductMenuModel(title = "Горячие"),
            CardOfProductMenuModel(title = "Весна-Лето"),
        )
    }
}