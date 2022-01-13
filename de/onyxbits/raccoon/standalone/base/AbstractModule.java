package de.onyxbits.raccoon.standalone.base;

public abstract class AbstractModule implements ProviderProxy, Module {
   private ModuleProvider provider;

   public void register(ModuleProvider provider) {
      this.provider = provider;
   }

   public final Module fetch(Class clazz) {
      return this.provider.fetch(clazz);
   }

   public void shutdown() {
   }
}
