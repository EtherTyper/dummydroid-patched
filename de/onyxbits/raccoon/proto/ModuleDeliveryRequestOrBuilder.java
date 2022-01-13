package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface ModuleDeliveryRequestOrBuilder extends MessageOrBuilder {
   boolean hasPackageName();

   String getPackageName();

   ByteString getPackageNameBytes();

   boolean hasVersionCode();

   int getVersionCode();

   List getAppModuleList();

   AppModule getAppModule(int var1);

   int getAppModuleCount();

   List getAppModuleOrBuilderList();

   AppModuleOrBuilder getAppModuleOrBuilder(int var1);

   List getPatchFormatList();

   int getPatchFormatCount();

   int getPatchFormat(int var1);

   List getCompressionFormatList();

   int getCompressionFormatCount();

   ModuleDeliveryRequest.CompressionFormat getCompressionFormat(int var1);
}
