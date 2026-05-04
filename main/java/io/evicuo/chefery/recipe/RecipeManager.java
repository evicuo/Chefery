package io.evicuo.chefery.recipe;

import io.evicuo.chefery.Chefery;
import io.evicuo.chefery.ingredient.Ingredient;
import io.evicuo.chefery.ingredient.IngredientManager;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeManager {

    public List<Recipe> recipes = new ArrayList<>();
    private final Chefery plugin;

    public RecipeManager(Chefery plugin) {
        this.plugin = plugin;
        loadRecipes();
    }

    public void loadRecipes() {
        for(String key : Chefery.getInstance().recipeConfig.get().getKeys(false)){ // for each recipe that exists
            ConfigurationSection section = Chefery.getInstance().recipeConfig.get().getConfigurationSection(key);
            String displayName = section.getString("name");

            List<String> recipeIngredientsId = section.getStringList("ingredients");

            List<Ingredient> globalIngredients = plugin.ingredientManager.getIngredients();

            Map<Ingredient, Integer> recipeIngredients = new HashMap<>();


            for(String ingredientId : recipeIngredientsId){ // for each ingredient in the recipe
                for(Ingredient ingredient : globalIngredients){ // for each ingredient that exists
                    if(ingredientId.equalsIgnoreCase(ingredient.getId())) {
                        if (recipeIngredients.containsKey(ingredient)) { // if the recipe already contains the ingredient
                            recipeIngredients.put(ingredient, recipeIngredients.get(ingredient) + 1); // add 1 to the amount of that ingredient in the recipe
                        } else {
                            recipeIngredients.put(ingredient, 1); // otherwise add the ingredient to the recipe with an amount of 1
                        }
                    }
                }
            }

            Recipe recipe = new Recipe(displayName, key, recipeIngredients);
            recipes.add(recipe);



        }
    }

    public Recipe getRecipeById(String id) {
        for(Recipe recipe : recipes) {
            if(recipe.getId().equalsIgnoreCase(id)) {
                return recipe;
            }
        }
        return null;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
