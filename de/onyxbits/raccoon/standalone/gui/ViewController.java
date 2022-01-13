package de.onyxbits.raccoon.standalone.gui;

import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import java.awt.Container;

public abstract class ViewController extends AbstractController {
   public ViewController(ModuleProvider provider) {
      super(provider);
   }

   public abstract Container mount();
}
