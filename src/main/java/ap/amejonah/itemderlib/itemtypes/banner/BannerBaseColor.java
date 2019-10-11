package ap.amejonah.itemderlib.itemtypes.banner;

import org.bukkit.Material;
import ap.amejonah.itemderlib.MCVersion;

public enum BannerBaseColor {
  
  WHITE(15),
  ORANGE(14),
  MAGENTA(13),
  LIGHT_BLUE(12),
  YELLOW(11),
  LIME(10),
  PINK(9),
  GRAY(8),
  LIGHT_GRAY(7),
  CYAN(6),
  PURPLE(5),
  BLUE(4),
  BROWN(3),
  GREEN(2),
  RED(1),
  BLACK(0);
  
  private int subId;
  
  private BannerBaseColor(int subId) {
    this.subId = subId;
  }
  
  public Material getMaterial() {
    String name = MCVersion.getVersion().isMajorOlderThan(13) ? "" : this.toString() + "_";
    return Material.valueOf(name + "BANNER");
  }
  
  public int getSubId() {
    return MCVersion.getVersion().isMajorOlderThan(13) ? 0 : subId;
  }
}
