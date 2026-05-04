package io.evicuo.chefery.ingredient.attributes;

import java.util.List;

public class Attribute {
    private final List<AttributeEffectsObject> attributeEffects;
    private final String attributeId;

    public List<AttributeEffectsObject> getAttributeEffects() {
        return attributeEffects;
    }

    public String getAttributeId() {
        return attributeId;
    }


    public Attribute(List<AttributeEffectsObject> attributeEffects, String attributeId) {
        this.attributeEffects = attributeEffects;
        this.attributeId = attributeId;
    }
}
