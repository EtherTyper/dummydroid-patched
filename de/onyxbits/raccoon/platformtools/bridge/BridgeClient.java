package de.onyxbits.raccoon.platformtools.bridge;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Vector;

public class BridgeClient {
   public final String serial;
   private InetAddress addr;
   private int port;

   public BridgeClient(InetAddress addr, int port, String serial) {
      this.addr = addr;
      this.port = port;
      this.serial = serial;
   }

   public InputStream openPullStream(String fname) throws IOException {
      Socket socket = new Socket(this.addr, this.port);
      InputStream in = socket.getInputStream();
      OutputStream out = socket.getOutputStream();
      DataOutputStream output = new DataOutputStream(socket.getOutputStream());
      WireProtocol.send("host:transport:" + this.serial, in, out);
      WireProtocol.send("sync:", in, out);
      output.writeBytes("RECV");
      output.writeInt(Integer.reverseBytes(fname.length()));
      output.writeBytes(fname);
      output.flush();
      return new PullStream(in);
   }

   public OutputStream openPushStream(String fname, int mode) throws IOException {
      Socket socket = new Socket(this.addr, this.port);
      InputStream in = socket.getInputStream();
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      WireProtocol.send("host:transport:" + this.serial, in, out);
      WireProtocol.send("sync:", in, out);
      out.writeBytes("SEND");
      String target = fname + "," + mode;
      out.writeInt(Integer.reverseBytes(target.length()));
      out.writeBytes(target);
      out.flush();
      return new PushStream(out);
   }

   public InputStream execStreaming(String cmd) throws IOException {
      Socket socket = new Socket(this.addr, this.port);
      InputStream in = socket.getInputStream();
      OutputStream out = socket.getOutputStream();
      WireProtocol.send("host:transport:" + this.serial, in, out);
      WireProtocol.send("shell:" + cmd, in, out);
      return in;
   }

   public String exec(String cmd) throws IOException {
      StringBuilder sb = new StringBuilder();
      InputStream in = this.execStreaming(cmd);
      int len = true;
      byte[] buf = new byte[1024];

      int len;
      while((len = in.read(buf)) != -1) {
         sb.append(new String(buf, 0, len));
      }

      in.close();
      return sb.toString();
   }

   public String getState() throws IOException {
      Socket socket = new Socket(this.addr, this.port);
      Throwable var2 = null;

      try {
         InputStream in = socket.getInputStream();
         DataOutputStream out = new DataOutputStream(socket.getOutputStream());
         WireProtocol.send("host-serial:" + this.serial + ":get-state", in, out);
         StringBuilder sb = new StringBuilder();
         byte[] buf = new byte[256];
         boolean var7 = true;

         int len;
         while((len = in.read(buf)) != -1) {
            sb.append(new String(buf, 0, len, Charset.defaultCharset()));
         }

         String var8 = sb.toString();
         return var8;
      } catch (Throwable var17) {
         var2 = var17;
         throw var17;
      } finally {
         if (socket != null) {
            if (var2 != null) {
               try {
                  socket.close();
               } catch (Throwable var16) {
                  var2.addSuppressed(var16);
               }
            } else {
               socket.close();
            }
         }

      }
   }

   public void screenshot() throws IOException {
      Socket socket = null;

      try {
         socket = new Socket(this.addr, this.port);
         InputStream in = socket.getInputStream();
         OutputStream out = socket.getOutputStream();
         WireProtocol.send("host:transport:" + this.serial, in, out);
         WireProtocol.send("framebuffer:", in, out);
         byte[] buffer = new byte[16384];
         in.read(buffer, 0, 16);
         int depth = WireProtocol.parseInt(buffer, 0);
         int size = WireProtocol.parseInt(buffer, 4);
         int width = WireProtocol.parseInt(buffer, 8);
         int height = WireProtocol.parseInt(buffer, 12);
         System.err.println(depth + " " + size + " " + width + " " + height);
         int len = false;
         FileOutputStream fout = new FileOutputStream(new File("/tmp/fb"));

         int len;
         while((len = in.read(buffer)) != -1) {
            fout.write(buffer, 0, len);
         }

         fout.close();
      } catch (IOException var12) {
         try {
            socket.close();
         } catch (IOException var11) {
         }

         throw var12;
      }
   }

   public RemoteFile stat(String remotePath) throws IOException {
      Socket socket = null;

      RemoteFile var7;
      try {
         socket = new Socket(this.addr, this.port);
         InputStream in = socket.getInputStream();
         DataOutputStream out = new DataOutputStream(socket.getOutputStream());
         WireProtocol.send("host:transport:" + this.serial, in, out);
         WireProtocol.send("sync:", in, out);
         out.writeBytes("STAT");
         out.writeInt(Integer.reverseBytes(remotePath.length()));
         out.writeBytes(remotePath);
         byte[] buf = new byte[12];
         in.read(buf, 0, 4);
         if (WireProtocol.parseInt(buf, 0) != WireProtocol.STAT) {
            throw new IOException("Protocol Error");
         }

         in.read(buf, 0, 12);
         socket.close();
         int mode = WireProtocol.parseInt(buf, 0);
         if (mode != 0) {
            var7 = new RemoteFile(remotePath, mode, (long)WireProtocol.parseInt(buf, 4), (long)WireProtocol.parseInt(buf, 8));
            return var7;
         }

         var7 = null;
      } finally {
         closeQuietly(socket);
      }

      return var7;
   }

   public List list(String remotePath) throws IOException {
      Socket socket = null;

      try {
         socket = new Socket(this.addr, this.port);
         InputStream in = socket.getInputStream();
         DataOutputStream out = new DataOutputStream(socket.getOutputStream());
         WireProtocol.send("host:transport:" + this.serial, in, out);
         WireProtocol.send("sync:", in, out);
         out.writeBytes("LIST");
         out.writeInt(Integer.reverseBytes(remotePath.length()));
         out.writeBytes(remotePath);
         byte[] buf = new byte[512];
         List result = new Vector();
         in.read(buf, 0, 4);

         while(WireProtocol.parseInt(buf, 0) == WireProtocol.DENT) {
            in.read(buf, 0, 16);
            int len = WireProtocol.parseInt(buf, 12);
            in.read(buf, 0, len);
            String fname = new String(buf, 0, len);
            result.add(new RemoteFile(fname, WireProtocol.parseInt(buf, 0), (long)WireProtocol.parseInt(buf, 4), (long)WireProtocol.parseInt(buf, 8)));
            in.read(buf, 0, 4);
         }

         Vector var12 = result;
         return var12;
      } finally {
         closeQuietly(socket);
      }
   }

   public String pathOfExternalStorage() throws IOException {
      String ret = this.exec("echo $EXTERNAL_STORAGE").trim();
      return ret.endsWith("/") ? ret.substring(0, ret.length() - 2) : ret;
   }

   public String pathOfStagingArea() {
      return "/data/local/tmp";
   }

   public static void closeQuietly(Socket socket) {
      if (socket != null) {
         try {
            socket.close();
         } catch (IOException var2) {
         }
      }

   }

   public static void closeQuietly(InputStream in) {
      if (in != null) {
         try {
            in.close();
         } catch (IOException var2) {
         }
      }

   }
}
