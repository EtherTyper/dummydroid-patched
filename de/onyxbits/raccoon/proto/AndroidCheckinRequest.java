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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class AndroidCheckinRequest extends GeneratedMessageV3 implements AndroidCheckinRequestOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int ID_FIELD_NUMBER = 2;
   private long id_;
   public static final int DIGEST_FIELD_NUMBER = 3;
   private volatile Object digest_;
   public static final int CHECKIN_FIELD_NUMBER = 4;
   private AndroidCheckinProto checkin_;
   public static final int DESIREDBUILD_FIELD_NUMBER = 5;
   private volatile Object desiredBuild_;
   public static final int LOCALE_FIELD_NUMBER = 6;
   private volatile Object locale_;
   public static final int MARKETCHECKIN_FIELD_NUMBER = 8;
   private volatile Object marketCheckin_;
   public static final int MACADDR_FIELD_NUMBER = 9;
   private LazyStringList macAddr_;
   public static final int MEID_FIELD_NUMBER = 10;
   private volatile Object meid_;
   public static final int ACCOUNTCOOKIE_FIELD_NUMBER = 11;
   private LazyStringList accountCookie_;
   public static final int TIMEZONE_FIELD_NUMBER = 12;
   private volatile Object timeZone_;
   public static final int SECURITYTOKEN_FIELD_NUMBER = 13;
   private long securityToken_;
   public static final int VERSION_FIELD_NUMBER = 14;
   private int version_;
   public static final int OTACERT_FIELD_NUMBER = 15;
   private LazyStringList otaCert_;
   public static final int SERIALNUMBER_FIELD_NUMBER = 16;
   private volatile Object serialNumber_;
   public static final int ESN_FIELD_NUMBER = 17;
   private volatile Object esn_;
   public static final int DEVICECONFIGURATION_FIELD_NUMBER = 18;
   private DeviceConfigurationProto deviceConfiguration_;
   public static final int MACADDRTYPE_FIELD_NUMBER = 19;
   private LazyStringList macAddrType_;
   public static final int FRAGMENT_FIELD_NUMBER = 20;
   private int fragment_;
   public static final int USERNAME_FIELD_NUMBER = 21;
   private volatile Object userName_;
   public static final int USERSERIALNUMBER_FIELD_NUMBER = 22;
   private int userSerialNumber_;
   private byte memoizedIsInitialized;
   private static final AndroidCheckinRequest DEFAULT_INSTANCE = new AndroidCheckinRequest();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public AndroidCheckinRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new AndroidCheckinRequest(input, extensionRegistry);
      }
   };

   private AndroidCheckinRequest(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private AndroidCheckinRequest() {
      this.memoizedIsInitialized = -1;
      this.digest_ = "";
      this.desiredBuild_ = "";
      this.locale_ = "";
      this.marketCheckin_ = "";
      this.macAddr_ = LazyStringArrayList.EMPTY;
      this.meid_ = "";
      this.accountCookie_ = LazyStringArrayList.EMPTY;
      this.timeZone_ = "";
      this.otaCert_ = LazyStringArrayList.EMPTY;
      this.serialNumber_ = "";
      this.esn_ = "";
      this.macAddrType_ = LazyStringArrayList.EMPTY;
      this.userName_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new AndroidCheckinRequest();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private AndroidCheckinRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 16:
                  this.bitField0_ |= 1;
                  this.id_ = input.readInt64();
                  break;
               case 26:
                  bs = input.readBytes();
                  this.bitField0_ |= 2;
                  this.digest_ = bs;
                  break;
               case 34:
                  AndroidCheckinProto.Builder subBuilder = null;
                  if ((this.bitField0_ & 4) != 0) {
                     subBuilder = this.checkin_.toBuilder();
                  }

                  this.checkin_ = (AndroidCheckinProto)input.readMessage(AndroidCheckinProto.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.checkin_);
                     this.checkin_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 4;
                  break;
               case 42:
                  bs = input.readBytes();
                  this.bitField0_ |= 8;
                  this.desiredBuild_ = bs;
                  break;
               case 50:
                  bs = input.readBytes();
                  this.bitField0_ |= 16;
                  this.locale_ = bs;
                  break;
               case 66:
                  bs = input.readBytes();
                  this.bitField0_ |= 32;
                  this.marketCheckin_ = bs;
                  break;
               case 74:
                  bs = input.readBytes();
                  if ((mutable_bitField0_ & 64) == 0) {
                     this.macAddr_ = new LazyStringArrayList();
                     mutable_bitField0_ |= 64;
                  }

                  this.macAddr_.add(bs);
                  break;
               case 82:
                  bs = input.readBytes();
                  this.bitField0_ |= 64;
                  this.meid_ = bs;
                  break;
               case 90:
                  bs = input.readBytes();
                  if ((mutable_bitField0_ & 256) == 0) {
                     this.accountCookie_ = new LazyStringArrayList();
                     mutable_bitField0_ |= 256;
                  }

                  this.accountCookie_.add(bs);
                  break;
               case 98:
                  bs = input.readBytes();
                  this.bitField0_ |= 128;
                  this.timeZone_ = bs;
                  break;
               case 105:
                  this.bitField0_ |= 256;
                  this.securityToken_ = input.readFixed64();
                  break;
               case 112:
                  this.bitField0_ |= 512;
                  this.version_ = input.readInt32();
                  break;
               case 122:
                  bs = input.readBytes();
                  if ((mutable_bitField0_ & 4096) == 0) {
                     this.otaCert_ = new LazyStringArrayList();
                     mutable_bitField0_ |= 4096;
                  }

                  this.otaCert_.add(bs);
                  break;
               case 130:
                  bs = input.readBytes();
                  this.bitField0_ |= 1024;
                  this.serialNumber_ = bs;
                  break;
               case 138:
                  bs = input.readBytes();
                  this.bitField0_ |= 2048;
                  this.esn_ = bs;
                  break;
               case 146:
                  DeviceConfigurationProto.Builder subBuilder = null;
                  if ((this.bitField0_ & 4096) != 0) {
                     subBuilder = this.deviceConfiguration_.toBuilder();
                  }

                  this.deviceConfiguration_ = (DeviceConfigurationProto)input.readMessage(DeviceConfigurationProto.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.deviceConfiguration_);
                     this.deviceConfiguration_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 4096;
                  break;
               case 154:
                  bs = input.readBytes();
                  if ((mutable_bitField0_ & 65536) == 0) {
                     this.macAddrType_ = new LazyStringArrayList();
                     mutable_bitField0_ |= 65536;
                  }

                  this.macAddrType_.add(bs);
                  break;
               case 160:
                  this.bitField0_ |= 8192;
                  this.fragment_ = input.readInt32();
                  break;
               case 170:
                  bs = input.readBytes();
                  this.bitField0_ |= 16384;
                  this.userName_ = bs;
                  break;
               case 176:
                  this.bitField0_ |= 32768;
                  this.userSerialNumber_ = input.readInt32();
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
            if ((mutable_bitField0_ & 64) != 0) {
               this.macAddr_ = this.macAddr_.getUnmodifiableView();
            }

            if ((mutable_bitField0_ & 256) != 0) {
               this.accountCookie_ = this.accountCookie_.getUnmodifiableView();
            }

            if ((mutable_bitField0_ & 4096) != 0) {
               this.otaCert_ = this.otaCert_.getUnmodifiableView();
            }

            if ((mutable_bitField0_ & 65536) != 0) {
               this.macAddrType_ = this.macAddrType_.getUnmodifiableView();
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_AndroidCheckinRequest_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_AndroidCheckinRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AndroidCheckinRequest.class, AndroidCheckinRequest.Builder.class);
   }

   public boolean hasId() {
      return (this.bitField0_ & 1) != 0;
   }

   public long getId() {
      return this.id_;
   }

   public boolean hasDigest() {
      return (this.bitField0_ & 2) != 0;
   }

   public String getDigest() {
      Object ref = this.digest_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.digest_ = s;
         }

         return s;
      }
   }

   public ByteString getDigestBytes() {
      Object ref = this.digest_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.digest_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasCheckin() {
      return (this.bitField0_ & 4) != 0;
   }

   public AndroidCheckinProto getCheckin() {
      return this.checkin_ == null ? AndroidCheckinProto.getDefaultInstance() : this.checkin_;
   }

   public AndroidCheckinProtoOrBuilder getCheckinOrBuilder() {
      return this.checkin_ == null ? AndroidCheckinProto.getDefaultInstance() : this.checkin_;
   }

   public boolean hasDesiredBuild() {
      return (this.bitField0_ & 8) != 0;
   }

   public String getDesiredBuild() {
      Object ref = this.desiredBuild_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.desiredBuild_ = s;
         }

         return s;
      }
   }

   public ByteString getDesiredBuildBytes() {
      Object ref = this.desiredBuild_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.desiredBuild_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasLocale() {
      return (this.bitField0_ & 16) != 0;
   }

   public String getLocale() {
      Object ref = this.locale_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.locale_ = s;
         }

         return s;
      }
   }

   public ByteString getLocaleBytes() {
      Object ref = this.locale_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.locale_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasMarketCheckin() {
      return (this.bitField0_ & 32) != 0;
   }

   public String getMarketCheckin() {
      Object ref = this.marketCheckin_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.marketCheckin_ = s;
         }

         return s;
      }
   }

   public ByteString getMarketCheckinBytes() {
      Object ref = this.marketCheckin_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.marketCheckin_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public ProtocolStringList getMacAddrList() {
      return this.macAddr_;
   }

   public int getMacAddrCount() {
      return this.macAddr_.size();
   }

   public String getMacAddr(int index) {
      return (String)this.macAddr_.get(index);
   }

   public ByteString getMacAddrBytes(int index) {
      return this.macAddr_.getByteString(index);
   }

   public boolean hasMeid() {
      return (this.bitField0_ & 64) != 0;
   }

   public String getMeid() {
      Object ref = this.meid_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.meid_ = s;
         }

         return s;
      }
   }

   public ByteString getMeidBytes() {
      Object ref = this.meid_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.meid_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public ProtocolStringList getAccountCookieList() {
      return this.accountCookie_;
   }

   public int getAccountCookieCount() {
      return this.accountCookie_.size();
   }

   public String getAccountCookie(int index) {
      return (String)this.accountCookie_.get(index);
   }

   public ByteString getAccountCookieBytes(int index) {
      return this.accountCookie_.getByteString(index);
   }

   public boolean hasTimeZone() {
      return (this.bitField0_ & 128) != 0;
   }

   public String getTimeZone() {
      Object ref = this.timeZone_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.timeZone_ = s;
         }

         return s;
      }
   }

   public ByteString getTimeZoneBytes() {
      Object ref = this.timeZone_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.timeZone_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasSecurityToken() {
      return (this.bitField0_ & 256) != 0;
   }

   public long getSecurityToken() {
      return this.securityToken_;
   }

   public boolean hasVersion() {
      return (this.bitField0_ & 512) != 0;
   }

   public int getVersion() {
      return this.version_;
   }

   public ProtocolStringList getOtaCertList() {
      return this.otaCert_;
   }

   public int getOtaCertCount() {
      return this.otaCert_.size();
   }

   public String getOtaCert(int index) {
      return (String)this.otaCert_.get(index);
   }

   public ByteString getOtaCertBytes(int index) {
      return this.otaCert_.getByteString(index);
   }

   public boolean hasSerialNumber() {
      return (this.bitField0_ & 1024) != 0;
   }

   public String getSerialNumber() {
      Object ref = this.serialNumber_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.serialNumber_ = s;
         }

         return s;
      }
   }

   public ByteString getSerialNumberBytes() {
      Object ref = this.serialNumber_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.serialNumber_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasEsn() {
      return (this.bitField0_ & 2048) != 0;
   }

   public String getEsn() {
      Object ref = this.esn_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.esn_ = s;
         }

         return s;
      }
   }

   public ByteString getEsnBytes() {
      Object ref = this.esn_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.esn_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasDeviceConfiguration() {
      return (this.bitField0_ & 4096) != 0;
   }

   public DeviceConfigurationProto getDeviceConfiguration() {
      return this.deviceConfiguration_ == null ? DeviceConfigurationProto.getDefaultInstance() : this.deviceConfiguration_;
   }

   public DeviceConfigurationProtoOrBuilder getDeviceConfigurationOrBuilder() {
      return this.deviceConfiguration_ == null ? DeviceConfigurationProto.getDefaultInstance() : this.deviceConfiguration_;
   }

   public ProtocolStringList getMacAddrTypeList() {
      return this.macAddrType_;
   }

   public int getMacAddrTypeCount() {
      return this.macAddrType_.size();
   }

   public String getMacAddrType(int index) {
      return (String)this.macAddrType_.get(index);
   }

   public ByteString getMacAddrTypeBytes(int index) {
      return this.macAddrType_.getByteString(index);
   }

   public boolean hasFragment() {
      return (this.bitField0_ & 8192) != 0;
   }

   public int getFragment() {
      return this.fragment_;
   }

   public boolean hasUserName() {
      return (this.bitField0_ & 16384) != 0;
   }

   public String getUserName() {
      Object ref = this.userName_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.userName_ = s;
         }

         return s;
      }
   }

   public ByteString getUserNameBytes() {
      Object ref = this.userName_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.userName_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasUserSerialNumber() {
      return (this.bitField0_ & '耀') != 0;
   }

   public int getUserSerialNumber() {
      return this.userSerialNumber_;
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
         output.writeInt64(2, this.id_);
      }

      if ((this.bitField0_ & 2) != 0) {
         GeneratedMessageV3.writeString(output, 3, this.digest_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeMessage(4, this.getCheckin());
      }

      if ((this.bitField0_ & 8) != 0) {
         GeneratedMessageV3.writeString(output, 5, this.desiredBuild_);
      }

      if ((this.bitField0_ & 16) != 0) {
         GeneratedMessageV3.writeString(output, 6, this.locale_);
      }

      if ((this.bitField0_ & 32) != 0) {
         GeneratedMessageV3.writeString(output, 8, this.marketCheckin_);
      }

      int i;
      for(i = 0; i < this.macAddr_.size(); ++i) {
         GeneratedMessageV3.writeString(output, 9, this.macAddr_.getRaw(i));
      }

      if ((this.bitField0_ & 64) != 0) {
         GeneratedMessageV3.writeString(output, 10, this.meid_);
      }

      for(i = 0; i < this.accountCookie_.size(); ++i) {
         GeneratedMessageV3.writeString(output, 11, this.accountCookie_.getRaw(i));
      }

      if ((this.bitField0_ & 128) != 0) {
         GeneratedMessageV3.writeString(output, 12, this.timeZone_);
      }

      if ((this.bitField0_ & 256) != 0) {
         output.writeFixed64(13, this.securityToken_);
      }

      if ((this.bitField0_ & 512) != 0) {
         output.writeInt32(14, this.version_);
      }

      for(i = 0; i < this.otaCert_.size(); ++i) {
         GeneratedMessageV3.writeString(output, 15, this.otaCert_.getRaw(i));
      }

      if ((this.bitField0_ & 1024) != 0) {
         GeneratedMessageV3.writeString(output, 16, this.serialNumber_);
      }

      if ((this.bitField0_ & 2048) != 0) {
         GeneratedMessageV3.writeString(output, 17, this.esn_);
      }

      if ((this.bitField0_ & 4096) != 0) {
         output.writeMessage(18, this.getDeviceConfiguration());
      }

      for(i = 0; i < this.macAddrType_.size(); ++i) {
         GeneratedMessageV3.writeString(output, 19, this.macAddrType_.getRaw(i));
      }

      if ((this.bitField0_ & 8192) != 0) {
         output.writeInt32(20, this.fragment_);
      }

      if ((this.bitField0_ & 16384) != 0) {
         GeneratedMessageV3.writeString(output, 21, this.userName_);
      }

      if ((this.bitField0_ & '耀') != 0) {
         output.writeInt32(22, this.userSerialNumber_);
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
            size += CodedOutputStream.computeInt64Size(2, this.id_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += GeneratedMessageV3.computeStringSize(3, this.digest_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeMessageSize(4, this.getCheckin());
         }

         if ((this.bitField0_ & 8) != 0) {
            size += GeneratedMessageV3.computeStringSize(5, this.desiredBuild_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += GeneratedMessageV3.computeStringSize(6, this.locale_);
         }

         if ((this.bitField0_ & 32) != 0) {
            size += GeneratedMessageV3.computeStringSize(8, this.marketCheckin_);
         }

         int dataSize = 0;

         int i;
         for(i = 0; i < this.macAddr_.size(); ++i) {
            dataSize += computeStringSizeNoTag(this.macAddr_.getRaw(i));
         }

         size += dataSize;
         size += 1 * this.getMacAddrList().size();
         if ((this.bitField0_ & 64) != 0) {
            size += GeneratedMessageV3.computeStringSize(10, this.meid_);
         }

         dataSize = 0;

         for(i = 0; i < this.accountCookie_.size(); ++i) {
            dataSize += computeStringSizeNoTag(this.accountCookie_.getRaw(i));
         }

         size += dataSize;
         size += 1 * this.getAccountCookieList().size();
         if ((this.bitField0_ & 128) != 0) {
            size += GeneratedMessageV3.computeStringSize(12, this.timeZone_);
         }

         if ((this.bitField0_ & 256) != 0) {
            size += CodedOutputStream.computeFixed64Size(13, this.securityToken_);
         }

         if ((this.bitField0_ & 512) != 0) {
            size += CodedOutputStream.computeInt32Size(14, this.version_);
         }

         dataSize = 0;

         for(i = 0; i < this.otaCert_.size(); ++i) {
            dataSize += computeStringSizeNoTag(this.otaCert_.getRaw(i));
         }

         size += dataSize;
         size += 1 * this.getOtaCertList().size();
         if ((this.bitField0_ & 1024) != 0) {
            size += GeneratedMessageV3.computeStringSize(16, this.serialNumber_);
         }

         if ((this.bitField0_ & 2048) != 0) {
            size += GeneratedMessageV3.computeStringSize(17, this.esn_);
         }

         if ((this.bitField0_ & 4096) != 0) {
            size += CodedOutputStream.computeMessageSize(18, this.getDeviceConfiguration());
         }

         dataSize = 0;

         for(i = 0; i < this.macAddrType_.size(); ++i) {
            dataSize += computeStringSizeNoTag(this.macAddrType_.getRaw(i));
         }

         size += dataSize;
         size += 2 * this.getMacAddrTypeList().size();
         if ((this.bitField0_ & 8192) != 0) {
            size += CodedOutputStream.computeInt32Size(20, this.fragment_);
         }

         if ((this.bitField0_ & 16384) != 0) {
            size += GeneratedMessageV3.computeStringSize(21, this.userName_);
         }

         if ((this.bitField0_ & '耀') != 0) {
            size += CodedOutputStream.computeInt32Size(22, this.userSerialNumber_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof AndroidCheckinRequest)) {
         return super.equals(obj);
      } else {
         AndroidCheckinRequest other = (AndroidCheckinRequest)obj;
         if (this.hasId() != other.hasId()) {
            return false;
         } else if (this.hasId() && this.getId() != other.getId()) {
            return false;
         } else if (this.hasDigest() != other.hasDigest()) {
            return false;
         } else if (this.hasDigest() && !this.getDigest().equals(other.getDigest())) {
            return false;
         } else if (this.hasCheckin() != other.hasCheckin()) {
            return false;
         } else if (this.hasCheckin() && !this.getCheckin().equals(other.getCheckin())) {
            return false;
         } else if (this.hasDesiredBuild() != other.hasDesiredBuild()) {
            return false;
         } else if (this.hasDesiredBuild() && !this.getDesiredBuild().equals(other.getDesiredBuild())) {
            return false;
         } else if (this.hasLocale() != other.hasLocale()) {
            return false;
         } else if (this.hasLocale() && !this.getLocale().equals(other.getLocale())) {
            return false;
         } else if (this.hasMarketCheckin() != other.hasMarketCheckin()) {
            return false;
         } else if (this.hasMarketCheckin() && !this.getMarketCheckin().equals(other.getMarketCheckin())) {
            return false;
         } else if (!this.getMacAddrList().equals(other.getMacAddrList())) {
            return false;
         } else if (this.hasMeid() != other.hasMeid()) {
            return false;
         } else if (this.hasMeid() && !this.getMeid().equals(other.getMeid())) {
            return false;
         } else if (!this.getAccountCookieList().equals(other.getAccountCookieList())) {
            return false;
         } else if (this.hasTimeZone() != other.hasTimeZone()) {
            return false;
         } else if (this.hasTimeZone() && !this.getTimeZone().equals(other.getTimeZone())) {
            return false;
         } else if (this.hasSecurityToken() != other.hasSecurityToken()) {
            return false;
         } else if (this.hasSecurityToken() && this.getSecurityToken() != other.getSecurityToken()) {
            return false;
         } else if (this.hasVersion() != other.hasVersion()) {
            return false;
         } else if (this.hasVersion() && this.getVersion() != other.getVersion()) {
            return false;
         } else if (!this.getOtaCertList().equals(other.getOtaCertList())) {
            return false;
         } else if (this.hasSerialNumber() != other.hasSerialNumber()) {
            return false;
         } else if (this.hasSerialNumber() && !this.getSerialNumber().equals(other.getSerialNumber())) {
            return false;
         } else if (this.hasEsn() != other.hasEsn()) {
            return false;
         } else if (this.hasEsn() && !this.getEsn().equals(other.getEsn())) {
            return false;
         } else if (this.hasDeviceConfiguration() != other.hasDeviceConfiguration()) {
            return false;
         } else if (this.hasDeviceConfiguration() && !this.getDeviceConfiguration().equals(other.getDeviceConfiguration())) {
            return false;
         } else if (!this.getMacAddrTypeList().equals(other.getMacAddrTypeList())) {
            return false;
         } else if (this.hasFragment() != other.hasFragment()) {
            return false;
         } else if (this.hasFragment() && this.getFragment() != other.getFragment()) {
            return false;
         } else if (this.hasUserName() != other.hasUserName()) {
            return false;
         } else if (this.hasUserName() && !this.getUserName().equals(other.getUserName())) {
            return false;
         } else if (this.hasUserSerialNumber() != other.hasUserSerialNumber()) {
            return false;
         } else if (this.hasUserSerialNumber() && this.getUserSerialNumber() != other.getUserSerialNumber()) {
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
         if (this.hasId()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + Internal.hashLong(this.getId());
         }

         if (this.hasDigest()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getDigest().hashCode();
         }

         if (this.hasCheckin()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getCheckin().hashCode();
         }

         if (this.hasDesiredBuild()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getDesiredBuild().hashCode();
         }

         if (this.hasLocale()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + this.getLocale().hashCode();
         }

         if (this.hasMarketCheckin()) {
            hash = 37 * hash + 8;
            hash = 53 * hash + this.getMarketCheckin().hashCode();
         }

         if (this.getMacAddrCount() > 0) {
            hash = 37 * hash + 9;
            hash = 53 * hash + this.getMacAddrList().hashCode();
         }

         if (this.hasMeid()) {
            hash = 37 * hash + 10;
            hash = 53 * hash + this.getMeid().hashCode();
         }

         if (this.getAccountCookieCount() > 0) {
            hash = 37 * hash + 11;
            hash = 53 * hash + this.getAccountCookieList().hashCode();
         }

         if (this.hasTimeZone()) {
            hash = 37 * hash + 12;
            hash = 53 * hash + this.getTimeZone().hashCode();
         }

         if (this.hasSecurityToken()) {
            hash = 37 * hash + 13;
            hash = 53 * hash + Internal.hashLong(this.getSecurityToken());
         }

         if (this.hasVersion()) {
            hash = 37 * hash + 14;
            hash = 53 * hash + this.getVersion();
         }

         if (this.getOtaCertCount() > 0) {
            hash = 37 * hash + 15;
            hash = 53 * hash + this.getOtaCertList().hashCode();
         }

         if (this.hasSerialNumber()) {
            hash = 37 * hash + 16;
            hash = 53 * hash + this.getSerialNumber().hashCode();
         }

         if (this.hasEsn()) {
            hash = 37 * hash + 17;
            hash = 53 * hash + this.getEsn().hashCode();
         }

         if (this.hasDeviceConfiguration()) {
            hash = 37 * hash + 18;
            hash = 53 * hash + this.getDeviceConfiguration().hashCode();
         }

         if (this.getMacAddrTypeCount() > 0) {
            hash = 37 * hash + 19;
            hash = 53 * hash + this.getMacAddrTypeList().hashCode();
         }

         if (this.hasFragment()) {
            hash = 37 * hash + 20;
            hash = 53 * hash + this.getFragment();
         }

         if (this.hasUserName()) {
            hash = 37 * hash + 21;
            hash = 53 * hash + this.getUserName().hashCode();
         }

         if (this.hasUserSerialNumber()) {
            hash = 37 * hash + 22;
            hash = 53 * hash + this.getUserSerialNumber();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static AndroidCheckinRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (AndroidCheckinRequest)PARSER.parseFrom(data);
   }

   public static AndroidCheckinRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidCheckinRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidCheckinRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (AndroidCheckinRequest)PARSER.parseFrom(data);
   }

   public static AndroidCheckinRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidCheckinRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidCheckinRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (AndroidCheckinRequest)PARSER.parseFrom(data);
   }

   public static AndroidCheckinRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidCheckinRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidCheckinRequest parseFrom(InputStream input) throws IOException {
      return (AndroidCheckinRequest)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AndroidCheckinRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidCheckinRequest)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static AndroidCheckinRequest parseDelimitedFrom(InputStream input) throws IOException {
      return (AndroidCheckinRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static AndroidCheckinRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidCheckinRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static AndroidCheckinRequest parseFrom(CodedInputStream input) throws IOException {
      return (AndroidCheckinRequest)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AndroidCheckinRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidCheckinRequest)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public AndroidCheckinRequest.Builder newBuilderForType() {
      return newBuilder();
   }

   public static AndroidCheckinRequest.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static AndroidCheckinRequest.Builder newBuilder(AndroidCheckinRequest prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public AndroidCheckinRequest.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new AndroidCheckinRequest.Builder() : (new AndroidCheckinRequest.Builder()).mergeFrom(this);
   }

   protected AndroidCheckinRequest.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      AndroidCheckinRequest.Builder builder = new AndroidCheckinRequest.Builder(parent);
      return builder;
   }

   public static AndroidCheckinRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public AndroidCheckinRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   AndroidCheckinRequest(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   AndroidCheckinRequest(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements AndroidCheckinRequestOrBuilder {
      private int bitField0_;
      private long id_;
      private Object digest_;
      private AndroidCheckinProto checkin_;
      private SingleFieldBuilderV3 checkinBuilder_;
      private Object desiredBuild_;
      private Object locale_;
      private Object marketCheckin_;
      private LazyStringList macAddr_;
      private Object meid_;
      private LazyStringList accountCookie_;
      private Object timeZone_;
      private long securityToken_;
      private int version_;
      private LazyStringList otaCert_;
      private Object serialNumber_;
      private Object esn_;
      private DeviceConfigurationProto deviceConfiguration_;
      private SingleFieldBuilderV3 deviceConfigurationBuilder_;
      private LazyStringList macAddrType_;
      private int fragment_;
      private Object userName_;
      private int userSerialNumber_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_AndroidCheckinRequest_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_AndroidCheckinRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AndroidCheckinRequest.class, AndroidCheckinRequest.Builder.class);
      }

      private Builder() {
         this.digest_ = "";
         this.desiredBuild_ = "";
         this.locale_ = "";
         this.marketCheckin_ = "";
         this.macAddr_ = LazyStringArrayList.EMPTY;
         this.meid_ = "";
         this.accountCookie_ = LazyStringArrayList.EMPTY;
         this.timeZone_ = "";
         this.otaCert_ = LazyStringArrayList.EMPTY;
         this.serialNumber_ = "";
         this.esn_ = "";
         this.macAddrType_ = LazyStringArrayList.EMPTY;
         this.userName_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.digest_ = "";
         this.desiredBuild_ = "";
         this.locale_ = "";
         this.marketCheckin_ = "";
         this.macAddr_ = LazyStringArrayList.EMPTY;
         this.meid_ = "";
         this.accountCookie_ = LazyStringArrayList.EMPTY;
         this.timeZone_ = "";
         this.otaCert_ = LazyStringArrayList.EMPTY;
         this.serialNumber_ = "";
         this.esn_ = "";
         this.macAddrType_ = LazyStringArrayList.EMPTY;
         this.userName_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (AndroidCheckinRequest.alwaysUseFieldBuilders) {
            this.getCheckinFieldBuilder();
            this.getDeviceConfigurationFieldBuilder();
         }

      }

      public AndroidCheckinRequest.Builder clear() {
         super.clear();
         this.id_ = 0L;
         this.bitField0_ &= -2;
         this.digest_ = "";
         this.bitField0_ &= -3;
         if (this.checkinBuilder_ == null) {
            this.checkin_ = null;
         } else {
            this.checkinBuilder_.clear();
         }

         this.bitField0_ &= -5;
         this.desiredBuild_ = "";
         this.bitField0_ &= -9;
         this.locale_ = "";
         this.bitField0_ &= -17;
         this.marketCheckin_ = "";
         this.bitField0_ &= -33;
         this.macAddr_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -65;
         this.meid_ = "";
         this.bitField0_ &= -129;
         this.accountCookie_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -257;
         this.timeZone_ = "";
         this.bitField0_ &= -513;
         this.securityToken_ = 0L;
         this.bitField0_ &= -1025;
         this.version_ = 0;
         this.bitField0_ &= -2049;
         this.otaCert_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -4097;
         this.serialNumber_ = "";
         this.bitField0_ &= -8193;
         this.esn_ = "";
         this.bitField0_ &= -16385;
         if (this.deviceConfigurationBuilder_ == null) {
            this.deviceConfiguration_ = null;
         } else {
            this.deviceConfigurationBuilder_.clear();
         }

         this.bitField0_ &= -32769;
         this.macAddrType_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -65537;
         this.fragment_ = 0;
         this.bitField0_ &= -131073;
         this.userName_ = "";
         this.bitField0_ &= -262145;
         this.userSerialNumber_ = 0;
         this.bitField0_ &= -524289;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_AndroidCheckinRequest_descriptor;
      }

      public AndroidCheckinRequest getDefaultInstanceForType() {
         return AndroidCheckinRequest.getDefaultInstance();
      }

      public AndroidCheckinRequest build() {
         AndroidCheckinRequest result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public AndroidCheckinRequest buildPartial() {
         AndroidCheckinRequest result = new AndroidCheckinRequest(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.id_ = this.id_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            to_bitField0_ |= 2;
         }

         result.digest_ = this.digest_;
         if ((from_bitField0_ & 4) != 0) {
            if (this.checkinBuilder_ == null) {
               result.checkin_ = this.checkin_;
            } else {
               result.checkin_ = (AndroidCheckinProto)this.checkinBuilder_.build();
            }

            to_bitField0_ |= 4;
         }

         if ((from_bitField0_ & 8) != 0) {
            to_bitField0_ |= 8;
         }

         result.desiredBuild_ = this.desiredBuild_;
         if ((from_bitField0_ & 16) != 0) {
            to_bitField0_ |= 16;
         }

         result.locale_ = this.locale_;
         if ((from_bitField0_ & 32) != 0) {
            to_bitField0_ |= 32;
         }

         result.marketCheckin_ = this.marketCheckin_;
         if ((this.bitField0_ & 64) != 0) {
            this.macAddr_ = this.macAddr_.getUnmodifiableView();
            this.bitField0_ &= -65;
         }

         result.macAddr_ = this.macAddr_;
         if ((from_bitField0_ & 128) != 0) {
            to_bitField0_ |= 64;
         }

         result.meid_ = this.meid_;
         if ((this.bitField0_ & 256) != 0) {
            this.accountCookie_ = this.accountCookie_.getUnmodifiableView();
            this.bitField0_ &= -257;
         }

         result.accountCookie_ = this.accountCookie_;
         if ((from_bitField0_ & 512) != 0) {
            to_bitField0_ |= 128;
         }

         result.timeZone_ = this.timeZone_;
         if ((from_bitField0_ & 1024) != 0) {
            result.securityToken_ = this.securityToken_;
            to_bitField0_ |= 256;
         }

         if ((from_bitField0_ & 2048) != 0) {
            result.version_ = this.version_;
            to_bitField0_ |= 512;
         }

         if ((this.bitField0_ & 4096) != 0) {
            this.otaCert_ = this.otaCert_.getUnmodifiableView();
            this.bitField0_ &= -4097;
         }

         result.otaCert_ = this.otaCert_;
         if ((from_bitField0_ & 8192) != 0) {
            to_bitField0_ |= 1024;
         }

         result.serialNumber_ = this.serialNumber_;
         if ((from_bitField0_ & 16384) != 0) {
            to_bitField0_ |= 2048;
         }

         result.esn_ = this.esn_;
         if ((from_bitField0_ & '耀') != 0) {
            if (this.deviceConfigurationBuilder_ == null) {
               result.deviceConfiguration_ = this.deviceConfiguration_;
            } else {
               result.deviceConfiguration_ = (DeviceConfigurationProto)this.deviceConfigurationBuilder_.build();
            }

            to_bitField0_ |= 4096;
         }

         if ((this.bitField0_ & 65536) != 0) {
            this.macAddrType_ = this.macAddrType_.getUnmodifiableView();
            this.bitField0_ &= -65537;
         }

         result.macAddrType_ = this.macAddrType_;
         if ((from_bitField0_ & 131072) != 0) {
            result.fragment_ = this.fragment_;
            to_bitField0_ |= 8192;
         }

         if ((from_bitField0_ & 262144) != 0) {
            to_bitField0_ |= 16384;
         }

         result.userName_ = this.userName_;
         if ((from_bitField0_ & 524288) != 0) {
            result.userSerialNumber_ = this.userSerialNumber_;
            to_bitField0_ |= 32768;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public AndroidCheckinRequest.Builder clone() {
         return (AndroidCheckinRequest.Builder)super.clone();
      }

      public AndroidCheckinRequest.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (AndroidCheckinRequest.Builder)super.setField(field, value);
      }

      public AndroidCheckinRequest.Builder clearField(Descriptors.FieldDescriptor field) {
         return (AndroidCheckinRequest.Builder)super.clearField(field);
      }

      public AndroidCheckinRequest.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (AndroidCheckinRequest.Builder)super.clearOneof(oneof);
      }

      public AndroidCheckinRequest.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (AndroidCheckinRequest.Builder)super.setRepeatedField(field, index, value);
      }

      public AndroidCheckinRequest.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (AndroidCheckinRequest.Builder)super.addRepeatedField(field, value);
      }

      public AndroidCheckinRequest.Builder mergeFrom(Message other) {
         if (other instanceof AndroidCheckinRequest) {
            return this.mergeFrom((AndroidCheckinRequest)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public AndroidCheckinRequest.Builder mergeFrom(AndroidCheckinRequest other) {
         if (other == AndroidCheckinRequest.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasId()) {
               this.setId(other.getId());
            }

            if (other.hasDigest()) {
               this.bitField0_ |= 2;
               this.digest_ = other.digest_;
               this.onChanged();
            }

            if (other.hasCheckin()) {
               this.mergeCheckin(other.getCheckin());
            }

            if (other.hasDesiredBuild()) {
               this.bitField0_ |= 8;
               this.desiredBuild_ = other.desiredBuild_;
               this.onChanged();
            }

            if (other.hasLocale()) {
               this.bitField0_ |= 16;
               this.locale_ = other.locale_;
               this.onChanged();
            }

            if (other.hasMarketCheckin()) {
               this.bitField0_ |= 32;
               this.marketCheckin_ = other.marketCheckin_;
               this.onChanged();
            }

            if (!other.macAddr_.isEmpty()) {
               if (this.macAddr_.isEmpty()) {
                  this.macAddr_ = other.macAddr_;
                  this.bitField0_ &= -65;
               } else {
                  this.ensureMacAddrIsMutable();
                  this.macAddr_.addAll(other.macAddr_);
               }

               this.onChanged();
            }

            if (other.hasMeid()) {
               this.bitField0_ |= 128;
               this.meid_ = other.meid_;
               this.onChanged();
            }

            if (!other.accountCookie_.isEmpty()) {
               if (this.accountCookie_.isEmpty()) {
                  this.accountCookie_ = other.accountCookie_;
                  this.bitField0_ &= -257;
               } else {
                  this.ensureAccountCookieIsMutable();
                  this.accountCookie_.addAll(other.accountCookie_);
               }

               this.onChanged();
            }

            if (other.hasTimeZone()) {
               this.bitField0_ |= 512;
               this.timeZone_ = other.timeZone_;
               this.onChanged();
            }

            if (other.hasSecurityToken()) {
               this.setSecurityToken(other.getSecurityToken());
            }

            if (other.hasVersion()) {
               this.setVersion(other.getVersion());
            }

            if (!other.otaCert_.isEmpty()) {
               if (this.otaCert_.isEmpty()) {
                  this.otaCert_ = other.otaCert_;
                  this.bitField0_ &= -4097;
               } else {
                  this.ensureOtaCertIsMutable();
                  this.otaCert_.addAll(other.otaCert_);
               }

               this.onChanged();
            }

            if (other.hasSerialNumber()) {
               this.bitField0_ |= 8192;
               this.serialNumber_ = other.serialNumber_;
               this.onChanged();
            }

            if (other.hasEsn()) {
               this.bitField0_ |= 16384;
               this.esn_ = other.esn_;
               this.onChanged();
            }

            if (other.hasDeviceConfiguration()) {
               this.mergeDeviceConfiguration(other.getDeviceConfiguration());
            }

            if (!other.macAddrType_.isEmpty()) {
               if (this.macAddrType_.isEmpty()) {
                  this.macAddrType_ = other.macAddrType_;
                  this.bitField0_ &= -65537;
               } else {
                  this.ensureMacAddrTypeIsMutable();
                  this.macAddrType_.addAll(other.macAddrType_);
               }

               this.onChanged();
            }

            if (other.hasFragment()) {
               this.setFragment(other.getFragment());
            }

            if (other.hasUserName()) {
               this.bitField0_ |= 262144;
               this.userName_ = other.userName_;
               this.onChanged();
            }

            if (other.hasUserSerialNumber()) {
               this.setUserSerialNumber(other.getUserSerialNumber());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public AndroidCheckinRequest.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         AndroidCheckinRequest parsedMessage = null;

         try {
            parsedMessage = (AndroidCheckinRequest)AndroidCheckinRequest.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (AndroidCheckinRequest)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasId() {
         return (this.bitField0_ & 1) != 0;
      }

      public long getId() {
         return this.id_;
      }

      public AndroidCheckinRequest.Builder setId(long value) {
         this.bitField0_ |= 1;
         this.id_ = value;
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder clearId() {
         this.bitField0_ &= -2;
         this.id_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasDigest() {
         return (this.bitField0_ & 2) != 0;
      }

      public String getDigest() {
         Object ref = this.digest_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.digest_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDigestBytes() {
         Object ref = this.digest_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.digest_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidCheckinRequest.Builder setDigest(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.digest_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinRequest.Builder clearDigest() {
         this.bitField0_ &= -3;
         this.digest_ = AndroidCheckinRequest.getDefaultInstance().getDigest();
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder setDigestBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.digest_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasCheckin() {
         return (this.bitField0_ & 4) != 0;
      }

      public AndroidCheckinProto getCheckin() {
         if (this.checkinBuilder_ == null) {
            return this.checkin_ == null ? AndroidCheckinProto.getDefaultInstance() : this.checkin_;
         } else {
            return (AndroidCheckinProto)this.checkinBuilder_.getMessage();
         }
      }

      public AndroidCheckinRequest.Builder setCheckin(AndroidCheckinProto value) {
         if (this.checkinBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.checkin_ = value;
            this.onChanged();
         } else {
            this.checkinBuilder_.setMessage(value);
         }

         this.bitField0_ |= 4;
         return this;
      }

      public AndroidCheckinRequest.Builder setCheckin(AndroidCheckinProto.Builder builderForValue) {
         if (this.checkinBuilder_ == null) {
            this.checkin_ = builderForValue.build();
            this.onChanged();
         } else {
            this.checkinBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 4;
         return this;
      }

      public AndroidCheckinRequest.Builder mergeCheckin(AndroidCheckinProto value) {
         if (this.checkinBuilder_ == null) {
            if ((this.bitField0_ & 4) != 0 && this.checkin_ != null && this.checkin_ != AndroidCheckinProto.getDefaultInstance()) {
               this.checkin_ = AndroidCheckinProto.newBuilder(this.checkin_).mergeFrom(value).buildPartial();
            } else {
               this.checkin_ = value;
            }

            this.onChanged();
         } else {
            this.checkinBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 4;
         return this;
      }

      public AndroidCheckinRequest.Builder clearCheckin() {
         if (this.checkinBuilder_ == null) {
            this.checkin_ = null;
            this.onChanged();
         } else {
            this.checkinBuilder_.clear();
         }

         this.bitField0_ &= -5;
         return this;
      }

      public AndroidCheckinProto.Builder getCheckinBuilder() {
         this.bitField0_ |= 4;
         this.onChanged();
         return (AndroidCheckinProto.Builder)this.getCheckinFieldBuilder().getBuilder();
      }

      public AndroidCheckinProtoOrBuilder getCheckinOrBuilder() {
         if (this.checkinBuilder_ != null) {
            return (AndroidCheckinProtoOrBuilder)this.checkinBuilder_.getMessageOrBuilder();
         } else {
            return this.checkin_ == null ? AndroidCheckinProto.getDefaultInstance() : this.checkin_;
         }
      }

      private SingleFieldBuilderV3 getCheckinFieldBuilder() {
         if (this.checkinBuilder_ == null) {
            this.checkinBuilder_ = new SingleFieldBuilderV3(this.getCheckin(), this.getParentForChildren(), this.isClean());
            this.checkin_ = null;
         }

         return this.checkinBuilder_;
      }

      public boolean hasDesiredBuild() {
         return (this.bitField0_ & 8) != 0;
      }

      public String getDesiredBuild() {
         Object ref = this.desiredBuild_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.desiredBuild_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDesiredBuildBytes() {
         Object ref = this.desiredBuild_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.desiredBuild_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidCheckinRequest.Builder setDesiredBuild(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.desiredBuild_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinRequest.Builder clearDesiredBuild() {
         this.bitField0_ &= -9;
         this.desiredBuild_ = AndroidCheckinRequest.getDefaultInstance().getDesiredBuild();
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder setDesiredBuildBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.desiredBuild_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasLocale() {
         return (this.bitField0_ & 16) != 0;
      }

      public String getLocale() {
         Object ref = this.locale_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.locale_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getLocaleBytes() {
         Object ref = this.locale_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.locale_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidCheckinRequest.Builder setLocale(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16;
            this.locale_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinRequest.Builder clearLocale() {
         this.bitField0_ &= -17;
         this.locale_ = AndroidCheckinRequest.getDefaultInstance().getLocale();
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder setLocaleBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16;
            this.locale_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasMarketCheckin() {
         return (this.bitField0_ & 32) != 0;
      }

      public String getMarketCheckin() {
         Object ref = this.marketCheckin_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.marketCheckin_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getMarketCheckinBytes() {
         Object ref = this.marketCheckin_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.marketCheckin_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidCheckinRequest.Builder setMarketCheckin(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 32;
            this.marketCheckin_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinRequest.Builder clearMarketCheckin() {
         this.bitField0_ &= -33;
         this.marketCheckin_ = AndroidCheckinRequest.getDefaultInstance().getMarketCheckin();
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder setMarketCheckinBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 32;
            this.marketCheckin_ = value;
            this.onChanged();
            return this;
         }
      }

      private void ensureMacAddrIsMutable() {
         if ((this.bitField0_ & 64) == 0) {
            this.macAddr_ = new LazyStringArrayList(this.macAddr_);
            this.bitField0_ |= 64;
         }

      }

      public ProtocolStringList getMacAddrList() {
         return this.macAddr_.getUnmodifiableView();
      }

      public int getMacAddrCount() {
         return this.macAddr_.size();
      }

      public String getMacAddr(int index) {
         return (String)this.macAddr_.get(index);
      }

      public ByteString getMacAddrBytes(int index) {
         return this.macAddr_.getByteString(index);
      }

      public AndroidCheckinRequest.Builder setMacAddr(int index, String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureMacAddrIsMutable();
            this.macAddr_.set(index, (Object)value);
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinRequest.Builder addMacAddr(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureMacAddrIsMutable();
            this.macAddr_.add((Object)value);
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinRequest.Builder addAllMacAddr(Iterable values) {
         this.ensureMacAddrIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.macAddr_);
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder clearMacAddr() {
         this.macAddr_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -65;
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder addMacAddrBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureMacAddrIsMutable();
            this.macAddr_.add(value);
            this.onChanged();
            return this;
         }
      }

      public boolean hasMeid() {
         return (this.bitField0_ & 128) != 0;
      }

      public String getMeid() {
         Object ref = this.meid_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.meid_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getMeidBytes() {
         Object ref = this.meid_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.meid_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidCheckinRequest.Builder setMeid(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 128;
            this.meid_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinRequest.Builder clearMeid() {
         this.bitField0_ &= -129;
         this.meid_ = AndroidCheckinRequest.getDefaultInstance().getMeid();
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder setMeidBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 128;
            this.meid_ = value;
            this.onChanged();
            return this;
         }
      }

      private void ensureAccountCookieIsMutable() {
         if ((this.bitField0_ & 256) == 0) {
            this.accountCookie_ = new LazyStringArrayList(this.accountCookie_);
            this.bitField0_ |= 256;
         }

      }

      public ProtocolStringList getAccountCookieList() {
         return this.accountCookie_.getUnmodifiableView();
      }

      public int getAccountCookieCount() {
         return this.accountCookie_.size();
      }

      public String getAccountCookie(int index) {
         return (String)this.accountCookie_.get(index);
      }

      public ByteString getAccountCookieBytes(int index) {
         return this.accountCookie_.getByteString(index);
      }

      public AndroidCheckinRequest.Builder setAccountCookie(int index, String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureAccountCookieIsMutable();
            this.accountCookie_.set(index, (Object)value);
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinRequest.Builder addAccountCookie(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureAccountCookieIsMutable();
            this.accountCookie_.add((Object)value);
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinRequest.Builder addAllAccountCookie(Iterable values) {
         this.ensureAccountCookieIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.accountCookie_);
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder clearAccountCookie() {
         this.accountCookie_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -257;
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder addAccountCookieBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureAccountCookieIsMutable();
            this.accountCookie_.add(value);
            this.onChanged();
            return this;
         }
      }

      public boolean hasTimeZone() {
         return (this.bitField0_ & 512) != 0;
      }

      public String getTimeZone() {
         Object ref = this.timeZone_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.timeZone_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getTimeZoneBytes() {
         Object ref = this.timeZone_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.timeZone_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidCheckinRequest.Builder setTimeZone(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 512;
            this.timeZone_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinRequest.Builder clearTimeZone() {
         this.bitField0_ &= -513;
         this.timeZone_ = AndroidCheckinRequest.getDefaultInstance().getTimeZone();
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder setTimeZoneBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 512;
            this.timeZone_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasSecurityToken() {
         return (this.bitField0_ & 1024) != 0;
      }

      public long getSecurityToken() {
         return this.securityToken_;
      }

      public AndroidCheckinRequest.Builder setSecurityToken(long value) {
         this.bitField0_ |= 1024;
         this.securityToken_ = value;
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder clearSecurityToken() {
         this.bitField0_ &= -1025;
         this.securityToken_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasVersion() {
         return (this.bitField0_ & 2048) != 0;
      }

      public int getVersion() {
         return this.version_;
      }

      public AndroidCheckinRequest.Builder setVersion(int value) {
         this.bitField0_ |= 2048;
         this.version_ = value;
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder clearVersion() {
         this.bitField0_ &= -2049;
         this.version_ = 0;
         this.onChanged();
         return this;
      }

      private void ensureOtaCertIsMutable() {
         if ((this.bitField0_ & 4096) == 0) {
            this.otaCert_ = new LazyStringArrayList(this.otaCert_);
            this.bitField0_ |= 4096;
         }

      }

      public ProtocolStringList getOtaCertList() {
         return this.otaCert_.getUnmodifiableView();
      }

      public int getOtaCertCount() {
         return this.otaCert_.size();
      }

      public String getOtaCert(int index) {
         return (String)this.otaCert_.get(index);
      }

      public ByteString getOtaCertBytes(int index) {
         return this.otaCert_.getByteString(index);
      }

      public AndroidCheckinRequest.Builder setOtaCert(int index, String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureOtaCertIsMutable();
            this.otaCert_.set(index, (Object)value);
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinRequest.Builder addOtaCert(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureOtaCertIsMutable();
            this.otaCert_.add((Object)value);
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinRequest.Builder addAllOtaCert(Iterable values) {
         this.ensureOtaCertIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.otaCert_);
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder clearOtaCert() {
         this.otaCert_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -4097;
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder addOtaCertBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureOtaCertIsMutable();
            this.otaCert_.add(value);
            this.onChanged();
            return this;
         }
      }

      public boolean hasSerialNumber() {
         return (this.bitField0_ & 8192) != 0;
      }

      public String getSerialNumber() {
         Object ref = this.serialNumber_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.serialNumber_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getSerialNumberBytes() {
         Object ref = this.serialNumber_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.serialNumber_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidCheckinRequest.Builder setSerialNumber(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8192;
            this.serialNumber_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinRequest.Builder clearSerialNumber() {
         this.bitField0_ &= -8193;
         this.serialNumber_ = AndroidCheckinRequest.getDefaultInstance().getSerialNumber();
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder setSerialNumberBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8192;
            this.serialNumber_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasEsn() {
         return (this.bitField0_ & 16384) != 0;
      }

      public String getEsn() {
         Object ref = this.esn_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.esn_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getEsnBytes() {
         Object ref = this.esn_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.esn_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidCheckinRequest.Builder setEsn(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16384;
            this.esn_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinRequest.Builder clearEsn() {
         this.bitField0_ &= -16385;
         this.esn_ = AndroidCheckinRequest.getDefaultInstance().getEsn();
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder setEsnBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16384;
            this.esn_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasDeviceConfiguration() {
         return (this.bitField0_ & '耀') != 0;
      }

      public DeviceConfigurationProto getDeviceConfiguration() {
         if (this.deviceConfigurationBuilder_ == null) {
            return this.deviceConfiguration_ == null ? DeviceConfigurationProto.getDefaultInstance() : this.deviceConfiguration_;
         } else {
            return (DeviceConfigurationProto)this.deviceConfigurationBuilder_.getMessage();
         }
      }

      public AndroidCheckinRequest.Builder setDeviceConfiguration(DeviceConfigurationProto value) {
         if (this.deviceConfigurationBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.deviceConfiguration_ = value;
            this.onChanged();
         } else {
            this.deviceConfigurationBuilder_.setMessage(value);
         }

         this.bitField0_ |= 32768;
         return this;
      }

      public AndroidCheckinRequest.Builder setDeviceConfiguration(DeviceConfigurationProto.Builder builderForValue) {
         if (this.deviceConfigurationBuilder_ == null) {
            this.deviceConfiguration_ = builderForValue.build();
            this.onChanged();
         } else {
            this.deviceConfigurationBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 32768;
         return this;
      }

      public AndroidCheckinRequest.Builder mergeDeviceConfiguration(DeviceConfigurationProto value) {
         if (this.deviceConfigurationBuilder_ == null) {
            if ((this.bitField0_ & '耀') != 0 && this.deviceConfiguration_ != null && this.deviceConfiguration_ != DeviceConfigurationProto.getDefaultInstance()) {
               this.deviceConfiguration_ = DeviceConfigurationProto.newBuilder(this.deviceConfiguration_).mergeFrom(value).buildPartial();
            } else {
               this.deviceConfiguration_ = value;
            }

            this.onChanged();
         } else {
            this.deviceConfigurationBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 32768;
         return this;
      }

      public AndroidCheckinRequest.Builder clearDeviceConfiguration() {
         if (this.deviceConfigurationBuilder_ == null) {
            this.deviceConfiguration_ = null;
            this.onChanged();
         } else {
            this.deviceConfigurationBuilder_.clear();
         }

         this.bitField0_ &= -32769;
         return this;
      }

      public DeviceConfigurationProto.Builder getDeviceConfigurationBuilder() {
         this.bitField0_ |= 32768;
         this.onChanged();
         return (DeviceConfigurationProto.Builder)this.getDeviceConfigurationFieldBuilder().getBuilder();
      }

      public DeviceConfigurationProtoOrBuilder getDeviceConfigurationOrBuilder() {
         if (this.deviceConfigurationBuilder_ != null) {
            return (DeviceConfigurationProtoOrBuilder)this.deviceConfigurationBuilder_.getMessageOrBuilder();
         } else {
            return this.deviceConfiguration_ == null ? DeviceConfigurationProto.getDefaultInstance() : this.deviceConfiguration_;
         }
      }

      private SingleFieldBuilderV3 getDeviceConfigurationFieldBuilder() {
         if (this.deviceConfigurationBuilder_ == null) {
            this.deviceConfigurationBuilder_ = new SingleFieldBuilderV3(this.getDeviceConfiguration(), this.getParentForChildren(), this.isClean());
            this.deviceConfiguration_ = null;
         }

         return this.deviceConfigurationBuilder_;
      }

      private void ensureMacAddrTypeIsMutable() {
         if ((this.bitField0_ & 65536) == 0) {
            this.macAddrType_ = new LazyStringArrayList(this.macAddrType_);
            this.bitField0_ |= 65536;
         }

      }

      public ProtocolStringList getMacAddrTypeList() {
         return this.macAddrType_.getUnmodifiableView();
      }

      public int getMacAddrTypeCount() {
         return this.macAddrType_.size();
      }

      public String getMacAddrType(int index) {
         return (String)this.macAddrType_.get(index);
      }

      public ByteString getMacAddrTypeBytes(int index) {
         return this.macAddrType_.getByteString(index);
      }

      public AndroidCheckinRequest.Builder setMacAddrType(int index, String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureMacAddrTypeIsMutable();
            this.macAddrType_.set(index, (Object)value);
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinRequest.Builder addMacAddrType(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureMacAddrTypeIsMutable();
            this.macAddrType_.add((Object)value);
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinRequest.Builder addAllMacAddrType(Iterable values) {
         this.ensureMacAddrTypeIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.macAddrType_);
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder clearMacAddrType() {
         this.macAddrType_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -65537;
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder addMacAddrTypeBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureMacAddrTypeIsMutable();
            this.macAddrType_.add(value);
            this.onChanged();
            return this;
         }
      }

      public boolean hasFragment() {
         return (this.bitField0_ & 131072) != 0;
      }

      public int getFragment() {
         return this.fragment_;
      }

      public AndroidCheckinRequest.Builder setFragment(int value) {
         this.bitField0_ |= 131072;
         this.fragment_ = value;
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder clearFragment() {
         this.bitField0_ &= -131073;
         this.fragment_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasUserName() {
         return (this.bitField0_ & 262144) != 0;
      }

      public String getUserName() {
         Object ref = this.userName_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.userName_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getUserNameBytes() {
         Object ref = this.userName_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.userName_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidCheckinRequest.Builder setUserName(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 262144;
            this.userName_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinRequest.Builder clearUserName() {
         this.bitField0_ &= -262145;
         this.userName_ = AndroidCheckinRequest.getDefaultInstance().getUserName();
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder setUserNameBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 262144;
            this.userName_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasUserSerialNumber() {
         return (this.bitField0_ & 524288) != 0;
      }

      public int getUserSerialNumber() {
         return this.userSerialNumber_;
      }

      public AndroidCheckinRequest.Builder setUserSerialNumber(int value) {
         this.bitField0_ |= 524288;
         this.userSerialNumber_ = value;
         this.onChanged();
         return this;
      }

      public AndroidCheckinRequest.Builder clearUserSerialNumber() {
         this.bitField0_ &= -524289;
         this.userSerialNumber_ = 0;
         this.onChanged();
         return this;
      }

      public final AndroidCheckinRequest.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (AndroidCheckinRequest.Builder)super.setUnknownFields(unknownFields);
      }

      public final AndroidCheckinRequest.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (AndroidCheckinRequest.Builder)super.mergeUnknownFields(unknownFields);
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
