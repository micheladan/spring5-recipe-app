package com.rsegrp.spring5recipeapp.services;

import com.rsegrp.spring5recipeapp.commands.RecipeDTO;
import com.rsegrp.spring5recipeapp.converters.RecipeDTOToEntity;
import com.rsegrp.spring5recipeapp.converters.RecipeEntityToDTO;
import com.rsegrp.spring5recipeapp.domain.Recipe;
import com.rsegrp.spring5recipeapp.repositories.RecipeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceIT {

    public static final String NEW_DESCRIPTION = "New Description";

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeDTOToEntity recipeDTOToEntity;

    @Autowired
    RecipeEntityToDTO recipeEntityToDTO;

    @Transactional
    @Test
    public void testSaveOfDescription() throws Exception {
        //given
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe testRecipe = recipes.iterator().next();
        RecipeDTO testRecipeDTO = recipeEntityToDTO.convert(testRecipe);

        //when
        testRecipeDTO.setDescription(NEW_DESCRIPTION);
        RecipeDTO savedRecipeDTO = recipeService.saveRecipeDTO(testRecipeDTO);

        //then
        assertEquals(NEW_DESCRIPTION, savedRecipeDTO.getDescription());
        assertEquals(testRecipe.getId(), savedRecipeDTO.getId());
        assertEquals(testRecipe.getCategories().size(), savedRecipeDTO.getCategories().size());
        assertEquals(testRecipe.getIngredients().size(), savedRecipeDTO.getIngredients().size());
    }
}