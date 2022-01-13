package de.onyxbits.raccoon.standalone.base;

import de.onyxbits.raccoon.util.SemanticVersion;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public abstract class AbstractApplication implements ModuleProvider {
   private HashMap registry;
   private Object syn = new Object();
   private Thread hook;

   public SemanticVersion getVersion() {
      try {
         return new SemanticVersion(this.getClass());
      } catch (Exception var3) {
         String[] meta = new String[]{"unknown"};
         return new SemanticVersion(0, 0, 0, new String[0], meta);
      }
   }

   public abstract File pathOf();

   public final Module fetch(Class module) {
      synchronized(this.syn) {
         if (this.registry == null) {
            this.registry = new HashMap();
            this.registry.put(AppAdapter.class, new AppAdapter(this));
            this.hook = new Thread(new ShutdownHook(this));
            Runtime.getRuntime().addShutdownHook(this.hook);
         }

         Module ret = (Module)this.registry.get(module);
         if (ret == null) {
            ret = this.create(module);
            this.registry.put(module, ret);
         }

         return ret;
      }
   }

   public Module create(Class module) {
      try {
         Module ret = (Module)module.newInstance();
         if (ret instanceof ProviderProxy) {
            ((ProviderProxy)ret).register(this);
         }

         return ret;
      } catch (Exception var3) {
         throw new RuntimeException(var3);
      }
   }

   public void shutdown() {
      synchronized(this.syn) {
         if (this.registry != null) {
            Iterator var2 = this.registry.keySet().iterator();

            while(var2.hasNext()) {
               Class key = (Class)var2.next();
               ((Module)this.registry.get(key)).shutdown();
            }

            this.registry = null;
         }

      }
   }

   public abstract String getProductCode();
}
