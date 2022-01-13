package de.onyxbits.raccoon.proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface EarlyUpdateResponseOrBuilder extends MessageOrBuilder {
   List getEarlyDocumentInfoList();

   EarlyDocumentInfo getEarlyDocumentInfo(int var1);

   int getEarlyDocumentInfoCount();

   List getEarlyDocumentInfoOrBuilderList();

   EarlyDocumentInfoOrBuilder getEarlyDocumentInfoOrBuilder(int var1);
}
