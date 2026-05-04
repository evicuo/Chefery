package io.evicuo.chefery.configs;

import io.evicuo.chefery.Chefery;
import io.evicuo.chefery.recipe.Recipe;
import io.evicuo.chefery.util.CustomConfig;

public class RecipeConfig extends CustomConfig {

    public RecipeConfig(Chefery plugin) {
        super(plugin,"recipes.yml");
    }
}

