package com.airswiss.titan.titan.TitanSubCommands;

import com.airswiss.titan.titan.Titan;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class Youtube2 implements CommandExecutor {

    public Titan pl;

    public Youtube2(Titan pl) {
        this.pl=pl;
    }

    String c(String c) {
        c = c.replace("&", "§");
        return c;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ConfigurationSection Messages = pl.getConfig().getConfigurationSection("SubCommands");
        ConfigurationSection Messagess = pl.getConfig().getConfigurationSection("Messages");
        if(!(sender instanceof Player)) {
            sender.sendMessage("You cant do that !");
            return false;
        }
        if(Messages.getBoolean("Youtube.Enable", true)) {
            if(command.getName().equalsIgnoreCase("Yt")) {
                sender.sendMessage(this.c(Messages.getString("Youtube.URL")));
                return true;
            }
        } else {
            sender.sendMessage(this.c(Messagess.getString("CommandDisable")));
        }
        return true;
    }
}
