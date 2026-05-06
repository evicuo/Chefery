package io.evicuo.chefery.ingredient.attributes;

import io.evicuo.chefery.Chefery;
import org.bukkit.NamespacedKey;

import java.util.List;

public class Attribute {
    private final List<AttributeEffectsObject> attributeEffects;
    private final String attributeId;
    private final NamespacedKey key;
    private final Chefery plugin;

    public List<AttributeEffectsObject> getAttributeEffects() {
        return attributeEffects;
    }

    public String getAttributeId() {
        return attributeId;
    }

    public NamespacedKey getKey() {
        return key;
    }


    public Attribute(Chefery plugin, List<AttributeEffectsObject> attributeEffects, String attributeId) {
        this.attributeEffects = attributeEffects;
        this.attributeId = attributeId;
        this.plugin = plugin;
        this.key = new NamespacedKey(plugin, attributeId);

    }
}
