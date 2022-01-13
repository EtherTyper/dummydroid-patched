package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface InstallDetailsOrBuilder extends MessageOrBuilder {
   boolean hasTotalApkSize();

   long getTotalApkSize();

   List getDependencyList();

   Dependency getDependency(int var1);

   int getDependencyCount();

   List getDependencyOrBuilderList();

   DependencyOrBuilder getDependencyOrBuilder(int var1);

   boolean hasTargetSdkVersion();

   int getTargetSdkVersion();

   boolean hasDerivedApkId();

   int getDerivedApkId();

   List getRequestedPermissionsList();

   int getRequestedPermissionsCount();

   String getRequestedPermissions(int var1);

   ByteString getRequestedPermissionsBytes(int var1);

   List getSplitIdList();

   int getSplitIdCount();

   String getSplitId(int var1);

   ByteString getSplitIdBytes(int var1);
}
