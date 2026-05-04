package io.evicuo.chefery.configs;

import io.evicuo.chefery.Chefery;
import io.evicuo.chefery.util.CustomConfig;

public class IngredientsConfig extends CustomConfig {

    public IngredientsConfig(Chefery plugin) {
        super(plugin,"ingredients.yml");
    }
}
