package ap.amejonah.itemderlib;

import ap.amejonah.itemderlib.nbttagger.NBTTagger;
import ap.amejonah.itemderlib.nbttagger.NBTTaggerMethodHandles;
import ap.amejonah.itemderlib.nbttagger.NBTTaggerReflect;

public class ItemBuilderLib {
  
  private static ItemBuilderLib instance;
  private NBTTagger nbtTagger;
  
  public ItemBuilderLib() {
    try {
      this.nbtTagger = new NBTTaggerMethodHandles();
    } catch (Throwable e) {
      e.printStackTrace();
      this.nbtTagger = new NBTTaggerReflect();
    }
    
  }
  
  public NBTTagger getNbtTagger() {
    return nbtTagger;
  }
  
  public static ItemBuilderLib getInstance() {
    return instance == null ? instance = new ItemBuilderLib() : instance;
  }
}
