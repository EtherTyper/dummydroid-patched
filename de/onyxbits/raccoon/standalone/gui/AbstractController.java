package de.onyxbits.raccoon.standalone.gui;

import de.onyxbits.raccoon.standalone.base.Module;
import de.onyxbits.raccoon.standalone.base.ModuleProvider;

public abstract class AbstractController {
   private ModuleProvider provider;

   public AbstractController(ModuleProvider provider) {
      this.provider = provider;
   }

   public final Module fetch(Class clazz) {
      return this.provider.fetch(clazz);
   }
}
