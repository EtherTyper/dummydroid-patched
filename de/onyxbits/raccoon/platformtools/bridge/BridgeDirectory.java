package de.onyxbits.raccoon.platformtools.bridge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BridgeDirectory implements Runnable {
   public static final int ADBPORT = 5037;
   public final int port;
   public final InetAddress addr;
   private List previous;
   private Socket socket;

   public BridgeDirectory() {
      this(InetAddress.getLoopbackAddress(), 5037);
   }

   public BridgeDirectory(int port) {
      this(InetAddress.getLoopbackAddress(), port);
   }

   public BridgeDirectory(InetAddress addr, int port) {
      this.addr = addr;
      this.port = port;
      if (addr == null) {
         throw new NullPointerException();
      } else {
         this.previous = Collections.emptyList();
      }
   }

   public List list() {
      Socket socket = null;

      List var3;
      try {
         socket = new Socket(this.addr, this.port);
         InputStream in = socket.getInputStream();
         OutputStream out = socket.getOutputStream();
         WireProtocol.send("host:devices", in, out);
         List var4 = this.poll(in, out);
         return var4;
      } catch (IOException var8) {
         var3 = Collections.emptyList();
      } finally {
         BridgeClient.closeQuietly(socket);
      }

      return var3;
   }

   public boolean ping() {
      Socket socket = null;

      boolean var3;
      try {
         socket = new Socket(this.addr, this.port);
         boolean var2 = true;
         return var2;
      } catch (IOException var7) {
         var3 = false;
      } finally {
         BridgeClient.closeQuietly(socket);
      }

      return var3;
   }

   public BridgeClient connect(String serial) {
      if (serial != null) {
         return new BridgeClient(this.addr, this.port, serial);
      } else if (!this.previous.isEmpty()) {
         return new BridgeClient(this.addr, this.port, (String)this.previous.get(0));
      } else {
         List tmp = this.list();
         return !tmp.isEmpty() ? new BridgeClient(this.addr, this.port, (String)tmp.get(0)) : new BridgeClient(this.addr, this.port, "");
      }
   }

   public static void startServer(File bin) throws InterruptedException, FileNotFoundException, IOException {
      if (bin.exists()) {
         Runtime rt = Runtime.getRuntime();
         rt.exec(bin.getAbsolutePath() + " start-server").waitFor();
      } else {
         throw new FileNotFoundException(bin.getAbsolutePath());
      }
   }

   public void kill() {
      if (this.socket != null) {
         try {
            this.socket.close();
         } catch (IOException var2) {
         }
      }

   }

   public void run() {
      try {
         this.socket = new Socket(this.addr, this.port);
         InputStream in = this.socket.getInputStream();
         OutputStream out = this.socket.getOutputStream();
         WireProtocol.send("host:track-devices", in, out);

         while(!this.socket.isClosed()) {
            List tmp = this.poll(in, out);
            List added = new ArrayList();
            List removed = new ArrayList();
            List connected = new ArrayList();
            Iterator var7 = tmp.iterator();

            String s;
            while(var7.hasNext()) {
               s = (String)var7.next();
               connected.add(s);
               if (!this.previous.contains(s)) {
                  added.add(s);
               }
            }

            var7 = this.previous.iterator();

            while(var7.hasNext()) {
               s = (String)var7.next();
               if (!connected.contains(s)) {
                  removed.add(s);
               }
            }

            this.onHotPlug(connected, removed, added);
            this.previous = tmp;
         }
      } catch (Exception var12) {
      } finally {
         BridgeClient.closeQuietly(this.socket);
      }

   }

   protected void onHotPlug(List connected, List removed, List added) {
   }

   private List poll(InputStream in, OutputStream out) throws IOException {
      StringBuilder sb = new StringBuilder();
      Stack ret = new Stack();
      byte[] buf = new byte[4];
      in.read(buf);
      int len = Integer.parseInt(new String(buf, 0, 4), 16);
      if (len == 0) {
         return ret;
      } else {
         for(int i = 0; i < len; ++i) {
            int a = in.read();
            switch(a) {
            case 9:
               ret.push(sb.toString());
               break;
            case 10:
               sb.setLength(0);
               break;
            default:
               sb.append((char)a);
            }
         }

         return ret;
      }
   }
}
