package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface EarlyDocumentInfoOrBuilder extends MessageOrBuilder {
   boolean hasDocid();

   Docid getDocid();

   DocidOrBuilder getDocidOrBuilder();

   boolean hasTitle();

   String getTitle();

   ByteString getTitleBytes();

   boolean hasVersionCode();

   int getVersionCode();

   boolean hasBackground();

   boolean getBackground();

   boolean hasCritical();

   boolean getCritical();
}
