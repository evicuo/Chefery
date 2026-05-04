package io.evicuo.chefery.recipe;

import io.evicuo.chefery.dish.DishBase;
import io.evicuo.chefery.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipe {
    String name;
    String id;
    Map<Ingredient, Integer> requiredIngredients = new HashMap<Ingredient, Integer>();
    DishBase dishBase;

    public Recipe(String name, String id, Map<Ingredient, Integer> requiredIngredients) {
        this.name = name;
        this.id = id;
        this.requiredIngredients = requiredIngredients;
    }


    public String getId() {
        return id;
    }
}
