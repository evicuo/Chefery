package io.evicuo.chefery.ingredient;

import io.evicuo.chefery.Chefery;
import io.evicuo.chefery.ingredient.attributes.Attribute;
import io.evicuo.chefery.util.ItemBuilder;
import io.evicuo.chefery.util.MiniMessageUtil;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class IngredientFactory {
    private final Chefery plugin;
    private final FileConfiguration ingredientsConfig;
    private List<ItemStack> ingredients;
    private MiniMessage mm = MiniMessageUtil.instance();

    NamespacedKey key;

    public IngredientFactory(Chefery plugin) {
        this.plugin = plugin;
        this.ingredientsConfig = this.plugin.ingredientsConfig.get();
        key = new NamespacedKey(plugin, "ingredient_id");
    }

    public List<ItemStack> buildAllIngredients() {
        List<ItemStack> ingredientList = new ArrayList<>();
        for(Ingredient ingredient : plugin.ingredientManager.getIngredients()) {
            Material material = Material.getMaterial(ingredient.getMaterialName());
            ItemStack item = new ItemBuilder(material)
                    .name(ingredient.getDisplayName())
                    .lore(ingredient.getDisplayLore())
                    .persistentData(key, PersistentDataType.STRING, ingredient.getId())
                    .build();
            ingredientList.add(item);

        }

        return ingredientList;
    }

    public ItemStack buildIngredientById(String id){
        Ingredient ingredient = plugin.ingredientManager.getIngredientById(id);
        if(ingredient == null) return null;

        Material material = Material.getMaterial(ingredient.getMaterialName());
        return new ItemBuilder(material)
                .name(ingredient.getDisplayName())
                .lore(ingredient.getDisplayLore())
                .persistentData(key, PersistentDataType.STRING, ingredient.getId())
                .build();
    }

    public ItemStack buildIngredientByObject(Ingredient ingredient){
        Material material = Material.getMaterial(ingredient.getMaterialName());
        return new ItemBuilder(material)
                .name(ingredient.getDisplayName())
                .lore(ingredient.getDisplayLore())
                .persistentData(key, PersistentDataType.STRING, ingredient.getId())
                .build();
    }



}

