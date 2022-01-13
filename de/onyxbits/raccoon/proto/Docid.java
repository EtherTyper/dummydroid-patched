package de.onyxbits.raccoon.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Docid extends GeneratedMessageV3 implements DocidOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int BACKENDDOCID_FIELD_NUMBER = 1;
   private volatile Object backendDocId_;
   public static final int TYPE_FIELD_NUMBER = 2;
   private int type_;
   public static final int BACKEND_FIELD_NUMBER = 3;
   private int backend_;
   private byte memoizedIsInitialized;
   private static final Docid DEFAULT_INSTANCE = new Docid();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public Docid parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new Docid(input, extensionRegistry);
      }
   };

   private Docid(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private Docid() {
      this.memoizedIsInitialized = -1;
      this.backendDocId_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new Docid();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private Docid(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               switch(tag) {
               case 0:
                  done = true;
                  break;
               case 10:
                  ByteString bs = input.readBytes();
                  this.bitField0_ |= 1;
                  this.backendDocId_ = bs;
                  break;
               case 16:
                  this.bitField0_ |= 2;
                  this.type_ = input.readInt32();
                  break;
               case 24:
                  this.bitField0_ |= 4;
                  this.backend_ = input.readInt32();
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
      return Mothership.internal_static_Docid_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_Docid_fieldAccessorTable.ensureFieldAccessorsInitialized(Docid.class, Docid.Builder.class);
   }

   public boolean hasBackendDocId() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getBackendDocId() {
      Object ref = this.backendDocId_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.backendDocId_ = s;
         }

         return s;
      }
   }

   public ByteString getBackendDocIdBytes() {
      Object ref = this.backendDocId_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.backendDocId_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasType() {
      return (this.bitField0_ & 2) != 0;
   }

   public int getType() {
      return this.type_;
   }

   public boolean hasBackend() {
      return (this.bitField0_ & 4) != 0;
   }

   public int getBackend() {
      return this.backend_;
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
         GeneratedMessageV3.writeString(output, 1, this.backendDocId_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeInt32(2, this.type_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeInt32(3, this.backend_);
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
            size += GeneratedMessageV3.computeStringSize(1, this.backendDocId_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeInt32Size(2, this.type_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeInt32Size(3, this.backend_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof Docid)) {
         return super.equals(obj);
      } else {
         Docid other = (Docid)obj;
         if (this.hasBackendDocId() != other.hasBackendDocId()) {
            return false;
         } else if (this.hasBackendDocId() && !this.getBackendDocId().equals(other.getBackendDocId())) {
            return false;
         } else if (this.hasType() != other.hasType()) {
            return false;
         } else if (this.hasType() && this.getType() != other.getType()) {
            return false;
         } else if (this.hasBackend() != other.hasBackend()) {
            return false;
         } else if (this.hasBackend() && this.getBackend() != other.getBackend()) {
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
         if (this.hasBackendDocId()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getBackendDocId().hashCode();
         }

         if (this.hasType()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getType();
         }

         if (this.hasBackend()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getBackend();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static Docid parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (Docid)PARSER.parseFrom(data);
   }

   public static Docid parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Docid)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Docid parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (Docid)PARSER.parseFrom(data);
   }

   public static Docid parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Docid)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Docid parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (Docid)PARSER.parseFrom(data);
   }

   public static Docid parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Docid)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Docid parseFrom(InputStream input) throws IOException {
      return (Docid)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Docid parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Docid)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static Docid parseDelimitedFrom(InputStream input) throws IOException {
      return (Docid)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static Docid parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Docid)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static Docid parseFrom(CodedInputStream input) throws IOException {
      return (Docid)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Docid parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Docid)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public Docid.Builder newBuilderForType() {
      return newBuilder();
   }

   public static Docid.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Docid.Builder newBuilder(Docid prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public Docid.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new Docid.Builder() : (new Docid.Builder()).mergeFrom(this);
   }

   protected Docid.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      Docid.Builder builder = new Docid.Builder(parent);
      return builder;
   }

   public static Docid getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Docid getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Docid(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   Docid(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements DocidOrBuilder {
      private int bitField0_;
      private Object backendDocId_;
      private int type_;
      private int backend_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_Docid_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_Docid_fieldAccessorTable.ensureFieldAccessorsInitialized(Docid.class, Docid.Builder.class);
      }

      private Builder() {
         this.backendDocId_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.backendDocId_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (Docid.alwaysUseFieldBuilders) {
         }

      }

      public Docid.Builder clear() {
         super.clear();
         this.backendDocId_ = "";
         this.bitField0_ &= -2;
         this.type_ = 0;
         this.bitField0_ &= -3;
         this.backend_ = 0;
         this.bitField0_ &= -5;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_Docid_descriptor;
      }

      public Docid getDefaultInstanceForType() {
         return Docid.getDefaultInstance();
      }

      public Docid build() {
         Docid result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public Docid buildPartial() {
         Docid result = new Docid(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.backendDocId_ = this.backendDocId_;
         if ((from_bitField0_ & 2) != 0) {
            result.type_ = this.type_;
            to_bitField0_ |= 2;
         }

         if ((from_bitField0_ & 4) != 0) {
            result.backend_ = this.backend_;
            to_bitField0_ |= 4;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public Docid.Builder clone() {
         return (Docid.Builder)super.clone();
      }

      public Docid.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (Docid.Builder)super.setField(field, value);
      }

      public Docid.Builder clearField(Descriptors.FieldDescriptor field) {
         return (Docid.Builder)super.clearField(field);
      }

      public Docid.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (Docid.Builder)super.clearOneof(oneof);
      }

      public Docid.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (Docid.Builder)super.setRepeatedField(field, index, value);
      }

      public Docid.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (Docid.Builder)super.addRepeatedField(field, value);
      }

      public Docid.Builder mergeFrom(Message other) {
         if (other instanceof Docid) {
            return this.mergeFrom((Docid)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public Docid.Builder mergeFrom(Docid other) {
         if (other == Docid.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasBackendDocId()) {
               this.bitField0_ |= 1;
               this.backendDocId_ = other.backendDocId_;
               this.onChanged();
            }

            if (other.hasType()) {
               this.setType(other.getType());
            }

            if (other.hasBackend()) {
               this.setBackend(other.getBackend());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public Docid.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         Docid parsedMessage = null;

         try {
            parsedMessage = (Docid)Docid.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (Docid)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasBackendDocId() {
         return (this.bitField0_ & 1) != 0;
      }

      public String getBackendDocId() {
         Object ref = this.backendDocId_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.backendDocId_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getBackendDocIdBytes() {
         Object ref = this.backendDocId_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.backendDocId_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Docid.Builder setBackendDocId(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.backendDocId_ = value;
            this.onChanged();
            return this;
         }
      }

      public Docid.Builder clearBackendDocId() {
         this.bitField0_ &= -2;
         this.backendDocId_ = Docid.getDefaultInstance().getBackendDocId();
         this.onChanged();
         return this;
      }

      public Docid.Builder setBackendDocIdBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.backendDocId_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasType() {
         return (this.bitField0_ & 2) != 0;
      }

      public int getType() {
         return this.type_;
      }

      public Docid.Builder setType(int value) {
         this.bitField0_ |= 2;
         this.type_ = value;
         this.onChanged();
         return this;
      }

      public Docid.Builder clearType() {
         this.bitField0_ &= -3;
         this.type_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasBackend() {
         return (this.bitField0_ & 4) != 0;
      }

      public int getBackend() {
         return this.backend_;
      }

      public Docid.Builder setBackend(int value) {
         this.bitField0_ |= 4;
         this.backend_ = value;
         this.onChanged();
         return this;
      }

      public Docid.Builder clearBackend() {
         this.bitField0_ &= -5;
         this.backend_ = 0;
         this.onChanged();
         return this;
      }

      public final Docid.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (Docid.Builder)super.setUnknownFields(unknownFields);
      }

      public final Docid.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (Docid.Builder)super.mergeUnknownFields(unknownFields);
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
