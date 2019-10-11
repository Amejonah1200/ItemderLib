package ap.amejonah.itemderlib.itemtypes.types;

import java.util.ArrayList;
import java.util.List;
import ap.amejonah.itemderlib.MCVersion;

public enum SpawnEggType {
  
  AREA_EFFECT_CLOUD(3, 12, 13, 14),
  ARMOR_STAND(30, 8, 12, 13, 14), // Monster_Spawner
  ARROW(10, 8, 12, 13, 14), // Monster_Spawner
  BAT(65, 8, 12, 13, 14), // Spawnable
  BLAZE(61, 8, 12, 13, 14), // Spawnable
  BOAT(41, 8, 12, 13, 14), // Monster_Spawner
  CAT(-1, 14),
  CAVE_SPIDER(59, 8, 12, 13, 14), // Spawnable
  CHICKEN(93, 8, 12, 13, 14), // Spawnable
  COD(-1, 13, 14),
  COMPLEX_PART(-1, 8, 12, 13),
  COW(92, 8, 12, 13, 14), // Spawnable
  CREEPER(50, 8, 12, 13, 14), // Spawnable
  DOLPHIN(-1, 13, 14),
  DONKEY(31, 12, 13, 14),
  DRAGON_FIREBALL(26, 12, 13, 14),
  DROPPED_ITEM(1, 8, 12, 13, 14), // Monster_Spawner
  DROWNED(-1, 13, 14),
  EGG_MC8("EGG", -1, 8),
  EGG(7, 12, 13, 14),
  ELDER_GUARDIAN(4, 12, 13, 14),
  ENDERMAN(58, 8, 12, 13, 14), // Spawnable
  ENDERMITE(67, 8, 12, 13, 14), // Spawnable
  ENDER_CRYSTAL(200, 8, 12, 13, 14), // null
  ENDER_DRAGON(63, 8, 12, 13, 14), // Monster_Spawner
  ENDER_PEARL(14, 8, 12, 13, 14), // Monster_Spawner
  ENDER_SIGNAL(15, 8, 12, 13, 14), // Monster_Spawner
  EVOKER(34, 12, 13, 14),
  EVOKER_FANGS(33, 12, 13, 14),
  EXPERIENCE_ORB(2, 8, 12, 13, 14), // Monster_Spawner
  FALLING_BLOCK(21, 8, 12, 13, 14), // Monster_Spawner
  FIREBALL(12, 8, 12, 13, 14), // Monster_Spawner
  FIREWORK(22, 8, 12, 13, 14), // Monster_Spawner
  FISHING_HOOK(-1, 8, 12, 13, 14),
  FOX(-1, 14),
  GHAST(56, 8, 12, 13, 14), // Spawnable
  GIANT(53, 8, 12, 13, 14), // Monster_Spawner
  GUARDIAN(68, 8, 12, 13, 14), // Spawnable
  HORSE(100, 8, 12, 13, 14), // Spawnable
  HUSK(23, 12, 13, 14),
  ILLUSIONER(37, 12, 13, 14),
  IRON_GOLEM(99, 8, 12, 13, 14), // Monster_Spawner
  ITEM_FRAME(18, 8, 12, 13, 14), // Monster_Spawner //(Crashable!)
  LEASH_HITCH(8, 8, 12, 13, 14), // Monster_Spawner //Useless!
  LIGHTNING(-1, 8, 12, 13, 14),
  LINGERING_POTION(-1, 12, 13),
  LLAMA(103, 12, 13, 14),
  LLAMA_SPIT(104, 12, 13, 14),
  MAGMA_CUBE(62, 8, 12, 13, 14), // Spawnable
  MINECART(42, 8, 12, 13, 14), // Monster_Spawner
  MINECART_CHEST(43, 8, 12, 13, 14), // Monster_Spawner
  MINECART_COMMAND(40, 8, 12, 13, 14), // Monster_Spawner
  MINECART_FURNACE(44, 8, 12, 13, 14), // Monster_Spawner
  MINECART_HOPPER(46, 8, 12, 13, 14), // Monster_Spawner
  MINECART_MOB_SPAWNER(47, 8, 12, 13, 14), // Monster_Spawner
  MINECART_TNT(45, 8, 12, 13, 14), // Monster_Spawner
  MULE(32, 12, 13, 14),
  MUSHROOM_COW(96, 8, 12, 13, 14), // Spawnable
  OCELOT(98, 8, 12, 13, 14), // Spawnable
  PAINTING(9, 8, 12, 13, 14), // Monster_Spawner //(Crashable!)
  PANDA(-1, 14),
  PARROT(105, 12, 13, 14),
  PHANTOM(-1, 13, 14),
  PIG(90, 8, 12, 13, 14), // Spawnable
  PIG_ZOMBIE(57, 8, 12, 13, 14), // Spawnable
  PILLAGER(-1, 14),
  PLAYER(-1, 8, 12, 13, 14),
  POLAR_BEAR(102, 12, 13, 14),
  PRIMED_TNT(20, 8, 12, 13, 14), // Monster_Spawner
  PUFFERFISH(-1, 13, 14),
  RABBIT(101, 8, 12, 13, 14), // Spawnable
  RAVAGER(-1, 14),
  SALMON(-1, 13, 14),
  SHEEP(91, 8, 12, 13, 14), // Spawnable
  SHULKER(69, 12, 13, 14),
  SHULKER_BULLET(25, 12, 13, 14),
  SILVERFISH(60, 8, 12, 13, 14), // Spawnable
  SKELETON(51, 8, 12, 13, 14), // Spawnable
  SKELETON_HORSE(28, 12, 13, 14),
  SLIME(55, 8, 12, 13, 14), // Spawnable
  SMALL_FIREBALL(13, 8, 12, 13, 14), // Monster_Spawner
  SNOWBALL(11, 8, 12, 13, 14), // Monster_Spawner
  SNOWMAN(97, 8, 12, 13, 14), // Monster_Spawner V
  SPECTRAL_ARROW(24, 12, 13, 14),
  SPIDER(52, 8, 12, 13, 14), // Spawnable
  SPLASH_POTION_MC8("SPLASH_POTION", -1, 8),
  SPLASH_POTION(16, 12, 13, 14),
  SQUID(94, 8, 12, 13, 14), // Spawnable
  STRAY(6, 12, 13, 14),
  THROWN_EXP_BOTTLE(17, 8, 12, 13, 14), // Monster_Spawner
  TIPPED_ARROW(-1, 12, 13),
  TRADER_LLAMA(-1, 14),
  TRIDENT(-1, 13, 14),
  TROPICAL_FISH(-1, 13, 14),
  TURTLE(-1, 13, 14),
  UNKNOWN(-1, 8, 12, 13, 14),
  VEX(35, 12, 13, 14),
  VILLAGER(120, 8, 12, 13, 14), // Spawnable
  VINDICATOR(36, 12, 13, 14),
  WANDERING_TRADER(-1, 14),
  WEATHER(-1, 8, 12, 13),
  WITCH(66, 8, 12, 13, 14), // Spawnable
  WITHER(64, 8, 12, 13, 14), // Monster_Spawner
  WITHER_SKELETON(5, 12, 13, 14),
  WITHER_SKULL(19, 8, 12, 13, 14), // Monster_Spawner
  WOLF(95, 8, 12, 13, 14), // Spawnable
  ZOMBIE(54, 8, 12, 13, 14), // Spawnable
  ZOMBIE_HORSE(29, 12, 13, 14),
  ZOMBIE_VILLAGER(27, 12, 13, 14);
  
  private int id;
  private int[] versions;
  private String name;
  
  private SpawnEggType(int id, int... versions) {
    this.id = id;
    this.versions = versions;
    this.name = null;
  }
  
  private SpawnEggType(String name, int id, int... versions) {
    this.id = id;
    this.versions = versions;
    this.name = name;
  }
  
  public String getName() {
    return name == null ? this.toString() : name;
  }
  
  public int getId() {
    return id;
  }
  
  public int[] getVersions() {
    return versions;
  }
  
  public static List<SpawnEggType> getTypesForVersion(MCVersion version) {
    List<SpawnEggType> types = new ArrayList<>();
    for (SpawnEggType type : values()) {
      if (type.isForVersion(version.getMajorVersion())) {
        types.add(type);
      }
    }
    return types;
  }
  
  public boolean isForVersion(int majorVersion) {
    for (int version : versions) {
      if (version == majorVersion) return true;
    }
    return false;
  }
}
