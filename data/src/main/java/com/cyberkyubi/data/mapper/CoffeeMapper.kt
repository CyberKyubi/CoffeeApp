package com.cyberkyubi.data.mapper

import android.util.Log
import com.cyberkyubi.data.entity.lower_level.CategoriesEntity
import com.cyberkyubi.data.entity.lower_level.MenuDataModel
import com.cyberkyubi.data.entity.lower_level.MenuDetailsDataModel
import com.cyberkyubi.data.entity.middle_level.DrinkDataModel
import com.cyberkyubi.data.entity.middle_level.FoodsEntity
import com.cyberkyubi.domain.model.CategoriesModel
import com.cyberkyubi.domain.model.DrinkModel
import com.cyberkyubi.domain.model.FoodModel
import com.cyberkyubi.domain.model.MenuDetailsModel
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


    private fun mapMenuDataModelToMenuModel(dataModel: MenuDataModel) : MenuModel {
        return MenuModel(
            menuId = dataModel.menuId,
            categoryId = dataModel.categoryId,
            title = dataModel.title,
            isSeasonalSpecials = dataModel.isSeasonalSpecials,
            drawableResourceName = dataModel.drawableResourceName
        )
    }

    fun mapListMenuDataModelToListMenuModel(dataModelList: List<MenuDataModel>) : List<MenuModel> {
        return dataModelList.map { mapMenuDataModelToMenuModel(it) }
    }

    fun mapMenuDetailsDataModelToMenuDetailsModel(dataModel: MenuDetailsDataModel) : MenuDetailsModel {
        return MenuDetailsModel(
            menuId = dataModel.menuId,
            title = dataModel.title,
            description = dataModel.description
        )
    }

    private fun mapDrinksEntityToDrinkModel(dataModel: DrinkDataModel) : DrinkModel {
        return DrinkModel(
            drinkId = dataModel.drinkId,
            name = dataModel.name,
            price = dataModel.price,
            drawableResourceName = dataModel.drawableResourceName,
            ingredients = dataModel.ingredientsId.split(", ").mapNotNull { it.toIntOrNull() },
        )
    }

    fun mapListDrinkDataModelToListDrinkModel(listDataModel: List<DrinkDataModel>) : List<DrinkModel> {
        return listDataModel.map { mapDrinksEntityToDrinkModel(it) }
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