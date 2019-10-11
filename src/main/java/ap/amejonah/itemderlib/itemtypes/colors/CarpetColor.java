package ap.amejonah.itemderlib.itemtypes.colors;

import org.bukkit.Material;
import ap.amejonah.itemderlib.MCVersion;

public enum CarpetColor {
  
  WHITE(0),
  ORANGE(1),
  MAGENTA(2),
  LIGHT_BLUE(3),
  YELLOW(4),
  LIME(5),
  PINK(6),
  GRAY(7),
  LIGHT_GRAY(8),
  CYAN(9),
  PURPLE(10),
  BLUE(11),
  BROWN(12),
  GREEN(13),
  RED(14),
  BLACK(15);
  
  private int subId;
  
  private CarpetColor(int subId) {
    this.subId = subId;
  }
  
  public Material getMaterial() {
    String name = MCVersion.getVersion().isMajorOlderThan(13) ? "" : this.toString() + "_";
    return Material.valueOf(name + "CARPET");
  }
  
  public int getSubId() {
    return MCVersion.getVersion().isMajorOlderThan(13) ? 0 : subId;
  }
}
