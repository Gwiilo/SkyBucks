package tokens;


import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
  implements Listener
{
  PluginDescriptionFile pdf = getDescription();

  public void onEnable()
  {
    getLogger().info("ServerSkyBucks : Version " + this.pdf.getVersion() + " : has been enabled!");

    PluginManager pm = Bukkit.getServer().getPluginManager();
    pm.registerEvents(this, this);
    pm.registerEvents(new Events(this), this);
    pm.registerEvents(new Utils(this), this);

    getCommand("SkyBuck").setExecutor(new Commands(this));

    saveDefaultConfig();
  }

  public void onDisable()
  {
    getLogger().info("ServerSkyBucks : Version " + this.pdf.getVersion() + " : has been disabled!");
  }
}