package io.evicuo.chefery.ingredient;

import io.evicuo.chefery.Chefery;
import io.evicuo.chefery.ingredient.attributes.Attribute;
import io.evicuo.chefery.ingredient.attributes.AttributeManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.ArrayList;
import java.util.List;

public class IngredientManager {

    private final Chefery plugin;
    private List<Ingredient> ingredients;

    public IngredientManager(Chefery plugin) {
        this.plugin = plugin;
        ingredients = new ArrayList<>();
        loadIngredients();
    }

    public void loadIngredients() {
        FileConfiguration config = Chefery.getInstance().ingredientsConfig.get();
        for(String key : config.getConfigurationSection("ingredients").getKeys(false)) {
            String name = config.getString("ingredients." + key + ".display_name");
            String materialName = config.getString("ingredients." + key + ".material");
            String category = config.getString("ingredients." + key + ".category");
            List<String> lore = config.getStringList("ingredients." + key + ".display_lore");
            List<String> attributeNames = config.getStringList("ingredients." + key + ".attributes");


            List<Attribute> attributes = plugin.attributeManager.getAttributeById(attributeNames);

            Ingredient ingredient = new Ingredient(key, name, lore, category, attributes, materialName);
            ingredients.add(ingredient);
        }

        // DEBUG //
        plugin.getLogger().info("Loaded ingredients: " + ingredients.size());

    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Ingredient getIngredientById(String id) {
        for(Ingredient ingredient : ingredients) {
            if(ingredient.getId().equals(id)) {
                return ingredient;
            }
        }
        return null;
    }
}
