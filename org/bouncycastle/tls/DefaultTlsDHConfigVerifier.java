package org.bouncycastle.tls;

import java.math.BigInteger;
import java.util.Vector;
import org.bouncycastle.tls.crypto.DHGroup;
import org.bouncycastle.tls.crypto.DHStandardGroups;
import org.bouncycastle.tls.crypto.TlsDHConfig;

public class DefaultTlsDHConfigVerifier implements TlsDHConfigVerifier {
   public static final int DEFAULT_MINIMUM_PRIME_BITS = 1024;
   protected static final Vector DEFAULT_GROUPS = new Vector();
   protected Vector groups;
   protected int minimumPrimeBits;

   private static void addDefaultGroup(DHGroup var0) {
      DEFAULT_GROUPS.addElement(TlsDHUtils.selectDHConfig(var0));
   }

   public DefaultTlsDHConfigVerifier() {
      this(1024);
   }

   public DefaultTlsDHConfigVerifier(int var1) {
      this(DEFAULT_GROUPS, var1);
   }

   public DefaultTlsDHConfigVerifier(Vector var1, int var2) {
      this.groups = var1;
      this.minimumPrimeBits = var2;
   }

   public boolean accept(TlsDHConfig var1) {
      if (var1.getExplicitPG()[0].bitLength() < this.getMinimumPrimeBits()) {
         return false;
      } else {
         for(int var2 = 0; var2 < this.groups.size(); ++var2) {
            if (this.areGroupsEqual(var1, (TlsDHConfig)this.groups.elementAt(var2))) {
               return true;
            }
         }

         return false;
      }
   }

   public int getMinimumPrimeBits() {
      return this.minimumPrimeBits;
   }

   protected boolean areGroupsEqual(TlsDHConfig var1, TlsDHConfig var2) {
      return var1 == var2 || this.areParametersEqual(var1.getExplicitPG(), var2.getExplicitPG());
   }

   protected boolean areParametersEqual(BigInteger[] var1, BigInteger[] var2) {
      return var1 == var2 || this.areParametersEqual(var1[0], var2[0]) && this.areParametersEqual(var1[1], var2[1]);
   }

   protected boolean areParametersEqual(BigInteger var1, BigInteger var2) {
      return var1 == var2 || var1.equals(var2);
   }

   static {
      addDefaultGroup(DHStandardGroups.rfc3526_1536);
      addDefaultGroup(DHStandardGroups.rfc3526_2048);
      addDefaultGroup(DHStandardGroups.rfc3526_3072);
      addDefaultGroup(DHStandardGroups.rfc3526_4096);
      addDefaultGroup(DHStandardGroups.rfc3526_6144);
      addDefaultGroup(DHStandardGroups.rfc3526_8192);
      addDefaultGroup(DHStandardGroups.rfc5996_768);
      addDefaultGroup(DHStandardGroups.rfc5996_1024);
   }
}
