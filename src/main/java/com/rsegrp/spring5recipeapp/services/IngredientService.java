package com.rsegrp.spring5recipeapp.services;

import com.rsegrp.spring5recipeapp.commands.IngredientDTO;

public interface IngredientService {

    IngredientDTO findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientDTO saveIngredientDTO(IngredientDTO ingredientDTO );

    void deleteByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
