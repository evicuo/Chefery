package io.evicuo.chefery.recipe;

import io.evicuo.chefery.dish.DishBase;
import io.evicuo.chefery.ingredient.Ingredient;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RecipeMatcher {
    List<Recipe> recipes = RecipeManager.recipes;
    DishBase dishBase;

    public Optional<DishBase> getDishBase(Map<Ingredient, Integer> inputIngredients) {

        for (Recipe recipe : recipes) {

            Map<Ingredient, Integer> requiredIngredients = recipe.requiredIngredients;

            boolean foundMatch = true; // local, reset per recipe

            for (Map.Entry<Ingredient, Integer> entry : requiredIngredients.entrySet()) {

                Ingredient ingredient = entry.getKey();
                int requiredAmount = entry.getValue();

                int inputAmount = inputIngredients.getOrDefault(ingredient, 0);

                if (inputAmount < requiredAmount) {
                    foundMatch = false;
                    break;
                }
            }


            if (foundMatch) {
                return Optional.of(recipe.dishBase);
            }
        }

        return Optional.empty();
    }

}
