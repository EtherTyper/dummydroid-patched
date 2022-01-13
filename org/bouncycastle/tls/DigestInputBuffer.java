package org.bouncycastle.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.tls.crypto.TlsHash;
import org.bouncycastle.util.io.Streams;

class DigestInputBuffer extends ByteArrayOutputStream {
   void updateDigest(TlsHash var1) {
      var1.update(this.buf, 0, this.count);
   }

   void copyTo(OutputStream var1) throws IOException {
      Streams.pipeAll(new ByteArrayInputStream(this.buf, 0, this.count), var1);
   }
}
