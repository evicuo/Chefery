package io.evicuo.chefery.ingredient.attributes;

public class AttributeEffectsObject {
    private final AttributeEffectsEnum attributeEffect;
    private final int level;
    private final float duration;

    public AttributeEffectsObject(AttributeEffectsEnum attributeEffect, int level, float duration) {
        this.attributeEffect = attributeEffect;
        this.level = level;
        this.duration = duration;
    }

    public AttributeEffectsEnum getAttributeEffect() {
        return attributeEffect;
    }

    public int getLevel() {
        return level;
    }

    public float getDuration() {
        return duration;
    }
}
