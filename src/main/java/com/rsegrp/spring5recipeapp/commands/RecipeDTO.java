package com.rsegrp.spring5recipeapp.commands;

import com.rsegrp.spring5recipeapp.enums.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDTO {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<IngredientDTO> ingredients = new HashSet<>();
    private Byte[] image;
    private Difficulty difficulty;
    private NotesDTO notes;
    private Set<CategoryDTO> categories = new HashSet<>();
}