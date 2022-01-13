package de.onyxbits.raccoon.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AppDetails extends GeneratedMessageV3 implements AppDetailsOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int DEVELOPERNAME_FIELD_NUMBER = 1;
   private volatile Object developerName_;
   public static final int MAJORVERSIONNUMBER_FIELD_NUMBER = 2;
   private int majorVersionNumber_;
   public static final int VERSIONCODE_FIELD_NUMBER = 3;
   private int versionCode_;
   public static final int VERSIONSTRING_FIELD_NUMBER = 4;
   private volatile Object versionString_;
   public static final int INSTALLATIONSIZE_FIELD_NUMBER = 9;
   private long installationSize_;
   public static final int PERMISSION_FIELD_NUMBER = 10;
   private LazyStringList permission_;
   public static final int DEVELOPEREMAIL_FIELD_NUMBER = 11;
   private volatile Object developerEmail_;
   public static final int DEVELOPERWEBSITE_FIELD_NUMBER = 12;
   private volatile Object developerWebsite_;
   public static final int NUMDOWNLOADS_FIELD_NUMBER = 13;
   private volatile Object numDownloads_;
   public static final int PACKAGENAME_FIELD_NUMBER = 14;
   private volatile Object packageName_;
   public static final int RECENTCHANGESHTML_FIELD_NUMBER = 15;
   private volatile Object recentChangesHtml_;
   public static final int UPLOADDATE_FIELD_NUMBER = 16;
   private volatile Object uploadDate_;
   public static final int DECLARESIAB_FIELD_NUMBER = 24;
   private boolean declaresIab_;
   public static final int SPLITID_FIELD_NUMBER = 25;
   private volatile Object splitId_;
   public static final int INSTALLNOTES_FIELD_NUMBER = 30;
   private volatile Object installNotes_;
   public static final int TARGETSDKVERSION_FIELD_NUMBER = 32;
   private int targetSdkVersion_;
   public static final int INSTALLDETAILS_FIELD_NUMBER = 34;
   private InstallDetails installDetails_;
   public static final int TESTINGPROGRAM_FIELD_NUMBER = 35;
   private TestingProgram testingProgram_;
   public static final int DEVELOPERADDRESS_FIELD_NUMBER = 45;
   private volatile Object developerAddress_;
   public static final int DEVELOPERPAGELINK_FIELD_NUMBER = 46;
   private Link developerPageLink_;
   public static final int BUNDLEMODULE_FIELD_NUMBER = 47;
   private List bundleModule_;
   public static final int ROUNDEDDOWNLOADCOUNT_FIELD_NUMBER = 53;
   private int roundedDownloadCount_;
   private byte memoizedIsInitialized;
   private static final AppDetails DEFAULT_INSTANCE = new AppDetails();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public AppDetails parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new AppDetails(input, extensionRegistry);
      }
   };

   private AppDetails(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private AppDetails() {
      this.memoizedIsInitialized = -1;
      this.developerName_ = "";
      this.versionString_ = "";
      this.permission_ = LazyStringArrayList.EMPTY;
      this.developerEmail_ = "";
      this.developerWebsite_ = "";
      this.numDownloads_ = "";
      this.packageName_ = "";
      this.recentChangesHtml_ = "";
      this.uploadDate_ = "";
      this.splitId_ = "";
      this.installNotes_ = "";
      this.developerAddress_ = "";
      this.bundleModule_ = Collections.emptyList();
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new AppDetails();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private AppDetails(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
         throw new NullPointerException();
      } else {
         int mutable_bitField0_ = 0;
         UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();

         try {
            boolean done = false;

            while(!done) {
               int tag = input.readTag();
               ByteString bs;
               switch(tag) {
               case 0:
                  done = true;
                  break;
               case 10:
                  bs = input.readBytes();
                  this.bitField0_ |= 1;
                  this.developerName_ = bs;
                  break;
               case 16:
                  this.bitField0_ |= 2;
                  this.majorVersionNumber_ = input.readInt32();
                  break;
               case 24:
                  this.bitField0_ |= 4;
                  this.versionCode_ = input.readInt32();
                  break;
               case 34:
                  bs = input.readBytes();
                  this.bitField0_ |= 8;
                  this.versionString_ = bs;
                  break;
               case 72:
                  this.bitField0_ |= 16;
                  this.installationSize_ = input.readInt64();
                  break;
               case 82:
                  bs = input.readBytes();
                  if ((mutable_bitField0_ & 32) == 0) {
                     this.permission_ = new LazyStringArrayList();
                     mutable_bitField0_ |= 32;
                  }

                  this.permission_.add(bs);
                  break;
               case 90:
                  bs = input.readBytes();
                  this.bitField0_ |= 32;
                  this.developerEmail_ = bs;
                  break;
               case 98:
                  bs = input.readBytes();
                  this.bitField0_ |= 64;
                  this.developerWebsite_ = bs;
                  break;
               case 106:
                  bs = input.readBytes();
                  this.bitField0_ |= 128;
                  this.numDownloads_ = bs;
                  break;
               case 114:
                  bs = input.readBytes();
                  this.bitField0_ |= 256;
                  this.packageName_ = bs;
                  break;
               case 122:
                  bs = input.readBytes();
                  this.bitField0_ |= 512;
                  this.recentChangesHtml_ = bs;
                  break;
               case 130:
                  bs = input.readBytes();
                  this.bitField0_ |= 1024;
                  this.uploadDate_ = bs;
                  break;
               case 192:
                  this.bitField0_ |= 2048;
                  this.declaresIab_ = input.readBool();
                  break;
               case 202:
                  bs = input.readBytes();
                  this.bitField0_ |= 4096;
                  this.splitId_ = bs;
                  break;
               case 242:
                  bs = input.readBytes();
                  this.bitField0_ |= 8192;
                  this.installNotes_ = bs;
                  break;
               case 256:
                  this.bitField0_ |= 16384;
                  this.targetSdkVersion_ = input.readInt32();
                  break;
               case 274:
                  InstallDetails.Builder subBuilder = null;
                  if ((this.bitField0_ & '耀') != 0) {
                     subBuilder = this.installDetails_.toBuilder();
                  }

                  this.installDetails_ = (InstallDetails)input.readMessage(InstallDetails.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.installDetails_);
                     this.installDetails_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 32768;
                  break;
               case 282:
                  TestingProgram.Builder subBuilder = null;
                  if ((this.bitField0_ & 65536) != 0) {
                     subBuilder = this.testingProgram_.toBuilder();
                  }

                  this.testingProgram_ = (TestingProgram)input.readMessage(TestingProgram.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.testingProgram_);
                     this.testingProgram_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 65536;
                  break;
               case 362:
                  bs = input.readBytes();
                  this.bitField0_ |= 131072;
                  this.developerAddress_ = bs;
                  break;
               case 370:
                  Link.Builder subBuilder = null;
                  if ((this.bitField0_ & 262144) != 0) {
                     subBuilder = this.developerPageLink_.toBuilder();
                  }

                  this.developerPageLink_ = (Link)input.readMessage(Link.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.developerPageLink_);
                     this.developerPageLink_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 262144;
                  break;
               case 378:
                  if ((mutable_bitField0_ & 1048576) == 0) {
                     this.bundleModule_ = new ArrayList();
                     mutable_bitField0_ |= 1048576;
                  }

                  this.bundleModule_.add(input.readMessage(AppBundleModule.PARSER, extensionRegistry));
                  break;
               case 424:
                  this.bitField0_ |= 524288;
                  this.roundedDownloadCount_ = input.readInt32();
                  break;
               default:
                  if (!this.parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                     done = true;
                  }
               }
            }
         } catch (InvalidProtocolBufferException var12) {
            throw var12.setUnfinishedMessage(this);
         } catch (IOException var13) {
            throw (new InvalidProtocolBufferException(var13)).setUnfinishedMessage(this);
         } finally {
            if ((mutable_bitField0_ & 32) != 0) {
               this.permission_ = this.permission_.getUnmodifiableView();
            }

            if ((mutable_bitField0_ & 1048576) != 0) {
               this.bundleModule_ = Collections.unmodifiableList(this.bundleModule_);
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_AppDetails_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_AppDetails_fieldAccessorTable.ensureFieldAccessorsInitialized(AppDetails.class, AppDetails.Builder.class);
   }

   public boolean hasDeveloperName() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getDeveloperName() {
      Object ref = this.developerName_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.developerName_ = s;
         }

         return s;
      }
   }

   public ByteString getDeveloperNameBytes() {
      Object ref = this.developerName_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.developerName_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasMajorVersionNumber() {
      return (this.bitField0_ & 2) != 0;
   }

   public int getMajorVersionNumber() {
      return this.majorVersionNumber_;
   }

   public boolean hasVersionCode() {
      return (this.bitField0_ & 4) != 0;
   }

   public int getVersionCode() {
      return this.versionCode_;
   }

   public boolean hasVersionString() {
      return (this.bitField0_ & 8) != 0;
   }

   public String getVersionString() {
      Object ref = this.versionString_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.versionString_ = s;
         }

         return s;
      }
   }

   public ByteString getVersionStringBytes() {
      Object ref = this.versionString_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.versionString_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasInstallationSize() {
      return (this.bitField0_ & 16) != 0;
   }

   public long getInstallationSize() {
      return this.installationSize_;
   }

   public ProtocolStringList getPermissionList() {
      return this.permission_;
   }

   public int getPermissionCount() {
      return this.permission_.size();
   }

   public String getPermission(int index) {
      return (String)this.permission_.get(index);
   }

   public ByteString getPermissionBytes(int index) {
      return this.permission_.getByteString(index);
   }

   public boolean hasDeveloperEmail() {
      return (this.bitField0_ & 32) != 0;
   }

   public String getDeveloperEmail() {
      Object ref = this.developerEmail_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.developerEmail_ = s;
         }

         return s;
      }
   }

   public ByteString getDeveloperEmailBytes() {
      Object ref = this.developerEmail_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.developerEmail_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasDeveloperWebsite() {
      return (this.bitField0_ & 64) != 0;
   }

   public String getDeveloperWebsite() {
      Object ref = this.developerWebsite_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.developerWebsite_ = s;
         }

         return s;
      }
   }

   public ByteString getDeveloperWebsiteBytes() {
      Object ref = this.developerWebsite_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.developerWebsite_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasNumDownloads() {
      return (this.bitField0_ & 128) != 0;
   }

   public String getNumDownloads() {
      Object ref = this.numDownloads_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.numDownloads_ = s;
         }

         return s;
      }
   }

   public ByteString getNumDownloadsBytes() {
      Object ref = this.numDownloads_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.numDownloads_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasPackageName() {
      return (this.bitField0_ & 256) != 0;
   }

   public String getPackageName() {
      Object ref = this.packageName_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.packageName_ = s;
         }

         return s;
      }
   }

   public ByteString getPackageNameBytes() {
      Object ref = this.packageName_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.packageName_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasRecentChangesHtml() {
      return (this.bitField0_ & 512) != 0;
   }

   public String getRecentChangesHtml() {
      Object ref = this.recentChangesHtml_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.recentChangesHtml_ = s;
         }

         return s;
      }
   }

   public ByteString getRecentChangesHtmlBytes() {
      Object ref = this.recentChangesHtml_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.recentChangesHtml_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasUploadDate() {
      return (this.bitField0_ & 1024) != 0;
   }

   public String getUploadDate() {
      Object ref = this.uploadDate_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.uploadDate_ = s;
         }

         return s;
      }
   }

   public ByteString getUploadDateBytes() {
      Object ref = this.uploadDate_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.uploadDate_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasDeclaresIab() {
      return (this.bitField0_ & 2048) != 0;
   }

   public boolean getDeclaresIab() {
      return this.declaresIab_;
   }

   public boolean hasSplitId() {
      return (this.bitField0_ & 4096) != 0;
   }

   public String getSplitId() {
      Object ref = this.splitId_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.splitId_ = s;
         }

         return s;
      }
   }

   public ByteString getSplitIdBytes() {
      Object ref = this.splitId_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.splitId_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasInstallNotes() {
      return (this.bitField0_ & 8192) != 0;
   }

   public String getInstallNotes() {
      Object ref = this.installNotes_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.installNotes_ = s;
         }

         return s;
      }
   }

   public ByteString getInstallNotesBytes() {
      Object ref = this.installNotes_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.installNotes_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasTargetSdkVersion() {
      return (this.bitField0_ & 16384) != 0;
   }

   public int getTargetSdkVersion() {
      return this.targetSdkVersion_;
   }

   public boolean hasInstallDetails() {
      return (this.bitField0_ & '耀') != 0;
   }

   public InstallDetails getInstallDetails() {
      return this.installDetails_ == null ? InstallDetails.getDefaultInstance() : this.installDetails_;
   }

   public InstallDetailsOrBuilder getInstallDetailsOrBuilder() {
      return this.installDetails_ == null ? InstallDetails.getDefaultInstance() : this.installDetails_;
   }

   public boolean hasTestingProgram() {
      return (this.bitField0_ & 65536) != 0;
   }

   public TestingProgram getTestingProgram() {
      return this.testingProgram_ == null ? TestingProgram.getDefaultInstance() : this.testingProgram_;
   }

   public TestingProgramOrBuilder getTestingProgramOrBuilder() {
      return this.testingProgram_ == null ? TestingProgram.getDefaultInstance() : this.testingProgram_;
   }

   public boolean hasDeveloperAddress() {
      return (this.bitField0_ & 131072) != 0;
   }

   public String getDeveloperAddress() {
      Object ref = this.developerAddress_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.developerAddress_ = s;
         }

         return s;
      }
   }

   public ByteString getDeveloperAddressBytes() {
      Object ref = this.developerAddress_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.developerAddress_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasDeveloperPageLink() {
      return (this.bitField0_ & 262144) != 0;
   }

   public Link getDeveloperPageLink() {
      return this.developerPageLink_ == null ? Link.getDefaultInstance() : this.developerPageLink_;
   }

   public LinkOrBuilder getDeveloperPageLinkOrBuilder() {
      return this.developerPageLink_ == null ? Link.getDefaultInstance() : this.developerPageLink_;
   }

   public List getBundleModuleList() {
      return this.bundleModule_;
   }

   public List getBundleModuleOrBuilderList() {
      return this.bundleModule_;
   }

   public int getBundleModuleCount() {
      return this.bundleModule_.size();
   }

   public AppBundleModule getBundleModule(int index) {
      return (AppBundleModule)this.bundleModule_.get(index);
   }

   public AppBundleModuleOrBuilder getBundleModuleOrBuilder(int index) {
      return (AppBundleModuleOrBuilder)this.bundleModule_.get(index);
   }

   public boolean hasRoundedDownloadCount() {
      return (this.bitField0_ & 524288) != 0;
   }

   public int getRoundedDownloadCount() {
      return this.roundedDownloadCount_;
   }

   public final boolean isInitialized() {
      byte isInitialized = this.memoizedIsInitialized;
      if (isInitialized == 1) {
         return true;
      } else if (isInitialized == 0) {
         return false;
      } else {
         this.memoizedIsInitialized = 1;
         return true;
      }
   }

   public void writeTo(CodedOutputStream output) throws IOException {
      if ((this.bitField0_ & 1) != 0) {
         GeneratedMessageV3.writeString(output, 1, this.developerName_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeInt32(2, this.majorVersionNumber_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeInt32(3, this.versionCode_);
      }

      if ((this.bitField0_ & 8) != 0) {
         GeneratedMessageV3.writeString(output, 4, this.versionString_);
      }

      if ((this.bitField0_ & 16) != 0) {
         output.writeInt64(9, this.installationSize_);
      }

      int i;
      for(i = 0; i < this.permission_.size(); ++i) {
         GeneratedMessageV3.writeString(output, 10, this.permission_.getRaw(i));
      }

      if ((this.bitField0_ & 32) != 0) {
         GeneratedMessageV3.writeString(output, 11, this.developerEmail_);
      }

      if ((this.bitField0_ & 64) != 0) {
         GeneratedMessageV3.writeString(output, 12, this.developerWebsite_);
      }

      if ((this.bitField0_ & 128) != 0) {
         GeneratedMessageV3.writeString(output, 13, this.numDownloads_);
      }

      if ((this.bitField0_ & 256) != 0) {
         GeneratedMessageV3.writeString(output, 14, this.packageName_);
      }

      if ((this.bitField0_ & 512) != 0) {
         GeneratedMessageV3.writeString(output, 15, this.recentChangesHtml_);
      }

      if ((this.bitField0_ & 1024) != 0) {
         GeneratedMessageV3.writeString(output, 16, this.uploadDate_);
      }

      if ((this.bitField0_ & 2048) != 0) {
         output.writeBool(24, this.declaresIab_);
      }

      if ((this.bitField0_ & 4096) != 0) {
         GeneratedMessageV3.writeString(output, 25, this.splitId_);
      }

      if ((this.bitField0_ & 8192) != 0) {
         GeneratedMessageV3.writeString(output, 30, this.installNotes_);
      }

      if ((this.bitField0_ & 16384) != 0) {
         output.writeInt32(32, this.targetSdkVersion_);
      }

      if ((this.bitField0_ & '耀') != 0) {
         output.writeMessage(34, this.getInstallDetails());
      }

      if ((this.bitField0_ & 65536) != 0) {
         output.writeMessage(35, this.getTestingProgram());
      }

      if ((this.bitField0_ & 131072) != 0) {
         GeneratedMessageV3.writeString(output, 45, this.developerAddress_);
      }

      if ((this.bitField0_ & 262144) != 0) {
         output.writeMessage(46, this.getDeveloperPageLink());
      }

      for(i = 0; i < this.bundleModule_.size(); ++i) {
         output.writeMessage(47, (MessageLite)this.bundleModule_.get(i));
      }

      if ((this.bitField0_ & 524288) != 0) {
         output.writeInt32(53, this.roundedDownloadCount_);
      }

      this.unknownFields.writeTo(output);
   }

   public int getSerializedSize() {
      int size = this.memoizedSize;
      if (size != -1) {
         return size;
      } else {
         size = 0;
         if ((this.bitField0_ & 1) != 0) {
            size += GeneratedMessageV3.computeStringSize(1, this.developerName_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeInt32Size(2, this.majorVersionNumber_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeInt32Size(3, this.versionCode_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += GeneratedMessageV3.computeStringSize(4, this.versionString_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += CodedOutputStream.computeInt64Size(9, this.installationSize_);
         }

         int i = 0;

         for(int i = 0; i < this.permission_.size(); ++i) {
            i += computeStringSizeNoTag(this.permission_.getRaw(i));
         }

         size += i;
         size += 1 * this.getPermissionList().size();
         if ((this.bitField0_ & 32) != 0) {
            size += GeneratedMessageV3.computeStringSize(11, this.developerEmail_);
         }

         if ((this.bitField0_ & 64) != 0) {
            size += GeneratedMessageV3.computeStringSize(12, this.developerWebsite_);
         }

         if ((this.bitField0_ & 128) != 0) {
            size += GeneratedMessageV3.computeStringSize(13, this.numDownloads_);
         }

         if ((this.bitField0_ & 256) != 0) {
            size += GeneratedMessageV3.computeStringSize(14, this.packageName_);
         }

         if ((this.bitField0_ & 512) != 0) {
            size += GeneratedMessageV3.computeStringSize(15, this.recentChangesHtml_);
         }

         if ((this.bitField0_ & 1024) != 0) {
            size += GeneratedMessageV3.computeStringSize(16, this.uploadDate_);
         }

         if ((this.bitField0_ & 2048) != 0) {
            size += CodedOutputStream.computeBoolSize(24, this.declaresIab_);
         }

         if ((this.bitField0_ & 4096) != 0) {
            size += GeneratedMessageV3.computeStringSize(25, this.splitId_);
         }

         if ((this.bitField0_ & 8192) != 0) {
            size += GeneratedMessageV3.computeStringSize(30, this.installNotes_);
         }

         if ((this.bitField0_ & 16384) != 0) {
            size += CodedOutputStream.computeInt32Size(32, this.targetSdkVersion_);
         }

         if ((this.bitField0_ & '耀') != 0) {
            size += CodedOutputStream.computeMessageSize(34, this.getInstallDetails());
         }

         if ((this.bitField0_ & 65536) != 0) {
            size += CodedOutputStream.computeMessageSize(35, this.getTestingProgram());
         }

         if ((this.bitField0_ & 131072) != 0) {
            size += GeneratedMessageV3.computeStringSize(45, this.developerAddress_);
         }

         if ((this.bitField0_ & 262144) != 0) {
            size += CodedOutputStream.computeMessageSize(46, this.getDeveloperPageLink());
         }

         for(i = 0; i < this.bundleModule_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(47, (MessageLite)this.bundleModule_.get(i));
         }

         if ((this.bitField0_ & 524288) != 0) {
            size += CodedOutputStream.computeInt32Size(53, this.roundedDownloadCount_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof AppDetails)) {
         return super.equals(obj);
      } else {
         AppDetails other = (AppDetails)obj;
         if (this.hasDeveloperName() != other.hasDeveloperName()) {
            return false;
         } else if (this.hasDeveloperName() && !this.getDeveloperName().equals(other.getDeveloperName())) {
            return false;
         } else if (this.hasMajorVersionNumber() != other.hasMajorVersionNumber()) {
            return false;
         } else if (this.hasMajorVersionNumber() && this.getMajorVersionNumber() != other.getMajorVersionNumber()) {
            return false;
         } else if (this.hasVersionCode() != other.hasVersionCode()) {
            return false;
         } else if (this.hasVersionCode() && this.getVersionCode() != other.getVersionCode()) {
            return false;
         } else if (this.hasVersionString() != other.hasVersionString()) {
            return false;
         } else if (this.hasVersionString() && !this.getVersionString().equals(other.getVersionString())) {
            return false;
         } else if (this.hasInstallationSize() != other.hasInstallationSize()) {
            return false;
         } else if (this.hasInstallationSize() && this.getInstallationSize() != other.getInstallationSize()) {
            return false;
         } else if (!this.getPermissionList().equals(other.getPermissionList())) {
            return false;
         } else if (this.hasDeveloperEmail() != other.hasDeveloperEmail()) {
            return false;
         } else if (this.hasDeveloperEmail() && !this.getDeveloperEmail().equals(other.getDeveloperEmail())) {
            return false;
         } else if (this.hasDeveloperWebsite() != other.hasDeveloperWebsite()) {
            return false;
         } else if (this.hasDeveloperWebsite() && !this.getDeveloperWebsite().equals(other.getDeveloperWebsite())) {
            return false;
         } else if (this.hasNumDownloads() != other.hasNumDownloads()) {
            return false;
         } else if (this.hasNumDownloads() && !this.getNumDownloads().equals(other.getNumDownloads())) {
            return false;
         } else if (this.hasPackageName() != other.hasPackageName()) {
            return false;
         } else if (this.hasPackageName() && !this.getPackageName().equals(other.getPackageName())) {
            return false;
         } else if (this.hasRecentChangesHtml() != other.hasRecentChangesHtml()) {
            return false;
         } else if (this.hasRecentChangesHtml() && !this.getRecentChangesHtml().equals(other.getRecentChangesHtml())) {
            return false;
         } else if (this.hasUploadDate() != other.hasUploadDate()) {
            return false;
         } else if (this.hasUploadDate() && !this.getUploadDate().equals(other.getUploadDate())) {
            return false;
         } else if (this.hasDeclaresIab() != other.hasDeclaresIab()) {
            return false;
         } else if (this.hasDeclaresIab() && this.getDeclaresIab() != other.getDeclaresIab()) {
            return false;
         } else if (this.hasSplitId() != other.hasSplitId()) {
            return false;
         } else if (this.hasSplitId() && !this.getSplitId().equals(other.getSplitId())) {
            return false;
         } else if (this.hasInstallNotes() != other.hasInstallNotes()) {
            return false;
         } else if (this.hasInstallNotes() && !this.getInstallNotes().equals(other.getInstallNotes())) {
            return false;
         } else if (this.hasTargetSdkVersion() != other.hasTargetSdkVersion()) {
            return false;
         } else if (this.hasTargetSdkVersion() && this.getTargetSdkVersion() != other.getTargetSdkVersion()) {
            return false;
         } else if (this.hasInstallDetails() != other.hasInstallDetails()) {
            return false;
         } else if (this.hasInstallDetails() && !this.getInstallDetails().equals(other.getInstallDetails())) {
            return false;
         } else if (this.hasTestingProgram() != other.hasTestingProgram()) {
            return false;
         } else if (this.hasTestingProgram() && !this.getTestingProgram().equals(other.getTestingProgram())) {
            return false;
         } else if (this.hasDeveloperAddress() != other.hasDeveloperAddress()) {
            return false;
         } else if (this.hasDeveloperAddress() && !this.getDeveloperAddress().equals(other.getDeveloperAddress())) {
            return false;
         } else if (this.hasDeveloperPageLink() != other.hasDeveloperPageLink()) {
            return false;
         } else if (this.hasDeveloperPageLink() && !this.getDeveloperPageLink().equals(other.getDeveloperPageLink())) {
            return false;
         } else if (!this.getBundleModuleList().equals(other.getBundleModuleList())) {
            return false;
         } else if (this.hasRoundedDownloadCount() != other.hasRoundedDownloadCount()) {
            return false;
         } else if (this.hasRoundedDownloadCount() && this.getRoundedDownloadCount() != other.getRoundedDownloadCount()) {
            return false;
         } else {
            return this.unknownFields.equals(other.unknownFields);
         }
      }
   }

   public int hashCode() {
      if (this.memoizedHashCode != 0) {
         return this.memoizedHashCode;
      } else {
         int hash = 41;
         int hash = 19 * hash + getDescriptor().hashCode();
         if (this.hasDeveloperName()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getDeveloperName().hashCode();
         }

         if (this.hasMajorVersionNumber()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getMajorVersionNumber();
         }

         if (this.hasVersionCode()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getVersionCode();
         }

         if (this.hasVersionString()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getVersionString().hashCode();
         }

         if (this.hasInstallationSize()) {
            hash = 37 * hash + 9;
            hash = 53 * hash + Internal.hashLong(this.getInstallationSize());
         }

         if (this.getPermissionCount() > 0) {
            hash = 37 * hash + 10;
            hash = 53 * hash + this.getPermissionList().hashCode();
         }

         if (this.hasDeveloperEmail()) {
            hash = 37 * hash + 11;
            hash = 53 * hash + this.getDeveloperEmail().hashCode();
         }

         if (this.hasDeveloperWebsite()) {
            hash = 37 * hash + 12;
            hash = 53 * hash + this.getDeveloperWebsite().hashCode();
         }

         if (this.hasNumDownloads()) {
            hash = 37 * hash + 13;
            hash = 53 * hash + this.getNumDownloads().hashCode();
         }

         if (this.hasPackageName()) {
            hash = 37 * hash + 14;
            hash = 53 * hash + this.getPackageName().hashCode();
         }

         if (this.hasRecentChangesHtml()) {
            hash = 37 * hash + 15;
            hash = 53 * hash + this.getRecentChangesHtml().hashCode();
         }

         if (this.hasUploadDate()) {
            hash = 37 * hash + 16;
            hash = 53 * hash + this.getUploadDate().hashCode();
         }

         if (this.hasDeclaresIab()) {
            hash = 37 * hash + 24;
            hash = 53 * hash + Internal.hashBoolean(this.getDeclaresIab());
         }

         if (this.hasSplitId()) {
            hash = 37 * hash + 25;
            hash = 53 * hash + this.getSplitId().hashCode();
         }

         if (this.hasInstallNotes()) {
            hash = 37 * hash + 30;
            hash = 53 * hash + this.getInstallNotes().hashCode();
         }

         if (this.hasTargetSdkVersion()) {
            hash = 37 * hash + 32;
            hash = 53 * hash + this.getTargetSdkVersion();
         }

         if (this.hasInstallDetails()) {
            hash = 37 * hash + 34;
            hash = 53 * hash + this.getInstallDetails().hashCode();
         }

         if (this.hasTestingProgram()) {
            hash = 37 * hash + 35;
            hash = 53 * hash + this.getTestingProgram().hashCode();
         }

         if (this.hasDeveloperAddress()) {
            hash = 37 * hash + 45;
            hash = 53 * hash + this.getDeveloperAddress().hashCode();
         }

         if (this.hasDeveloperPageLink()) {
            hash = 37 * hash + 46;
            hash = 53 * hash + this.getDeveloperPageLink().hashCode();
         }

         if (this.getBundleModuleCount() > 0) {
            hash = 37 * hash + 47;
            hash = 53 * hash + this.getBundleModuleList().hashCode();
         }

         if (this.hasRoundedDownloadCount()) {
            hash = 37 * hash + 53;
            hash = 53 * hash + this.getRoundedDownloadCount();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static AppDetails parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (AppDetails)PARSER.parseFrom(data);
   }

   public static AppDetails parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AppDetails)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AppDetails parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (AppDetails)PARSER.parseFrom(data);
   }

   public static AppDetails parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AppDetails)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AppDetails parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (AppDetails)PARSER.parseFrom(data);
   }

   public static AppDetails parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AppDetails)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AppDetails parseFrom(InputStream input) throws IOException {
      return (AppDetails)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AppDetails parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AppDetails)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static AppDetails parseDelimitedFrom(InputStream input) throws IOException {
      return (AppDetails)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static AppDetails parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AppDetails)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static AppDetails parseFrom(CodedInputStream input) throws IOException {
      return (AppDetails)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AppDetails parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AppDetails)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public AppDetails.Builder newBuilderForType() {
      return newBuilder();
   }

   public static AppDetails.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static AppDetails.Builder newBuilder(AppDetails prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public AppDetails.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new AppDetails.Builder() : (new AppDetails.Builder()).mergeFrom(this);
   }

   protected AppDetails.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      AppDetails.Builder builder = new AppDetails.Builder(parent);
      return builder;
   }

   public static AppDetails getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public AppDetails getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   AppDetails(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   AppDetails(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements AppDetailsOrBuilder {
      private int bitField0_;
      private Object developerName_;
      private int majorVersionNumber_;
      private int versionCode_;
      private Object versionString_;
      private long installationSize_;
      private LazyStringList permission_;
      private Object developerEmail_;
      private Object developerWebsite_;
      private Object numDownloads_;
      private Object packageName_;
      private Object recentChangesHtml_;
      private Object uploadDate_;
      private boolean declaresIab_;
      private Object splitId_;
      private Object installNotes_;
      private int targetSdkVersion_;
      private InstallDetails installDetails_;
      private SingleFieldBuilderV3 installDetailsBuilder_;
      private TestingProgram testingProgram_;
      private SingleFieldBuilderV3 testingProgramBuilder_;
      private Object developerAddress_;
      private Link developerPageLink_;
      private SingleFieldBuilderV3 developerPageLinkBuilder_;
      private List bundleModule_;
      private RepeatedFieldBuilderV3 bundleModuleBuilder_;
      private int roundedDownloadCount_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_AppDetails_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_AppDetails_fieldAccessorTable.ensureFieldAccessorsInitialized(AppDetails.class, AppDetails.Builder.class);
      }

      private Builder() {
         this.developerName_ = "";
         this.versionString_ = "";
         this.permission_ = LazyStringArrayList.EMPTY;
         this.developerEmail_ = "";
         this.developerWebsite_ = "";
         this.numDownloads_ = "";
         this.packageName_ = "";
         this.recentChangesHtml_ = "";
         this.uploadDate_ = "";
         this.splitId_ = "";
         this.installNotes_ = "";
         this.developerAddress_ = "";
         this.bundleModule_ = Collections.emptyList();
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.developerName_ = "";
         this.versionString_ = "";
         this.permission_ = LazyStringArrayList.EMPTY;
         this.developerEmail_ = "";
         this.developerWebsite_ = "";
         this.numDownloads_ = "";
         this.packageName_ = "";
         this.recentChangesHtml_ = "";
         this.uploadDate_ = "";
         this.splitId_ = "";
         this.installNotes_ = "";
         this.developerAddress_ = "";
         this.bundleModule_ = Collections.emptyList();
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (AppDetails.alwaysUseFieldBuilders) {
            this.getInstallDetailsFieldBuilder();
            this.getTestingProgramFieldBuilder();
            this.getDeveloperPageLinkFieldBuilder();
            this.getBundleModuleFieldBuilder();
         }

      }

      public AppDetails.Builder clear() {
         super.clear();
         this.developerName_ = "";
         this.bitField0_ &= -2;
         this.majorVersionNumber_ = 0;
         this.bitField0_ &= -3;
         this.versionCode_ = 0;
         this.bitField0_ &= -5;
         this.versionString_ = "";
         this.bitField0_ &= -9;
         this.installationSize_ = 0L;
         this.bitField0_ &= -17;
         this.permission_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -33;
         this.developerEmail_ = "";
         this.bitField0_ &= -65;
         this.developerWebsite_ = "";
         this.bitField0_ &= -129;
         this.numDownloads_ = "";
         this.bitField0_ &= -257;
         this.packageName_ = "";
         this.bitField0_ &= -513;
         this.recentChangesHtml_ = "";
         this.bitField0_ &= -1025;
         this.uploadDate_ = "";
         this.bitField0_ &= -2049;
         this.declaresIab_ = false;
         this.bitField0_ &= -4097;
         this.splitId_ = "";
         this.bitField0_ &= -8193;
         this.installNotes_ = "";
         this.bitField0_ &= -16385;
         this.targetSdkVersion_ = 0;
         this.bitField0_ &= -32769;
         if (this.installDetailsBuilder_ == null) {
            this.installDetails_ = null;
         } else {
            this.installDetailsBuilder_.clear();
         }

         this.bitField0_ &= -65537;
         if (this.testingProgramBuilder_ == null) {
            this.testingProgram_ = null;
         } else {
            this.testingProgramBuilder_.clear();
         }

         this.bitField0_ &= -131073;
         this.developerAddress_ = "";
         this.bitField0_ &= -262145;
         if (this.developerPageLinkBuilder_ == null) {
            this.developerPageLink_ = null;
         } else {
            this.developerPageLinkBuilder_.clear();
         }

         this.bitField0_ &= -524289;
         if (this.bundleModuleBuilder_ == null) {
            this.bundleModule_ = Collections.emptyList();
            this.bitField0_ &= -1048577;
         } else {
            this.bundleModuleBuilder_.clear();
         }

         this.roundedDownloadCount_ = 0;
         this.bitField0_ &= -2097153;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_AppDetails_descriptor;
      }

      public AppDetails getDefaultInstanceForType() {
         return AppDetails.getDefaultInstance();
      }

      public AppDetails build() {
         AppDetails result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public AppDetails buildPartial() {
         AppDetails result = new AppDetails(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.developerName_ = this.developerName_;
         if ((from_bitField0_ & 2) != 0) {
            result.majorVersionNumber_ = this.majorVersionNumber_;
            to_bitField0_ |= 2;
         }

         if ((from_bitField0_ & 4) != 0) {
            result.versionCode_ = this.versionCode_;
            to_bitField0_ |= 4;
         }

         if ((from_bitField0_ & 8) != 0) {
            to_bitField0_ |= 8;
         }

         result.versionString_ = this.versionString_;
         if ((from_bitField0_ & 16) != 0) {
            result.installationSize_ = this.installationSize_;
            to_bitField0_ |= 16;
         }

         if ((this.bitField0_ & 32) != 0) {
            this.permission_ = this.permission_.getUnmodifiableView();
            this.bitField0_ &= -33;
         }

         result.permission_ = this.permission_;
         if ((from_bitField0_ & 64) != 0) {
            to_bitField0_ |= 32;
         }

         result.developerEmail_ = this.developerEmail_;
         if ((from_bitField0_ & 128) != 0) {
            to_bitField0_ |= 64;
         }

         result.developerWebsite_ = this.developerWebsite_;
         if ((from_bitField0_ & 256) != 0) {
            to_bitField0_ |= 128;
         }

         result.numDownloads_ = this.numDownloads_;
         if ((from_bitField0_ & 512) != 0) {
            to_bitField0_ |= 256;
         }

         result.packageName_ = this.packageName_;
         if ((from_bitField0_ & 1024) != 0) {
            to_bitField0_ |= 512;
         }

         result.recentChangesHtml_ = this.recentChangesHtml_;
         if ((from_bitField0_ & 2048) != 0) {
            to_bitField0_ |= 1024;
         }

         result.uploadDate_ = this.uploadDate_;
         if ((from_bitField0_ & 4096) != 0) {
            result.declaresIab_ = this.declaresIab_;
            to_bitField0_ |= 2048;
         }

         if ((from_bitField0_ & 8192) != 0) {
            to_bitField0_ |= 4096;
         }

         result.splitId_ = this.splitId_;
         if ((from_bitField0_ & 16384) != 0) {
            to_bitField0_ |= 8192;
         }

         result.installNotes_ = this.installNotes_;
         if ((from_bitField0_ & '耀') != 0) {
            result.targetSdkVersion_ = this.targetSdkVersion_;
            to_bitField0_ |= 16384;
         }

         if ((from_bitField0_ & 65536) != 0) {
            if (this.installDetailsBuilder_ == null) {
               result.installDetails_ = this.installDetails_;
            } else {
               result.installDetails_ = (InstallDetails)this.installDetailsBuilder_.build();
            }

            to_bitField0_ |= 32768;
         }

         if ((from_bitField0_ & 131072) != 0) {
            if (this.testingProgramBuilder_ == null) {
               result.testingProgram_ = this.testingProgram_;
            } else {
               result.testingProgram_ = (TestingProgram)this.testingProgramBuilder_.build();
            }

            to_bitField0_ |= 65536;
         }

         if ((from_bitField0_ & 262144) != 0) {
            to_bitField0_ |= 131072;
         }

         result.developerAddress_ = this.developerAddress_;
         if ((from_bitField0_ & 524288) != 0) {
            if (this.developerPageLinkBuilder_ == null) {
               result.developerPageLink_ = this.developerPageLink_;
            } else {
               result.developerPageLink_ = (Link)this.developerPageLinkBuilder_.build();
            }

            to_bitField0_ |= 262144;
         }

         if (this.bundleModuleBuilder_ == null) {
            if ((this.bitField0_ & 1048576) != 0) {
               this.bundleModule_ = Collections.unmodifiableList(this.bundleModule_);
               this.bitField0_ &= -1048577;
            }

            result.bundleModule_ = this.bundleModule_;
         } else {
            result.bundleModule_ = this.bundleModuleBuilder_.build();
         }

         if ((from_bitField0_ & 2097152) != 0) {
            result.roundedDownloadCount_ = this.roundedDownloadCount_;
            to_bitField0_ |= 524288;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public AppDetails.Builder clone() {
         return (AppDetails.Builder)super.clone();
      }

      public AppDetails.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (AppDetails.Builder)super.setField(field, value);
      }

      public AppDetails.Builder clearField(Descriptors.FieldDescriptor field) {
         return (AppDetails.Builder)super.clearField(field);
      }

      public AppDetails.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (AppDetails.Builder)super.clearOneof(oneof);
      }

      public AppDetails.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (AppDetails.Builder)super.setRepeatedField(field, index, value);
      }

      public AppDetails.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (AppDetails.Builder)super.addRepeatedField(field, value);
      }

      public AppDetails.Builder mergeFrom(Message other) {
         if (other instanceof AppDetails) {
            return this.mergeFrom((AppDetails)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public AppDetails.Builder mergeFrom(AppDetails other) {
         if (other == AppDetails.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasDeveloperName()) {
               this.bitField0_ |= 1;
               this.developerName_ = other.developerName_;
               this.onChanged();
            }

            if (other.hasMajorVersionNumber()) {
               this.setMajorVersionNumber(other.getMajorVersionNumber());
            }

            if (other.hasVersionCode()) {
               this.setVersionCode(other.getVersionCode());
            }

            if (other.hasVersionString()) {
               this.bitField0_ |= 8;
               this.versionString_ = other.versionString_;
               this.onChanged();
            }

            if (other.hasInstallationSize()) {
               this.setInstallationSize(other.getInstallationSize());
            }

            if (!other.permission_.isEmpty()) {
               if (this.permission_.isEmpty()) {
                  this.permission_ = other.permission_;
                  this.bitField0_ &= -33;
               } else {
                  this.ensurePermissionIsMutable();
                  this.permission_.addAll(other.permission_);
               }

               this.onChanged();
            }

            if (other.hasDeveloperEmail()) {
               this.bitField0_ |= 64;
               this.developerEmail_ = other.developerEmail_;
               this.onChanged();
            }

            if (other.hasDeveloperWebsite()) {
               this.bitField0_ |= 128;
               this.developerWebsite_ = other.developerWebsite_;
               this.onChanged();
            }

            if (other.hasNumDownloads()) {
               this.bitField0_ |= 256;
               this.numDownloads_ = other.numDownloads_;
               this.onChanged();
            }

            if (other.hasPackageName()) {
               this.bitField0_ |= 512;
               this.packageName_ = other.packageName_;
               this.onChanged();
            }

            if (other.hasRecentChangesHtml()) {
               this.bitField0_ |= 1024;
               this.recentChangesHtml_ = other.recentChangesHtml_;
               this.onChanged();
            }

            if (other.hasUploadDate()) {
               this.bitField0_ |= 2048;
               this.uploadDate_ = other.uploadDate_;
               this.onChanged();
            }

            if (other.hasDeclaresIab()) {
               this.setDeclaresIab(other.getDeclaresIab());
            }

            if (other.hasSplitId()) {
               this.bitField0_ |= 8192;
               this.splitId_ = other.splitId_;
               this.onChanged();
            }

            if (other.hasInstallNotes()) {
               this.bitField0_ |= 16384;
               this.installNotes_ = other.installNotes_;
               this.onChanged();
            }

            if (other.hasTargetSdkVersion()) {
               this.setTargetSdkVersion(other.getTargetSdkVersion());
            }

            if (other.hasInstallDetails()) {
               this.mergeInstallDetails(other.getInstallDetails());
            }

            if (other.hasTestingProgram()) {
               this.mergeTestingProgram(other.getTestingProgram());
            }

            if (other.hasDeveloperAddress()) {
               this.bitField0_ |= 262144;
               this.developerAddress_ = other.developerAddress_;
               this.onChanged();
            }

            if (other.hasDeveloperPageLink()) {
               this.mergeDeveloperPageLink(other.getDeveloperPageLink());
            }

            if (this.bundleModuleBuilder_ == null) {
               if (!other.bundleModule_.isEmpty()) {
                  if (this.bundleModule_.isEmpty()) {
                     this.bundleModule_ = other.bundleModule_;
                     this.bitField0_ &= -1048577;
                  } else {
                     this.ensureBundleModuleIsMutable();
                     this.bundleModule_.addAll(other.bundleModule_);
                  }

                  this.onChanged();
               }
            } else if (!other.bundleModule_.isEmpty()) {
               if (this.bundleModuleBuilder_.isEmpty()) {
                  this.bundleModuleBuilder_.dispose();
                  this.bundleModuleBuilder_ = null;
                  this.bundleModule_ = other.bundleModule_;
                  this.bitField0_ &= -1048577;
                  this.bundleModuleBuilder_ = AppDetails.alwaysUseFieldBuilders ? this.getBundleModuleFieldBuilder() : null;
               } else {
                  this.bundleModuleBuilder_.addAllMessages(other.bundleModule_);
               }
            }

            if (other.hasRoundedDownloadCount()) {
               this.setRoundedDownloadCount(other.getRoundedDownloadCount());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public AppDetails.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         AppDetails parsedMessage = null;

         try {
            parsedMessage = (AppDetails)AppDetails.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (AppDetails)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasDeveloperName() {
         return (this.bitField0_ & 1) != 0;
      }

      public String getDeveloperName() {
         Object ref = this.developerName_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.developerName_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDeveloperNameBytes() {
         Object ref = this.developerName_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.developerName_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AppDetails.Builder setDeveloperName(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.developerName_ = value;
            this.onChanged();
            return this;
         }
      }

      public AppDetails.Builder clearDeveloperName() {
         this.bitField0_ &= -2;
         this.developerName_ = AppDetails.getDefaultInstance().getDeveloperName();
         this.onChanged();
         return this;
      }

      public AppDetails.Builder setDeveloperNameBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.developerName_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasMajorVersionNumber() {
         return (this.bitField0_ & 2) != 0;
      }

      public int getMajorVersionNumber() {
         return this.majorVersionNumber_;
      }

      public AppDetails.Builder setMajorVersionNumber(int value) {
         this.bitField0_ |= 2;
         this.majorVersionNumber_ = value;
         this.onChanged();
         return this;
      }

      public AppDetails.Builder clearMajorVersionNumber() {
         this.bitField0_ &= -3;
         this.majorVersionNumber_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasVersionCode() {
         return (this.bitField0_ & 4) != 0;
      }

      public int getVersionCode() {
         return this.versionCode_;
      }

      public AppDetails.Builder setVersionCode(int value) {
         this.bitField0_ |= 4;
         this.versionCode_ = value;
         this.onChanged();
         return this;
      }

      public AppDetails.Builder clearVersionCode() {
         this.bitField0_ &= -5;
         this.versionCode_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasVersionString() {
         return (this.bitField0_ & 8) != 0;
      }

      public String getVersionString() {
         Object ref = this.versionString_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.versionString_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getVersionStringBytes() {
         Object ref = this.versionString_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.versionString_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AppDetails.Builder setVersionString(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.versionString_ = value;
            this.onChanged();
            return this;
         }
      }

      public AppDetails.Builder clearVersionString() {
         this.bitField0_ &= -9;
         this.versionString_ = AppDetails.getDefaultInstance().getVersionString();
         this.onChanged();
         return this;
      }

      public AppDetails.Builder setVersionStringBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.versionString_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasInstallationSize() {
         return (this.bitField0_ & 16) != 0;
      }

      public long getInstallationSize() {
         return this.installationSize_;
      }

      public AppDetails.Builder setInstallationSize(long value) {
         this.bitField0_ |= 16;
         this.installationSize_ = value;
         this.onChanged();
         return this;
      }

      public AppDetails.Builder clearInstallationSize() {
         this.bitField0_ &= -17;
         this.installationSize_ = 0L;
         this.onChanged();
         return this;
      }

      private void ensurePermissionIsMutable() {
         if ((this.bitField0_ & 32) == 0) {
            this.permission_ = new LazyStringArrayList(this.permission_);
            this.bitField0_ |= 32;
         }

      }

      public ProtocolStringList getPermissionList() {
         return this.permission_.getUnmodifiableView();
      }

      public int getPermissionCount() {
         return this.permission_.size();
      }

      public String getPermission(int index) {
         return (String)this.permission_.get(index);
      }

      public ByteString getPermissionBytes(int index) {
         return this.permission_.getByteString(index);
      }

      public AppDetails.Builder setPermission(int index, String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensurePermissionIsMutable();
            this.permission_.set(index, (Object)value);
            this.onChanged();
            return this;
         }
      }

      public AppDetails.Builder addPermission(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensurePermissionIsMutable();
            this.permission_.add((Object)value);
            this.onChanged();
            return this;
         }
      }

      public AppDetails.Builder addAllPermission(Iterable values) {
         this.ensurePermissionIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.permission_);
         this.onChanged();
         return this;
      }

      public AppDetails.Builder clearPermission() {
         this.permission_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -33;
         this.onChanged();
         return this;
      }

      public AppDetails.Builder addPermissionBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensurePermissionIsMutable();
            this.permission_.add(value);
            this.onChanged();
            return this;
         }
      }

      public boolean hasDeveloperEmail() {
         return (this.bitField0_ & 64) != 0;
      }

      public String getDeveloperEmail() {
         Object ref = this.developerEmail_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.developerEmail_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDeveloperEmailBytes() {
         Object ref = this.developerEmail_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.developerEmail_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AppDetails.Builder setDeveloperEmail(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 64;
            this.developerEmail_ = value;
            this.onChanged();
            return this;
         }
      }

      public AppDetails.Builder clearDeveloperEmail() {
         this.bitField0_ &= -65;
         this.developerEmail_ = AppDetails.getDefaultInstance().getDeveloperEmail();
         this.onChanged();
         return this;
      }

      public AppDetails.Builder setDeveloperEmailBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 64;
            this.developerEmail_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasDeveloperWebsite() {
         return (this.bitField0_ & 128) != 0;
      }

      public String getDeveloperWebsite() {
         Object ref = this.developerWebsite_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.developerWebsite_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDeveloperWebsiteBytes() {
         Object ref = this.developerWebsite_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.developerWebsite_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AppDetails.Builder setDeveloperWebsite(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 128;
            this.developerWebsite_ = value;
            this.onChanged();
            return this;
         }
      }

      public AppDetails.Builder clearDeveloperWebsite() {
         this.bitField0_ &= -129;
         this.developerWebsite_ = AppDetails.getDefaultInstance().getDeveloperWebsite();
         this.onChanged();
         return this;
      }

      public AppDetails.Builder setDeveloperWebsiteBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 128;
            this.developerWebsite_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasNumDownloads() {
         return (this.bitField0_ & 256) != 0;
      }

      public String getNumDownloads() {
         Object ref = this.numDownloads_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.numDownloads_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getNumDownloadsBytes() {
         Object ref = this.numDownloads_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.numDownloads_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AppDetails.Builder setNumDownloads(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 256;
            this.numDownloads_ = value;
            this.onChanged();
            return this;
         }
      }

      public AppDetails.Builder clearNumDownloads() {
         this.bitField0_ &= -257;
         this.numDownloads_ = AppDetails.getDefaultInstance().getNumDownloads();
         this.onChanged();
         return this;
      }

      public AppDetails.Builder setNumDownloadsBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 256;
            this.numDownloads_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasPackageName() {
         return (this.bitField0_ & 512) != 0;
      }

      public String getPackageName() {
         Object ref = this.packageName_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.packageName_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getPackageNameBytes() {
         Object ref = this.packageName_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.packageName_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AppDetails.Builder setPackageName(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 512;
            this.packageName_ = value;
            this.onChanged();
            return this;
         }
      }

      public AppDetails.Builder clearPackageName() {
         this.bitField0_ &= -513;
         this.packageName_ = AppDetails.getDefaultInstance().getPackageName();
         this.onChanged();
         return this;
      }

      public AppDetails.Builder setPackageNameBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 512;
            this.packageName_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasRecentChangesHtml() {
         return (this.bitField0_ & 1024) != 0;
      }

      public String getRecentChangesHtml() {
         Object ref = this.recentChangesHtml_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.recentChangesHtml_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getRecentChangesHtmlBytes() {
         Object ref = this.recentChangesHtml_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.recentChangesHtml_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AppDetails.Builder setRecentChangesHtml(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1024;
            this.recentChangesHtml_ = value;
            this.onChanged();
            return this;
         }
      }

      public AppDetails.Builder clearRecentChangesHtml() {
         this.bitField0_ &= -1025;
         this.recentChangesHtml_ = AppDetails.getDefaultInstance().getRecentChangesHtml();
         this.onChanged();
         return this;
      }

      public AppDetails.Builder setRecentChangesHtmlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1024;
            this.recentChangesHtml_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasUploadDate() {
         return (this.bitField0_ & 2048) != 0;
      }

      public String getUploadDate() {
         Object ref = this.uploadDate_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.uploadDate_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getUploadDateBytes() {
         Object ref = this.uploadDate_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.uploadDate_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AppDetails.Builder setUploadDate(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2048;
            this.uploadDate_ = value;
            this.onChanged();
            return this;
         }
      }

      public AppDetails.Builder clearUploadDate() {
         this.bitField0_ &= -2049;
         this.uploadDate_ = AppDetails.getDefaultInstance().getUploadDate();
         this.onChanged();
         return this;
      }

      public AppDetails.Builder setUploadDateBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2048;
            this.uploadDate_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasDeclaresIab() {
         return (this.bitField0_ & 4096) != 0;
      }

      public boolean getDeclaresIab() {
         return this.declaresIab_;
      }

      public AppDetails.Builder setDeclaresIab(boolean value) {
         this.bitField0_ |= 4096;
         this.declaresIab_ = value;
         this.onChanged();
         return this;
      }

      public AppDetails.Builder clearDeclaresIab() {
         this.bitField0_ &= -4097;
         this.declaresIab_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasSplitId() {
         return (this.bitField0_ & 8192) != 0;
      }

      public String getSplitId() {
         Object ref = this.splitId_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.splitId_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getSplitIdBytes() {
         Object ref = this.splitId_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.splitId_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AppDetails.Builder setSplitId(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8192;
            this.splitId_ = value;
            this.onChanged();
            return this;
         }
      }

      public AppDetails.Builder clearSplitId() {
         this.bitField0_ &= -8193;
         this.splitId_ = AppDetails.getDefaultInstance().getSplitId();
         this.onChanged();
         return this;
      }

      public AppDetails.Builder setSplitIdBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8192;
            this.splitId_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasInstallNotes() {
         return (this.bitField0_ & 16384) != 0;
      }

      public String getInstallNotes() {
         Object ref = this.installNotes_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.installNotes_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getInstallNotesBytes() {
         Object ref = this.installNotes_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.installNotes_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AppDetails.Builder setInstallNotes(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16384;
            this.installNotes_ = value;
            this.onChanged();
            return this;
         }
      }

      public AppDetails.Builder clearInstallNotes() {
         this.bitField0_ &= -16385;
         this.installNotes_ = AppDetails.getDefaultInstance().getInstallNotes();
         this.onChanged();
         return this;
      }

      public AppDetails.Builder setInstallNotesBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16384;
            this.installNotes_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasTargetSdkVersion() {
         return (this.bitField0_ & '耀') != 0;
      }

      public int getTargetSdkVersion() {
         return this.targetSdkVersion_;
      }

      public AppDetails.Builder setTargetSdkVersion(int value) {
         this.bitField0_ |= 32768;
         this.targetSdkVersion_ = value;
         this.onChanged();
         return this;
      }

      public AppDetails.Builder clearTargetSdkVersion() {
         this.bitField0_ &= -32769;
         this.targetSdkVersion_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasInstallDetails() {
         return (this.bitField0_ & 65536) != 0;
      }

      public InstallDetails getInstallDetails() {
         if (this.installDetailsBuilder_ == null) {
            return this.installDetails_ == null ? InstallDetails.getDefaultInstance() : this.installDetails_;
         } else {
            return (InstallDetails)this.installDetailsBuilder_.getMessage();
         }
      }

      public AppDetails.Builder setInstallDetails(InstallDetails value) {
         if (this.installDetailsBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.installDetails_ = value;
            this.onChanged();
         } else {
            this.installDetailsBuilder_.setMessage(value);
         }

         this.bitField0_ |= 65536;
         return this;
      }

      public AppDetails.Builder setInstallDetails(InstallDetails.Builder builderForValue) {
         if (this.installDetailsBuilder_ == null) {
            this.installDetails_ = builderForValue.build();
            this.onChanged();
         } else {
            this.installDetailsBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 65536;
         return this;
      }

      public AppDetails.Builder mergeInstallDetails(InstallDetails value) {
         if (this.installDetailsBuilder_ == null) {
            if ((this.bitField0_ & 65536) != 0 && this.installDetails_ != null && this.installDetails_ != InstallDetails.getDefaultInstance()) {
               this.installDetails_ = InstallDetails.newBuilder(this.installDetails_).mergeFrom(value).buildPartial();
            } else {
               this.installDetails_ = value;
            }

            this.onChanged();
         } else {
            this.installDetailsBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 65536;
         return this;
      }

      public AppDetails.Builder clearInstallDetails() {
         if (this.installDetailsBuilder_ == null) {
            this.installDetails_ = null;
            this.onChanged();
         } else {
            this.installDetailsBuilder_.clear();
         }

         this.bitField0_ &= -65537;
         return this;
      }

      public InstallDetails.Builder getInstallDetailsBuilder() {
         this.bitField0_ |= 65536;
         this.onChanged();
         return (InstallDetails.Builder)this.getInstallDetailsFieldBuilder().getBuilder();
      }

      public InstallDetailsOrBuilder getInstallDetailsOrBuilder() {
         if (this.installDetailsBuilder_ != null) {
            return (InstallDetailsOrBuilder)this.installDetailsBuilder_.getMessageOrBuilder();
         } else {
            return this.installDetails_ == null ? InstallDetails.getDefaultInstance() : this.installDetails_;
         }
      }

      private SingleFieldBuilderV3 getInstallDetailsFieldBuilder() {
         if (this.installDetailsBuilder_ == null) {
            this.installDetailsBuilder_ = new SingleFieldBuilderV3(this.getInstallDetails(), this.getParentForChildren(), this.isClean());
            this.installDetails_ = null;
         }

         return this.installDetailsBuilder_;
      }

      public boolean hasTestingProgram() {
         return (this.bitField0_ & 131072) != 0;
      }

      public TestingProgram getTestingProgram() {
         if (this.testingProgramBuilder_ == null) {
            return this.testingProgram_ == null ? TestingProgram.getDefaultInstance() : this.testingProgram_;
         } else {
            return (TestingProgram)this.testingProgramBuilder_.getMessage();
         }
      }

      public AppDetails.Builder setTestingProgram(TestingProgram value) {
         if (this.testingProgramBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.testingProgram_ = value;
            this.onChanged();
         } else {
            this.testingProgramBuilder_.setMessage(value);
         }

         this.bitField0_ |= 131072;
         return this;
      }

      public AppDetails.Builder setTestingProgram(TestingProgram.Builder builderForValue) {
         if (this.testingProgramBuilder_ == null) {
            this.testingProgram_ = builderForValue.build();
            this.onChanged();
         } else {
            this.testingProgramBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 131072;
         return this;
      }

      public AppDetails.Builder mergeTestingProgram(TestingProgram value) {
         if (this.testingProgramBuilder_ == null) {
            if ((this.bitField0_ & 131072) != 0 && this.testingProgram_ != null && this.testingProgram_ != TestingProgram.getDefaultInstance()) {
               this.testingProgram_ = TestingProgram.newBuilder(this.testingProgram_).mergeFrom(value).buildPartial();
            } else {
               this.testingProgram_ = value;
            }

            this.onChanged();
         } else {
            this.testingProgramBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 131072;
         return this;
      }

      public AppDetails.Builder clearTestingProgram() {
         if (this.testingProgramBuilder_ == null) {
            this.testingProgram_ = null;
            this.onChanged();
         } else {
            this.testingProgramBuilder_.clear();
         }

         this.bitField0_ &= -131073;
         return this;
      }

      public TestingProgram.Builder getTestingProgramBuilder() {
         this.bitField0_ |= 131072;
         this.onChanged();
         return (TestingProgram.Builder)this.getTestingProgramFieldBuilder().getBuilder();
      }

      public TestingProgramOrBuilder getTestingProgramOrBuilder() {
         if (this.testingProgramBuilder_ != null) {
            return (TestingProgramOrBuilder)this.testingProgramBuilder_.getMessageOrBuilder();
         } else {
            return this.testingProgram_ == null ? TestingProgram.getDefaultInstance() : this.testingProgram_;
         }
      }

      private SingleFieldBuilderV3 getTestingProgramFieldBuilder() {
         if (this.testingProgramBuilder_ == null) {
            this.testingProgramBuilder_ = new SingleFieldBuilderV3(this.getTestingProgram(), this.getParentForChildren(), this.isClean());
            this.testingProgram_ = null;
         }

         return this.testingProgramBuilder_;
      }

      public boolean hasDeveloperAddress() {
         return (this.bitField0_ & 262144) != 0;
      }

      public String getDeveloperAddress() {
         Object ref = this.developerAddress_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.developerAddress_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDeveloperAddressBytes() {
         Object ref = this.developerAddress_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.developerAddress_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AppDetails.Builder setDeveloperAddress(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 262144;
            this.developerAddress_ = value;
            this.onChanged();
            return this;
         }
      }

      public AppDetails.Builder clearDeveloperAddress() {
         this.bitField0_ &= -262145;
         this.developerAddress_ = AppDetails.getDefaultInstance().getDeveloperAddress();
         this.onChanged();
         return this;
      }

      public AppDetails.Builder setDeveloperAddressBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 262144;
            this.developerAddress_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasDeveloperPageLink() {
         return (this.bitField0_ & 524288) != 0;
      }

      public Link getDeveloperPageLink() {
         if (this.developerPageLinkBuilder_ == null) {
            return this.developerPageLink_ == null ? Link.getDefaultInstance() : this.developerPageLink_;
         } else {
            return (Link)this.developerPageLinkBuilder_.getMessage();
         }
      }

      public AppDetails.Builder setDeveloperPageLink(Link value) {
         if (this.developerPageLinkBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.developerPageLink_ = value;
            this.onChanged();
         } else {
            this.developerPageLinkBuilder_.setMessage(value);
         }

         this.bitField0_ |= 524288;
         return this;
      }

      public AppDetails.Builder setDeveloperPageLink(Link.Builder builderForValue) {
         if (this.developerPageLinkBuilder_ == null) {
            this.developerPageLink_ = builderForValue.build();
            this.onChanged();
         } else {
            this.developerPageLinkBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 524288;
         return this;
      }

      public AppDetails.Builder mergeDeveloperPageLink(Link value) {
         if (this.developerPageLinkBuilder_ == null) {
            if ((this.bitField0_ & 524288) != 0 && this.developerPageLink_ != null && this.developerPageLink_ != Link.getDefaultInstance()) {
               this.developerPageLink_ = Link.newBuilder(this.developerPageLink_).mergeFrom(value).buildPartial();
            } else {
               this.developerPageLink_ = value;
            }

            this.onChanged();
         } else {
            this.developerPageLinkBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 524288;
         return this;
      }

      public AppDetails.Builder clearDeveloperPageLink() {
         if (this.developerPageLinkBuilder_ == null) {
            this.developerPageLink_ = null;
            this.onChanged();
         } else {
            this.developerPageLinkBuilder_.clear();
         }

         this.bitField0_ &= -524289;
         return this;
      }

      public Link.Builder getDeveloperPageLinkBuilder() {
         this.bitField0_ |= 524288;
         this.onChanged();
         return (Link.Builder)this.getDeveloperPageLinkFieldBuilder().getBuilder();
      }

      public LinkOrBuilder getDeveloperPageLinkOrBuilder() {
         if (this.developerPageLinkBuilder_ != null) {
            return (LinkOrBuilder)this.developerPageLinkBuilder_.getMessageOrBuilder();
         } else {
            return this.developerPageLink_ == null ? Link.getDefaultInstance() : this.developerPageLink_;
         }
      }

      private SingleFieldBuilderV3 getDeveloperPageLinkFieldBuilder() {
         if (this.developerPageLinkBuilder_ == null) {
            this.developerPageLinkBuilder_ = new SingleFieldBuilderV3(this.getDeveloperPageLink(), this.getParentForChildren(), this.isClean());
            this.developerPageLink_ = null;
         }

         return this.developerPageLinkBuilder_;
      }

      private void ensureBundleModuleIsMutable() {
         if ((this.bitField0_ & 1048576) == 0) {
            this.bundleModule_ = new ArrayList(this.bundleModule_);
            this.bitField0_ |= 1048576;
         }

      }

      public List getBundleModuleList() {
         return this.bundleModuleBuilder_ == null ? Collections.unmodifiableList(this.bundleModule_) : this.bundleModuleBuilder_.getMessageList();
      }

      public int getBundleModuleCount() {
         return this.bundleModuleBuilder_ == null ? this.bundleModule_.size() : this.bundleModuleBuilder_.getCount();
      }

      public AppBundleModule getBundleModule(int index) {
         return this.bundleModuleBuilder_ == null ? (AppBundleModule)this.bundleModule_.get(index) : (AppBundleModule)this.bundleModuleBuilder_.getMessage(index);
      }

      public AppDetails.Builder setBundleModule(int index, AppBundleModule value) {
         if (this.bundleModuleBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureBundleModuleIsMutable();
            this.bundleModule_.set(index, value);
            this.onChanged();
         } else {
            this.bundleModuleBuilder_.setMessage(index, value);
         }

         return this;
      }

      public AppDetails.Builder setBundleModule(int index, AppBundleModule.Builder builderForValue) {
         if (this.bundleModuleBuilder_ == null) {
            this.ensureBundleModuleIsMutable();
            this.bundleModule_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.bundleModuleBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public AppDetails.Builder addBundleModule(AppBundleModule value) {
         if (this.bundleModuleBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureBundleModuleIsMutable();
            this.bundleModule_.add(value);
            this.onChanged();
         } else {
            this.bundleModuleBuilder_.addMessage(value);
         }

         return this;
      }

      public AppDetails.Builder addBundleModule(int index, AppBundleModule value) {
         if (this.bundleModuleBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureBundleModuleIsMutable();
            this.bundleModule_.add(index, value);
            this.onChanged();
         } else {
            this.bundleModuleBuilder_.addMessage(index, value);
         }

         return this;
      }

      public AppDetails.Builder addBundleModule(AppBundleModule.Builder builderForValue) {
         if (this.bundleModuleBuilder_ == null) {
            this.ensureBundleModuleIsMutable();
            this.bundleModule_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.bundleModuleBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public AppDetails.Builder addBundleModule(int index, AppBundleModule.Builder builderForValue) {
         if (this.bundleModuleBuilder_ == null) {
            this.ensureBundleModuleIsMutable();
            this.bundleModule_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.bundleModuleBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public AppDetails.Builder addAllBundleModule(Iterable values) {
         if (this.bundleModuleBuilder_ == null) {
            this.ensureBundleModuleIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.bundleModule_);
            this.onChanged();
         } else {
            this.bundleModuleBuilder_.addAllMessages(values);
         }

         return this;
      }

      public AppDetails.Builder clearBundleModule() {
         if (this.bundleModuleBuilder_ == null) {
            this.bundleModule_ = Collections.emptyList();
            this.bitField0_ &= -1048577;
            this.onChanged();
         } else {
            this.bundleModuleBuilder_.clear();
         }

         return this;
      }

      public AppDetails.Builder removeBundleModule(int index) {
         if (this.bundleModuleBuilder_ == null) {
            this.ensureBundleModuleIsMutable();
            this.bundleModule_.remove(index);
            this.onChanged();
         } else {
            this.bundleModuleBuilder_.remove(index);
         }

         return this;
      }

      public AppBundleModule.Builder getBundleModuleBuilder(int index) {
         return (AppBundleModule.Builder)this.getBundleModuleFieldBuilder().getBuilder(index);
      }

      public AppBundleModuleOrBuilder getBundleModuleOrBuilder(int index) {
         return this.bundleModuleBuilder_ == null ? (AppBundleModuleOrBuilder)this.bundleModule_.get(index) : (AppBundleModuleOrBuilder)this.bundleModuleBuilder_.getMessageOrBuilder(index);
      }

      public List getBundleModuleOrBuilderList() {
         return this.bundleModuleBuilder_ != null ? this.bundleModuleBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.bundleModule_);
      }

      public AppBundleModule.Builder addBundleModuleBuilder() {
         return (AppBundleModule.Builder)this.getBundleModuleFieldBuilder().addBuilder(AppBundleModule.getDefaultInstance());
      }

      public AppBundleModule.Builder addBundleModuleBuilder(int index) {
         return (AppBundleModule.Builder)this.getBundleModuleFieldBuilder().addBuilder(index, AppBundleModule.getDefaultInstance());
      }

      public List getBundleModuleBuilderList() {
         return this.getBundleModuleFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getBundleModuleFieldBuilder() {
         if (this.bundleModuleBuilder_ == null) {
            this.bundleModuleBuilder_ = new RepeatedFieldBuilderV3(this.bundleModule_, (this.bitField0_ & 1048576) != 0, this.getParentForChildren(), this.isClean());
            this.bundleModule_ = null;
         }

         return this.bundleModuleBuilder_;
      }

      public boolean hasRoundedDownloadCount() {
         return (this.bitField0_ & 2097152) != 0;
      }

      public int getRoundedDownloadCount() {
         return this.roundedDownloadCount_;
      }

      public AppDetails.Builder setRoundedDownloadCount(int value) {
         this.bitField0_ |= 2097152;
         this.roundedDownloadCount_ = value;
         this.onChanged();
         return this;
      }

      public AppDetails.Builder clearRoundedDownloadCount() {
         this.bitField0_ &= -2097153;
         this.roundedDownloadCount_ = 0;
         this.onChanged();
         return this;
      }

      public final AppDetails.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (AppDetails.Builder)super.setUnknownFields(unknownFields);
      }

      public final AppDetails.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (AppDetails.Builder)super.mergeUnknownFields(unknownFields);
      }

      // $FF: synthetic method
      Builder(Object x0) {
         this();
      }

      // $FF: synthetic method
      Builder(GeneratedMessageV3.BuilderParent x0, Object x1) {
         this(x0);
      }
   }
}
