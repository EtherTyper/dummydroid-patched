package org.bouncycastle.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.tls.crypto.TlsSecret;
import org.bouncycastle.util.Arrays;

public final class SessionParameters {
   private int cipherSuite;
   private short compressionAlgorithm;
   private Certificate localCertificate;
   private TlsSecret masterSecret;
   private ProtocolVersion negotiatedVersion;
   private Certificate peerCertificate;
   private byte[] pskIdentity;
   private byte[] srpIdentity;
   private byte[] encodedServerExtensions;

   private SessionParameters(int var1, short var2, Certificate var3, TlsSecret var4, ProtocolVersion var5, Certificate var6, byte[] var7, byte[] var8, byte[] var9) {
      this.pskIdentity = null;
      this.srpIdentity = null;
      this.cipherSuite = var1;
      this.compressionAlgorithm = var2;
      this.localCertificate = var3;
      this.masterSecret = var4;
      this.negotiatedVersion = var5;
      this.peerCertificate = var6;
      this.pskIdentity = Arrays.clone(var7);
      this.srpIdentity = Arrays.clone(var8);
      this.encodedServerExtensions = var9;
   }

   public void clear() {
      if (this.masterSecret != null) {
         this.masterSecret.destroy();
      }

   }

   public SessionParameters copy() {
      return new SessionParameters(this.cipherSuite, this.compressionAlgorithm, this.localCertificate, this.masterSecret, this.negotiatedVersion, this.peerCertificate, this.pskIdentity, this.srpIdentity, this.encodedServerExtensions);
   }

   public int getCipherSuite() {
      return this.cipherSuite;
   }

   public short getCompressionAlgorithm() {
      return this.compressionAlgorithm;
   }

   public Certificate getLocalCertificate() {
      return this.localCertificate;
   }

   public TlsSecret getMasterSecret() {
      return this.masterSecret;
   }

   public ProtocolVersion getNegotiatedVersion() {
      return this.negotiatedVersion;
   }

   public Certificate getPeerCertificate() {
      return this.peerCertificate;
   }

   /** @deprecated */
   public byte[] getPskIdentity() {
      return this.pskIdentity;
   }

   public byte[] getPSKIdentity() {
      return this.pskIdentity;
   }

   public byte[] getSRPIdentity() {
      return this.srpIdentity;
   }

   public Hashtable readServerExtensions() throws IOException {
      if (this.encodedServerExtensions == null) {
         return null;
      } else {
         ByteArrayInputStream var1 = new ByteArrayInputStream(this.encodedServerExtensions);
         return TlsProtocol.readExtensions(var1);
      }
   }

   // $FF: synthetic method
   SessionParameters(int var1, short var2, Certificate var3, TlsSecret var4, ProtocolVersion var5, Certificate var6, byte[] var7, byte[] var8, byte[] var9, Object var10) {
      this(var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public static final class Builder {
      private int cipherSuite = -1;
      private short compressionAlgorithm = -1;
      private Certificate localCertificate = null;
      private TlsSecret masterSecret = null;
      private ProtocolVersion negotiatedVersion;
      private Certificate peerCertificate = null;
      private byte[] pskIdentity = null;
      private byte[] srpIdentity = null;
      private byte[] encodedServerExtensions = null;

      public SessionParameters build() {
         this.validate(this.cipherSuite >= 0, "cipherSuite");
         this.validate(this.compressionAlgorithm >= 0, "compressionAlgorithm");
         this.validate(this.masterSecret != null, "masterSecret");
         return new SessionParameters(this.cipherSuite, this.compressionAlgorithm, this.localCertificate, this.masterSecret, this.negotiatedVersion, this.peerCertificate, this.pskIdentity, this.srpIdentity, this.encodedServerExtensions);
      }

      public SessionParameters.Builder setCipherSuite(int var1) {
         this.cipherSuite = var1;
         return this;
      }

      public SessionParameters.Builder setCompressionAlgorithm(short var1) {
         this.compressionAlgorithm = var1;
         return this;
      }

      public SessionParameters.Builder setLocalCertificate(Certificate var1) {
         this.localCertificate = var1;
         return this;
      }

      public SessionParameters.Builder setMasterSecret(TlsSecret var1) {
         this.masterSecret = var1;
         return this;
      }

      public SessionParameters.Builder setNegotiatedVersion(ProtocolVersion var1) {
         this.negotiatedVersion = var1;
         return this;
      }

      public SessionParameters.Builder setPeerCertificate(Certificate var1) {
         this.peerCertificate = var1;
         return this;
      }

      /** @deprecated */
      public SessionParameters.Builder setPskIdentity(byte[] var1) {
         this.pskIdentity = var1;
         return this;
      }

      public SessionParameters.Builder setPSKIdentity(byte[] var1) {
         this.pskIdentity = var1;
         return this;
      }

      public SessionParameters.Builder setSRPIdentity(byte[] var1) {
         this.srpIdentity = var1;
         return this;
      }

      public SessionParameters.Builder setServerExtensions(Hashtable var1) throws IOException {
         if (var1 == null) {
            this.encodedServerExtensions = null;
         } else {
            ByteArrayOutputStream var2 = new ByteArrayOutputStream();
            TlsProtocol.writeExtensions(var2, var1);
            this.encodedServerExtensions = var2.toByteArray();
         }

         return this;
      }

      private void validate(boolean var1, String var2) {
         if (!var1) {
            throw new IllegalStateException("Required session parameter '" + var2 + "' not configured");
         }
      }
   }
}
