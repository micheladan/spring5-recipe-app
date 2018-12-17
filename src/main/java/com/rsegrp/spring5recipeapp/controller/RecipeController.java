package com.rsegrp.spring5recipeapp.controller;

import com.rsegrp.spring5recipeapp.commands.RecipeDTO;
import com.rsegrp.spring5recipeapp.exceptions.NotFoundException;
import com.rsegrp.spring5recipeapp.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("exception", exception);
        modelAndView.setViewName("404ErrorPage");

        return modelAndView;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleBadNumberFormat(Exception exception){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("exception", exception);
        modelAndView.setViewName("404ErrorPage");

        return modelAndView;
    }

}