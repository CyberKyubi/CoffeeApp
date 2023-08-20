package com.cyberkyubi.data.mapper

import com.cyberkyubi.data.entity.lower_level.CategoriesEntity
import com.cyberkyubi.data.entity.lower_level.MenuEntity
import com.cyberkyubi.data.entity.middle_level.DrinksEntity
import com.cyberkyubi.data.entity.middle_level.FoodsEntity
import com.cyberkyubi.domain.model.CategoriesModel
import com.cyberkyubi.domain.model.DrinkModel
import com.cyberkyubi.domain.model.FoodModel
import com.cyberkyubi.domain.model.MenuModel

object CoffeeMapper {

    private fun mapCategoriesEntityToCategoriesModel(entity: CategoriesEntity) : CategoriesModel {
        return CategoriesModel(
            categoryId = entity.categoryId,
            title = entity.title
        )
    }
    fun mapListCategoriesEntityToListCategoriesModel(entityList: List<CategoriesEntity>) : List<CategoriesModel> {
        return entityList.map { mapCategoriesEntityToCategoriesModel(it) }
    }


    private fun mapMenuEntityToMenuModel(entity: MenuEntity) : MenuModel {
        return MenuModel(
            menuId = entity.menuId,
            categoryId = entity.categoryId,
            title = entity.title,
            drawableResourceName = entity.drawableResourceName
        )
    }

    fun mapListMenuEntityToListMenuModel(entityList: List<MenuEntity>) : List<MenuModel> {
        return entityList.map { mapMenuEntityToMenuModel(it) }
    }

    private fun mapDrinksEntityToDrinkModel(entity: DrinksEntity) : DrinkModel {
        return DrinkModel(
            drinkId = entity.drinkId,
            menuId = entity.menuId,
            name = entity.name,
            drawableResourceName = entity.drawableResourceName
        )
    }

    fun mapListDrinksEntityToListDrinkModel(entityList: List<DrinksEntity>) : List<DrinkModel> {
        return entityList.map { mapDrinksEntityToDrinkModel(it) }
    }

   private fun mapFoodsEntityToFoodModel(entity: FoodsEntity) : FoodModel {
        return FoodModel(
            foodId = entity.foodId,
            menuId = entity.menuId,
            name = entity.name,
            drawableResourceName = entity.drawableResourceName
        )
   }

    fun mapListFoodsEntityToListFoodModel(entityList: List<FoodsEntity>) : List<FoodModel> {
        return entityList.map { mapFoodsEntityToFoodModel(it) }
    }

}