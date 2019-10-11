package ap.amejonah.itemderlib.utils;

import org.bukkit.Bukkit;

public class VersionUtils {
  
  public static String getMCVersion() {
    return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
  }
  
  public static boolean isUsingSubID() {
    String version = getMCVersion();
    if (version.startsWith("v1_12") || version.startsWith("v1_13") || version.startsWith("v1_14")) { return false; }
    return true;
  }
  
  public static String getMCMainVersion() {
    String version = getMCVersion();
    return version.split("_")[0].replaceFirst("v", "mc") + version.split("_")[1];
  }
  
  @SuppressWarnings("rawtypes")
  public static Class<?> getNMSClass(String paramString) {
    String bukkitServerPackage = Bukkit.getServer().getClass().getPackage().getName();
    String version = bukkitServerPackage.replace(".", ",").split(",")[3];
    String nmsPackage = "net.minecraft.server." + version + "." + paramString;
    Class nmsClass = null;
    try {
      nmsClass = Class.forName(nmsPackage);
    } catch (ClassNotFoundException exception) {
      exception.printStackTrace();
      System.err.println("Unable to find reflection class " + nmsPackage + "!");
    }
    return nmsClass;
  }
  
  @SuppressWarnings("rawtypes")
  public static Class<?> getOBCBClass(String paramString) {
    String bukkitServerPackage = Bukkit.getServer().getClass().getPackage().getName();
    String version = bukkitServerPackage.replace(".", ",").split(",")[3];
    String obcbPackage = "org.bukkit.craftbukkit." + version + "." + paramString;
    Class obcbClass = null;
    try {
      obcbClass = Class.forName(obcbPackage);
    } catch (ClassNotFoundException exception) {
      exception.printStackTrace();
      System.err.println("Unable to find reflection class " + obcbPackage + "!");
    }
    return obcbClass;
  }
  
  public static double getNMSVersion() {
    String bukkitServerPackage = Bukkit.getServer().getClass().getPackage().getName();
    String[] version = bukkitServerPackage.replace(".", ",").split(",")[3].split("_");
    String major = version[0].replace("v", "");
    String minor = version[1];
    return Double.parseDouble(major + "." + minor);
  }
}
