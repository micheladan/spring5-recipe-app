package com.rsegrp.spring5recipeapp.commands;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by jt on 6/21/17.
 */
@Setter
@Getter
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private String description;
}