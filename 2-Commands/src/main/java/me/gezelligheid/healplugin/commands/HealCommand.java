package me.gezelligheid.healplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("heal")){

            Player player = (Player) sender;
            if(player.hasPermission("heal.use")){
//                Als er geen argumenten zijn dus: /heal
                if(args.length == 0){
                    player.setHealth(20);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&2Je bent genezen!"));
                }
//                Als er 1 argument is: /heal <Player>
                if(args.length == 1){
                    try{
                        Player target = Bukkit.getPlayer(args[0]);
                        target.setHealth(20);
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&',"&2Je bent genezen!"));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&2Je hebt " + target.getName() + " genezen!"));
                    }
                    catch (Exception ex){
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cNo player found"));
                    }
                }
//                Als er 2 argumenten is: /heal sethealth <0-20>
                if(args.length == 2){
                    if(args[0].equalsIgnoreCase("sethealth")){
                        int value = Integer.parseInt(args[1]);
                        if(value >=0 && value <=20){
                            player.setHealth(value);
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&2Je bent genezen!"));
                        }
                        else{
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cValue must be between 0 and 20"));
                        }
                    }
                }
            }
            else{
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cNo permission"));
            }

        }

        return false;
    }

}
