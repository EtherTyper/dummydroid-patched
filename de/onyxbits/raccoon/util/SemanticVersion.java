package de.onyxbits.raccoon.util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public final class SemanticVersion implements Comparable {
   public final int major;
   public final int minor;
   public final int patch;
   private final String[] preRelease;
   private final String[] buildMeta;
   private int[] vParts;
   private ArrayList preParts;
   private ArrayList metaParts;
   private int errPos;
   private String errMes;
   private char[] input;

   public SemanticVersion(int major, int minor, int patch) {
      this(major, minor, patch, new String[0], new String[0]);
   }

   public SemanticVersion(int major, int minor, int patch, String[] preRelease, String[] buildMeta) {
      if (major >= 0 && minor >= 0 && patch >= 0) {
         this.buildMeta = new String[buildMeta.length];
         this.preRelease = new String[preRelease.length];
         Pattern p = Pattern.compile("[0-9A-Za-z-]+");

         int i;
         for(i = 0; i < preRelease.length; ++i) {
            if (preRelease[i] == null || !p.matcher(preRelease[i]).matches()) {
               throw new IllegalArgumentException("Pre Release tag: " + i);
            }

            this.preRelease[i] = preRelease[i];
         }

         for(i = 0; i < buildMeta.length; ++i) {
            if (buildMeta[i] == null || !p.matcher(buildMeta[i]).matches()) {
               throw new IllegalArgumentException("Build Meta tag: " + i);
            }

            this.buildMeta[i] = buildMeta[i];
         }

         this.major = major;
         this.minor = minor;
         this.patch = patch;
      } else {
         throw new IllegalArgumentException("Versionnumbers must be positive!");
      }
   }

   public SemanticVersion(Class clazz) throws ParseException {
      this(clazz.getPackage().getImplementationVersion());
   }

   public SemanticVersion(String version) throws ParseException {
      this.vParts = new int[3];
      this.preParts = new ArrayList(5);
      this.metaParts = new ArrayList(5);
      this.input = version.toCharArray();
      if (!this.stateMajor()) {
         throw new ParseException(this.errMes, this.errPos);
      } else {
         this.major = this.vParts[0];
         this.minor = this.vParts[1];
         this.patch = this.vParts[2];
         this.preRelease = (String[])this.preParts.toArray(new String[this.preParts.size()]);
         this.buildMeta = (String[])this.metaParts.toArray(new String[this.metaParts.size()]);
      }
   }

   public boolean hasBuildMeta(String tag) {
      String[] var2 = this.buildMeta;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String s = var2[var4];
         if (s.equals(tag)) {
            return true;
         }
      }

      return false;
   }

   public boolean hasPreRelease(String tag) {
      String[] var2 = this.preRelease;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String s = var2[var4];
         if (s.equals(tag)) {
            return true;
         }
      }

      return false;
   }

   public String[] getPreRelease() {
      String[] ret = new String[this.preRelease.length];
      System.arraycopy(this.preRelease, 0, ret, 0, ret.length);
      return ret;
   }

   public String[] getBuildMeta() {
      String[] ret = new String[this.buildMeta.length];
      System.arraycopy(this.buildMeta, 0, ret, 0, ret.length);
      return ret;
   }

   public boolean isUpdateFor(SemanticVersion v) {
      return this.compareTo(v) > 0;
   }

   public boolean isCompatibleUpdateFor(SemanticVersion v) {
      return this.isUpdateFor(v) && this.major == v.major && (this.major != 0 || v.major != 0);
   }

   public boolean isStable() {
      return this.major > 0 && this.preRelease.length == 0;
   }

   public String toString() {
      StringBuilder ret = new StringBuilder();
      ret.append(this.major);
      ret.append('.');
      ret.append(this.minor);
      ret.append('.');
      ret.append(this.patch);
      int i;
      if (this.preRelease.length > 0) {
         ret.append('-');

         for(i = 0; i < this.preRelease.length; ++i) {
            ret.append(this.preRelease[i]);
            if (i < this.preRelease.length - 1) {
               ret.append('.');
            }
         }
      }

      if (this.buildMeta.length > 0) {
         ret.append('+');

         for(i = 0; i < this.buildMeta.length; ++i) {
            ret.append(this.buildMeta[i]);
            if (i < this.buildMeta.length - 1) {
               ret.append('.');
            }
         }
      }

      return ret.toString();
   }

   public int hashCode() {
      return this.toString().hashCode();
   }

   public boolean equals(Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof SemanticVersion)) {
         return false;
      } else {
         SemanticVersion ov = (SemanticVersion)other;
         if (ov.major == this.major && ov.minor == this.minor && ov.patch == this.patch) {
            if (ov.preRelease.length != this.preRelease.length) {
               return false;
            } else {
               int i;
               for(i = 0; i < this.preRelease.length; ++i) {
                  if (!this.preRelease[i].equals(ov.preRelease[i])) {
                     return false;
                  }
               }

               if (ov.buildMeta.length != this.buildMeta.length) {
                  return false;
               } else {
                  for(i = 0; i < this.buildMeta.length; ++i) {
                     if (!this.buildMeta[i].equals(ov.buildMeta[i])) {
                        return false;
                     }
                  }

                  return true;
               }
            }
         } else {
            return false;
         }
      }
   }

   public int compareTo(SemanticVersion v) {
      int result = this.major - v.major;
      if (result == 0) {
         result = this.minor - v.minor;
         if (result == 0) {
            result = this.patch - v.patch;
            if (result == 0) {
               if (this.preRelease.length == 0 && v.preRelease.length > 0) {
                  result = 1;
               }

               if (v.preRelease.length == 0 && this.preRelease.length > 0) {
                  result = -1;
               }

               if (this.preRelease.length > 0 && v.preRelease.length > 0) {
                  int len = Math.min(this.preRelease.length, v.preRelease.length);
                  int count = false;

                  int count;
                  for(count = 0; count < len; ++count) {
                     result = this.comparePreReleaseTag(count, v);
                     if (result != 0) {
                        break;
                     }
                  }

                  if (result == 0 && count == len) {
                     result = this.preRelease.length - v.preRelease.length;
                  }
               }
            }
         }
      }

      return result;
   }

   private int comparePreReleaseTag(int pos, SemanticVersion ov) {
      Integer here = null;
      Integer there = null;

      try {
         here = Integer.parseInt(this.preRelease[pos], 10);
      } catch (NumberFormatException var7) {
      }

      try {
         there = Integer.parseInt(ov.preRelease[pos], 10);
      } catch (NumberFormatException var6) {
      }

      if (here != null && there == null) {
         return -1;
      } else if (here == null && there != null) {
         return 1;
      } else {
         return here == null && there == null ? this.preRelease[pos].compareTo(ov.preRelease[pos]) : here.compareTo(there);
      }
   }

   private boolean stateMajor() {
      int pos;
      for(pos = 0; pos < this.input.length && this.input[pos] >= '0' && this.input[pos] <= '9'; ++pos) {
      }

      if (pos == 0) {
         this.errMes = "Empty major version";
         this.errPos = 0;
         return false;
      } else if (pos == this.input.length) {
         this.errMes = "Missing minor version and patch level";
         this.errPos = this.input.length - 1;
         return false;
      } else if (this.input[0] == '0' && pos > 1) {
         this.errMes = "Major version number with leading zero";
         this.errPos = 0;
         return false;
      } else {
         this.vParts[0] = Integer.parseInt(new String(this.input, 0, pos), 10);
         if (this.input[pos] == '.') {
            return this.stateMinor(pos + 1);
         } else {
            this.errPos = pos;
            this.errMes = "Unexpected character";
            return false;
         }
      }
   }

   private boolean stateMinor(int index) {
      int pos;
      for(pos = index; pos < this.input.length && this.input[pos] >= '0' && this.input[pos] <= '9'; ++pos) {
      }

      if (pos == index) {
         this.errPos = index;
         this.errMes = "Empty minor version";
         return false;
      } else if (pos == this.input.length) {
         this.errMes = "Missing patch level";
         this.errPos = this.input.length - 1;
         return false;
      } else if (this.input[0] == '0' && pos - index > 1) {
         this.errPos = index;
         this.errMes = "Minor version number with leading zero";
         return false;
      } else {
         this.vParts[1] = Integer.parseInt(new String(this.input, index, pos - index), 10);
         if (this.input[pos] == '.') {
            return this.statePatch(pos + 1);
         } else {
            this.errPos = pos;
            this.errMes = "Unexpected character";
            return false;
         }
      }
   }

   private boolean statePatch(int index) {
      int pos;
      for(pos = index; pos < this.input.length && this.input[pos] >= '0' && this.input[pos] <= '9'; ++pos) {
      }

      if (pos == index) {
         this.errPos = index;
         this.errMes = "Empty patch level";
         return false;
      } else if (this.input[0] == '0' && pos - index > 1) {
         this.errPos = index;
         this.errMes = "Patch level with leading zero";
         return false;
      } else {
         this.vParts[2] = Integer.parseInt(new String(this.input, index, pos - index), 10);
         if (pos == this.input.length) {
            return true;
         } else if (this.input[pos] == '+') {
            return this.stateMeta(pos + 1);
         } else if (this.input[pos] == '-') {
            return this.stateRelease(pos + 1);
         } else {
            this.errPos = pos;
            this.errMes = "Unexpected character";
            return false;
         }
      }
   }

   private boolean stateRelease(int index) {
      int pos;
      for(pos = index; pos < this.input.length && (this.input[pos] >= '0' && this.input[pos] <= '9' || this.input[pos] >= 'a' && this.input[pos] <= 'z' || this.input[pos] >= 'A' && this.input[pos] <= 'Z' || this.input[pos] == '-'); ++pos) {
      }

      if (pos == index) {
         this.errPos = index;
         this.errMes = "Empty release tag";
         return false;
      } else {
         this.preParts.add(new String(this.input, index, pos - index));
         if (pos == this.input.length) {
            return true;
         } else if (this.input[pos] == '.') {
            return this.stateRelease(pos + 1);
         } else if (this.input[pos] == '+') {
            return this.stateMeta(pos + 1);
         } else {
            this.errPos = pos;
            this.errMes = "Unexpected character";
            return false;
         }
      }
   }

   private boolean stateMeta(int index) {
      int pos;
      for(pos = index; pos < this.input.length && (this.input[pos] >= '0' && this.input[pos] <= '9' || this.input[pos] >= 'a' && this.input[pos] <= 'z' || this.input[pos] >= 'A' && this.input[pos] <= 'Z' || this.input[pos] == '-'); ++pos) {
      }

      if (pos == index) {
         this.errPos = index;
         this.errMes = "Empty meta tag";
         return false;
      } else {
         this.metaParts.add(new String(this.input, index, pos - index));
         if (pos == this.input.length) {
            return true;
         } else if (this.input[pos] == '.') {
            return this.stateMeta(pos + 1);
         } else {
            this.errPos = pos;
            this.errMes = "Unexpected character";
            return false;
         }
      }
   }
}
