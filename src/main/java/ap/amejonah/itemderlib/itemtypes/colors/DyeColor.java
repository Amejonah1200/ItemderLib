package ap.amejonah.itemderlib.itemtypes.colors;

import org.bukkit.Material;
import ap.amejonah.itemderlib.MCVersion;

public enum DyeColor {
  
  RED(1, "ROSE_RED"),
  GREEN(2, "CACTUS_GREEN"),
  PURPLE(5),
  CYAN(6),
  LIGHT_GRAY(7),
  GRAY(8),
  PINK(9),
  LIME(10),
  YELLOW(11, "DANDELION_YELLOW"),
  LIGHT_BLUE(12),
  MAGENTA(13),
  ORANGE(14),
  BLACK(0, "INK_SAC"),
  BROWN(3, "COCOA_BEANS"),
  BLUE(4, "LAPIS_LAZULI"),
  WHITE(15, "BONE_MEAL");
  
  private int subId;
  private String name;
  
  private DyeColor(int subId, String name) {
    this.subId = subId;
    this.name = name;
  }
  
  private DyeColor(int subId) {
    this.subId = subId;
  }
  
  public int getSubId() {
    return subId;
  }
  
  public Material getMaterial() {
    String material = this.toString() + "_DYE";
    if (MCVersion.getVersion().isMajorOlderThan(13)) {
      material = "INK_SACK";
    } else if (MCVersion.getVersion().getMajorVersion() == 13) {
      material = name == null ? this.toString() + "_DYE" : name;
    }
    return Material.valueOf(material);
  }
}
