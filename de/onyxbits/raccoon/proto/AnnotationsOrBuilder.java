package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface AnnotationsOrBuilder extends MessageOrBuilder {
   boolean hasPrivacyUrl();

   String getPrivacyUrl();

   ByteString getPrivacyUrlBytes();
}
