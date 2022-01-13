package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface AndroidCheckinProtoOrBuilder extends MessageOrBuilder {
   boolean hasBuild();

   AndroidBuildProto getBuild();

   AndroidBuildProtoOrBuilder getBuildOrBuilder();

   boolean hasLastCheckinMsec();

   long getLastCheckinMsec();

   List getRequestedGroupList();

   int getRequestedGroupCount();

   String getRequestedGroup(int var1);

   ByteString getRequestedGroupBytes(int var1);

   boolean hasCellOperator();

   String getCellOperator();

   ByteString getCellOperatorBytes();

   boolean hasSimOperator();

   String getSimOperator();

   ByteString getSimOperatorBytes();

   boolean hasRoaming();

   String getRoaming();

   ByteString getRoamingBytes();
}
