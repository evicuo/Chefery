package io.evicuo.chefery.ingredient.attributes;

public class AttributeEffectsObject {
    public AttributeEffectsEnum getAttributeEffect() {
        return attributeEffect;
    }

    public int getLevel() {
        return level;
    }

    public float getDuration() {
        return duration;
    }

    private final AttributeEffectsEnum attributeEffect;
    private int level;
    private float duration;

    public AttributeEffectsObject(AttributeEffectsEnum attributeEffect, int level, float duration) {
        this.attributeEffect = attributeEffect;
        this.level = level;
        this.duration = duration;
    }
}
