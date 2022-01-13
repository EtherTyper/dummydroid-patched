package de.onyxbits.raccoon.platformtools.bridge;

import de.onyxbits.raccoon.mockup.Device;
import de.onyxbits.raccoon.mockup.MockUtil;
import java.io.IOException;
import java.io.InputStream;

public class SpecTool extends ShellTool {
   public SpecTool(BridgeClient client) {
      super(client);
   }

   protected InputStream openCode() throws IOException {
      String name = this.getClass().getPackage().getName().replace('.', '/').concat("/shelltools.jar");
      return this.getClass().getClassLoader().getResourceAsStream(name);
   }

   protected String getMainClass() {
      return "de.onyxbits.raccoon.shelltools.Main";
   }

   protected String getBaseName() {
      return "devicespecs";
   }

   public Device describe() throws IOException {
      String json = this.client.exec(this.createCommand(new String[]{"--spec"}));
      if (json.startsWith("Killed")) {
         throw new IOException("Killed");
      } else {
         return MockUtil.decodeDevice(json);
      }
   }
}
