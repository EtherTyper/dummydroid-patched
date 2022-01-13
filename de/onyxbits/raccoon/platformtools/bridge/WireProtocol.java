package de.onyxbits.raccoon.platformtools.bridge;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class WireProtocol {
   protected static final int OKAY = parseInt("OKAY".getBytes(), 0);
   protected static final int FAIL = parseInt("FAIL".getBytes(), 0);
   protected static final int DONE = parseInt("DONE".getBytes(), 0);
   protected static final int DATA = parseInt("DATA".getBytes(), 0);
   protected static final int DENT = parseInt("DENT".getBytes(), 0);
   protected static final int STAT = parseInt("STAT".getBytes(), 0);

   protected static int parseInt(byte[] buffer, int offset) {
      return buffer[offset] & 255 | (buffer[offset + 1] & 255) << 8 | (buffer[offset + 2] & 255) << 16 | (buffer[offset + 3] & 255) << 24;
   }

   protected static void send(String command, InputStream in, OutputStream out) throws IOException {
      out.write(String.format("%04x", command.length()).getBytes());
      out.write(command.getBytes());
      out.flush();
      byte[] buf = new byte[4];
      in.read(buf);
      int response = parseInt(buf, 0);
      if (response != OKAY) {
         in.read(buf);
         buf = new byte[Integer.parseInt(new String(buf, 0, 4), 16)];
         in.read(buf);
         throw new IOException(new String(buf));
      }
   }
}
