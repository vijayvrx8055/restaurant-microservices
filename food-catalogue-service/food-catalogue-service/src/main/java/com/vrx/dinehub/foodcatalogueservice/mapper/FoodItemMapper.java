package com.vrx.dinehub.foodcatalogueservice.mapper;

import com.vrx.dinehub.foodcatalogueservice.dto.FoodItemDto;
import com.vrx.dinehub.foodcatalogueservice.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper MAPPER = Mappers.getMapper(FoodItemMapper.class);

    FoodItemDto mapFoodItemToFoodItemDto(FoodItem foodItem);
    FoodItem mapFoodItemDtoToFoodItem(FoodItemDto foodItemDto);
}
