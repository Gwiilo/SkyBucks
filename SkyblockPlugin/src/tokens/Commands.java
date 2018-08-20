package tokens;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands
  implements CommandExecutor
{
  Main plugin;

  public Commands(Main plugin)
  {
    this.plugin = plugin;
  }

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("SkyBuck"))
    {
      if (args.length == 0)
      {
        sender.sendMessage(ChatColor.GRAY + "---------------[ " + ChatColor.GREEN + "ServerSkyBucks User Help " + ChatColor.GRAY + "]---------------");
        sender.sendMessage(ChatColor.GREEN + "/SkyBuck shop " + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "Spend your SkyBucks");
        sender.sendMessage(ChatColor.GREEN + "/SkyBuck balance " + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "Check your SkyBuck balance!");
        sender.sendMessage(ChatColor.GREEN + "/SkyBuck balance <name> " + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "Check another player's balance!");
        sender.sendMessage(ChatColor.GREEN + "/SkyBuck pay <name> <amnt> " + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "Give another player SkyBucks!");
        sender.sendMessage(ChatColor.GREEN + "/SkyBuck help <1 :: 2> " + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "View a helpful list of commands!");
        sender.sendMessage(ChatColor.GRAY + "-----------------------------------------------------");
      }
      else if (args.length == 1)
      {
        if (args[0].equalsIgnoreCase("shop"))
        {
          if ((sender instanceof Player))
          {
            Player p = (Player)sender;
            p.openInventory(Utils.showInventory(p));
          }
          else
          {
            sender.sendMessage(Utils.prefix() + ChatColor.RED + " Console cannot use that command!");
          }
        }
        else if (args[0].equalsIgnoreCase("balance"))
        {
          if ((sender instanceof Player))
          {
            Player p = (Player)sender;
            p.sendMessage(Utils.prefix() + ChatColor.GRAY + " You have ß" + ChatColor.GREEN + Utils.SkyBuckBal(p) + " SkyBucks!");
          }
          else
          {
            sender.sendMessage(Utils.prefix() + ChatColor.RED + " Console cannot use that command!");
          }
        }
        else if (args[0].equalsIgnoreCase("reload"))
        {
          if (sender.hasPermission("ServerSkyBucks.reload"))
          {
            this.plugin.reloadConfig();
            sender.sendMessage(Utils.prefix() + ChatColor.GREEN + " Successfully reloaded the plugin!");
          }
          else
          {
            sender.sendMessage(Utils.prefix() + ChatColor.RED + " You do not have permission to use that!");
          }
        }
      }
      else if (args.length == 2)
      {
        if (args[0].equalsIgnoreCase("help"))
        {
          if (args[1].equalsIgnoreCase("1"))
          {
            sender.sendMessage(ChatColor.GRAY + "---------------[ " + ChatColor.GREEN + "ServerSkyBucks User Help " + ChatColor.GRAY + "]--------------");
            sender.sendMessage(ChatColor.GREEN + "/SkyBuck shop " + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "Spend your SkyBucks");
            sender.sendMessage(ChatColor.GREEN + "/SkyBuck balance " + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "Check your SkyBuck balance!");
            sender.sendMessage(ChatColor.GREEN + "/SkyBuck balance <name> " + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "Check another player's balance!");
            sender.sendMessage(ChatColor.GREEN + "/SkyBuck pay <name> <amnt> " + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "Give another player SkyBucks!");
            sender.sendMessage(ChatColor.GRAY + "-----------------------------------------------------");
          }
          else if (args[1].equalsIgnoreCase("2"))
          {
            if (sender.hasPermission("ServerSkyBucks.adminhelp"))
            {
              sender.sendMessage(ChatColor.GRAY + "---------------[ " + ChatColor.GREEN + "ServerSkyBucks Admin Help " + ChatColor.GRAY + "]--------------");
              sender.sendMessage(ChatColor.GREEN + "/SkyBuck add <name> <amnt> " + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "Add SkyBucks to a player's balance!");
              sender.sendMessage(ChatColor.GREEN + "/SkyBuck remove <name> <amnt> " + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "Remove SkyBucks from a player's balance!");
              sender.sendMessage(ChatColor.GREEN + "/SkyBuck set <name> <amnt> " + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "Set a player's SkyBuck balance!");
              sender.sendMessage(ChatColor.GREEN + "/SkyBuck reload " + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "Reload the plugin!");
              sender.sendMessage(ChatColor.GRAY + "-----------------------------------------------------");
            }
            else
            {
              sender.sendMessage(Utils.prefix() + ChatColor.RED + " You do not have permission to use that!");
            }
          }
          else
          {
            sender.sendMessage(Utils.prefix() + ChatColor.RED + " " + args[1] + " is not a proper selection!");
          }
        }
        else if (args[0].equalsIgnoreCase("balance"))
        {
          if (sender.hasPermission("ServerSkyBucks.balanceothers"))
          {
            Player target = Bukkit.getPlayerExact(args[1]);
            if (target == null)
            {
              sender.sendMessage(Utils.prefix() + " " + ChatColor.RED + args[1] + " is not currently online!");
            }
            else
            {
              sender.sendMessage(Utils.prefix() + " " + ChatColor.GREEN + args[1] + ChatColor.GRAY + " has " + ChatColor.GREEN + Utils.SkyBuckBal(target) + " SkyBucks!");
            }
          }
          else
          {
            sender.sendMessage(Utils.prefix() + ChatColor.RED + " You do not have permission to use that!");
          }
        }
      }
      else if (args.length == 3)
      {
        if (args[0].equalsIgnoreCase("pay"))
        {
          if ((sender instanceof Player))
          {
            Player p = (Player)sender;
            if (p.hasPermission("ServerSkyBucks.payothers"))
            {
              Player target = Bukkit.getPlayer(args[1]);
              if (target == null)
              {
                p.sendMessage(Utils.prefix() + " " + ChatColor.RED + args[1] + " is not currently online!");
              }
              else if (Utils.isInt(args[2]))
              {
                if (Integer.valueOf(args[2]).intValue() > 0)
                {
                  if (Utils.SkyBuckBal(p) > Integer.valueOf(args[2]).intValue())
                  {
                    this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) - Integer.valueOf(args[2]).intValue()));
                    this.plugin.getConfig().set("Players." + target.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(target) + Integer.valueOf(args[2]).intValue()));
                    this.plugin.saveConfig();

                    p.sendMessage(Utils.prefix() + ChatColor.GRAY + " You have given " + ChatColor.GREEN + args[1] + " " + args[2] + " SkyBucks!");
                    target.sendMessage(Utils.prefix() + " " + ChatColor.GREEN + p.getName() + ChatColor.GRAY + " has given you " + ChatColor.GREEN + args[2] + " SkyBucks!");
                  }
                  else
                  {
                    p.sendMessage(Utils.prefix() + ChatColor.RED + " You do not have enough SkyBucks!");
                  }
                }
                else
                {
                  p.sendMessage(Utils.prefix() + ChatColor.RED + " You cannot send less than 1 SkyBuck!");
                }
              }
              else
              {
                p.sendMessage(Utils.prefix() + " " + ChatColor.RED + args[2] + " is not an integer value!");
              }

            }
            else
            {
              sender.sendMessage(Utils.prefix() + ChatColor.RED + " You do not have permission to use that!");
            }
          }
          else
          {
            sender.sendMessage(Utils.prefix() + ChatColor.RED + " Console cannot use that command!");
          }
        }
        else if (args[0].equalsIgnoreCase("add"))
        {
          if (sender.hasPermission("ServerSkyBucks.addSkyBucks"))
          {
            Player target = Bukkit.getPlayer(args[1]);
            if (target == null)
            {
              sender.sendMessage(Utils.prefix() + " " + ChatColor.RED + args[1] + " is not currently online!");
            }
            else if (Utils.isInt(args[2]))
            {
              if (Integer.valueOf(args[2]).intValue() > 0)
              {
                this.plugin.getConfig().set("Players." + target.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(target) + Integer.valueOf(args[2]).intValue()));
                this.plugin.saveConfig();

                if (!args[1].endsWith("s"))
                {
                  sender.sendMessage(Utils.prefix() + ChatColor.GRAY + " You have added " + ChatColor.GREEN + args[2] + " SkyBucks " + ChatColor.GRAY + "to " + ChatColor.GREEN + args[1] + "'s balance!");
                }
                else
                {
                  sender.sendMessage(Utils.prefix() + ChatColor.GRAY + " You have added " + ChatColor.GREEN + args[2] + " SkyBucks " + ChatColor.GRAY + "to " + ChatColor.GREEN + args[1] + "' balance!");
                }

                target.sendMessage(Utils.prefix() + ChatColor.GRAY + " You have received " + ChatColor.GREEN + args[2] + " SkyBucks!");
              }
              else
              {
                sender.sendMessage(Utils.prefix() + ChatColor.RED + " You cannot add less than 1 SkyBuck!");
              }
            }
            else
            {
              sender.sendMessage(Utils.prefix() + " " + ChatColor.RED + args[2] + " is not an integer value!");
            }

          }
          else
          {
            sender.sendMessage(Utils.prefix() + ChatColor.RED + " You do not have permission to use that!");
          }
        }
        else if (args[0].equalsIgnoreCase("remove"))
        {
          if (sender.hasPermission("ServerSkyBucks.removeSkyBucks"))
          {
            Player target = Bukkit.getPlayer(args[1]);
            if (target == null)
            {
              sender.sendMessage(Utils.prefix() + " " + ChatColor.RED + args[1] + " is not currently online!");
            }
            else if (Utils.isInt(args[2]))
            {
              if (Integer.valueOf(args[2]).intValue() > 0)
              {
                if (Utils.SkyBuckBal(target) > Integer.valueOf(args[2]).intValue())
                {
                  this.plugin.getConfig().set("Players." + target.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(target) - Integer.valueOf(args[2]).intValue()));
                  this.plugin.saveConfig();

                  if (!args[1].endsWith("s"))
                  {
                    sender.sendMessage(Utils.prefix() + ChatColor.GRAY + " You have removed " + ChatColor.GREEN + args[2] + " SkyBucks " + ChatColor.GRAY + "from " + ChatColor.GREEN + args[1] + "'s balance!");
                  }
                  else
                  {
                    sender.sendMessage(Utils.prefix() + ChatColor.GRAY + " You have removed " + ChatColor.GREEN + args[2] + " SkyBucks " + ChatColor.GRAY + "from " + ChatColor.GREEN + args[1] + "' balance!");
                  }

                  target.sendMessage(Utils.prefix() + ChatColor.GRAY + " You have lost " + ChatColor.GREEN + args[2] + " SkyBucks!");
                }
                else
                {
                  sender.sendMessage(Utils.prefix() + " " + ChatColor.RED + args[1] + " does not have that many SkyBucks!");
                }
              }
              else
              {
                sender.sendMessage(Utils.prefix() + ChatColor.RED + " You cannot remove less than 1 SkyBuck!");
              }
            }
            else
            {
              sender.sendMessage(Utils.prefix() + " " + ChatColor.RED + args[2] + " is not an integer value!");
            }

          }
          else
          {
            sender.sendMessage(Utils.prefix() + ChatColor.RED + " You do not have permission to use that!");
          }
        }
        else if (args[0].equalsIgnoreCase("set"))
        {
          if (sender.hasPermission("ServerSkyBucks.setSkyBucks"))
          {
            Player target = Bukkit.getPlayer(args[1]);
            if (target == null)
            {
              sender.sendMessage(Utils.prefix() + " " + ChatColor.RED + args[1] + " is not currently online!");
            }
            else if (Utils.isInt(args[2]))
            {
              if (Integer.valueOf(args[2]).intValue() > -1)
              {
                this.plugin.getConfig().set("Players." + target.getUniqueId() + ".SkyBucks", Integer.valueOf(args[2]));
                this.plugin.saveConfig();

                if (!args[1].endsWith("s"))
                {
                  sender.sendMessage(Utils.prefix() + ChatColor.GRAY + " You have set " + ChatColor.GREEN + args[1] + "'s" + ChatColor.GRAY + " balance to " + ChatColor.GREEN + args[2] + " SkyBucks!");
                }
                else
                {
                  sender.sendMessage(Utils.prefix() + ChatColor.GRAY + " You have set " + ChatColor.GREEN + args[1] + "'" + ChatColor.GRAY + " balance to " + ChatColor.GREEN + args[2] + " SkyBucks!");
                }

                target.sendMessage(Utils.prefix() + ChatColor.GRAY + " Your balance has been set to " + ChatColor.GREEN + args[2] + " SkyBucks!");
              }
              else
              {
                sender.sendMessage(Utils.prefix() + ChatColor.RED + " You cannot set a negative SkyBuck balance!");
              }
            }
            else
            {
              sender.sendMessage(Utils.prefix() + " " + ChatColor.RED + args[2] + " is not an integer value!");
            }

          }
          else
          {
            sender.sendMessage(Utils.prefix() + ChatColor.RED + " You do not have permission to use that!");
          }
        }
      }
      else
      {
        sender.sendMessage(ChatColor.GRAY + "---------------[ " + ChatColor.GREEN + "ServerSkyBucks User Help " + ChatColor.GRAY + "]---------------");
        sender.sendMessage(ChatColor.GREEN + "/SkyBuck shop " + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "Spend your SkyBucks");
        sender.sendMessage(ChatColor.GREEN + "/SkyBuck balance " + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "Check your SkyBuck balance!");
        sender.sendMessage(ChatColor.GREEN + "/SkyBuck balance <name> " + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "Check another player's balance!");
        sender.sendMessage(ChatColor.GREEN + "/SkyBuck pay <name> <amnt> " + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "Give another player SkyBucks!");
        sender.sendMessage(ChatColor.GREEN + "/SkyBuck help <1 :: 2> " + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "View a helpful list of commands!");
        sender.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      }
    }
    return false;
  }
}
