package io.evicuo.chefery.ingredient.attributes;

import io.evicuo.chefery.Chefery;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttributeManager {
    private final Chefery plugin;
    Map<String, Attribute> attributes = new HashMap<>();

    private final ConfigurationSection attributesSection;

    public AttributeManager(Chefery plugin) {
        this.plugin = plugin;
        attributesSection = plugin.attributesConfig.get().getConfigurationSection("attributes");
        loadAttributes();
    }
    public void loadAttributes() {

        if (attributesSection == null) {
            plugin.getLogger().warning("Attributes section is missing!");
            return;
        }

        for (String attrKey : attributesSection.getKeys(false)) {

            ConfigurationSection attrSection = attributesSection.getConfigurationSection(attrKey);
            if (attrSection == null) {
                plugin.getLogger().warning("Invalid attribute section: " + attrKey);
                continue;
            }

            List<AttributeEffectsObject> effects = new ArrayList<>();

            for (Map<?, ?> effectMap : attrSection.getMapList("effects")) {

                if (!effectMap.containsKey("type")) continue;

                String type = (String) effectMap.get("type");
                AttributeEffectsEnum attributeEffect = attributeEffectMatch(type);
                if (attributeEffect == null) continue;

                Number levelNum = (Number) effectMap.get("base_level");
                Number durationNum = (Number) effectMap.get("duration");

                int level = levelNum.intValue();
                float duration = durationNum.floatValue();

                effects.add(new AttributeEffectsObject(attributeEffect, level, duration));
            }

            attributes.put(attrKey, new Attribute(plugin, effects, attrKey.toUpperCase()));
        }

        // ** DEBUG ** //
        plugin.getLogger().info("Loaded attributes: " + attributes.size());
    }


    public AttributeEffectsEnum attributeEffectMatch(String attributeEffect){
        try {
            return AttributeEffectsEnum.valueOf(attributeEffect.toUpperCase());
        } catch (IllegalArgumentException e) {
            plugin.getLogger().warning("Invalid effect: " + attributeEffect);
            return null;
        }
    }

    public List<Attribute> getAttributeById(List<String> attributeIds){
        List<Attribute> appliedAttributes = new ArrayList<>();
        attributeIds.forEach(attributeId -> {
            if(attributes.containsKey(attributeId.toUpperCase())) {
                appliedAttributes.add(attributes.get(attributeId.toUpperCase()));
            }
        });
        return appliedAttributes;
        }


    public Attribute getAttributeById(String attributeId) {
        return attributes.get(attributeId.toUpperCase());
    }





}
