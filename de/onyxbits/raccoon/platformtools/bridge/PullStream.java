package de.onyxbits.raccoon.platformtools.bridge;

import java.io.IOException;
import java.io.InputStream;

class PullStream extends InputStream {
   private InputStream input;
   private int left;

   public PullStream(InputStream in) {
      this.input = in;
   }

   public int read() throws IOException {
      if (this.input == null) {
         return -1;
      } else {
         if (this.left == 0) {
            byte[] buf = new byte[8];
            this.input.read(buf);
            int res = WireProtocol.parseInt(buf, 0);
            int len = WireProtocol.parseInt(buf, 4);
            if (res == WireProtocol.DONE) {
               this.close();
               return -1;
            }

            if (res == WireProtocol.FAIL) {
               buf = new byte[len];
               this.input.read(buf);
               this.input.close();
               throw new IOException(new String(buf));
            }

            if (res == WireProtocol.DATA) {
               this.left = len;
            }
         }

         --this.left;
         return this.input.read();
      }
   }

   public void close() throws IOException {
      if (this.input != null) {
         this.input.close();
         this.input = null;
      }

   }
}
