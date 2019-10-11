package ap.amejonah.itemderlib.nbttagger;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.Set;
import org.bukkit.inventory.ItemStack;
import ap.amejonah.itemderlib.utils.VersionUtils;

public enum NBTReflections {
  
  //@formatter:off
  COMPOUND_SETNBTBASE(VersionUtils.getNMSClass("NBTTagCompound"), "set", String.class, VersionUtils.getNMSClass("NBTBase")),
  COMPOUND_SETBOOLEAN(VersionUtils.getNMSClass("NBTTagCompound"), "setBoolean", String.class, boolean.class),
  COMPOUND_SETBYTE(VersionUtils.getNMSClass("NBTTagCompound"), "setByte", String.class, byte.class),
  COMPOUND_SETBYTEARRAY(VersionUtils.getNMSClass("NBTTagCompound"), "setByteArray", String.class, byte[].class),
  COMPOUND_SETDOUBLE(VersionUtils.getNMSClass("NBTTagCompound"), "setDouble", String.class, double.class),
  COMPOUND_SETFLOAT(VersionUtils.getNMSClass("NBTTagCompound"), "setFloat", String.class, float.class),
  COMPOUND_SETINT(VersionUtils.getNMSClass("NBTTagCompound"), "setInt", String.class, int.class),
  COMPOUND_SETINTARRAY(VersionUtils.getNMSClass("NBTTagCompound"), "setIntArray", String.class, int[].class),
  COMPOUND_SETLONG(VersionUtils.getNMSClass("NBTTagCompound"), "setLong", String.class, long.class),
  COMPOUND_SETSHORT(VersionUtils.getNMSClass("NBTTagCompound"), "setShort", String.class, short.class),
  COMPOUND_SETSTRING(VersionUtils.getNMSClass("NBTTagCompound"), "setString", String.class, String.class),
  
  COMPOUND_GETNBTBASE(VersionUtils.getNMSClass("NBTTagCompound"), VersionUtils.getNMSClass("NBTBase"), "get", String.class),
  COMPOUND_GETBOOLEAN(VersionUtils.getNMSClass("NBTTagCompound"), boolean.class, "getBoolean", String.class),
  COMPOUND_GETBYTE(VersionUtils.getNMSClass("NBTTagCompound"), byte.class, "getByte", String.class),
  COMPOUND_GETBYTEARRAY(VersionUtils.getNMSClass("NBTTagCompound"), byte[].class, "getByteArray", String.class),
  COMPOUND_GETCOMPOUND(VersionUtils.getNMSClass("NBTTagCompound"), VersionUtils.getNMSClass("NBTTagCompound"),  "getByteArray", String.class),
  COMPOUND_GETDOUBLE(VersionUtils.getNMSClass("NBTTagCompound"), double.class, "getDouble", String.class),
  COMPOUND_GETFLOAT(VersionUtils.getNMSClass("NBTTagCompound"), float.class, "getFloat", String.class ),
  COMPOUND_GETINT(VersionUtils.getNMSClass("NBTTagCompound"), int.class, "getInt", String.class),
  COMPOUND_GETINTARRAY(VersionUtils.getNMSClass("NBTTagCompound"), int[].class, "getIntArray", String.class),
  COMPOUND_GETKEYS(VersionUtils.getNMSClass("NBTTagCompound"), Set.class, "getKeys", String.class),
  COMPOUND_GETLIST(VersionUtils.getNMSClass("NBTTagCompound"), VersionUtils.getNMSClass("NBTTagList") , "getList", String.class, int.class),
  COMPOUND_GETLONG(VersionUtils.getNMSClass("NBTTagCompound"), long.class, "getLong", String.class),
  COMPOUND_GETSHORT(VersionUtils.getNMSClass("NBTTagCompound"), short.class, "getShort", String.class),
  COMPOUND_GETSTRING(VersionUtils.getNMSClass("NBTTagCompound"), String.class, "getString", String.class),
  COMPOUND_GETTYPEID(VersionUtils.getNMSClass("NBTTagCompound"), byte.class, "getTypeId"),
  
  COMPOUND_REMOVE(VersionUtils.getNMSClass("NBTTagCompound"), "remove", String.class),
  COMPOUND_HASTAG(VersionUtils.getNMSClass("NBTTagCompound"), boolean.class, "hasKey", String.class),
  
  OBCB_STATIC_ASNMS(VersionUtils.getOBCBClass("inventory.CraftItemStack"), VersionUtils.getNMSClass("ItemStack"), true, "asNMSCopy", ItemStack.class),
  OBCB_STATIC_ASBUKKIT(VersionUtils.getOBCBClass("inventory.CraftItemStack"), ItemStack.class, true, "asBukkitCopy", VersionUtils.getNMSClass("ItemStack")),
  
  MOJANGPARSER_PARSE(VersionUtils.getNMSClass("MojangsonParser"),VersionUtils.getNMSClass("NBTTagCompound"), true, "parse", String.class),
  
  NMSITEM_SETTAG(VersionUtils.getNMSClass("ItemStack"), void.class, "setTag", VersionUtils.getNMSClass("NBTTagCompound")),
  NMSITEM_GETTAG(VersionUtils.getNMSClass("ItemStack"), VersionUtils.getNMSClass("NBTTagCompound"), "getTag"),
  NMSITEM_HASTAG(VersionUtils.getNMSClass("ItemStack"), boolean.class, "hasTag");
  //@formatter:on
  private static Lookup lookup;
  private MethodHandle handle;
  private Method method;
  
  private NBTReflections(Class<?> refClass, Class<?> returnType, boolean isStatic, String name,
      Class<?>... parameters) {
    try {
      if (isStatic) {
        this.handle = lookup().findStatic(refClass, name, MethodType.methodType(returnType, parameters));
      } else {
        this.handle = lookup().findVirtual(refClass, name, MethodType.methodType(returnType, parameters));
      }
      this.method = refClass.getMethod(name, parameters);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private NBTReflections(Class<?> refClass, Class<?> returnType, String name, Class<?>... parameters) {
    this(refClass, returnType, false, name, parameters);
  }
  
  private NBTReflections(Class<?> refClass, String name, Class<?>... parameters) {
    this(refClass, void.class, false, name, parameters);
  }
  
  private Lookup lookup() {
    return lookup == null ? lookup = MethodHandles.lookup() : lookup;
  }
  
  public Object mhInvoke(Object obj, Object... parameters) throws Throwable {
    return this.handle.invoke(obj, parameters);
  }
  
  public void mhInvokeVoid(Object obj, Object... parameters) throws Throwable {
    this.handle.invoke(obj, parameters);
  }
  
  public void mhInvokeStaticVoid(Object... parameters) throws Throwable {
    this.handle.invoke(null, parameters);
  }
  
  public Object mhInvokeStatic(Object... parameters) throws Throwable {
    return this.handle.invoke(parameters);
  }
  
  public Object reflectInvoke(Object obj, Object... parameters) throws Throwable {
    return this.method.invoke(obj, parameters);
  }
  
  public void reflectInvokeVoid(Object obj, Object... parameters) throws Throwable {
    this.method.invoke(obj, parameters);
  }
  
  public void reflectInvokeStaticVoid(Object... parameters) throws Throwable {
    this.method.invoke(null, parameters);
  }
  
  public Object reflectInvokeStatic(Object... parameters) throws Throwable {
    return this.method.invoke(null, parameters);
  }
}
