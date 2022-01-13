package org.bouncycastle.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.bouncycastle.tls.crypto.TlsCertificate;

public class Certificate {
   public static final Certificate EMPTY_CHAIN = new Certificate(new TlsCertificate[0]);
   protected TlsCertificate[] certificateList;

   public Certificate(TlsCertificate[] var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("'certificateList' cannot be null");
      } else {
         this.certificateList = var1;
      }
   }

   public TlsCertificate[] getCertificateList() {
      return this.cloneCertificateList();
   }

   public TlsCertificate getCertificateAt(int var1) {
      return this.certificateList[var1];
   }

   public int getLength() {
      return this.certificateList.length;
   }

   public boolean isEmpty() {
      return this.certificateList.length == 0;
   }

   public void encode(OutputStream var1) throws IOException {
      Vector var2 = new Vector(this.certificateList.length);
      int var3 = 0;

      int var4;
      byte[] var5;
      for(var4 = 0; var4 < this.certificateList.length; ++var4) {
         var5 = this.certificateList[var4].getEncoded();
         var2.addElement(var5);
         var3 += var5.length + 3;
      }

      TlsUtils.checkUint24(var3);
      TlsUtils.writeUint24(var3, var1);

      for(var4 = 0; var4 < var2.size(); ++var4) {
         var5 = (byte[])((byte[])var2.elementAt(var4));
         TlsUtils.writeOpaque24(var5, var1);
      }

   }

   public static Certificate parse(TlsContext var0, InputStream var1) throws IOException {
      int var2 = TlsUtils.readUint24(var1);
      if (var2 == 0) {
         return EMPTY_CHAIN;
      } else {
         byte[] var3 = TlsUtils.readFully(var2, var1);
         ByteArrayInputStream var4 = new ByteArrayInputStream(var3);
         Vector var5 = new Vector();

         while(var4.available() > 0) {
            byte[] var6 = TlsUtils.readOpaque24(var4);
            var5.addElement(var0.getCrypto().createCertificate(var6));
         }

         TlsCertificate[] var8 = new TlsCertificate[var5.size()];

         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var8[var7] = (TlsCertificate)var5.elementAt(var7);
         }

         return new Certificate(var8);
      }
   }

   protected TlsCertificate[] cloneCertificateList() {
      TlsCertificate[] var1 = new TlsCertificate[this.certificateList.length];
      System.arraycopy(this.certificateList, 0, var1, 0, var1.length);
      return var1;
   }
}
