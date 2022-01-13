package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface EncryptionParamsOrBuilder extends MessageOrBuilder {
   boolean hasVersion();

   int getVersion();

   boolean hasEncryptionKey();

   String getEncryptionKey();

   ByteString getEncryptionKeyBytes();

   boolean hasHmacKey();

   String getHmacKey();

   ByteString getHmacKeyBytes();
}
