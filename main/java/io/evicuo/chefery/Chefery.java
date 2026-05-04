package io.evicuo.chefery;

import io.evicuo.chefery.configs.AttributesConfig;
import io.evicuo.chefery.configs.IngredientsConfig;
import io.evicuo.chefery.configs.RecipeConfig;
import io.evicuo.chefery.ingredient.IngredientManager;
import io.evicuo.chefery.ingredient.attributes.AttributeManager;
import io.evicuo.chefery.recipe.RecipeManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Chefery extends JavaPlugin {

    public static Chefery plugin;

    public RecipeConfig recipeConfig;
    public IngredientsConfig ingredientsConfig;
    public AttributesConfig attributesConfig;

    public IngredientManager ingredientManager;
    public RecipeManager recipeManager;
    public AttributeManager attributeManager;

    public static Chefery getInstance() {
        return plugin;
    }

    @Override
    public void onEnable() {
        recipeConfig = new RecipeConfig(plugin);
        ingredientsConfig = new IngredientsConfig(plugin);
        attributesConfig = new AttributesConfig();

        ingredientManager = new IngredientManager(plugin);
        recipeManager = new RecipeManager(plugin);
        attributeManager = new AttributeManager();


    }

    @Override
    public void onDisable() {
        recipeConfig.save();
    }
}
