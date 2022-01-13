package org.bouncycastle.tls;

import java.io.IOException;
import java.util.Vector;
import org.bouncycastle.tls.crypto.TlsDHConfig;
import org.bouncycastle.tls.crypto.TlsECConfig;

public class DefaultTlsKeyExchangeFactory extends AbstractTlsKeyExchangeFactory {
   public TlsKeyExchange createDHKeyExchangeClient(int var1, Vector var2, TlsDHConfigVerifier var3) throws IOException {
      return new TlsDHKeyExchange(var1, var2, var3);
   }

   public TlsKeyExchange createDHKeyExchangeServer(int var1, Vector var2, TlsDHConfig var3) throws IOException {
      return new TlsDHKeyExchange(var1, var2, var3);
   }

   public TlsKeyExchange createDHEKeyExchangeClient(int var1, Vector var2, TlsDHConfigVerifier var3) throws IOException {
      return new TlsDHEKeyExchange(var1, var2, var3);
   }

   public TlsKeyExchange createDHEKeyExchangeServer(int var1, Vector var2, TlsDHConfig var3) throws IOException {
      return new TlsDHEKeyExchange(var1, var2, var3);
   }

   public TlsKeyExchange createECDHKeyExchangeClient(int var1, Vector var2, TlsECConfigVerifier var3, short[] var4, short[] var5) throws IOException {
      return new TlsECDHKeyExchange(var1, var2, var3, var4, var5);
   }

   public TlsKeyExchange createECDHKeyExchangeServer(int var1, Vector var2, TlsECConfig var3, short[] var4) throws IOException {
      return new TlsECDHKeyExchange(var1, var2, var3, var4);
   }

   public TlsKeyExchange createECDHEKeyExchangeClient(int var1, Vector var2, TlsECConfigVerifier var3, short[] var4, short[] var5) throws IOException {
      return new TlsECDHEKeyExchange(var1, var2, var3, var4, var5);
   }

   public TlsKeyExchange createECDHEKeyExchangeServer(int var1, Vector var2, TlsECConfig var3, short[] var4) throws IOException {
      return new TlsECDHEKeyExchange(var1, var2, var3, var4);
   }

   public TlsKeyExchange createPSKKeyExchangeClient(int var1, Vector var2, TlsPSKIdentity var3, TlsDHConfigVerifier var4, TlsECConfigVerifier var5, short[] var6, short[] var7) throws IOException {
      return new TlsPSKKeyExchange(var1, var2, var3, var4, var5, var6, var7);
   }

   public TlsKeyExchange createPSKKeyExchangeServer(int var1, Vector var2, TlsPSKIdentityManager var3, TlsDHConfig var4, TlsECConfig var5, short[] var6) throws IOException {
      return new TlsPSKKeyExchange(var1, var2, (TlsPSKIdentity)null, var3, var4, var5, var6);
   }

   public TlsKeyExchange createRSAKeyExchange(Vector var1) throws IOException {
      return new TlsRSAKeyExchange(var1);
   }

   public TlsKeyExchange createSRPKeyExchangeClient(int var1, Vector var2, TlsSRPConfigVerifier var3, byte[] var4, byte[] var5) throws IOException {
      return new TlsSRPKeyExchange(var1, var2, var3, var4, var5);
   }

   public TlsKeyExchange createSRPKeyExchangeServer(int var1, Vector var2, byte[] var3, TlsSRPLoginParameters var4) throws IOException {
      return new TlsSRPKeyExchange(var1, var2, var3, var4);
   }
}
