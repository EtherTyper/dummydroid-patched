package de.onyxbits.raccoon.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.Adler32;

public class VersionFile {
   private static final String IDPROPERTY = "id";
   private static final String CREATEDPROPERTY = "created";
   private static final String VERSIONCODEPROPERTY = "versionCode";
   private static final String CHECKSUMPROPERTY = "checksum";
   private File file;
   private JsonObject obj;
   private String id;
   private long created;
   private int versionCode;

   public VersionFile(File file) throws FileNotFoundException, IOException, IllegalArgumentException {
      this.file = file;
      FileReader json = null;

      try {
         json = new FileReader(file);
         long fcs = 0L;
         JsonReader reader = new JsonReader(json);
         JsonElement elem = null;
         this.obj = Streams.parse(reader).getAsJsonObject();
         if (this.obj.has("id")) {
            elem = this.obj.get("id");
            if (elem.getAsJsonPrimitive().isString()) {
               this.id = elem.getAsString();
            }
         }

         if (this.obj.has("created")) {
            elem = this.obj.get("created");
            if (elem.getAsJsonPrimitive().isNumber()) {
               this.created = elem.getAsLong();
            }
         }

         if (this.obj.has("versionCode")) {
            elem = this.obj.get("versionCode");
            if (elem.getAsJsonPrimitive().isNumber()) {
               this.versionCode = elem.getAsInt();
            }
         }

         if (this.obj.has("checksum")) {
            elem = this.obj.get("checksum");
            if (elem.getAsJsonPrimitive().isNumber()) {
               fcs = elem.getAsLong();
            }
         }

         long cs = checksum(this.id, this.versionCode, this.created);
         if (cs != fcs) {
            throw new IllegalArgumentException("checksum mismatch");
         }
      } catch (JsonIOException var17) {
         throw new IOException(var17.getMessage());
      } catch (JsonParseException var18) {
         throw new IllegalArgumentException("broken file");
      } finally {
         try {
            json.close();
         } catch (IOException var16) {
         }

      }

   }

   public long getCreated() {
      return this.created;
   }

   public String getId() {
      return this.id;
   }

   public int getVersionCode() {
      return this.versionCode;
   }

   public VersionFile update(int versionCode) throws IOException {
      if (versionCode < this.versionCode) {
         throw new IllegalArgumentException("Cannot downgrade!");
      } else {
         this.file.delete();
         this.versionCode = versionCode;
         return create(this.file, this.getCreated(), this.getId(), versionCode);
      }
   }

   public static VersionFile create(File file, String id, int versionCode) throws IOException {
      return create(file, System.currentTimeMillis(), id, versionCode);
   }

   public static VersionFile create(File file, long created, String id, int versionCode) throws IOException {
      if (versionCode < 0) {
         throw new IllegalArgumentException("version code must not be negative");
      } else {
         long checksum = checksum(id, versionCode, created);
         JsonObject obj = new JsonObject();
         obj.addProperty("id", id);
         obj.addProperty("versionCode", (Number)versionCode);
         obj.addProperty("created", (Number)created);
         obj.addProperty("checksum", (Number)checksum);
         FileOutputStream fos = new FileOutputStream(file);
         Throwable var9 = null;

         VersionFile var10;
         try {
            fos.write(obj.toString().getBytes());
            var10 = new VersionFile(file);
         } catch (Throwable var19) {
            var9 = var19;
            throw var19;
         } finally {
            if (fos != null) {
               if (var9 != null) {
                  try {
                     fos.close();
                  } catch (Throwable var18) {
                     var9.addSuppressed(var18);
                  }
               } else {
                  fos.close();
               }
            }

         }

         return var10;
      }
   }

   private static long checksum(String id, int vc, long created) {
      Adler32 adler = new Adler32();
      StringBuilder sb = new StringBuilder();
      sb.append(id);
      sb.append(vc);
      sb.append(created);
      adler.update(sb.toString().getBytes());
      return adler.getValue();
   }
}
