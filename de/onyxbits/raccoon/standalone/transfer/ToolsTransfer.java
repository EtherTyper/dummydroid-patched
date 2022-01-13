package de.onyxbits.raccoon.standalone.transfer;

import de.onyxbits.raccoon.platformtools.Sources;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

public class ToolsTransfer extends AbstractTransfer {
   private HttpClient client;
   private long size;
   private File dest;
   private HttpEntity entity;
   private File temp;

   public ToolsTransfer(HttpClient client, File dest) {
      this.client = client;
      this.dest = dest;
   }

   public long getTotal() {
      return this.size;
   }

   protected void onPreProcess() {
      HttpGet get = new HttpGet(Sources.getOsUrl());

      try {
         this.temp = File.createTempFile("platform-tools", ".zip");
         HttpResponse response = this.client.execute(get);
         this.entity = response.getEntity();
         this.size = this.entity.getContentLength();
      } catch (Exception var3) {
         this.logFatal(var3.getMessage());
         EntityUtils.consumeQuietly(this.entity);
      }

   }

   protected void onTransfer() {
      try {
         FileOutputStream out = new FileOutputStream(this.temp);
         this.copy(this.entity.getContent(), new OutputStream[]{out});
      } catch (Exception var2) {
         this.logFatal(var2.getMessage());
         EntityUtils.consumeQuietly(this.entity);
      }

   }

   protected void onPostProcess() {
      try {
         ZipFile zip = new ZipFile(this.temp);
         ZipEntry entry = null;
         byte[] buffer = new byte[8192];
         Enumeration e = zip.entries();
         this.dest.mkdirs();

         while(e.hasMoreElements()) {
            entry = (ZipEntry)e.nextElement();
            File tmp = this.dest;
            String[] path = entry.getName().split("/");

            for(int i = 1; i < path.length - 1; ++i) {
               tmp = new File(tmp, path[i]);
               if (!tmp.exists()) {
                  tmp.mkdirs();
               }
            }

            if (!entry.isDirectory()) {
               tmp = new File(tmp, path[path.length - 1]);
               FileOutputStream fos = new FileOutputStream(tmp);
               InputStream ins = zip.getInputStream(entry);

               int len;
               while((len = ins.read(buffer)) > 0) {
                  fos.write(buffer, 0, len);
               }

               fos.close();
               ins.close();
               tmp.setExecutable(this.isExecutable(entry));
            }
         }

         zip.close();
      } catch (Exception var10) {
         this.logFatal(var10.getMessage());
      }

   }

   private boolean isExecutable(ZipEntry entry) {
      return true;
   }
}
