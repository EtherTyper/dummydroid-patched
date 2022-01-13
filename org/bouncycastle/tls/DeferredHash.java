package org.bouncycastle.tls;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.tls.crypto.TlsHash;
import org.bouncycastle.util.Shorts;

class DeferredHash implements TlsHandshakeHash {
   protected static final int BUFFERING_HASH_LIMIT = 4;
   protected TlsContext context;
   private DigestInputBuffer buf;
   private Hashtable hashes;
   private boolean forceBuffering;
   private boolean sealed;

   DeferredHash(TlsContext var1) {
      this.context = var1;
      this.buf = new DigestInputBuffer();
      this.hashes = new Hashtable();
      this.forceBuffering = false;
      this.sealed = false;
   }

   private DeferredHash(TlsContext var1, Hashtable var2) {
      this.context = var1;
      this.buf = null;
      this.hashes = var2;
      this.forceBuffering = false;
      this.sealed = true;
   }

   public void copyBufferTo(OutputStream var1) throws IOException {
      if (this.buf == null) {
         throw new IllegalStateException("Not buffering");
      } else {
         this.buf.copyTo(var1);
      }
   }

   public void forceBuffering() {
      if (this.sealed) {
         throw new IllegalStateException("Too late to force buffering");
      } else {
         this.forceBuffering = true;
      }
   }

   public TlsHandshakeHash notifyPRFDetermined() {
      int var1 = this.context.getSecurityParameters().getPrfAlgorithm();
      if (var1 == 0) {
         this.checkTrackingHash(Short.valueOf((short)1));
         this.checkTrackingHash(Short.valueOf((short)2));
      } else {
         this.checkTrackingHash(TlsUtils.getHashAlgorithmForPRFAlgorithm(var1));
      }

      return this;
   }

   public void trackHashAlgorithm(short var1) {
      if (this.sealed) {
         throw new IllegalStateException("Too late to track more hash algorithms");
      } else {
         this.checkTrackingHash(Shorts.valueOf(var1));
      }
   }

   public void sealHashAlgorithms() {
      if (!this.sealed) {
         this.sealed = true;
         this.checkStopBuffering();
      }

   }

   public TlsHandshakeHash stopTracking() {
      Hashtable var1 = new Hashtable();
      int var2 = this.context.getSecurityParameters().getPrfAlgorithm();
      if (var2 == 0) {
         this.cloneHash(var1, Short.valueOf((short)1));
         this.cloneHash(var1, Short.valueOf((short)2));
      } else {
         this.cloneHash(var1, TlsUtils.getHashAlgorithmForPRFAlgorithm(var2));
      }

      return new DeferredHash(this.context, var1);
   }

   public TlsHash forkPRFHash() {
      this.checkStopBuffering();
      int var2 = this.context.getSecurityParameters().getPrfAlgorithm();
      Object var1;
      if (var2 == 0) {
         var1 = new CombinedHash(this.context, this.cloneHash(Short.valueOf((short)1)), this.cloneHash(Short.valueOf((short)2)));
      } else {
         var1 = this.cloneHash(TlsUtils.getHashAlgorithmForPRFAlgorithm(var2));
      }

      if (this.buf != null) {
         this.buf.updateDigest((TlsHash)var1);
      }

      return (TlsHash)var1;
   }

   public byte[] getFinalHash(short var1) {
      TlsHash var2 = (TlsHash)this.hashes.get(Shorts.valueOf(var1));
      if (var2 == null) {
         throw new IllegalStateException("HashAlgorithm." + HashAlgorithm.getText(var1) + " is not being tracked");
      } else {
         var2 = (TlsHash)var2.clone();
         if (this.buf != null) {
            this.buf.updateDigest(var2);
         }

         return var2.calculateHash();
      }
   }

   public void update(byte[] var1, int var2, int var3) {
      if (this.buf != null) {
         this.buf.write(var1, var2, var3);
      } else {
         Enumeration var4 = this.hashes.elements();

         while(var4.hasMoreElements()) {
            TlsHash var5 = (TlsHash)var4.nextElement();
            var5.update(var1, var2, var3);
         }

      }
   }

   public byte[] calculateHash() {
      throw new IllegalStateException("Use fork() to get a definite Digest");
   }

   public Object clone() {
      throw new IllegalStateException("attempt to clone a DeferredHash");
   }

   public void reset() {
      this.forceBuffering = false;
      this.sealed = false;
      if (this.buf != null) {
         this.buf.reset();
      } else {
         Enumeration var1 = this.hashes.elements();

         while(var1.hasMoreElements()) {
            TlsHash var2 = (TlsHash)var1.nextElement();
            var2.reset();
         }

      }
   }

   protected void checkStopBuffering() {
      if (!this.forceBuffering && this.sealed && this.buf != null && this.hashes.size() <= 4) {
         Enumeration var1 = this.hashes.elements();

         while(var1.hasMoreElements()) {
            TlsHash var2 = (TlsHash)var1.nextElement();
            this.buf.updateDigest(var2);
         }

         this.buf = null;
      }

   }

   protected void checkTrackingHash(Short var1) {
      if (!this.hashes.containsKey(var1)) {
         TlsHash var2 = this.context.getCrypto().createHash(var1);
         this.hashes.put(var1, var2);
      }

   }

   protected TlsHash cloneHash(Short var1) {
      return (TlsHash)((TlsHash)this.hashes.get(var1)).clone();
   }

   protected void cloneHash(Hashtable var1, Short var2) {
      TlsHash var3 = this.cloneHash(var2);
      if (this.buf != null) {
         this.buf.updateDigest(var3);
      }

      var1.put(var2, var3);
   }
}
