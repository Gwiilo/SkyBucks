import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;

@SuppressWarnings("unused")
public class main {
	
	
	public void onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("gwiilo")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                p.sendMessage(ChatColor.BOLD + "" + ChatColor.RED + "How dare you.");
            }
        }
	}
	
	// import your stuff here

//import your stuff here
}



