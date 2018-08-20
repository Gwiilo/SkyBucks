package tokens;

import java.util.List;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Horse;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events
  implements Listener
{
  Main plugin;

  public Events(Main plugin)
  {
    this.plugin = plugin;
  }

  @EventHandler
  public void onJoin(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();

    if (!Utils.hasAccount(p))
    {
      this.plugin.getConfig().set("Players." + p.getUniqueId() + ".Name", p.getName());
      this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.defaultAmnt()));

      this.plugin.saveConfig();
    }
    else;
  }

  @EventHandler
  public void onDeath(EntityDeathEvent e)
  {
    if ((e.getEntity().getKiller() instanceof Player))
    {
      Entity mob = e.getEntity();
      Player p = e.getEntity().getKiller();

      if (this.plugin.getConfig().getBoolean("Options.EnableSkyBuckDrops"))
      {
        if ((mob instanceof Skeleton))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Creeper))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof CaveSpider))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Spider))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof PigZombie))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Zombie))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof MagmaCube))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Slime))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Ghast))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Enderman))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from an " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Silverfish))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Blaze))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Bat))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Witch))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof IronGolem))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from an " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Pig))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Sheep))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof MushroomCow))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Cow))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Chicken))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Squid))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Wolf))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Ocelot))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from an " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Villager))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof EnderDragon))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from an " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Horse))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if ((mob instanceof Snowman))
        {
          Random random = new Random();
          int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
          if (chance == -1)
          {
            return;
          }

          if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
          {
            this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
            this.plugin.saveConfig();
            p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
            return;
          }

          return;
        }

        if (!(mob instanceof Wither))
          return;
        Random random = new Random();
        int chance = this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance");
        if (chance == -1)
        {
          return;
        }

        if (chance - 1 == random.nextInt(this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".Chance")))
        {
          this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) + this.plugin.getConfig().getInt("DropChances." + mob.getType() + ".NumSkyBucks")));
          this.plugin.saveConfig();
          p.sendMessage(Utils.prefix() + " " + "You received " + ChatColor.GREEN + this.plugin.getConfig().getInt(new StringBuilder("DropChances.").append(mob.getType()).append(".NumSkyBucks").toString()) + ChatColor.GRAY + " SkyBuck(s) from a " + mob.getType() + "!");
          return;
        }
      }
    }
    else;
  }

  //@EventHandler
  public void onClick(InventoryClickEvent e)
  {
    if ((e.getWhoClicked() instanceof Player))
    {
      Player p = (Player)e.getWhoClicked();
      if (e.getInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Options.Title"))))
      {
        for (int i = 0; i < Utils.numSlots(); i++)
        {
          int slot = e.getSlot();
          if (slot == i)
          {
            if (this.plugin.getConfig().getInt("Shop." + i + ".Price") <= 0)
            {
              e.setCancelled(true);
            }
            else if (Utils.canAfford(p, slot))
            {
              if (!Utils.fullInv(p))
              {
                List<String> cmdlist = this.plugin.getConfig().getStringList("Shop." + i + ".Commands");
                for (String cmd : cmdlist)
                {
                  if (cmd.contains("{player}"))
                  {
                    cmd = cmd.replace("{player}", p.getName());
                  }

                  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                }

                e.setCancelled(true);
                p.closeInventory();

                this.plugin.getConfig().set("Players." + p.getUniqueId() + ".SkyBucks", Integer.valueOf(Utils.SkyBuckBal(p) - this.plugin.getConfig().getInt("Shop." + i + ".Price")));
                this.plugin.saveConfig();

                p.sendMessage(Utils.prefix() + ChatColor.GRAY + " You now have " + ChatColor.GREEN + Utils.SkyBuckBal(p) + " SkyBucks!");
              }
              else
              {
                e.setCancelled(true);
                p.closeInventory();
                p.sendMessage(Utils.prefix() + ChatColor.RED + " Your inventory is full!");
              }
            }
            else
            {
              e.setCancelled(true);
              p.sendMessage(Utils.prefix() + ChatColor.RED + " You cannot afford that item!");
            }
          }
        }
      }
    }
  }
}