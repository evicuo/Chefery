package io.evicuo.chefery.commands;

import io.evicuo.chefery.Chefery;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CheferyReloadCommand implements CommandExecutor {
    private final Chefery plugin;
    public CheferyReloadCommand(Chefery plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!command.getName().equalsIgnoreCase("chefery")){
            return true;
        }

        if(args.length != 1){
            return true;
        }

        if(args[0].equalsIgnoreCase("reload")){
            plugin.attributesConfig.reload();
            plugin.ingredientsConfig.reload();
            plugin.recipeConfig.reload();
        }

        return true;

    }
}
