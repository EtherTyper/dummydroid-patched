package org.bouncycastle.tls;

import org.bouncycastle.util.Arrays;

class TlsSessionImpl implements TlsSession {
   final byte[] sessionID;
   final SessionParameters sessionParameters;
   boolean resumable;

   TlsSessionImpl(byte[] var1, SessionParameters var2) {
      if (var1 == null) {
         throw new IllegalArgumentException("'sessionID' cannot be null");
      } else if (var1.length > 32) {
         throw new IllegalArgumentException("'sessionID' cannot be longer than 32 bytes");
      } else {
         this.sessionID = Arrays.clone(var1);
         this.sessionParameters = var2;
         this.resumable = var1.length > 0;
      }
   }

   public synchronized SessionParameters exportSessionParameters() {
      return this.sessionParameters == null ? null : this.sessionParameters.copy();
   }

   public synchronized byte[] getSessionID() {
      return this.sessionID;
   }

   public synchronized void invalidate() {
      this.resumable = false;
   }

   public synchronized boolean isResumable() {
      return this.resumable;
   }
}
