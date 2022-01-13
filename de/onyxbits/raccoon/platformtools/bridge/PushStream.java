package de.onyxbits.raccoon.platformtools.bridge;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

class PushStream extends OutputStream {
   private OutputStream output;
   private final byte[] DATA = "DATA".getBytes();

   public PushStream(BridgeClient client, Socket socket, String remote) throws IOException {
      InputStream input = socket.getInputStream();
      this.output = socket.getOutputStream();
      WireProtocol.send("host:transport:" + client.serial, input, this.output);
      WireProtocol.send("sync:", input, this.output);
      this.writeBytes("SEND");
      this.writeInt(Integer.reverseBytes(remote.length()));
      this.writeBytes(remote);
      this.output.flush();
   }

   public PushStream(DataOutputStream out) {
      this.output = out;
   }

   public void write(byte[] b, int off, int len) throws IOException {
      for(int i = 0; i < this.DATA.length; ++i) {
         this.output.write(this.DATA[i]);
      }

      this.writeInt(Integer.reverseBytes(len - off));
      this.output.write(b, off, len);
   }

   public void write(int b) throws IOException {
      for(int i = 0; i < this.DATA.length; ++i) {
         this.output.write(this.DATA[i]);
      }

      this.writeInt(Integer.reverseBytes(1));
      this.output.write(b);
   }

   public void close() throws IOException {
      if (this.output != null) {
         this.writeBytes("DONE");
         this.writeInt(Integer.reverseBytes(0));
         this.output.flush();
         this.output.close();
         this.output = null;
      }

   }

   private final void writeInt(int v) throws IOException {
      this.output.write(v >>> 24 & 255);
      this.output.write(v >>> 16 & 255);
      this.output.write(v >>> 8 & 255);
      this.output.write(v >>> 0 & 255);
   }

   private final void writeBytes(String s) throws IOException {
      int len = s.length();

      for(int i = 0; i < len; ++i) {
         this.output.write((byte)s.charAt(i));
      }

   }
}
