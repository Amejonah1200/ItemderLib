package ap.amejonah.itemderlib;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder implements Cloneable {
  
  protected ItemStack itemStack;
  protected ItemMeta itemMeta;
  protected List<String> lore;
  
  private ItemBuilder(ItemStack itemStack, ItemMeta itemMeta, List<String> lore) {
    this.itemStack = itemStack;
    this.itemMeta = itemMeta;
    this.lore = new ArrayList<>();
    this.lore.addAll(lore);
  }
  
  private ItemBuilder(ItemBuilder itemBuilder) {
    this(itemBuilder.itemStack.clone(), itemBuilder.itemMeta.clone(), itemBuilder.lore);
  }
  
  @Override
  protected ItemBuilder clone() throws CloneNotSupportedException {
    return new ItemBuilder(this);
  }
}
