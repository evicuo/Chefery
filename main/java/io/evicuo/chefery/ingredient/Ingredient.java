package io.evicuo.chefery.ingredient;

import io.evicuo.chefery.ingredient.attributes.Attribute;
import io.evicuo.chefery.ingredient.attributes.AttributeScalingEngine;

import java.util.List;

public class Ingredient {

    private final String id;
    private final String displayName;
    private final List<String> displayLore;
    private final String category;
    private final List<Attribute> attributes;
    private final String materialName;


    public Ingredient(String id, String displayName, List<String> displayLore, String category, List<Attribute> attributes, String materialName) {
        this.id = id;
        this.displayName = displayName;
        this.displayLore = displayLore;
        this.category = category;
        this.attributes = attributes;
        this.materialName = materialName;
    }

    public String getId() {
        return id;
    }

    public List<String> getDisplayLore() {
        return displayLore;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getCategory() {
        return category;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public String getMaterialName() {
        return materialName;
    }
}
