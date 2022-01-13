package org.bouncycastle.tls;

import java.io.OutputStream;

public class TlsNullCompression implements TlsCompression {
   public OutputStream compress(OutputStream var1) {
      return var1;
   }

   public OutputStream decompress(OutputStream var1) {
      return var1;
   }
}
