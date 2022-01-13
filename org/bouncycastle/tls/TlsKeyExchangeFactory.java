package org.bouncycastle.tls;

import java.io.IOException;
import java.util.Vector;
import org.bouncycastle.tls.crypto.TlsDHConfig;
import org.bouncycastle.tls.crypto.TlsECConfig;

public interface TlsKeyExchangeFactory {
   TlsKeyExchange createDHKeyExchangeClient(int var1, Vector var2, TlsDHConfigVerifier var3) throws IOException;

   TlsKeyExchange createDHKeyExchangeServer(int var1, Vector var2, TlsDHConfig var3) throws IOException;

   TlsKeyExchange createDHEKeyExchangeClient(int var1, Vector var2, TlsDHConfigVerifier var3) throws IOException;

   TlsKeyExchange createDHEKeyExchangeServer(int var1, Vector var2, TlsDHConfig var3) throws IOException;

   TlsKeyExchange createECDHKeyExchangeClient(int var1, Vector var2, TlsECConfigVerifier var3, short[] var4, short[] var5) throws IOException;

   TlsKeyExchange createECDHKeyExchangeServer(int var1, Vector var2, TlsECConfig var3, short[] var4) throws IOException;

   TlsKeyExchange createECDHEKeyExchangeClient(int var1, Vector var2, TlsECConfigVerifier var3, short[] var4, short[] var5) throws IOException;

   TlsKeyExchange createECDHEKeyExchangeServer(int var1, Vector var2, TlsECConfig var3, short[] var4) throws IOException;

   TlsKeyExchange createPSKKeyExchangeClient(int var1, Vector var2, TlsPSKIdentity var3, TlsDHConfigVerifier var4, TlsECConfigVerifier var5, short[] var6, short[] var7) throws IOException;

   TlsKeyExchange createPSKKeyExchangeServer(int var1, Vector var2, TlsPSKIdentityManager var3, TlsDHConfig var4, TlsECConfig var5, short[] var6) throws IOException;

   TlsKeyExchange createRSAKeyExchange(Vector var1) throws IOException;

   TlsKeyExchange createSRPKeyExchangeClient(int var1, Vector var2, TlsSRPConfigVerifier var3, byte[] var4, byte[] var5) throws IOException;

   TlsKeyExchange createSRPKeyExchangeServer(int var1, Vector var2, byte[] var3, TlsSRPLoginParameters var4) throws IOException;
}
