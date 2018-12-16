package com.rsegrp.spring5recipeapp.controller;

import com.rsegrp.spring5recipeapp.commands.RecipeDTO;
import com.rsegrp.spring5recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";
    }


    @GetMapping("/add")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeDTO());
        return "recipe/recipeform";
    }

    @PostMapping(value = "/update")
    public String saveOrUpdate(@ModelAttribute RecipeDTO recipeDTO){
        RecipeDTO savedRecipe = recipeService.saveRecipeDTO(recipeDTO);

        return "redirect:/recipe/"+savedRecipe.getId()+"/show";
    }

    @GetMapping("/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model)
    {
        model.addAttribute("recipe", recipeService.findByIdDTO(Long.valueOf(id)));
        return "recipe/recipeform";
    }

}