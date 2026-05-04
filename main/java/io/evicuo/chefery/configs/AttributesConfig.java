package io.evicuo.chefery.configs;

import io.evicuo.chefery.Chefery;
import io.evicuo.chefery.util.CustomConfig;

public class AttributesConfig extends CustomConfig{

    public AttributesConfig() {
        super(Chefery.getInstance(), "attributes.yml");
    }
}
