package io.evicuo.chefery.util;

import net.kyori.adventure.text.minimessage.MiniMessage;

public class MiniMessageUtil {
    private static final MiniMessage instance = MiniMessage.miniMessage();


    public static MiniMessage instance() {
        return instance;
    }

}
