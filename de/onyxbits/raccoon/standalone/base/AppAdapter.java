package de.onyxbits.raccoon.standalone.base;

import de.onyxbits.raccoon.util.SemanticVersion;
import java.io.File;

public final class AppAdapter implements Module, ModuleProvider {
   private AbstractApplication app;

   protected AppAdapter(AbstractApplication app) {
      this.app = app;
   }

   public void exit() {
      this.app.shutdown();
   }

   public SemanticVersion getVersion() {
      return this.app.getVersion();
   }

   public String getProductCode() {
      return this.app.getProductCode();
   }

   public File pathOf() {
      return this.app.pathOf();
   }

   public File pathOfConfig() {
      return new File(this.pathOf(), "config");
   }

   public void shutdown() {
   }

   public Module fetch(Class clazz) {
      return this.app.fetch(clazz);
   }
}
