package org.bouncycastle.tls;

import java.io.IOException;
import java.io.OutputStream;

abstract class SimpleOutputStream extends OutputStream {
   public void close() {
   }

   public void flush() {
   }

   public void write(int var1) throws IOException {
      byte[] var2 = new byte[]{(byte)var1};
      this.write(var2, 0, 1);
   }
}
