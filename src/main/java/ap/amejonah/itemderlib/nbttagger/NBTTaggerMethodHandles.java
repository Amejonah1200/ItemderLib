package ap.amejonah.itemderlib.nbttagger;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import ap.amejonah.itemderlib.utils.VersionUtils;

public final class NBTTaggerMethodHandles implements NBTTagger {
  
  
  public NBTTaggerMethodHandles() throws Throwable {
    ItemStack item = new ItemStack(Material.DIRT);
    if(NBTReflections.OBCB_STATIC_ASBUKKIT.mhInvokeStatic(NBTReflections.OBCB_STATIC_ASNMS.mhInvokeStatic(item)).equals(item)) {
      throw new Exception("Unable to use MethodHandles.");
    }
  }
  
  @Override
  public ItemStack setNBTTag(String key, Object obj, ItemStack is) {
    ItemStack save = is.clone();
    try {
      Object nmsItem = getNMSItem(is);
      Object compound = getNMSCompound(nmsItem);
      if (obj.getClass().isAssignableFrom(VersionUtils.getNMSClass("NBTBase"))) {
        NBTReflections.COMPOUND_SETNBTBASE.mhInvoke(compound, key, obj);
      } else if (obj instanceof String) {
        NBTReflections.COMPOUND_SETSTRING.mhInvoke(compound, key, obj);
      } else if (obj instanceof Boolean) {
        NBTReflections.COMPOUND_SETBOOLEAN.mhInvoke(compound, key, obj);
      } else if (obj instanceof Integer) {
        NBTReflections.COMPOUND_SETINT.mhInvoke(compound, key, obj);
      } else if (obj instanceof Float) {
        NBTReflections.COMPOUND_SETFLOAT.mhInvoke(compound, key, obj);
      } else if (obj instanceof Long) {
        NBTReflections.COMPOUND_SETLONG.mhInvoke(compound, key, obj);
      } else if (obj instanceof Byte) {
        NBTReflections.COMPOUND_SETBYTE.mhInvoke(compound, key, obj);
      } else if (obj instanceof byte[]) {
        NBTReflections.COMPOUND_SETBYTEARRAY.mhInvoke(compound, key, obj);
      } else if (obj instanceof Double) {
        NBTReflections.COMPOUND_SETDOUBLE.mhInvoke(compound, key, obj);
      } else if (obj instanceof int[]) {
        NBTReflections.COMPOUND_SETINTARRAY.mhInvoke(compound, key, obj);
      } else if (obj instanceof Short) {
        NBTReflections.COMPOUND_SETSHORT.mhInvoke(compound, key, obj);
      }
      NBTReflections.NMSITEM_SETTAG.mhInvokeVoid(nmsItem, compound);
      return (ItemStack) NBTReflections.OBCB_STATIC_ASBUKKIT.mhInvokeStatic(nmsItem);
    } catch (Throwable e) {
      e.printStackTrace();
    }
    return save;
  }
  
  @Override
  public ItemStack setNBTTag(String tag, ItemStack item) {
    try {
      Object nmsItem = getNMSItem(item);
      Object compound = NBTReflections.MOJANGPARSER_PARSE.mhInvokeStatic(tag);
      NBTReflections.NMSITEM_SETTAG.mhInvokeVoid(nmsItem, compound);
      return (ItemStack) NBTReflections.OBCB_STATIC_ASBUKKIT.mhInvokeStatic(nmsItem);
    } catch (Throwable e) {
      e.printStackTrace();
      return item;
    }
  }
  
  @Override
  public ItemStack resetNBTTag(ItemStack item) {
    try {
      Object nmsItem = getNMSItem(item);
      Object compound = VersionUtils.getNMSClass("NBTTagCompound").getConstructor().newInstance();
      NBTReflections.NMSITEM_SETTAG.mhInvokeVoid(nmsItem, compound);
      return (ItemStack) NBTReflections.OBCB_STATIC_ASBUKKIT.mhInvokeStatic(nmsItem);
    } catch (Throwable e) {
      e.printStackTrace();
      return item;
    }
  }
  
  @Override
  public Object getNBTTag(String key, ItemStack item) {
    try {
      return NBTReflections.COMPOUND_GETNBTBASE.mhInvoke(getNMSCompound(item), key);
    } catch (Throwable e) {
      return null;
    }
  }
  
  @Override
  public String getNBTTagString(String key, ItemStack item) {
    try {
      return (String) NBTReflections.COMPOUND_GETSTRING.mhInvoke(getNMSCompound(item), key);
    } catch (Throwable e) {
      return null;
    }
  }
  
  @Override
  public int getNBTTagInt(String key, ItemStack item) {
    try {
      return (int) NBTReflections.COMPOUND_GETLONG.mhInvoke(getNMSCompound(item), key);
    } catch (Throwable e) {
      return 0;
    }
  }
  
  @Override
  public long getNBTTagLong(String key, ItemStack item) {
    try {
      return (long) NBTReflections.COMPOUND_GETLONG.mhInvoke(getNMSCompound(item), key);
    } catch (Throwable e) {
      return 0;
    }
  }
  
  @Override
  public ItemStack removeNBTTag(String key, ItemStack item) {
    try {
      return (ItemStack) NBTReflections.OBCB_STATIC_ASBUKKIT.mhInvokeStatic(
        NBTReflections.COMPOUND_REMOVE.mhInvoke(getNMSCompound(item), key));
    } catch (Throwable e) {
      return item;
    }
  }
  
  @Override
  public boolean getNBTTagBoolean(String key, ItemStack item) {
    try {
      return (boolean) NBTReflections.COMPOUND_GETBOOLEAN.mhInvoke(getNMSCompound(item), key);
    } catch (Throwable e) {
      return false;
    }
  }
  
  @Override
  public Object getNBTTagList(String key, ItemStack item, int type) {
    try {
      return NBTReflections.COMPOUND_GETLIST.mhInvoke(getNMSCompound(item), key);
    } catch (Throwable e) {
      return null;
    }
  }
  
  @Override
  public boolean hasTag(String key, ItemStack item) {
    try {
      return (boolean) NBTReflections.COMPOUND_HASTAG.mhInvoke(getNMSCompound(item), key);
    } catch (Throwable e) {
      return false;
    }
  }
  
  @Override
  public float getNBTTagFloat(String key, ItemStack item) {
    try {
      return (float) NBTReflections.COMPOUND_GETFLOAT.mhInvoke(getNMSCompound(item), key);
    } catch (Throwable e) {
      return 0.0F;
    }
  }
  
  @Override
  public Object getNMSItem(ItemStack is) throws Throwable {
    return NBTReflections.OBCB_STATIC_ASNMS.mhInvokeStatic(is);
  }
  
  @Override
  public Object getNMSCompound(Object item) throws Throwable {
    if (item instanceof ItemStack) { return getNMSCompound(NBTReflections.OBCB_STATIC_ASNMS.mhInvokeStatic(item)); }
    return (boolean) NBTReflections.NMSITEM_HASTAG.mhInvoke(item) ? NBTReflections.NMSITEM_GETTAG.mhInvoke(
      item) : VersionUtils.getNMSClass("NBTTagCompound").getConstructor().newInstance();
  }
}
