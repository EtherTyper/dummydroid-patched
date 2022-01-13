package org.bouncycastle.tls;

import org.bouncycastle.tls.crypto.TlsSecret;

public class SecurityParameters {
   int entity = -1;
   int cipherSuite = -1;
   short compressionAlgorithm = 0;
   short maxFragmentLength = -1;
   int prfAlgorithm = -1;
   int verifyDataLength = -1;
   TlsSecret masterSecret = null;
   byte[] clientRandom = null;
   byte[] serverRandom = null;
   byte[] sessionHash = null;
   byte[] pskIdentity = null;
   byte[] srpIdentity = null;
   byte[] tlsUnique = null;
   boolean encryptThenMAC = false;
   boolean extendedMasterSecret = false;
   boolean truncatedHMac = false;

   void clear() {
      if (this.masterSecret != null) {
         this.masterSecret.destroy();
         this.masterSecret = null;
      }

   }

   public int getEntity() {
      return this.entity;
   }

   public int getCipherSuite() {
      return this.cipherSuite;
   }

   public short getCompressionAlgorithm() {
      return this.compressionAlgorithm;
   }

   public short getMaxFragmentLength() {
      return this.maxFragmentLength;
   }

   public int getPrfAlgorithm() {
      return this.prfAlgorithm;
   }

   public int getVerifyDataLength() {
      return this.verifyDataLength;
   }

   public TlsSecret getMasterSecret() {
      return this.masterSecret;
   }

   public byte[] getClientRandom() {
      return this.clientRandom;
   }

   public byte[] getServerRandom() {
      return this.serverRandom;
   }

   public byte[] getSessionHash() {
      return this.sessionHash;
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

   public byte[] getTLSUnique() {
      return this.tlsUnique;
   }

   public boolean isEncryptThenMAC() {
      return this.encryptThenMAC;
   }

   public boolean isExtendedMasterSecret() {
      return this.extendedMasterSecret;
   }

   public boolean isTruncatedHMac() {
      return this.truncatedHMac;
   }
}
