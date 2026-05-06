package io.evicuo.chefery.commands;

import io.evicuo.chefery.Chefery;
import io.evicuo.chefery.ingredient.IngredientFactory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveIngredientCommand implements CommandExecutor {

    Chefery plugin;
    public GiveIngredientCommand(Chefery plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (args.length == 1) {
                String ingredientName = args[0];
                if (plugin.ingredientManager.getIngredientById(ingredientName) != null) {
                    IngredientFactory ingredientFactory = new IngredientFactory(plugin);
                    ItemStack ingredient = ingredientFactory.buildIngredientById(ingredientName);
                    player.getInventory().addItem(ingredient);


                }
            }
        }


        return true;
    }
}
