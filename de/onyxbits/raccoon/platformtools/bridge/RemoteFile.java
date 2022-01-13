package de.onyxbits.raccoon.platformtools.bridge;

public class RemoteFile {
   public final int mode;
   public final long size;
   public final long lastModified;
   public String path;

   public RemoteFile(String path, int mode, long size, long lastModified) {
      this.path = path;
      this.mode = mode;
      this.size = size;
      this.lastModified = lastModified;
   }

   public boolean isDirectory() {
      return (this.mode & 16384) == 16384;
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         RemoteFile other = (RemoteFile)o;
         return this.path.equals(other.path) && this.size == other.size && this.mode == other.mode && this.lastModified == other.lastModified;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.path.hashCode();
   }

   public String toString() {
      StringBuilder ret = new StringBuilder();
      ret.append(this.mode);
      ret.append("\t");
      ret.append(this.size);
      ret.append(" ");
      ret.append(this.lastModified);
      ret.append(" ");
      ret.append(this.path);
      return ret.toString();
   }
}
