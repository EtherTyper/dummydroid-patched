package de.onyxbits.raccoon.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class AndroidBuildProto extends GeneratedMessageV3 implements AndroidBuildProtoOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int ID_FIELD_NUMBER = 1;
   private volatile Object id_;
   public static final int PRODUCT_FIELD_NUMBER = 2;
   private volatile Object product_;
   public static final int CARRIER_FIELD_NUMBER = 3;
   private volatile Object carrier_;
   public static final int RADIO_FIELD_NUMBER = 4;
   private volatile Object radio_;
   public static final int BOOTLOADER_FIELD_NUMBER = 5;
   private volatile Object bootloader_;
   public static final int CLIENT_FIELD_NUMBER = 6;
   private volatile Object client_;
   public static final int TIMESTAMP_FIELD_NUMBER = 7;
   private long timestamp_;
   public static final int GOOGLESERVICES_FIELD_NUMBER = 8;
   private int googleServices_;
   public static final int DEVICE_FIELD_NUMBER = 9;
   private volatile Object device_;
   public static final int SDKVERSION_FIELD_NUMBER = 10;
   private int sdkVersion_;
   public static final int MODEL_FIELD_NUMBER = 11;
   private volatile Object model_;
   public static final int MANUFACTURER_FIELD_NUMBER = 12;
   private volatile Object manufacturer_;
   public static final int BUILDPRODUCT_FIELD_NUMBER = 13;
   private volatile Object buildProduct_;
   public static final int OTAINSTALLED_FIELD_NUMBER = 14;
   private boolean otaInstalled_;
   private byte memoizedIsInitialized;
   private static final AndroidBuildProto DEFAULT_INSTANCE = new AndroidBuildProto();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public AndroidBuildProto parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new AndroidBuildProto(input, extensionRegistry);
      }
   };

   private AndroidBuildProto(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private AndroidBuildProto() {
      this.memoizedIsInitialized = -1;
      this.id_ = "";
      this.product_ = "";
      this.carrier_ = "";
      this.radio_ = "";
      this.bootloader_ = "";
      this.client_ = "";
      this.device_ = "";
      this.model_ = "";
      this.manufacturer_ = "";
      this.buildProduct_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new AndroidBuildProto();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private AndroidBuildProto(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
         throw new NullPointerException();
      } else {
         int mutable_bitField0_ = false;
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
                  this.id_ = bs;
                  break;
               case 18:
                  bs = input.readBytes();
                  this.bitField0_ |= 2;
                  this.product_ = bs;
                  break;
               case 26:
                  bs = input.readBytes();
                  this.bitField0_ |= 4;
                  this.carrier_ = bs;
                  break;
               case 34:
                  bs = input.readBytes();
                  this.bitField0_ |= 8;
                  this.radio_ = bs;
                  break;
               case 42:
                  bs = input.readBytes();
                  this.bitField0_ |= 16;
                  this.bootloader_ = bs;
                  break;
               case 50:
                  bs = input.readBytes();
                  this.bitField0_ |= 32;
                  this.client_ = bs;
                  break;
               case 56:
                  this.bitField0_ |= 64;
                  this.timestamp_ = input.readInt64();
                  break;
               case 64:
                  this.bitField0_ |= 128;
                  this.googleServices_ = input.readInt32();
                  break;
               case 74:
                  bs = input.readBytes();
                  this.bitField0_ |= 256;
                  this.device_ = bs;
                  break;
               case 80:
                  this.bitField0_ |= 512;
                  this.sdkVersion_ = input.readInt32();
                  break;
               case 90:
                  bs = input.readBytes();
                  this.bitField0_ |= 1024;
                  this.model_ = bs;
                  break;
               case 98:
                  bs = input.readBytes();
                  this.bitField0_ |= 2048;
                  this.manufacturer_ = bs;
                  break;
               case 106:
                  bs = input.readBytes();
                  this.bitField0_ |= 4096;
                  this.buildProduct_ = bs;
                  break;
               case 112:
                  this.bitField0_ |= 8192;
                  this.otaInstalled_ = input.readBool();
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
            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_AndroidBuildProto_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_AndroidBuildProto_fieldAccessorTable.ensureFieldAccessorsInitialized(AndroidBuildProto.class, AndroidBuildProto.Builder.class);
   }

   public boolean hasId() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getId() {
      Object ref = this.id_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.id_ = s;
         }

         return s;
      }
   }

   public ByteString getIdBytes() {
      Object ref = this.id_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.id_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasProduct() {
      return (this.bitField0_ & 2) != 0;
   }

   public String getProduct() {
      Object ref = this.product_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.product_ = s;
         }

         return s;
      }
   }

   public ByteString getProductBytes() {
      Object ref = this.product_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.product_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasCarrier() {
      return (this.bitField0_ & 4) != 0;
   }

   public String getCarrier() {
      Object ref = this.carrier_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.carrier_ = s;
         }

         return s;
      }
   }

   public ByteString getCarrierBytes() {
      Object ref = this.carrier_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.carrier_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasRadio() {
      return (this.bitField0_ & 8) != 0;
   }

   public String getRadio() {
      Object ref = this.radio_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.radio_ = s;
         }

         return s;
      }
   }

   public ByteString getRadioBytes() {
      Object ref = this.radio_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.radio_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasBootloader() {
      return (this.bitField0_ & 16) != 0;
   }

   public String getBootloader() {
      Object ref = this.bootloader_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.bootloader_ = s;
         }

         return s;
      }
   }

   public ByteString getBootloaderBytes() {
      Object ref = this.bootloader_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.bootloader_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasClient() {
      return (this.bitField0_ & 32) != 0;
   }

   public String getClient() {
      Object ref = this.client_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.client_ = s;
         }

         return s;
      }
   }

   public ByteString getClientBytes() {
      Object ref = this.client_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.client_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasTimestamp() {
      return (this.bitField0_ & 64) != 0;
   }

   public long getTimestamp() {
      return this.timestamp_;
   }

   public boolean hasGoogleServices() {
      return (this.bitField0_ & 128) != 0;
   }

   public int getGoogleServices() {
      return this.googleServices_;
   }

   public boolean hasDevice() {
      return (this.bitField0_ & 256) != 0;
   }

   public String getDevice() {
      Object ref = this.device_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.device_ = s;
         }

         return s;
      }
   }

   public ByteString getDeviceBytes() {
      Object ref = this.device_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.device_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasSdkVersion() {
      return (this.bitField0_ & 512) != 0;
   }

   public int getSdkVersion() {
      return this.sdkVersion_;
   }

   public boolean hasModel() {
      return (this.bitField0_ & 1024) != 0;
   }

   public String getModel() {
      Object ref = this.model_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.model_ = s;
         }

         return s;
      }
   }

   public ByteString getModelBytes() {
      Object ref = this.model_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.model_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasManufacturer() {
      return (this.bitField0_ & 2048) != 0;
   }

   public String getManufacturer() {
      Object ref = this.manufacturer_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.manufacturer_ = s;
         }

         return s;
      }
   }

   public ByteString getManufacturerBytes() {
      Object ref = this.manufacturer_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.manufacturer_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasBuildProduct() {
      return (this.bitField0_ & 4096) != 0;
   }

   public String getBuildProduct() {
      Object ref = this.buildProduct_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.buildProduct_ = s;
         }

         return s;
      }
   }

   public ByteString getBuildProductBytes() {
      Object ref = this.buildProduct_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.buildProduct_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasOtaInstalled() {
      return (this.bitField0_ & 8192) != 0;
   }

   public boolean getOtaInstalled() {
      return this.otaInstalled_;
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
         GeneratedMessageV3.writeString(output, 1, this.id_);
      }

      if ((this.bitField0_ & 2) != 0) {
         GeneratedMessageV3.writeString(output, 2, this.product_);
      }

      if ((this.bitField0_ & 4) != 0) {
         GeneratedMessageV3.writeString(output, 3, this.carrier_);
      }

      if ((this.bitField0_ & 8) != 0) {
         GeneratedMessageV3.writeString(output, 4, this.radio_);
      }

      if ((this.bitField0_ & 16) != 0) {
         GeneratedMessageV3.writeString(output, 5, this.bootloader_);
      }

      if ((this.bitField0_ & 32) != 0) {
         GeneratedMessageV3.writeString(output, 6, this.client_);
      }

      if ((this.bitField0_ & 64) != 0) {
         output.writeInt64(7, this.timestamp_);
      }

      if ((this.bitField0_ & 128) != 0) {
         output.writeInt32(8, this.googleServices_);
      }

      if ((this.bitField0_ & 256) != 0) {
         GeneratedMessageV3.writeString(output, 9, this.device_);
      }

      if ((this.bitField0_ & 512) != 0) {
         output.writeInt32(10, this.sdkVersion_);
      }

      if ((this.bitField0_ & 1024) != 0) {
         GeneratedMessageV3.writeString(output, 11, this.model_);
      }

      if ((this.bitField0_ & 2048) != 0) {
         GeneratedMessageV3.writeString(output, 12, this.manufacturer_);
      }

      if ((this.bitField0_ & 4096) != 0) {
         GeneratedMessageV3.writeString(output, 13, this.buildProduct_);
      }

      if ((this.bitField0_ & 8192) != 0) {
         output.writeBool(14, this.otaInstalled_);
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
            size += GeneratedMessageV3.computeStringSize(1, this.id_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += GeneratedMessageV3.computeStringSize(2, this.product_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += GeneratedMessageV3.computeStringSize(3, this.carrier_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += GeneratedMessageV3.computeStringSize(4, this.radio_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += GeneratedMessageV3.computeStringSize(5, this.bootloader_);
         }

         if ((this.bitField0_ & 32) != 0) {
            size += GeneratedMessageV3.computeStringSize(6, this.client_);
         }

         if ((this.bitField0_ & 64) != 0) {
            size += CodedOutputStream.computeInt64Size(7, this.timestamp_);
         }

         if ((this.bitField0_ & 128) != 0) {
            size += CodedOutputStream.computeInt32Size(8, this.googleServices_);
         }

         if ((this.bitField0_ & 256) != 0) {
            size += GeneratedMessageV3.computeStringSize(9, this.device_);
         }

         if ((this.bitField0_ & 512) != 0) {
            size += CodedOutputStream.computeInt32Size(10, this.sdkVersion_);
         }

         if ((this.bitField0_ & 1024) != 0) {
            size += GeneratedMessageV3.computeStringSize(11, this.model_);
         }

         if ((this.bitField0_ & 2048) != 0) {
            size += GeneratedMessageV3.computeStringSize(12, this.manufacturer_);
         }

         if ((this.bitField0_ & 4096) != 0) {
            size += GeneratedMessageV3.computeStringSize(13, this.buildProduct_);
         }

         if ((this.bitField0_ & 8192) != 0) {
            size += CodedOutputStream.computeBoolSize(14, this.otaInstalled_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof AndroidBuildProto)) {
         return super.equals(obj);
      } else {
         AndroidBuildProto other = (AndroidBuildProto)obj;
         if (this.hasId() != other.hasId()) {
            return false;
         } else if (this.hasId() && !this.getId().equals(other.getId())) {
            return false;
         } else if (this.hasProduct() != other.hasProduct()) {
            return false;
         } else if (this.hasProduct() && !this.getProduct().equals(other.getProduct())) {
            return false;
         } else if (this.hasCarrier() != other.hasCarrier()) {
            return false;
         } else if (this.hasCarrier() && !this.getCarrier().equals(other.getCarrier())) {
            return false;
         } else if (this.hasRadio() != other.hasRadio()) {
            return false;
         } else if (this.hasRadio() && !this.getRadio().equals(other.getRadio())) {
            return false;
         } else if (this.hasBootloader() != other.hasBootloader()) {
            return false;
         } else if (this.hasBootloader() && !this.getBootloader().equals(other.getBootloader())) {
            return false;
         } else if (this.hasClient() != other.hasClient()) {
            return false;
         } else if (this.hasClient() && !this.getClient().equals(other.getClient())) {
            return false;
         } else if (this.hasTimestamp() != other.hasTimestamp()) {
            return false;
         } else if (this.hasTimestamp() && this.getTimestamp() != other.getTimestamp()) {
            return false;
         } else if (this.hasGoogleServices() != other.hasGoogleServices()) {
            return false;
         } else if (this.hasGoogleServices() && this.getGoogleServices() != other.getGoogleServices()) {
            return false;
         } else if (this.hasDevice() != other.hasDevice()) {
            return false;
         } else if (this.hasDevice() && !this.getDevice().equals(other.getDevice())) {
            return false;
         } else if (this.hasSdkVersion() != other.hasSdkVersion()) {
            return false;
         } else if (this.hasSdkVersion() && this.getSdkVersion() != other.getSdkVersion()) {
            return false;
         } else if (this.hasModel() != other.hasModel()) {
            return false;
         } else if (this.hasModel() && !this.getModel().equals(other.getModel())) {
            return false;
         } else if (this.hasManufacturer() != other.hasManufacturer()) {
            return false;
         } else if (this.hasManufacturer() && !this.getManufacturer().equals(other.getManufacturer())) {
            return false;
         } else if (this.hasBuildProduct() != other.hasBuildProduct()) {
            return false;
         } else if (this.hasBuildProduct() && !this.getBuildProduct().equals(other.getBuildProduct())) {
            return false;
         } else if (this.hasOtaInstalled() != other.hasOtaInstalled()) {
            return false;
         } else if (this.hasOtaInstalled() && this.getOtaInstalled() != other.getOtaInstalled()) {
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
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getId().hashCode();
         }

         if (this.hasProduct()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getProduct().hashCode();
         }

         if (this.hasCarrier()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getCarrier().hashCode();
         }

         if (this.hasRadio()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getRadio().hashCode();
         }

         if (this.hasBootloader()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getBootloader().hashCode();
         }

         if (this.hasClient()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + this.getClient().hashCode();
         }

         if (this.hasTimestamp()) {
            hash = 37 * hash + 7;
            hash = 53 * hash + Internal.hashLong(this.getTimestamp());
         }

         if (this.hasGoogleServices()) {
            hash = 37 * hash + 8;
            hash = 53 * hash + this.getGoogleServices();
         }

         if (this.hasDevice()) {
            hash = 37 * hash + 9;
            hash = 53 * hash + this.getDevice().hashCode();
         }

         if (this.hasSdkVersion()) {
            hash = 37 * hash + 10;
            hash = 53 * hash + this.getSdkVersion();
         }

         if (this.hasModel()) {
            hash = 37 * hash + 11;
            hash = 53 * hash + this.getModel().hashCode();
         }

         if (this.hasManufacturer()) {
            hash = 37 * hash + 12;
            hash = 53 * hash + this.getManufacturer().hashCode();
         }

         if (this.hasBuildProduct()) {
            hash = 37 * hash + 13;
            hash = 53 * hash + this.getBuildProduct().hashCode();
         }

         if (this.hasOtaInstalled()) {
            hash = 37 * hash + 14;
            hash = 53 * hash + Internal.hashBoolean(this.getOtaInstalled());
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static AndroidBuildProto parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (AndroidBuildProto)PARSER.parseFrom(data);
   }

   public static AndroidBuildProto parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidBuildProto)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidBuildProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (AndroidBuildProto)PARSER.parseFrom(data);
   }

   public static AndroidBuildProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidBuildProto)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidBuildProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (AndroidBuildProto)PARSER.parseFrom(data);
   }

   public static AndroidBuildProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidBuildProto)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidBuildProto parseFrom(InputStream input) throws IOException {
      return (AndroidBuildProto)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AndroidBuildProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidBuildProto)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static AndroidBuildProto parseDelimitedFrom(InputStream input) throws IOException {
      return (AndroidBuildProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static AndroidBuildProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidBuildProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static AndroidBuildProto parseFrom(CodedInputStream input) throws IOException {
      return (AndroidBuildProto)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AndroidBuildProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidBuildProto)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public AndroidBuildProto.Builder newBuilderForType() {
      return newBuilder();
   }

   public static AndroidBuildProto.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static AndroidBuildProto.Builder newBuilder(AndroidBuildProto prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public AndroidBuildProto.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new AndroidBuildProto.Builder() : (new AndroidBuildProto.Builder()).mergeFrom(this);
   }

   protected AndroidBuildProto.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      AndroidBuildProto.Builder builder = new AndroidBuildProto.Builder(parent);
      return builder;
   }

   public static AndroidBuildProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public AndroidBuildProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   AndroidBuildProto(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   AndroidBuildProto(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements AndroidBuildProtoOrBuilder {
      private int bitField0_;
      private Object id_;
      private Object product_;
      private Object carrier_;
      private Object radio_;
      private Object bootloader_;
      private Object client_;
      private long timestamp_;
      private int googleServices_;
      private Object device_;
      private int sdkVersion_;
      private Object model_;
      private Object manufacturer_;
      private Object buildProduct_;
      private boolean otaInstalled_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_AndroidBuildProto_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_AndroidBuildProto_fieldAccessorTable.ensureFieldAccessorsInitialized(AndroidBuildProto.class, AndroidBuildProto.Builder.class);
      }

      private Builder() {
         this.id_ = "";
         this.product_ = "";
         this.carrier_ = "";
         this.radio_ = "";
         this.bootloader_ = "";
         this.client_ = "";
         this.device_ = "";
         this.model_ = "";
         this.manufacturer_ = "";
         this.buildProduct_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.id_ = "";
         this.product_ = "";
         this.carrier_ = "";
         this.radio_ = "";
         this.bootloader_ = "";
         this.client_ = "";
         this.device_ = "";
         this.model_ = "";
         this.manufacturer_ = "";
         this.buildProduct_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (AndroidBuildProto.alwaysUseFieldBuilders) {
         }

      }

      public AndroidBuildProto.Builder clear() {
         super.clear();
         this.id_ = "";
         this.bitField0_ &= -2;
         this.product_ = "";
         this.bitField0_ &= -3;
         this.carrier_ = "";
         this.bitField0_ &= -5;
         this.radio_ = "";
         this.bitField0_ &= -9;
         this.bootloader_ = "";
         this.bitField0_ &= -17;
         this.client_ = "";
         this.bitField0_ &= -33;
         this.timestamp_ = 0L;
         this.bitField0_ &= -65;
         this.googleServices_ = 0;
         this.bitField0_ &= -129;
         this.device_ = "";
         this.bitField0_ &= -257;
         this.sdkVersion_ = 0;
         this.bitField0_ &= -513;
         this.model_ = "";
         this.bitField0_ &= -1025;
         this.manufacturer_ = "";
         this.bitField0_ &= -2049;
         this.buildProduct_ = "";
         this.bitField0_ &= -4097;
         this.otaInstalled_ = false;
         this.bitField0_ &= -8193;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_AndroidBuildProto_descriptor;
      }

      public AndroidBuildProto getDefaultInstanceForType() {
         return AndroidBuildProto.getDefaultInstance();
      }

      public AndroidBuildProto build() {
         AndroidBuildProto result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public AndroidBuildProto buildPartial() {
         AndroidBuildProto result = new AndroidBuildProto(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.id_ = this.id_;
         if ((from_bitField0_ & 2) != 0) {
            to_bitField0_ |= 2;
         }

         result.product_ = this.product_;
         if ((from_bitField0_ & 4) != 0) {
            to_bitField0_ |= 4;
         }

         result.carrier_ = this.carrier_;
         if ((from_bitField0_ & 8) != 0) {
            to_bitField0_ |= 8;
         }

         result.radio_ = this.radio_;
         if ((from_bitField0_ & 16) != 0) {
            to_bitField0_ |= 16;
         }

         result.bootloader_ = this.bootloader_;
         if ((from_bitField0_ & 32) != 0) {
            to_bitField0_ |= 32;
         }

         result.client_ = this.client_;
         if ((from_bitField0_ & 64) != 0) {
            result.timestamp_ = this.timestamp_;
            to_bitField0_ |= 64;
         }

         if ((from_bitField0_ & 128) != 0) {
            result.googleServices_ = this.googleServices_;
            to_bitField0_ |= 128;
         }

         if ((from_bitField0_ & 256) != 0) {
            to_bitField0_ |= 256;
         }

         result.device_ = this.device_;
         if ((from_bitField0_ & 512) != 0) {
            result.sdkVersion_ = this.sdkVersion_;
            to_bitField0_ |= 512;
         }

         if ((from_bitField0_ & 1024) != 0) {
            to_bitField0_ |= 1024;
         }

         result.model_ = this.model_;
         if ((from_bitField0_ & 2048) != 0) {
            to_bitField0_ |= 2048;
         }

         result.manufacturer_ = this.manufacturer_;
         if ((from_bitField0_ & 4096) != 0) {
            to_bitField0_ |= 4096;
         }

         result.buildProduct_ = this.buildProduct_;
         if ((from_bitField0_ & 8192) != 0) {
            result.otaInstalled_ = this.otaInstalled_;
            to_bitField0_ |= 8192;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public AndroidBuildProto.Builder clone() {
         return (AndroidBuildProto.Builder)super.clone();
      }

      public AndroidBuildProto.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (AndroidBuildProto.Builder)super.setField(field, value);
      }

      public AndroidBuildProto.Builder clearField(Descriptors.FieldDescriptor field) {
         return (AndroidBuildProto.Builder)super.clearField(field);
      }

      public AndroidBuildProto.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (AndroidBuildProto.Builder)super.clearOneof(oneof);
      }

      public AndroidBuildProto.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (AndroidBuildProto.Builder)super.setRepeatedField(field, index, value);
      }

      public AndroidBuildProto.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (AndroidBuildProto.Builder)super.addRepeatedField(field, value);
      }

      public AndroidBuildProto.Builder mergeFrom(Message other) {
         if (other instanceof AndroidBuildProto) {
            return this.mergeFrom((AndroidBuildProto)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public AndroidBuildProto.Builder mergeFrom(AndroidBuildProto other) {
         if (other == AndroidBuildProto.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasId()) {
               this.bitField0_ |= 1;
               this.id_ = other.id_;
               this.onChanged();
            }

            if (other.hasProduct()) {
               this.bitField0_ |= 2;
               this.product_ = other.product_;
               this.onChanged();
            }

            if (other.hasCarrier()) {
               this.bitField0_ |= 4;
               this.carrier_ = other.carrier_;
               this.onChanged();
            }

            if (other.hasRadio()) {
               this.bitField0_ |= 8;
               this.radio_ = other.radio_;
               this.onChanged();
            }

            if (other.hasBootloader()) {
               this.bitField0_ |= 16;
               this.bootloader_ = other.bootloader_;
               this.onChanged();
            }

            if (other.hasClient()) {
               this.bitField0_ |= 32;
               this.client_ = other.client_;
               this.onChanged();
            }

            if (other.hasTimestamp()) {
               this.setTimestamp(other.getTimestamp());
            }

            if (other.hasGoogleServices()) {
               this.setGoogleServices(other.getGoogleServices());
            }

            if (other.hasDevice()) {
               this.bitField0_ |= 256;
               this.device_ = other.device_;
               this.onChanged();
            }

            if (other.hasSdkVersion()) {
               this.setSdkVersion(other.getSdkVersion());
            }

            if (other.hasModel()) {
               this.bitField0_ |= 1024;
               this.model_ = other.model_;
               this.onChanged();
            }

            if (other.hasManufacturer()) {
               this.bitField0_ |= 2048;
               this.manufacturer_ = other.manufacturer_;
               this.onChanged();
            }

            if (other.hasBuildProduct()) {
               this.bitField0_ |= 4096;
               this.buildProduct_ = other.buildProduct_;
               this.onChanged();
            }

            if (other.hasOtaInstalled()) {
               this.setOtaInstalled(other.getOtaInstalled());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public AndroidBuildProto.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         AndroidBuildProto parsedMessage = null;

         try {
            parsedMessage = (AndroidBuildProto)AndroidBuildProto.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (AndroidBuildProto)var8.getUnfinishedMessage();
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

      public String getId() {
         Object ref = this.id_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.id_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getIdBytes() {
         Object ref = this.id_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.id_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidBuildProto.Builder setId(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.id_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidBuildProto.Builder clearId() {
         this.bitField0_ &= -2;
         this.id_ = AndroidBuildProto.getDefaultInstance().getId();
         this.onChanged();
         return this;
      }

      public AndroidBuildProto.Builder setIdBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.id_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasProduct() {
         return (this.bitField0_ & 2) != 0;
      }

      public String getProduct() {
         Object ref = this.product_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.product_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getProductBytes() {
         Object ref = this.product_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.product_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidBuildProto.Builder setProduct(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.product_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidBuildProto.Builder clearProduct() {
         this.bitField0_ &= -3;
         this.product_ = AndroidBuildProto.getDefaultInstance().getProduct();
         this.onChanged();
         return this;
      }

      public AndroidBuildProto.Builder setProductBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.product_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasCarrier() {
         return (this.bitField0_ & 4) != 0;
      }

      public String getCarrier() {
         Object ref = this.carrier_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.carrier_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getCarrierBytes() {
         Object ref = this.carrier_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.carrier_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidBuildProto.Builder setCarrier(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.carrier_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidBuildProto.Builder clearCarrier() {
         this.bitField0_ &= -5;
         this.carrier_ = AndroidBuildProto.getDefaultInstance().getCarrier();
         this.onChanged();
         return this;
      }

      public AndroidBuildProto.Builder setCarrierBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.carrier_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasRadio() {
         return (this.bitField0_ & 8) != 0;
      }

      public String getRadio() {
         Object ref = this.radio_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.radio_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getRadioBytes() {
         Object ref = this.radio_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.radio_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidBuildProto.Builder setRadio(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.radio_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidBuildProto.Builder clearRadio() {
         this.bitField0_ &= -9;
         this.radio_ = AndroidBuildProto.getDefaultInstance().getRadio();
         this.onChanged();
         return this;
      }

      public AndroidBuildProto.Builder setRadioBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.radio_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasBootloader() {
         return (this.bitField0_ & 16) != 0;
      }

      public String getBootloader() {
         Object ref = this.bootloader_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.bootloader_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getBootloaderBytes() {
         Object ref = this.bootloader_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.bootloader_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidBuildProto.Builder setBootloader(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16;
            this.bootloader_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidBuildProto.Builder clearBootloader() {
         this.bitField0_ &= -17;
         this.bootloader_ = AndroidBuildProto.getDefaultInstance().getBootloader();
         this.onChanged();
         return this;
      }

      public AndroidBuildProto.Builder setBootloaderBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16;
            this.bootloader_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasClient() {
         return (this.bitField0_ & 32) != 0;
      }

      public String getClient() {
         Object ref = this.client_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.client_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getClientBytes() {
         Object ref = this.client_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.client_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidBuildProto.Builder setClient(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 32;
            this.client_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidBuildProto.Builder clearClient() {
         this.bitField0_ &= -33;
         this.client_ = AndroidBuildProto.getDefaultInstance().getClient();
         this.onChanged();
         return this;
      }

      public AndroidBuildProto.Builder setClientBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 32;
            this.client_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasTimestamp() {
         return (this.bitField0_ & 64) != 0;
      }

      public long getTimestamp() {
         return this.timestamp_;
      }

      public AndroidBuildProto.Builder setTimestamp(long value) {
         this.bitField0_ |= 64;
         this.timestamp_ = value;
         this.onChanged();
         return this;
      }

      public AndroidBuildProto.Builder clearTimestamp() {
         this.bitField0_ &= -65;
         this.timestamp_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasGoogleServices() {
         return (this.bitField0_ & 128) != 0;
      }

      public int getGoogleServices() {
         return this.googleServices_;
      }

      public AndroidBuildProto.Builder setGoogleServices(int value) {
         this.bitField0_ |= 128;
         this.googleServices_ = value;
         this.onChanged();
         return this;
      }

      public AndroidBuildProto.Builder clearGoogleServices() {
         this.bitField0_ &= -129;
         this.googleServices_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasDevice() {
         return (this.bitField0_ & 256) != 0;
      }

      public String getDevice() {
         Object ref = this.device_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.device_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDeviceBytes() {
         Object ref = this.device_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.device_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidBuildProto.Builder setDevice(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 256;
            this.device_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidBuildProto.Builder clearDevice() {
         this.bitField0_ &= -257;
         this.device_ = AndroidBuildProto.getDefaultInstance().getDevice();
         this.onChanged();
         return this;
      }

      public AndroidBuildProto.Builder setDeviceBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 256;
            this.device_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasSdkVersion() {
         return (this.bitField0_ & 512) != 0;
      }

      public int getSdkVersion() {
         return this.sdkVersion_;
      }

      public AndroidBuildProto.Builder setSdkVersion(int value) {
         this.bitField0_ |= 512;
         this.sdkVersion_ = value;
         this.onChanged();
         return this;
      }

      public AndroidBuildProto.Builder clearSdkVersion() {
         this.bitField0_ &= -513;
         this.sdkVersion_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasModel() {
         return (this.bitField0_ & 1024) != 0;
      }

      public String getModel() {
         Object ref = this.model_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.model_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getModelBytes() {
         Object ref = this.model_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.model_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidBuildProto.Builder setModel(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1024;
            this.model_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidBuildProto.Builder clearModel() {
         this.bitField0_ &= -1025;
         this.model_ = AndroidBuildProto.getDefaultInstance().getModel();
         this.onChanged();
         return this;
      }

      public AndroidBuildProto.Builder setModelBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1024;
            this.model_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasManufacturer() {
         return (this.bitField0_ & 2048) != 0;
      }

      public String getManufacturer() {
         Object ref = this.manufacturer_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.manufacturer_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getManufacturerBytes() {
         Object ref = this.manufacturer_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.manufacturer_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidBuildProto.Builder setManufacturer(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2048;
            this.manufacturer_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidBuildProto.Builder clearManufacturer() {
         this.bitField0_ &= -2049;
         this.manufacturer_ = AndroidBuildProto.getDefaultInstance().getManufacturer();
         this.onChanged();
         return this;
      }

      public AndroidBuildProto.Builder setManufacturerBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2048;
            this.manufacturer_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasBuildProduct() {
         return (this.bitField0_ & 4096) != 0;
      }

      public String getBuildProduct() {
         Object ref = this.buildProduct_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.buildProduct_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getBuildProductBytes() {
         Object ref = this.buildProduct_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.buildProduct_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidBuildProto.Builder setBuildProduct(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4096;
            this.buildProduct_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidBuildProto.Builder clearBuildProduct() {
         this.bitField0_ &= -4097;
         this.buildProduct_ = AndroidBuildProto.getDefaultInstance().getBuildProduct();
         this.onChanged();
         return this;
      }

      public AndroidBuildProto.Builder setBuildProductBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4096;
            this.buildProduct_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasOtaInstalled() {
         return (this.bitField0_ & 8192) != 0;
      }

      public boolean getOtaInstalled() {
         return this.otaInstalled_;
      }

      public AndroidBuildProto.Builder setOtaInstalled(boolean value) {
         this.bitField0_ |= 8192;
         this.otaInstalled_ = value;
         this.onChanged();
         return this;
      }

      public AndroidBuildProto.Builder clearOtaInstalled() {
         this.bitField0_ &= -8193;
         this.otaInstalled_ = false;
         this.onChanged();
         return this;
      }

      public final AndroidBuildProto.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (AndroidBuildProto.Builder)super.setUnknownFields(unknownFields);
      }

      public final AndroidBuildProto.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (AndroidBuildProto.Builder)super.mergeUnknownFields(unknownFields);
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
