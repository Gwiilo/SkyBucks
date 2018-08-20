import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.block.BlockFace;

	public class GeneratedOre {
	 private final Location origin;
	 private final Map<BlockFace, Integer> data = new HashMap<>(); // This will store the amount of ore each side has. Using BlockFace it can be used to get the adjacent block to 'origin' in whatever direction we want.

	 public GeneratedOre(Location origin){
	     this.origin = origin;

	     // Prefill the data map.
	     for(BlockFace b : BlockFace.values()){
	         this.data.put(b, 0);
	     }
	 }

	 public Location getOrigin(){
	     return this.origin;
	 }

	 public int getOreCount(BlockFace side){
	     return this.data.get(side);
	 }

	 public void addOre(BlockFace side, int amount){
	     int current = this.data.get(side);
	     this.data.put(side, current + amount);
	 }

	 // For convenience.
	 public void addOre(BlockFace side){
	     this.addOre(side, 1);
	 }

	 public void removeOre(BlockFace side, int amount){
	     int current = this.data.get(side);
	     int check = current - amount;

	     // No negatives
	     if(check < 0) check = 0;

	     this.data.put(side, check);
	 }

	 public void removeOre(BlockFace side){
	     this.removeOre(side, 1);
	 }

}
