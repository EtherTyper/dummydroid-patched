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

public final class Annotations extends GeneratedMessageV3 implements AnnotationsOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int PRIVACYURL_FIELD_NUMBER = 18;
   private volatile Object privacyUrl_;
   private byte memoizedIsInitialized;
   private static final Annotations DEFAULT_INSTANCE = new Annotations();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public Annotations parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new Annotations(input, extensionRegistry);
      }
   };

   private Annotations(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private Annotations() {
      this.memoizedIsInitialized = -1;
      this.privacyUrl_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new Annotations();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private Annotations(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 146:
                  ByteString bs = input.readBytes();
                  this.bitField0_ |= 1;
                  this.privacyUrl_ = bs;
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
      return Mothership.internal_static_Annotations_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_Annotations_fieldAccessorTable.ensureFieldAccessorsInitialized(Annotations.class, Annotations.Builder.class);
   }

   public boolean hasPrivacyUrl() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getPrivacyUrl() {
      Object ref = this.privacyUrl_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.privacyUrl_ = s;
         }

         return s;
      }
   }

   public ByteString getPrivacyUrlBytes() {
      Object ref = this.privacyUrl_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.privacyUrl_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
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
         GeneratedMessageV3.writeString(output, 18, this.privacyUrl_);
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
            size += GeneratedMessageV3.computeStringSize(18, this.privacyUrl_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof Annotations)) {
         return super.equals(obj);
      } else {
         Annotations other = (Annotations)obj;
         if (this.hasPrivacyUrl() != other.hasPrivacyUrl()) {
            return false;
         } else if (this.hasPrivacyUrl() && !this.getPrivacyUrl().equals(other.getPrivacyUrl())) {
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
         if (this.hasPrivacyUrl()) {
            hash = 37 * hash + 18;
            hash = 53 * hash + this.getPrivacyUrl().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static Annotations parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (Annotations)PARSER.parseFrom(data);
   }

   public static Annotations parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Annotations)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Annotations parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (Annotations)PARSER.parseFrom(data);
   }

   public static Annotations parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Annotations)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Annotations parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (Annotations)PARSER.parseFrom(data);
   }

   public static Annotations parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Annotations)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Annotations parseFrom(InputStream input) throws IOException {
      return (Annotations)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Annotations parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Annotations)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static Annotations parseDelimitedFrom(InputStream input) throws IOException {
      return (Annotations)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static Annotations parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Annotations)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static Annotations parseFrom(CodedInputStream input) throws IOException {
      return (Annotations)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Annotations parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Annotations)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public Annotations.Builder newBuilderForType() {
      return newBuilder();
   }

   public static Annotations.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Annotations.Builder newBuilder(Annotations prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public Annotations.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new Annotations.Builder() : (new Annotations.Builder()).mergeFrom(this);
   }

   protected Annotations.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      Annotations.Builder builder = new Annotations.Builder(parent);
      return builder;
   }

   public static Annotations getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Annotations getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Annotations(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   Annotations(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements AnnotationsOrBuilder {
      private int bitField0_;
      private Object privacyUrl_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_Annotations_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_Annotations_fieldAccessorTable.ensureFieldAccessorsInitialized(Annotations.class, Annotations.Builder.class);
      }

      private Builder() {
         this.privacyUrl_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.privacyUrl_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (Annotations.alwaysUseFieldBuilders) {
         }

      }

      public Annotations.Builder clear() {
         super.clear();
         this.privacyUrl_ = "";
         this.bitField0_ &= -2;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_Annotations_descriptor;
      }

      public Annotations getDefaultInstanceForType() {
         return Annotations.getDefaultInstance();
      }

      public Annotations build() {
         Annotations result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public Annotations buildPartial() {
         Annotations result = new Annotations(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.privacyUrl_ = this.privacyUrl_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public Annotations.Builder clone() {
         return (Annotations.Builder)super.clone();
      }

      public Annotations.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (Annotations.Builder)super.setField(field, value);
      }

      public Annotations.Builder clearField(Descriptors.FieldDescriptor field) {
         return (Annotations.Builder)super.clearField(field);
      }

      public Annotations.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (Annotations.Builder)super.clearOneof(oneof);
      }

      public Annotations.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (Annotations.Builder)super.setRepeatedField(field, index, value);
      }

      public Annotations.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (Annotations.Builder)super.addRepeatedField(field, value);
      }

      public Annotations.Builder mergeFrom(Message other) {
         if (other instanceof Annotations) {
            return this.mergeFrom((Annotations)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public Annotations.Builder mergeFrom(Annotations other) {
         if (other == Annotations.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasPrivacyUrl()) {
               this.bitField0_ |= 1;
               this.privacyUrl_ = other.privacyUrl_;
               this.onChanged();
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public Annotations.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         Annotations parsedMessage = null;

         try {
            parsedMessage = (Annotations)Annotations.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (Annotations)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasPrivacyUrl() {
         return (this.bitField0_ & 1) != 0;
      }

      public String getPrivacyUrl() {
         Object ref = this.privacyUrl_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.privacyUrl_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getPrivacyUrlBytes() {
         Object ref = this.privacyUrl_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.privacyUrl_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Annotations.Builder setPrivacyUrl(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.privacyUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public Annotations.Builder clearPrivacyUrl() {
         this.bitField0_ &= -2;
         this.privacyUrl_ = Annotations.getDefaultInstance().getPrivacyUrl();
         this.onChanged();
         return this;
      }

      public Annotations.Builder setPrivacyUrlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.privacyUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public final Annotations.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (Annotations.Builder)super.setUnknownFields(unknownFields);
      }

      public final Annotations.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (Annotations.Builder)super.mergeUnknownFields(unknownFields);
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
