package io.evicuo.chefery.util;

import io.papermc.paper.datacomponent.DataComponentType;
import io.papermc.paper.datacomponent.DataComponentTypes;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.CustomModelDataComponent;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class ItemBuilder {

    private final MiniMessage mm  = MiniMessageUtil.instance();

    private ItemStack item;
    private ItemMeta itemMeta;


    public ItemBuilder(Material material){
        this.item = new ItemStack(material);
        this.itemMeta = item.getItemMeta();
    }



    public ItemBuilder name(String displayName){
        itemMeta.displayName(mm.deserialize(displayName));
        return this;
    }

    public ItemBuilder lore(List<String> lore){
        lore.stream()
                .map(mm::deserialize)
                .forEach(deserializedLore -> itemMeta.lore(List.of(deserializedLore)));
        return this;
    }

    public ItemBuilder enchantment(Enchantment enchantment, int level){
        itemMeta.addEnchant(enchantment, level, true);
        return this;
    }

    public ItemBuilder customModelData(int data){
        itemMeta.setCustomModelData(data);
        return this;
    }

    public <T> ItemBuilder persistentData(NamespacedKey key, PersistentDataType<?, T> type, T value){
        itemMeta.getPersistentDataContainer().set(
                key,
                type,
                value
        );
        return this;
    }

    public <T> ItemBuilder persistentData(List<NamespacedKey> keys, PersistentDataType<?, T> type, T value){
        keys.forEach(key -> itemMeta.getPersistentDataContainer().set(
                key,
                type,
                value
        ));
        return this;
    }


    public ItemStack build(){
        item.setItemMeta(itemMeta);
        return item;
    }










}
