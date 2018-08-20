package tokens;


import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils
  implements Listener
{
  static Main plugin;

  public Utils(Main plugin)
  {
    Utils.plugin = plugin;
  }

  public static String prefix()
  {
    String prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Options.Prefix"));

    return prefix;
  }

  public static int defaultAmnt()
  {
    int amnt = plugin.getConfig().getInt("Options.StartingAmount");

    return amnt;
  }

  public static int numSlots()
  {
    int slots = plugin.getConfig().getInt("Options.NumberOfSlots");

    return slots;
  }

  public static String getTitle()
  {
    String title = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Options.Title"));

    return title;
  }

  public static boolean hasAccount(Player p) {
    if (plugin.getConfig().contains("Players." + p.getUniqueId()))
    {
      return true;
    }

    return false;
  }

  public static int SkyBuckBal(Player p)
  {
    int bal = plugin.getConfig().getInt("Players." + p.getUniqueId() + ".SkyBucks");

    return bal;
  }

  public static Inventory showInventory(Player p)
  {
    Inventory inv = Bukkit.createInventory(null, numSlots(), getTitle());

    for (int i = 0; i < numSlots(); i++)
    {
      int amnt = plugin.getConfig().getInt("Shop." + i + ".Amount");
      int id = plugin.getConfig().getInt("Shop." + i + ".Meta");
      ItemStack item = new ItemStack(Material.getMaterial(plugin.getConfig().getString("Shop." + i + ".Item").toUpperCase()), amnt, (short)id);
      ItemMeta im = item.getItemMeta();
      im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Shop." + i + ".DisplayName")));

      ArrayList<String> lore = new ArrayList<String>();
      if (plugin.getConfig().contains("Shop." + i + ".Lore"))
      {
        lore.add(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Shop." + i + ".Lore")));
      }

      lore.add(ChatColor.GRAY + "Price: " + plugin.getConfig().getInt(new StringBuilder("Shop.").append(i).append(".Price").toString()));
      if (plugin.getConfig().getInt("Players." + p.getUniqueId() + ".SkyBucks") < plugin.getConfig().getInt("Shop." + i + ".Price"))
      {
        lore.add(ChatColor.RED + "You cannot afford this!");
      }
      else
      {
        lore.add(ChatColor.GREEN + "You can afford this!");
      }

      im.setLore(lore);
      item.setItemMeta(im);

      inv.setItem(i, item);
    }

    return inv;
  }

  public static boolean fullInv(Player p)
  {
    int check = p.getInventory().firstEmpty();
    if (check == -1)
    {
      return true;
    }

    return false;
  }

  public static boolean canAfford(Player p, int slot)
  {
    if (plugin.getConfig().getInt("Players." + p.getUniqueId() + ".SkyBucks") >= plugin.getConfig().getInt("Shop." + slot + ".Price"))
    {
      return true;
    }

    return false;
  }

  public static boolean isInt(String value)
  {
    try
    {
      Integer.parseInt(value);
    }
    catch (NumberFormatException efr)
    {
      return false;
    }
    return true;
  }
}