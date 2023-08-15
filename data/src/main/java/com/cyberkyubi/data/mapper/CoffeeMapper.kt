package com.cyberkyubi.data.mapper

import com.cyberkyubi.data.entity.lower_level.CategoriesEntity
import com.cyberkyubi.data.entity.lower_level.MenuEntity
import com.cyberkyubi.domain.model.CategoriesModel
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

    // add
    private fun mapCategoriesModelToCategoriesEntity(model: CategoriesModel) : CategoriesEntity {
        return CategoriesEntity(
            categoryId = model.categoryId,
            title = model.title
        )
    }
    fun mapListCategoriesModelToListCategoriesEntity(modelList: List<CategoriesModel>) : List<CategoriesEntity> {
        return modelList.map { mapCategoriesModelToCategoriesEntity(it) }
    }

    // add
    private fun mapMenuModelToMenuEntity(model: MenuModel) : MenuEntity {
        return MenuEntity(
            menuId = model.menuId,
            categoryId = model.categoryId,
            title = model.title,
            drawableResourceName = model.drawableResourceName
        )
    }

    fun mapListMenuModelToListMenuEntity(modelList: List<MenuModel>) : List<MenuEntity> {
        return modelList.map { mapMenuModelToMenuEntity(it) }
    }
}