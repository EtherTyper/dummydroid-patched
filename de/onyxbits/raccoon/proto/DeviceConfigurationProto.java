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
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DeviceConfigurationProto extends GeneratedMessageV3 implements DeviceConfigurationProtoOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int TOUCHSCREEN_FIELD_NUMBER = 1;
   private int touchScreen_;
   public static final int KEYBOARD_FIELD_NUMBER = 2;
   private int keyboard_;
   public static final int NAVIGATION_FIELD_NUMBER = 3;
   private int navigation_;
   public static final int SCREENLAYOUT_FIELD_NUMBER = 4;
   private int screenLayout_;
   public static final int HASHARDKEYBOARD_FIELD_NUMBER = 5;
   private boolean hasHardKeyboard_;
   public static final int HASFIVEWAYNAVIGATION_FIELD_NUMBER = 6;
   private boolean hasFiveWayNavigation_;
   public static final int SCREENDENSITY_FIELD_NUMBER = 7;
   private int screenDensity_;
   public static final int GLESVERSION_FIELD_NUMBER = 8;
   private int glEsVersion_;
   public static final int SYSTEMSHAREDLIBRARY_FIELD_NUMBER = 9;
   private LazyStringList systemSharedLibrary_;
   public static final int SYSTEMAVAILABLEFEATURE_FIELD_NUMBER = 10;
   private LazyStringList systemAvailableFeature_;
   public static final int NATIVEPLATFORM_FIELD_NUMBER = 11;
   private LazyStringList nativePlatform_;
   public static final int SCREENWIDTH_FIELD_NUMBER = 12;
   private int screenWidth_;
   public static final int SCREENHEIGHT_FIELD_NUMBER = 13;
   private int screenHeight_;
   public static final int SYSTEMSUPPORTEDLOCALE_FIELD_NUMBER = 14;
   private LazyStringList systemSupportedLocale_;
   public static final int GLEXTENSION_FIELD_NUMBER = 15;
   private LazyStringList glExtension_;
   public static final int MAXAPKDOWNLOADSIZEMB_FIELD_NUMBER = 17;
   private int maxApkDownloadSizeMb_;
   public static final int SMALLESTSCREENWIDTHDP_FIELD_NUMBER = 18;
   private int smallestScreenWidthDp_;
   public static final int LOWRAMDEVICE_FIELD_NUMBER = 19;
   private boolean lowRamDevice_;
   public static final int TOTALMEMORYBYTES_FIELD_NUMBER = 20;
   private long totalMemoryBytes_;
   public static final int MAXNUMOFCPUCORES_FIELD_NUMBER = 21;
   private int maxNumOfCpuCores_;
   private byte memoizedIsInitialized;
   private static final DeviceConfigurationProto DEFAULT_INSTANCE = new DeviceConfigurationProto();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public DeviceConfigurationProto parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new DeviceConfigurationProto(input, extensionRegistry);
      }
   };

   private DeviceConfigurationProto(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private DeviceConfigurationProto() {
      this.memoizedIsInitialized = -1;
      this.systemSharedLibrary_ = LazyStringArrayList.EMPTY;
      this.systemAvailableFeature_ = LazyStringArrayList.EMPTY;
      this.nativePlatform_ = LazyStringArrayList.EMPTY;
      this.systemSupportedLocale_ = LazyStringArrayList.EMPTY;
      this.glExtension_ = LazyStringArrayList.EMPTY;
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new DeviceConfigurationProto();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DeviceConfigurationProto(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 8:
                  this.bitField0_ |= 1;
                  this.touchScreen_ = input.readInt32();
                  break;
               case 16:
                  this.bitField0_ |= 2;
                  this.keyboard_ = input.readInt32();
                  break;
               case 24:
                  this.bitField0_ |= 4;
                  this.navigation_ = input.readInt32();
                  break;
               case 32:
                  this.bitField0_ |= 8;
                  this.screenLayout_ = input.readInt32();
                  break;
               case 40:
                  this.bitField0_ |= 16;
                  this.hasHardKeyboard_ = input.readBool();
                  break;
               case 48:
                  this.bitField0_ |= 32;
                  this.hasFiveWayNavigation_ = input.readBool();
                  break;
               case 56:
                  this.bitField0_ |= 64;
                  this.screenDensity_ = input.readInt32();
                  break;
               case 64:
                  this.bitField0_ |= 128;
                  this.glEsVersion_ = input.readInt32();
                  break;
               case 74:
                  bs = input.readBytes();
                  if ((mutable_bitField0_ & 256) == 0) {
                     this.systemSharedLibrary_ = new LazyStringArrayList();
                     mutable_bitField0_ |= 256;
                  }

                  this.systemSharedLibrary_.add(bs);
                  break;
               case 82:
                  bs = input.readBytes();
                  if ((mutable_bitField0_ & 512) == 0) {
                     this.systemAvailableFeature_ = new LazyStringArrayList();
                     mutable_bitField0_ |= 512;
                  }

                  this.systemAvailableFeature_.add(bs);
                  break;
               case 90:
                  bs = input.readBytes();
                  if ((mutable_bitField0_ & 1024) == 0) {
                     this.nativePlatform_ = new LazyStringArrayList();
                     mutable_bitField0_ |= 1024;
                  }

                  this.nativePlatform_.add(bs);
                  break;
               case 96:
                  this.bitField0_ |= 256;
                  this.screenWidth_ = input.readInt32();
                  break;
               case 104:
                  this.bitField0_ |= 512;
                  this.screenHeight_ = input.readInt32();
                  break;
               case 114:
                  bs = input.readBytes();
                  if ((mutable_bitField0_ & 8192) == 0) {
                     this.systemSupportedLocale_ = new LazyStringArrayList();
                     mutable_bitField0_ |= 8192;
                  }

                  this.systemSupportedLocale_.add(bs);
                  break;
               case 122:
                  bs = input.readBytes();
                  if ((mutable_bitField0_ & 16384) == 0) {
                     this.glExtension_ = new LazyStringArrayList();
                     mutable_bitField0_ |= 16384;
                  }

                  this.glExtension_.add(bs);
                  break;
               case 136:
                  this.bitField0_ |= 1024;
                  this.maxApkDownloadSizeMb_ = input.readInt32();
                  break;
               case 144:
                  this.bitField0_ |= 2048;
                  this.smallestScreenWidthDp_ = input.readInt32();
                  break;
               case 152:
                  this.bitField0_ |= 4096;
                  this.lowRamDevice_ = input.readBool();
                  break;
               case 160:
                  this.bitField0_ |= 8192;
                  this.totalMemoryBytes_ = input.readInt64();
                  break;
               case 168:
                  this.bitField0_ |= 16384;
                  this.maxNumOfCpuCores_ = input.readInt32();
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
            if ((mutable_bitField0_ & 256) != 0) {
               this.systemSharedLibrary_ = this.systemSharedLibrary_.getUnmodifiableView();
            }

            if ((mutable_bitField0_ & 512) != 0) {
               this.systemAvailableFeature_ = this.systemAvailableFeature_.getUnmodifiableView();
            }

            if ((mutable_bitField0_ & 1024) != 0) {
               this.nativePlatform_ = this.nativePlatform_.getUnmodifiableView();
            }

            if ((mutable_bitField0_ & 8192) != 0) {
               this.systemSupportedLocale_ = this.systemSupportedLocale_.getUnmodifiableView();
            }

            if ((mutable_bitField0_ & 16384) != 0) {
               this.glExtension_ = this.glExtension_.getUnmodifiableView();
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_DeviceConfigurationProto_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_DeviceConfigurationProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DeviceConfigurationProto.class, DeviceConfigurationProto.Builder.class);
   }

   public boolean hasTouchScreen() {
      return (this.bitField0_ & 1) != 0;
   }

   public int getTouchScreen() {
      return this.touchScreen_;
   }

   public boolean hasKeyboard() {
      return (this.bitField0_ & 2) != 0;
   }

   public int getKeyboard() {
      return this.keyboard_;
   }

   public boolean hasNavigation() {
      return (this.bitField0_ & 4) != 0;
   }

   public int getNavigation() {
      return this.navigation_;
   }

   public boolean hasScreenLayout() {
      return (this.bitField0_ & 8) != 0;
   }

   public int getScreenLayout() {
      return this.screenLayout_;
   }

   public boolean hasHasHardKeyboard() {
      return (this.bitField0_ & 16) != 0;
   }

   public boolean getHasHardKeyboard() {
      return this.hasHardKeyboard_;
   }

   public boolean hasHasFiveWayNavigation() {
      return (this.bitField0_ & 32) != 0;
   }

   public boolean getHasFiveWayNavigation() {
      return this.hasFiveWayNavigation_;
   }

   public boolean hasScreenDensity() {
      return (this.bitField0_ & 64) != 0;
   }

   public int getScreenDensity() {
      return this.screenDensity_;
   }

   public boolean hasGlEsVersion() {
      return (this.bitField0_ & 128) != 0;
   }

   public int getGlEsVersion() {
      return this.glEsVersion_;
   }

   public ProtocolStringList getSystemSharedLibraryList() {
      return this.systemSharedLibrary_;
   }

   public int getSystemSharedLibraryCount() {
      return this.systemSharedLibrary_.size();
   }

   public String getSystemSharedLibrary(int index) {
      return (String)this.systemSharedLibrary_.get(index);
   }

   public ByteString getSystemSharedLibraryBytes(int index) {
      return this.systemSharedLibrary_.getByteString(index);
   }

   public ProtocolStringList getSystemAvailableFeatureList() {
      return this.systemAvailableFeature_;
   }

   public int getSystemAvailableFeatureCount() {
      return this.systemAvailableFeature_.size();
   }

   public String getSystemAvailableFeature(int index) {
      return (String)this.systemAvailableFeature_.get(index);
   }

   public ByteString getSystemAvailableFeatureBytes(int index) {
      return this.systemAvailableFeature_.getByteString(index);
   }

   public ProtocolStringList getNativePlatformList() {
      return this.nativePlatform_;
   }

   public int getNativePlatformCount() {
      return this.nativePlatform_.size();
   }

   public String getNativePlatform(int index) {
      return (String)this.nativePlatform_.get(index);
   }

   public ByteString getNativePlatformBytes(int index) {
      return this.nativePlatform_.getByteString(index);
   }

   public boolean hasScreenWidth() {
      return (this.bitField0_ & 256) != 0;
   }

   public int getScreenWidth() {
      return this.screenWidth_;
   }

   public boolean hasScreenHeight() {
      return (this.bitField0_ & 512) != 0;
   }

   public int getScreenHeight() {
      return this.screenHeight_;
   }

   public ProtocolStringList getSystemSupportedLocaleList() {
      return this.systemSupportedLocale_;
   }

   public int getSystemSupportedLocaleCount() {
      return this.systemSupportedLocale_.size();
   }

   public String getSystemSupportedLocale(int index) {
      return (String)this.systemSupportedLocale_.get(index);
   }

   public ByteString getSystemSupportedLocaleBytes(int index) {
      return this.systemSupportedLocale_.getByteString(index);
   }

   public ProtocolStringList getGlExtensionList() {
      return this.glExtension_;
   }

   public int getGlExtensionCount() {
      return this.glExtension_.size();
   }

   public String getGlExtension(int index) {
      return (String)this.glExtension_.get(index);
   }

   public ByteString getGlExtensionBytes(int index) {
      return this.glExtension_.getByteString(index);
   }

   public boolean hasMaxApkDownloadSizeMb() {
      return (this.bitField0_ & 1024) != 0;
   }

   public int getMaxApkDownloadSizeMb() {
      return this.maxApkDownloadSizeMb_;
   }

   public boolean hasSmallestScreenWidthDp() {
      return (this.bitField0_ & 2048) != 0;
   }

   public int getSmallestScreenWidthDp() {
      return this.smallestScreenWidthDp_;
   }

   public boolean hasLowRamDevice() {
      return (this.bitField0_ & 4096) != 0;
   }

   public boolean getLowRamDevice() {
      return this.lowRamDevice_;
   }

   public boolean hasTotalMemoryBytes() {
      return (this.bitField0_ & 8192) != 0;
   }

   public long getTotalMemoryBytes() {
      return this.totalMemoryBytes_;
   }

   public boolean hasMaxNumOfCpuCores() {
      return (this.bitField0_ & 16384) != 0;
   }

   public int getMaxNumOfCpuCores() {
      return this.maxNumOfCpuCores_;
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
         output.writeInt32(1, this.touchScreen_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeInt32(2, this.keyboard_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeInt32(3, this.navigation_);
      }

      if ((this.bitField0_ & 8) != 0) {
         output.writeInt32(4, this.screenLayout_);
      }

      if ((this.bitField0_ & 16) != 0) {
         output.writeBool(5, this.hasHardKeyboard_);
      }

      if ((this.bitField0_ & 32) != 0) {
         output.writeBool(6, this.hasFiveWayNavigation_);
      }

      if ((this.bitField0_ & 64) != 0) {
         output.writeInt32(7, this.screenDensity_);
      }

      if ((this.bitField0_ & 128) != 0) {
         output.writeInt32(8, this.glEsVersion_);
      }

      int i;
      for(i = 0; i < this.systemSharedLibrary_.size(); ++i) {
         GeneratedMessageV3.writeString(output, 9, this.systemSharedLibrary_.getRaw(i));
      }

      for(i = 0; i < this.systemAvailableFeature_.size(); ++i) {
         GeneratedMessageV3.writeString(output, 10, this.systemAvailableFeature_.getRaw(i));
      }

      for(i = 0; i < this.nativePlatform_.size(); ++i) {
         GeneratedMessageV3.writeString(output, 11, this.nativePlatform_.getRaw(i));
      }

      if ((this.bitField0_ & 256) != 0) {
         output.writeInt32(12, this.screenWidth_);
      }

      if ((this.bitField0_ & 512) != 0) {
         output.writeInt32(13, this.screenHeight_);
      }

      for(i = 0; i < this.systemSupportedLocale_.size(); ++i) {
         GeneratedMessageV3.writeString(output, 14, this.systemSupportedLocale_.getRaw(i));
      }

      for(i = 0; i < this.glExtension_.size(); ++i) {
         GeneratedMessageV3.writeString(output, 15, this.glExtension_.getRaw(i));
      }

      if ((this.bitField0_ & 1024) != 0) {
         output.writeInt32(17, this.maxApkDownloadSizeMb_);
      }

      if ((this.bitField0_ & 2048) != 0) {
         output.writeInt32(18, this.smallestScreenWidthDp_);
      }

      if ((this.bitField0_ & 4096) != 0) {
         output.writeBool(19, this.lowRamDevice_);
      }

      if ((this.bitField0_ & 8192) != 0) {
         output.writeInt64(20, this.totalMemoryBytes_);
      }

      if ((this.bitField0_ & 16384) != 0) {
         output.writeInt32(21, this.maxNumOfCpuCores_);
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
            size += CodedOutputStream.computeInt32Size(1, this.touchScreen_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeInt32Size(2, this.keyboard_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeInt32Size(3, this.navigation_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += CodedOutputStream.computeInt32Size(4, this.screenLayout_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += CodedOutputStream.computeBoolSize(5, this.hasHardKeyboard_);
         }

         if ((this.bitField0_ & 32) != 0) {
            size += CodedOutputStream.computeBoolSize(6, this.hasFiveWayNavigation_);
         }

         if ((this.bitField0_ & 64) != 0) {
            size += CodedOutputStream.computeInt32Size(7, this.screenDensity_);
         }

         if ((this.bitField0_ & 128) != 0) {
            size += CodedOutputStream.computeInt32Size(8, this.glEsVersion_);
         }

         int dataSize = 0;

         int i;
         for(i = 0; i < this.systemSharedLibrary_.size(); ++i) {
            dataSize += computeStringSizeNoTag(this.systemSharedLibrary_.getRaw(i));
         }

         size += dataSize;
         size += 1 * this.getSystemSharedLibraryList().size();
         dataSize = 0;

         for(i = 0; i < this.systemAvailableFeature_.size(); ++i) {
            dataSize += computeStringSizeNoTag(this.systemAvailableFeature_.getRaw(i));
         }

         size += dataSize;
         size += 1 * this.getSystemAvailableFeatureList().size();
         dataSize = 0;

         for(i = 0; i < this.nativePlatform_.size(); ++i) {
            dataSize += computeStringSizeNoTag(this.nativePlatform_.getRaw(i));
         }

         size += dataSize;
         size += 1 * this.getNativePlatformList().size();
         if ((this.bitField0_ & 256) != 0) {
            size += CodedOutputStream.computeInt32Size(12, this.screenWidth_);
         }

         if ((this.bitField0_ & 512) != 0) {
            size += CodedOutputStream.computeInt32Size(13, this.screenHeight_);
         }

         dataSize = 0;

         for(i = 0; i < this.systemSupportedLocale_.size(); ++i) {
            dataSize += computeStringSizeNoTag(this.systemSupportedLocale_.getRaw(i));
         }

         size += dataSize;
         size += 1 * this.getSystemSupportedLocaleList().size();
         dataSize = 0;

         for(i = 0; i < this.glExtension_.size(); ++i) {
            dataSize += computeStringSizeNoTag(this.glExtension_.getRaw(i));
         }

         size += dataSize;
         size += 1 * this.getGlExtensionList().size();
         if ((this.bitField0_ & 1024) != 0) {
            size += CodedOutputStream.computeInt32Size(17, this.maxApkDownloadSizeMb_);
         }

         if ((this.bitField0_ & 2048) != 0) {
            size += CodedOutputStream.computeInt32Size(18, this.smallestScreenWidthDp_);
         }

         if ((this.bitField0_ & 4096) != 0) {
            size += CodedOutputStream.computeBoolSize(19, this.lowRamDevice_);
         }

         if ((this.bitField0_ & 8192) != 0) {
            size += CodedOutputStream.computeInt64Size(20, this.totalMemoryBytes_);
         }

         if ((this.bitField0_ & 16384) != 0) {
            size += CodedOutputStream.computeInt32Size(21, this.maxNumOfCpuCores_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof DeviceConfigurationProto)) {
         return super.equals(obj);
      } else {
         DeviceConfigurationProto other = (DeviceConfigurationProto)obj;
         if (this.hasTouchScreen() != other.hasTouchScreen()) {
            return false;
         } else if (this.hasTouchScreen() && this.getTouchScreen() != other.getTouchScreen()) {
            return false;
         } else if (this.hasKeyboard() != other.hasKeyboard()) {
            return false;
         } else if (this.hasKeyboard() && this.getKeyboard() != other.getKeyboard()) {
            return false;
         } else if (this.hasNavigation() != other.hasNavigation()) {
            return false;
         } else if (this.hasNavigation() && this.getNavigation() != other.getNavigation()) {
            return false;
         } else if (this.hasScreenLayout() != other.hasScreenLayout()) {
            return false;
         } else if (this.hasScreenLayout() && this.getScreenLayout() != other.getScreenLayout()) {
            return false;
         } else if (this.hasHasHardKeyboard() != other.hasHasHardKeyboard()) {
            return false;
         } else if (this.hasHasHardKeyboard() && this.getHasHardKeyboard() != other.getHasHardKeyboard()) {
            return false;
         } else if (this.hasHasFiveWayNavigation() != other.hasHasFiveWayNavigation()) {
            return false;
         } else if (this.hasHasFiveWayNavigation() && this.getHasFiveWayNavigation() != other.getHasFiveWayNavigation()) {
            return false;
         } else if (this.hasScreenDensity() != other.hasScreenDensity()) {
            return false;
         } else if (this.hasScreenDensity() && this.getScreenDensity() != other.getScreenDensity()) {
            return false;
         } else if (this.hasGlEsVersion() != other.hasGlEsVersion()) {
            return false;
         } else if (this.hasGlEsVersion() && this.getGlEsVersion() != other.getGlEsVersion()) {
            return false;
         } else if (!this.getSystemSharedLibraryList().equals(other.getSystemSharedLibraryList())) {
            return false;
         } else if (!this.getSystemAvailableFeatureList().equals(other.getSystemAvailableFeatureList())) {
            return false;
         } else if (!this.getNativePlatformList().equals(other.getNativePlatformList())) {
            return false;
         } else if (this.hasScreenWidth() != other.hasScreenWidth()) {
            return false;
         } else if (this.hasScreenWidth() && this.getScreenWidth() != other.getScreenWidth()) {
            return false;
         } else if (this.hasScreenHeight() != other.hasScreenHeight()) {
            return false;
         } else if (this.hasScreenHeight() && this.getScreenHeight() != other.getScreenHeight()) {
            return false;
         } else if (!this.getSystemSupportedLocaleList().equals(other.getSystemSupportedLocaleList())) {
            return false;
         } else if (!this.getGlExtensionList().equals(other.getGlExtensionList())) {
            return false;
         } else if (this.hasMaxApkDownloadSizeMb() != other.hasMaxApkDownloadSizeMb()) {
            return false;
         } else if (this.hasMaxApkDownloadSizeMb() && this.getMaxApkDownloadSizeMb() != other.getMaxApkDownloadSizeMb()) {
            return false;
         } else if (this.hasSmallestScreenWidthDp() != other.hasSmallestScreenWidthDp()) {
            return false;
         } else if (this.hasSmallestScreenWidthDp() && this.getSmallestScreenWidthDp() != other.getSmallestScreenWidthDp()) {
            return false;
         } else if (this.hasLowRamDevice() != other.hasLowRamDevice()) {
            return false;
         } else if (this.hasLowRamDevice() && this.getLowRamDevice() != other.getLowRamDevice()) {
            return false;
         } else if (this.hasTotalMemoryBytes() != other.hasTotalMemoryBytes()) {
            return false;
         } else if (this.hasTotalMemoryBytes() && this.getTotalMemoryBytes() != other.getTotalMemoryBytes()) {
            return false;
         } else if (this.hasMaxNumOfCpuCores() != other.hasMaxNumOfCpuCores()) {
            return false;
         } else if (this.hasMaxNumOfCpuCores() && this.getMaxNumOfCpuCores() != other.getMaxNumOfCpuCores()) {
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
         if (this.hasTouchScreen()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getTouchScreen();
         }

         if (this.hasKeyboard()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getKeyboard();
         }

         if (this.hasNavigation()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getNavigation();
         }

         if (this.hasScreenLayout()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getScreenLayout();
         }

         if (this.hasHasHardKeyboard()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + Internal.hashBoolean(this.getHasHardKeyboard());
         }

         if (this.hasHasFiveWayNavigation()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + Internal.hashBoolean(this.getHasFiveWayNavigation());
         }

         if (this.hasScreenDensity()) {
            hash = 37 * hash + 7;
            hash = 53 * hash + this.getScreenDensity();
         }

         if (this.hasGlEsVersion()) {
            hash = 37 * hash + 8;
            hash = 53 * hash + this.getGlEsVersion();
         }

         if (this.getSystemSharedLibraryCount() > 0) {
            hash = 37 * hash + 9;
            hash = 53 * hash + this.getSystemSharedLibraryList().hashCode();
         }

         if (this.getSystemAvailableFeatureCount() > 0) {
            hash = 37 * hash + 10;
            hash = 53 * hash + this.getSystemAvailableFeatureList().hashCode();
         }

         if (this.getNativePlatformCount() > 0) {
            hash = 37 * hash + 11;
            hash = 53 * hash + this.getNativePlatformList().hashCode();
         }

         if (this.hasScreenWidth()) {
            hash = 37 * hash + 12;
            hash = 53 * hash + this.getScreenWidth();
         }

         if (this.hasScreenHeight()) {
            hash = 37 * hash + 13;
            hash = 53 * hash + this.getScreenHeight();
         }

         if (this.getSystemSupportedLocaleCount() > 0) {
            hash = 37 * hash + 14;
            hash = 53 * hash + this.getSystemSupportedLocaleList().hashCode();
         }

         if (this.getGlExtensionCount() > 0) {
            hash = 37 * hash + 15;
            hash = 53 * hash + this.getGlExtensionList().hashCode();
         }

         if (this.hasMaxApkDownloadSizeMb()) {
            hash = 37 * hash + 17;
            hash = 53 * hash + this.getMaxApkDownloadSizeMb();
         }

         if (this.hasSmallestScreenWidthDp()) {
            hash = 37 * hash + 18;
            hash = 53 * hash + this.getSmallestScreenWidthDp();
         }

         if (this.hasLowRamDevice()) {
            hash = 37 * hash + 19;
            hash = 53 * hash + Internal.hashBoolean(this.getLowRamDevice());
         }

         if (this.hasTotalMemoryBytes()) {
            hash = 37 * hash + 20;
            hash = 53 * hash + Internal.hashLong(this.getTotalMemoryBytes());
         }

         if (this.hasMaxNumOfCpuCores()) {
            hash = 37 * hash + 21;
            hash = 53 * hash + this.getMaxNumOfCpuCores();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static DeviceConfigurationProto parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (DeviceConfigurationProto)PARSER.parseFrom(data);
   }

   public static DeviceConfigurationProto parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (DeviceConfigurationProto)PARSER.parseFrom(data, extensionRegistry);
   }

   public static DeviceConfigurationProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (DeviceConfigurationProto)PARSER.parseFrom(data);
   }

   public static DeviceConfigurationProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (DeviceConfigurationProto)PARSER.parseFrom(data, extensionRegistry);
   }

   public static DeviceConfigurationProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (DeviceConfigurationProto)PARSER.parseFrom(data);
   }

   public static DeviceConfigurationProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (DeviceConfigurationProto)PARSER.parseFrom(data, extensionRegistry);
   }

   public static DeviceConfigurationProto parseFrom(InputStream input) throws IOException {
      return (DeviceConfigurationProto)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static DeviceConfigurationProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (DeviceConfigurationProto)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static DeviceConfigurationProto parseDelimitedFrom(InputStream input) throws IOException {
      return (DeviceConfigurationProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static DeviceConfigurationProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (DeviceConfigurationProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static DeviceConfigurationProto parseFrom(CodedInputStream input) throws IOException {
      return (DeviceConfigurationProto)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static DeviceConfigurationProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (DeviceConfigurationProto)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public DeviceConfigurationProto.Builder newBuilderForType() {
      return newBuilder();
   }

   public static DeviceConfigurationProto.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DeviceConfigurationProto.Builder newBuilder(DeviceConfigurationProto prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public DeviceConfigurationProto.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new DeviceConfigurationProto.Builder() : (new DeviceConfigurationProto.Builder()).mergeFrom(this);
   }

   protected DeviceConfigurationProto.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      DeviceConfigurationProto.Builder builder = new DeviceConfigurationProto.Builder(parent);
      return builder;
   }

   public static DeviceConfigurationProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DeviceConfigurationProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DeviceConfigurationProto(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   DeviceConfigurationProto(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements DeviceConfigurationProtoOrBuilder {
      private int bitField0_;
      private int touchScreen_;
      private int keyboard_;
      private int navigation_;
      private int screenLayout_;
      private boolean hasHardKeyboard_;
      private boolean hasFiveWayNavigation_;
      private int screenDensity_;
      private int glEsVersion_;
      private LazyStringList systemSharedLibrary_;
      private LazyStringList systemAvailableFeature_;
      private LazyStringList nativePlatform_;
      private int screenWidth_;
      private int screenHeight_;
      private LazyStringList systemSupportedLocale_;
      private LazyStringList glExtension_;
      private int maxApkDownloadSizeMb_;
      private int smallestScreenWidthDp_;
      private boolean lowRamDevice_;
      private long totalMemoryBytes_;
      private int maxNumOfCpuCores_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_DeviceConfigurationProto_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_DeviceConfigurationProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DeviceConfigurationProto.class, DeviceConfigurationProto.Builder.class);
      }

      private Builder() {
         this.systemSharedLibrary_ = LazyStringArrayList.EMPTY;
         this.systemAvailableFeature_ = LazyStringArrayList.EMPTY;
         this.nativePlatform_ = LazyStringArrayList.EMPTY;
         this.systemSupportedLocale_ = LazyStringArrayList.EMPTY;
         this.glExtension_ = LazyStringArrayList.EMPTY;
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.systemSharedLibrary_ = LazyStringArrayList.EMPTY;
         this.systemAvailableFeature_ = LazyStringArrayList.EMPTY;
         this.nativePlatform_ = LazyStringArrayList.EMPTY;
         this.systemSupportedLocale_ = LazyStringArrayList.EMPTY;
         this.glExtension_ = LazyStringArrayList.EMPTY;
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (DeviceConfigurationProto.alwaysUseFieldBuilders) {
         }

      }

      public DeviceConfigurationProto.Builder clear() {
         super.clear();
         this.touchScreen_ = 0;
         this.bitField0_ &= -2;
         this.keyboard_ = 0;
         this.bitField0_ &= -3;
         this.navigation_ = 0;
         this.bitField0_ &= -5;
         this.screenLayout_ = 0;
         this.bitField0_ &= -9;
         this.hasHardKeyboard_ = false;
         this.bitField0_ &= -17;
         this.hasFiveWayNavigation_ = false;
         this.bitField0_ &= -33;
         this.screenDensity_ = 0;
         this.bitField0_ &= -65;
         this.glEsVersion_ = 0;
         this.bitField0_ &= -129;
         this.systemSharedLibrary_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -257;
         this.systemAvailableFeature_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -513;
         this.nativePlatform_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -1025;
         this.screenWidth_ = 0;
         this.bitField0_ &= -2049;
         this.screenHeight_ = 0;
         this.bitField0_ &= -4097;
         this.systemSupportedLocale_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -8193;
         this.glExtension_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -16385;
         this.maxApkDownloadSizeMb_ = 0;
         this.bitField0_ &= -32769;
         this.smallestScreenWidthDp_ = 0;
         this.bitField0_ &= -65537;
         this.lowRamDevice_ = false;
         this.bitField0_ &= -131073;
         this.totalMemoryBytes_ = 0L;
         this.bitField0_ &= -262145;
         this.maxNumOfCpuCores_ = 0;
         this.bitField0_ &= -524289;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_DeviceConfigurationProto_descriptor;
      }

      public DeviceConfigurationProto getDefaultInstanceForType() {
         return DeviceConfigurationProto.getDefaultInstance();
      }

      public DeviceConfigurationProto build() {
         DeviceConfigurationProto result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public DeviceConfigurationProto buildPartial() {
         DeviceConfigurationProto result = new DeviceConfigurationProto(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.touchScreen_ = this.touchScreen_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            result.keyboard_ = this.keyboard_;
            to_bitField0_ |= 2;
         }

         if ((from_bitField0_ & 4) != 0) {
            result.navigation_ = this.navigation_;
            to_bitField0_ |= 4;
         }

         if ((from_bitField0_ & 8) != 0) {
            result.screenLayout_ = this.screenLayout_;
            to_bitField0_ |= 8;
         }

         if ((from_bitField0_ & 16) != 0) {
            result.hasHardKeyboard_ = this.hasHardKeyboard_;
            to_bitField0_ |= 16;
         }

         if ((from_bitField0_ & 32) != 0) {
            result.hasFiveWayNavigation_ = this.hasFiveWayNavigation_;
            to_bitField0_ |= 32;
         }

         if ((from_bitField0_ & 64) != 0) {
            result.screenDensity_ = this.screenDensity_;
            to_bitField0_ |= 64;
         }

         if ((from_bitField0_ & 128) != 0) {
            result.glEsVersion_ = this.glEsVersion_;
            to_bitField0_ |= 128;
         }

         if ((this.bitField0_ & 256) != 0) {
            this.systemSharedLibrary_ = this.systemSharedLibrary_.getUnmodifiableView();
            this.bitField0_ &= -257;
         }

         result.systemSharedLibrary_ = this.systemSharedLibrary_;
         if ((this.bitField0_ & 512) != 0) {
            this.systemAvailableFeature_ = this.systemAvailableFeature_.getUnmodifiableView();
            this.bitField0_ &= -513;
         }

         result.systemAvailableFeature_ = this.systemAvailableFeature_;
         if ((this.bitField0_ & 1024) != 0) {
            this.nativePlatform_ = this.nativePlatform_.getUnmodifiableView();
            this.bitField0_ &= -1025;
         }

         result.nativePlatform_ = this.nativePlatform_;
         if ((from_bitField0_ & 2048) != 0) {
            result.screenWidth_ = this.screenWidth_;
            to_bitField0_ |= 256;
         }

         if ((from_bitField0_ & 4096) != 0) {
            result.screenHeight_ = this.screenHeight_;
            to_bitField0_ |= 512;
         }

         if ((this.bitField0_ & 8192) != 0) {
            this.systemSupportedLocale_ = this.systemSupportedLocale_.getUnmodifiableView();
            this.bitField0_ &= -8193;
         }

         result.systemSupportedLocale_ = this.systemSupportedLocale_;
         if ((this.bitField0_ & 16384) != 0) {
            this.glExtension_ = this.glExtension_.getUnmodifiableView();
            this.bitField0_ &= -16385;
         }

         result.glExtension_ = this.glExtension_;
         if ((from_bitField0_ & '耀') != 0) {
            result.maxApkDownloadSizeMb_ = this.maxApkDownloadSizeMb_;
            to_bitField0_ |= 1024;
         }

         if ((from_bitField0_ & 65536) != 0) {
            result.smallestScreenWidthDp_ = this.smallestScreenWidthDp_;
            to_bitField0_ |= 2048;
         }

         if ((from_bitField0_ & 131072) != 0) {
            result.lowRamDevice_ = this.lowRamDevice_;
            to_bitField0_ |= 4096;
         }

         if ((from_bitField0_ & 262144) != 0) {
            result.totalMemoryBytes_ = this.totalMemoryBytes_;
            to_bitField0_ |= 8192;
         }

         if ((from_bitField0_ & 524288) != 0) {
            result.maxNumOfCpuCores_ = this.maxNumOfCpuCores_;
            to_bitField0_ |= 16384;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public DeviceConfigurationProto.Builder clone() {
         return (DeviceConfigurationProto.Builder)super.clone();
      }

      public DeviceConfigurationProto.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (DeviceConfigurationProto.Builder)super.setField(field, value);
      }

      public DeviceConfigurationProto.Builder clearField(Descriptors.FieldDescriptor field) {
         return (DeviceConfigurationProto.Builder)super.clearField(field);
      }

      public DeviceConfigurationProto.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (DeviceConfigurationProto.Builder)super.clearOneof(oneof);
      }

      public DeviceConfigurationProto.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (DeviceConfigurationProto.Builder)super.setRepeatedField(field, index, value);
      }

      public DeviceConfigurationProto.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (DeviceConfigurationProto.Builder)super.addRepeatedField(field, value);
      }

      public DeviceConfigurationProto.Builder mergeFrom(Message other) {
         if (other instanceof DeviceConfigurationProto) {
            return this.mergeFrom((DeviceConfigurationProto)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public DeviceConfigurationProto.Builder mergeFrom(DeviceConfigurationProto other) {
         if (other == DeviceConfigurationProto.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasTouchScreen()) {
               this.setTouchScreen(other.getTouchScreen());
            }

            if (other.hasKeyboard()) {
               this.setKeyboard(other.getKeyboard());
            }

            if (other.hasNavigation()) {
               this.setNavigation(other.getNavigation());
            }

            if (other.hasScreenLayout()) {
               this.setScreenLayout(other.getScreenLayout());
            }

            if (other.hasHasHardKeyboard()) {
               this.setHasHardKeyboard(other.getHasHardKeyboard());
            }

            if (other.hasHasFiveWayNavigation()) {
               this.setHasFiveWayNavigation(other.getHasFiveWayNavigation());
            }

            if (other.hasScreenDensity()) {
               this.setScreenDensity(other.getScreenDensity());
            }

            if (other.hasGlEsVersion()) {
               this.setGlEsVersion(other.getGlEsVersion());
            }

            if (!other.systemSharedLibrary_.isEmpty()) {
               if (this.systemSharedLibrary_.isEmpty()) {
                  this.systemSharedLibrary_ = other.systemSharedLibrary_;
                  this.bitField0_ &= -257;
               } else {
                  this.ensureSystemSharedLibraryIsMutable();
                  this.systemSharedLibrary_.addAll(other.systemSharedLibrary_);
               }

               this.onChanged();
            }

            if (!other.systemAvailableFeature_.isEmpty()) {
               if (this.systemAvailableFeature_.isEmpty()) {
                  this.systemAvailableFeature_ = other.systemAvailableFeature_;
                  this.bitField0_ &= -513;
               } else {
                  this.ensureSystemAvailableFeatureIsMutable();
                  this.systemAvailableFeature_.addAll(other.systemAvailableFeature_);
               }

               this.onChanged();
            }

            if (!other.nativePlatform_.isEmpty()) {
               if (this.nativePlatform_.isEmpty()) {
                  this.nativePlatform_ = other.nativePlatform_;
                  this.bitField0_ &= -1025;
               } else {
                  this.ensureNativePlatformIsMutable();
                  this.nativePlatform_.addAll(other.nativePlatform_);
               }

               this.onChanged();
            }

            if (other.hasScreenWidth()) {
               this.setScreenWidth(other.getScreenWidth());
            }

            if (other.hasScreenHeight()) {
               this.setScreenHeight(other.getScreenHeight());
            }

            if (!other.systemSupportedLocale_.isEmpty()) {
               if (this.systemSupportedLocale_.isEmpty()) {
                  this.systemSupportedLocale_ = other.systemSupportedLocale_;
                  this.bitField0_ &= -8193;
               } else {
                  this.ensureSystemSupportedLocaleIsMutable();
                  this.systemSupportedLocale_.addAll(other.systemSupportedLocale_);
               }

               this.onChanged();
            }

            if (!other.glExtension_.isEmpty()) {
               if (this.glExtension_.isEmpty()) {
                  this.glExtension_ = other.glExtension_;
                  this.bitField0_ &= -16385;
               } else {
                  this.ensureGlExtensionIsMutable();
                  this.glExtension_.addAll(other.glExtension_);
               }

               this.onChanged();
            }

            if (other.hasMaxApkDownloadSizeMb()) {
               this.setMaxApkDownloadSizeMb(other.getMaxApkDownloadSizeMb());
            }

            if (other.hasSmallestScreenWidthDp()) {
               this.setSmallestScreenWidthDp(other.getSmallestScreenWidthDp());
            }

            if (other.hasLowRamDevice()) {
               this.setLowRamDevice(other.getLowRamDevice());
            }

            if (other.hasTotalMemoryBytes()) {
               this.setTotalMemoryBytes(other.getTotalMemoryBytes());
            }

            if (other.hasMaxNumOfCpuCores()) {
               this.setMaxNumOfCpuCores(other.getMaxNumOfCpuCores());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public DeviceConfigurationProto.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         DeviceConfigurationProto parsedMessage = null;

         try {
            parsedMessage = (DeviceConfigurationProto)DeviceConfigurationProto.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (DeviceConfigurationProto)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasTouchScreen() {
         return (this.bitField0_ & 1) != 0;
      }

      public int getTouchScreen() {
         return this.touchScreen_;
      }

      public DeviceConfigurationProto.Builder setTouchScreen(int value) {
         this.bitField0_ |= 1;
         this.touchScreen_ = value;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearTouchScreen() {
         this.bitField0_ &= -2;
         this.touchScreen_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasKeyboard() {
         return (this.bitField0_ & 2) != 0;
      }

      public int getKeyboard() {
         return this.keyboard_;
      }

      public DeviceConfigurationProto.Builder setKeyboard(int value) {
         this.bitField0_ |= 2;
         this.keyboard_ = value;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearKeyboard() {
         this.bitField0_ &= -3;
         this.keyboard_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasNavigation() {
         return (this.bitField0_ & 4) != 0;
      }

      public int getNavigation() {
         return this.navigation_;
      }

      public DeviceConfigurationProto.Builder setNavigation(int value) {
         this.bitField0_ |= 4;
         this.navigation_ = value;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearNavigation() {
         this.bitField0_ &= -5;
         this.navigation_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasScreenLayout() {
         return (this.bitField0_ & 8) != 0;
      }

      public int getScreenLayout() {
         return this.screenLayout_;
      }

      public DeviceConfigurationProto.Builder setScreenLayout(int value) {
         this.bitField0_ |= 8;
         this.screenLayout_ = value;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearScreenLayout() {
         this.bitField0_ &= -9;
         this.screenLayout_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasHasHardKeyboard() {
         return (this.bitField0_ & 16) != 0;
      }

      public boolean getHasHardKeyboard() {
         return this.hasHardKeyboard_;
      }

      public DeviceConfigurationProto.Builder setHasHardKeyboard(boolean value) {
         this.bitField0_ |= 16;
         this.hasHardKeyboard_ = value;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearHasHardKeyboard() {
         this.bitField0_ &= -17;
         this.hasHardKeyboard_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasHasFiveWayNavigation() {
         return (this.bitField0_ & 32) != 0;
      }

      public boolean getHasFiveWayNavigation() {
         return this.hasFiveWayNavigation_;
      }

      public DeviceConfigurationProto.Builder setHasFiveWayNavigation(boolean value) {
         this.bitField0_ |= 32;
         this.hasFiveWayNavigation_ = value;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearHasFiveWayNavigation() {
         this.bitField0_ &= -33;
         this.hasFiveWayNavigation_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasScreenDensity() {
         return (this.bitField0_ & 64) != 0;
      }

      public int getScreenDensity() {
         return this.screenDensity_;
      }

      public DeviceConfigurationProto.Builder setScreenDensity(int value) {
         this.bitField0_ |= 64;
         this.screenDensity_ = value;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearScreenDensity() {
         this.bitField0_ &= -65;
         this.screenDensity_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasGlEsVersion() {
         return (this.bitField0_ & 128) != 0;
      }

      public int getGlEsVersion() {
         return this.glEsVersion_;
      }

      public DeviceConfigurationProto.Builder setGlEsVersion(int value) {
         this.bitField0_ |= 128;
         this.glEsVersion_ = value;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearGlEsVersion() {
         this.bitField0_ &= -129;
         this.glEsVersion_ = 0;
         this.onChanged();
         return this;
      }

      private void ensureSystemSharedLibraryIsMutable() {
         if ((this.bitField0_ & 256) == 0) {
            this.systemSharedLibrary_ = new LazyStringArrayList(this.systemSharedLibrary_);
            this.bitField0_ |= 256;
         }

      }

      public ProtocolStringList getSystemSharedLibraryList() {
         return this.systemSharedLibrary_.getUnmodifiableView();
      }

      public int getSystemSharedLibraryCount() {
         return this.systemSharedLibrary_.size();
      }

      public String getSystemSharedLibrary(int index) {
         return (String)this.systemSharedLibrary_.get(index);
      }

      public ByteString getSystemSharedLibraryBytes(int index) {
         return this.systemSharedLibrary_.getByteString(index);
      }

      public DeviceConfigurationProto.Builder setSystemSharedLibrary(int index, String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureSystemSharedLibraryIsMutable();
            this.systemSharedLibrary_.set(index, (Object)value);
            this.onChanged();
            return this;
         }
      }

      public DeviceConfigurationProto.Builder addSystemSharedLibrary(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureSystemSharedLibraryIsMutable();
            this.systemSharedLibrary_.add((Object)value);
            this.onChanged();
            return this;
         }
      }

      public DeviceConfigurationProto.Builder addAllSystemSharedLibrary(Iterable values) {
         this.ensureSystemSharedLibraryIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.systemSharedLibrary_);
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearSystemSharedLibrary() {
         this.systemSharedLibrary_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -257;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder addSystemSharedLibraryBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureSystemSharedLibraryIsMutable();
            this.systemSharedLibrary_.add(value);
            this.onChanged();
            return this;
         }
      }

      private void ensureSystemAvailableFeatureIsMutable() {
         if ((this.bitField0_ & 512) == 0) {
            this.systemAvailableFeature_ = new LazyStringArrayList(this.systemAvailableFeature_);
            this.bitField0_ |= 512;
         }

      }

      public ProtocolStringList getSystemAvailableFeatureList() {
         return this.systemAvailableFeature_.getUnmodifiableView();
      }

      public int getSystemAvailableFeatureCount() {
         return this.systemAvailableFeature_.size();
      }

      public String getSystemAvailableFeature(int index) {
         return (String)this.systemAvailableFeature_.get(index);
      }

      public ByteString getSystemAvailableFeatureBytes(int index) {
         return this.systemAvailableFeature_.getByteString(index);
      }

      public DeviceConfigurationProto.Builder setSystemAvailableFeature(int index, String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureSystemAvailableFeatureIsMutable();
            this.systemAvailableFeature_.set(index, (Object)value);
            this.onChanged();
            return this;
         }
      }

      public DeviceConfigurationProto.Builder addSystemAvailableFeature(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureSystemAvailableFeatureIsMutable();
            this.systemAvailableFeature_.add((Object)value);
            this.onChanged();
            return this;
         }
      }

      public DeviceConfigurationProto.Builder addAllSystemAvailableFeature(Iterable values) {
         this.ensureSystemAvailableFeatureIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.systemAvailableFeature_);
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearSystemAvailableFeature() {
         this.systemAvailableFeature_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -513;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder addSystemAvailableFeatureBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureSystemAvailableFeatureIsMutable();
            this.systemAvailableFeature_.add(value);
            this.onChanged();
            return this;
         }
      }

      private void ensureNativePlatformIsMutable() {
         if ((this.bitField0_ & 1024) == 0) {
            this.nativePlatform_ = new LazyStringArrayList(this.nativePlatform_);
            this.bitField0_ |= 1024;
         }

      }

      public ProtocolStringList getNativePlatformList() {
         return this.nativePlatform_.getUnmodifiableView();
      }

      public int getNativePlatformCount() {
         return this.nativePlatform_.size();
      }

      public String getNativePlatform(int index) {
         return (String)this.nativePlatform_.get(index);
      }

      public ByteString getNativePlatformBytes(int index) {
         return this.nativePlatform_.getByteString(index);
      }

      public DeviceConfigurationProto.Builder setNativePlatform(int index, String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureNativePlatformIsMutable();
            this.nativePlatform_.set(index, (Object)value);
            this.onChanged();
            return this;
         }
      }

      public DeviceConfigurationProto.Builder addNativePlatform(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureNativePlatformIsMutable();
            this.nativePlatform_.add((Object)value);
            this.onChanged();
            return this;
         }
      }

      public DeviceConfigurationProto.Builder addAllNativePlatform(Iterable values) {
         this.ensureNativePlatformIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.nativePlatform_);
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearNativePlatform() {
         this.nativePlatform_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -1025;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder addNativePlatformBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureNativePlatformIsMutable();
            this.nativePlatform_.add(value);
            this.onChanged();
            return this;
         }
      }

      public boolean hasScreenWidth() {
         return (this.bitField0_ & 2048) != 0;
      }

      public int getScreenWidth() {
         return this.screenWidth_;
      }

      public DeviceConfigurationProto.Builder setScreenWidth(int value) {
         this.bitField0_ |= 2048;
         this.screenWidth_ = value;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearScreenWidth() {
         this.bitField0_ &= -2049;
         this.screenWidth_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasScreenHeight() {
         return (this.bitField0_ & 4096) != 0;
      }

      public int getScreenHeight() {
         return this.screenHeight_;
      }

      public DeviceConfigurationProto.Builder setScreenHeight(int value) {
         this.bitField0_ |= 4096;
         this.screenHeight_ = value;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearScreenHeight() {
         this.bitField0_ &= -4097;
         this.screenHeight_ = 0;
         this.onChanged();
         return this;
      }

      private void ensureSystemSupportedLocaleIsMutable() {
         if ((this.bitField0_ & 8192) == 0) {
            this.systemSupportedLocale_ = new LazyStringArrayList(this.systemSupportedLocale_);
            this.bitField0_ |= 8192;
         }

      }

      public ProtocolStringList getSystemSupportedLocaleList() {
         return this.systemSupportedLocale_.getUnmodifiableView();
      }

      public int getSystemSupportedLocaleCount() {
         return this.systemSupportedLocale_.size();
      }

      public String getSystemSupportedLocale(int index) {
         return (String)this.systemSupportedLocale_.get(index);
      }

      public ByteString getSystemSupportedLocaleBytes(int index) {
         return this.systemSupportedLocale_.getByteString(index);
      }

      public DeviceConfigurationProto.Builder setSystemSupportedLocale(int index, String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureSystemSupportedLocaleIsMutable();
            this.systemSupportedLocale_.set(index, (Object)value);
            this.onChanged();
            return this;
         }
      }

      public DeviceConfigurationProto.Builder addSystemSupportedLocale(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureSystemSupportedLocaleIsMutable();
            this.systemSupportedLocale_.add((Object)value);
            this.onChanged();
            return this;
         }
      }

      public DeviceConfigurationProto.Builder addAllSystemSupportedLocale(Iterable values) {
         this.ensureSystemSupportedLocaleIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.systemSupportedLocale_);
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearSystemSupportedLocale() {
         this.systemSupportedLocale_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -8193;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder addSystemSupportedLocaleBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureSystemSupportedLocaleIsMutable();
            this.systemSupportedLocale_.add(value);
            this.onChanged();
            return this;
         }
      }

      private void ensureGlExtensionIsMutable() {
         if ((this.bitField0_ & 16384) == 0) {
            this.glExtension_ = new LazyStringArrayList(this.glExtension_);
            this.bitField0_ |= 16384;
         }

      }

      public ProtocolStringList getGlExtensionList() {
         return this.glExtension_.getUnmodifiableView();
      }

      public int getGlExtensionCount() {
         return this.glExtension_.size();
      }

      public String getGlExtension(int index) {
         return (String)this.glExtension_.get(index);
      }

      public ByteString getGlExtensionBytes(int index) {
         return this.glExtension_.getByteString(index);
      }

      public DeviceConfigurationProto.Builder setGlExtension(int index, String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureGlExtensionIsMutable();
            this.glExtension_.set(index, (Object)value);
            this.onChanged();
            return this;
         }
      }

      public DeviceConfigurationProto.Builder addGlExtension(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureGlExtensionIsMutable();
            this.glExtension_.add((Object)value);
            this.onChanged();
            return this;
         }
      }

      public DeviceConfigurationProto.Builder addAllGlExtension(Iterable values) {
         this.ensureGlExtensionIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.glExtension_);
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearGlExtension() {
         this.glExtension_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -16385;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder addGlExtensionBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureGlExtensionIsMutable();
            this.glExtension_.add(value);
            this.onChanged();
            return this;
         }
      }

      public boolean hasMaxApkDownloadSizeMb() {
         return (this.bitField0_ & '耀') != 0;
      }

      public int getMaxApkDownloadSizeMb() {
         return this.maxApkDownloadSizeMb_;
      }

      public DeviceConfigurationProto.Builder setMaxApkDownloadSizeMb(int value) {
         this.bitField0_ |= 32768;
         this.maxApkDownloadSizeMb_ = value;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearMaxApkDownloadSizeMb() {
         this.bitField0_ &= -32769;
         this.maxApkDownloadSizeMb_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasSmallestScreenWidthDp() {
         return (this.bitField0_ & 65536) != 0;
      }

      public int getSmallestScreenWidthDp() {
         return this.smallestScreenWidthDp_;
      }

      public DeviceConfigurationProto.Builder setSmallestScreenWidthDp(int value) {
         this.bitField0_ |= 65536;
         this.smallestScreenWidthDp_ = value;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearSmallestScreenWidthDp() {
         this.bitField0_ &= -65537;
         this.smallestScreenWidthDp_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasLowRamDevice() {
         return (this.bitField0_ & 131072) != 0;
      }

      public boolean getLowRamDevice() {
         return this.lowRamDevice_;
      }

      public DeviceConfigurationProto.Builder setLowRamDevice(boolean value) {
         this.bitField0_ |= 131072;
         this.lowRamDevice_ = value;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearLowRamDevice() {
         this.bitField0_ &= -131073;
         this.lowRamDevice_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasTotalMemoryBytes() {
         return (this.bitField0_ & 262144) != 0;
      }

      public long getTotalMemoryBytes() {
         return this.totalMemoryBytes_;
      }

      public DeviceConfigurationProto.Builder setTotalMemoryBytes(long value) {
         this.bitField0_ |= 262144;
         this.totalMemoryBytes_ = value;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearTotalMemoryBytes() {
         this.bitField0_ &= -262145;
         this.totalMemoryBytes_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasMaxNumOfCpuCores() {
         return (this.bitField0_ & 524288) != 0;
      }

      public int getMaxNumOfCpuCores() {
         return this.maxNumOfCpuCores_;
      }

      public DeviceConfigurationProto.Builder setMaxNumOfCpuCores(int value) {
         this.bitField0_ |= 524288;
         this.maxNumOfCpuCores_ = value;
         this.onChanged();
         return this;
      }

      public DeviceConfigurationProto.Builder clearMaxNumOfCpuCores() {
         this.bitField0_ &= -524289;
         this.maxNumOfCpuCores_ = 0;
         this.onChanged();
         return this;
      }

      public final DeviceConfigurationProto.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (DeviceConfigurationProto.Builder)super.setUnknownFields(unknownFields);
      }

      public final DeviceConfigurationProto.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (DeviceConfigurationProto.Builder)super.mergeUnknownFields(unknownFields);
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
