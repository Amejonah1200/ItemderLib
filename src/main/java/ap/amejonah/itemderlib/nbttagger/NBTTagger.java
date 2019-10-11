package ap.amejonah.itemderlib.nbttagger;

import org.bukkit.inventory.ItemStack;

public interface NBTTagger {
  
  public ItemStack setNBTTag(String key, Object o, ItemStack item);
  
  public ItemStack setNBTTag(String tag, ItemStack itemStack);
  
  public ItemStack resetNBTTag(ItemStack item);
  
  public Object getNBTTag(String key, ItemStack item);
  
  public String getNBTTagString(String key, ItemStack item);
  
  public int getNBTTagInt(String key, ItemStack item);
  
  public long getNBTTagLong(String key, ItemStack item);
  
  public ItemStack removeNBTTag(String key, ItemStack item);
  
  public boolean getNBTTagBoolean(String key, ItemStack item);
  
  public Object getNBTTagList(String key, ItemStack item, int type);
  
  public boolean hasTag(String key, ItemStack item);
  
  public float getNBTTagFloat(String key, ItemStack item);
  
  public Object getNMSItem(ItemStack item) throws Throwable;
  
  public Object getNMSCompound(Object nmsItem) throws Throwable;
}
