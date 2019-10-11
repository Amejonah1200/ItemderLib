package ap.amejonah.itemderlib.itemtypes.types;

import org.bukkit.Material;
import ap.amejonah.itemderlib.MCVersion;

public enum MusicDisc {
  
  MUSIC_DISC_13("GOLD_RECORD"),
  MUSIC_DISC_CAT("GREEN_RECORD"),
  MUSIC_DISC_BLOCKS("RECORD_3"),
  MUSIC_DISC_CHRIP("RECORD_4"),
  MUSIC_DISC_FAR("RECORD_5"),
  MUSIC_DISC_MALL("RECORD_6"),
  MUSIC_DISC_MELLOHI("RECORD_7"),
  MUSIC_DISC_STAL("RECORD_8"),
  MUSIC_DISC_STRAD("RECORD_9"),
  MUSIC_DISC_WARD("RECORD_10"),
  MUSIC_DISC_11("RECORD_11"),
  MUSIC_DISC_WAIT("RECORD_12");
  
  private String legacyName;
  
  private MusicDisc(String legacyName) {
    this.legacyName = legacyName;
  }
  
  public Material getMaterial() {
    return Material.valueOf(MCVersion.getVersion().isMajorOlderThan(13) ? this.getLegacyName() : this.toString());
  }

  public String getLegacyName() {
    return legacyName;
  }
}
