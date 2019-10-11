package ap.amejonah.itemderlib.nbttagger;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ap.amejonah.itemderlib.utils.VersionUtils;

public final class NBTTaggerReflect implements NBTTagger {
  
  @Override
  public ItemStack setNBTTag(String key, Object obj, ItemStack is) {
    ItemStack save = is.clone();
    try {
      Object nmsItem = getNMSItem(is);
      Object compound = getNMSCompound(nmsItem);
      if (obj.getClass().isAssignableFrom(VersionUtils.getNMSClass("NBTBase"))) {
        compound.getClass().getMethod("set", String.class, VersionUtils.getNMSClass("NBTBase")).invoke(compound, key,
          obj);
      } else if (obj instanceof String) {
        compound.getClass().getMethod("setString", String.class, String.class).invoke(compound, key, (String) obj);
      } else if (obj instanceof Boolean) {
        compound.getClass().getMethod("setBoolean", String.class, boolean.class).invoke(compound, key, (boolean) obj);
      } else if (obj instanceof Integer) {
        compound.getClass().getMethod("setInt", String.class, int.class).invoke(compound, key, (int) obj);
      } else if (obj instanceof Float) {
        compound.getClass().getMethod("setFloat", String.class, float.class).invoke(compound, key, (float) obj);
      } else if (obj instanceof Long) {
        compound.getClass().getMethod("setLong", String.class, long.class).invoke(compound, key, (long) obj);
      }
      nmsItem.getClass().getMethod("setTag", VersionUtils.getNMSClass("NBTTagCompound")).invoke(nmsItem, compound);
      return (ItemStack) VersionUtils.getOBCBClass("inventory.CraftItemStack").getMethod("asBukkitCopy",
        nmsItem.getClass()).invoke(null, nmsItem);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return save;
  }
  
  @Override
  public ItemStack removeNBTTag(String key, ItemStack is) {
    ItemStack save = is.clone();
    try {
      Object nmsItem = getNMSItem(is);
      Object compound = getNMSCompound(nmsItem);
      compound.getClass().getMethod("remove", String.class).invoke(compound, key);
      nmsItem.getClass().getMethod("setTag", VersionUtils.getNMSClass("NBTTagCompound")).invoke(nmsItem, compound);
      is.setItemMeta((ItemMeta) VersionUtils.getOBCBClass("inventory.CraftItemStack").getMethod("getItemMeta",
        nmsItem.getClass()).invoke(null, nmsItem));
      return is;
    } catch (Exception e) {
      e.printStackTrace();
      return save;
    }
  }
  
  @Override
  public boolean hasTag(String key, ItemStack is) {
    try {
      Object nmsItem = getNMSItem(is);
      Object compound = getNMSCompound(nmsItem);
      return (boolean) compound.getClass().getMethod("hasKey", String.class).invoke(compound, key);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
  
  @Override
  public Object getNBTTag(String key, ItemStack is) {
    try {
      Object nmsItem = getNMSItem(is);
      Object compound = getNMSCompound(nmsItem);
      return compound.getClass().getMethod("get", String.class).invoke(compound, key);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
  
  @Override
  public String getNBTTagString(String key, ItemStack is) {
    try {
      Object nmsItem = getNMSItem(is);
      Object compound = getNMSCompound(nmsItem);
      return (String) compound.getClass().getMethod("getString", String.class).invoke(compound, key);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
  
  @Override
  public int getNBTTagInt(String key, ItemStack is) {
    try {
      Object nmsItem = getNMSItem(is);
      Object compound = getNMSCompound(nmsItem);
      return (int) compound.getClass().getMethod("getInt", String.class).invoke(compound, key);
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }
  
  @Override
  public long getNBTTagLong(String key, ItemStack is) {
    try {
      Object nmsItem = getNMSItem(is);
      Object compound = getNMSCompound(nmsItem);
      return (int) compound.getClass().getMethod("getLong", String.class).invoke(compound, key);
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }
  
  @Override
  public boolean getNBTTagBoolean(String key, ItemStack is) {
    try {
      Object nmsItem = getNMSItem(is);
      Object compound = getNMSCompound(nmsItem);
      return (boolean) compound.getClass().getMethod("getBoolean", String.class).invoke(compound, key);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
  
  @Override
  public Object getNBTTagList(String key, ItemStack is, int type) {
    try {
      Object nmsItem = getNMSItem(is);
      Object compound = getNMSCompound(nmsItem);
      return compound.getClass().getMethod("getList", String.class, int.class).invoke(compound, key, type);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
  
  @Override
  public float getNBTTagFloat(String key, ItemStack is) {
    try {
      Object nmsItem = getNMSItem(is);
      Object compound = getNMSCompound(nmsItem);
      return (float) compound.getClass().getMethod("getFloat", String.class).invoke(compound, key);
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }
  
  @Override
  public Object getNMSItem(ItemStack is) throws Exception {
    return VersionUtils.getOBCBClass("inventory.CraftItemStack").getMethod("asNMSCopy", ItemStack.class).invoke(null,
      is);
  }
  
  @Override
  public Object getNMSCompound(Object nmsItem) throws Exception {
    return (boolean) nmsItem.getClass().getMethod("hasTag").invoke(nmsItem) ? nmsItem.getClass().getMethod(
      "getTag").invoke(nmsItem) : VersionUtils.getNMSClass("NBTTagCompound").getConstructor().newInstance();
  }
  
  @Override
  public ItemStack resetNBTTag(ItemStack is) {
    try {
      Object nmsItem = getNMSItem(is);
      Object compound = VersionUtils.getNMSClass("NBTTagCompound").getConstructor().newInstance();
      nmsItem.getClass().getMethod("setTag", VersionUtils.getNMSClass("NBTTagCompound")).invoke(nmsItem, compound);
      return (ItemStack) VersionUtils.getOBCBClass("inventory.CraftItemStack").getMethod("asBukkitCopy",
        nmsItem.getClass()).invoke(null, nmsItem);
    } catch (Exception e) {
      return is;
    }
  }
  
  @Override
  public ItemStack setNBTTag(String tag, ItemStack itemStack) {
    ItemStack save = itemStack.clone();
    try {
      Object nmsItem = getNMSItem(itemStack);
      nmsItem.getClass().getMethod("setTag", VersionUtils.getNMSClass("NBTTagCompound")).invoke(nmsItem,
        VersionUtils.getNMSClass("MojangsonParser").getMethod("parse", String.class).invoke(null, tag));
      return (ItemStack) VersionUtils.getOBCBClass("inventory.CraftItemStack").getMethod("asBukkitCopy",
        nmsItem.getClass()).invoke(null, nmsItem);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return save;
  }
}
