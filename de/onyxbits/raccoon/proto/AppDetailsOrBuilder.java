package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface AppDetailsOrBuilder extends MessageOrBuilder {
   boolean hasDeveloperName();

   String getDeveloperName();

   ByteString getDeveloperNameBytes();

   boolean hasMajorVersionNumber();

   int getMajorVersionNumber();

   boolean hasVersionCode();

   int getVersionCode();

   boolean hasVersionString();

   String getVersionString();

   ByteString getVersionStringBytes();

   boolean hasInstallationSize();

   long getInstallationSize();

   List getPermissionList();

   int getPermissionCount();

   String getPermission(int var1);

   ByteString getPermissionBytes(int var1);

   boolean hasDeveloperEmail();

   String getDeveloperEmail();

   ByteString getDeveloperEmailBytes();

   boolean hasDeveloperWebsite();

   String getDeveloperWebsite();

   ByteString getDeveloperWebsiteBytes();

   boolean hasNumDownloads();

   String getNumDownloads();

   ByteString getNumDownloadsBytes();

   boolean hasPackageName();

   String getPackageName();

   ByteString getPackageNameBytes();

   boolean hasRecentChangesHtml();

   String getRecentChangesHtml();

   ByteString getRecentChangesHtmlBytes();

   boolean hasUploadDate();

   String getUploadDate();

   ByteString getUploadDateBytes();

   boolean hasDeclaresIab();

   boolean getDeclaresIab();

   boolean hasSplitId();

   String getSplitId();

   ByteString getSplitIdBytes();

   boolean hasInstallNotes();

   String getInstallNotes();

   ByteString getInstallNotesBytes();

   boolean hasTargetSdkVersion();

   int getTargetSdkVersion();

   boolean hasInstallDetails();

   InstallDetails getInstallDetails();

   InstallDetailsOrBuilder getInstallDetailsOrBuilder();

   boolean hasTestingProgram();

   TestingProgram getTestingProgram();

   TestingProgramOrBuilder getTestingProgramOrBuilder();

   boolean hasDeveloperAddress();

   String getDeveloperAddress();

   ByteString getDeveloperAddressBytes();

   boolean hasDeveloperPageLink();

   Link getDeveloperPageLink();

   LinkOrBuilder getDeveloperPageLinkOrBuilder();

   List getBundleModuleList();

   AppBundleModule getBundleModule(int var1);

   int getBundleModuleCount();

   List getBundleModuleOrBuilderList();

   AppBundleModuleOrBuilder getBundleModuleOrBuilder(int var1);

   boolean hasRoundedDownloadCount();

   int getRoundedDownloadCount();
}
