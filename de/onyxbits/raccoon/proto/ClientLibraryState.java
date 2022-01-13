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

public final class ClientLibraryState extends GeneratedMessageV3 implements ClientLibraryStateOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int CORPUS_FIELD_NUMBER = 1;
   private int corpus_;
   public static final int SERVERTOKEN_FIELD_NUMBER = 2;
   private ByteString serverToken_;
   public static final int HASHCODESUM_FIELD_NUMBER = 3;
   private long hashcodesum_;
   public static final int LIBRARYSIZE_FIELD_NUMBER = 4;
   private int librarySize_;
   public static final int LIBRARYID_FIELD_NUMBER = 5;
   private volatile Object libraryId_;
   private byte memoizedIsInitialized;
   private static final ClientLibraryState DEFAULT_INSTANCE = new ClientLibraryState();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public ClientLibraryState parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new ClientLibraryState(input, extensionRegistry);
      }
   };

   private ClientLibraryState(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private ClientLibraryState() {
      this.memoizedIsInitialized = -1;
      this.serverToken_ = ByteString.EMPTY;
      this.libraryId_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new ClientLibraryState();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private ClientLibraryState(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 8:
                  this.bitField0_ |= 1;
                  this.corpus_ = input.readInt32();
                  break;
               case 18:
                  this.bitField0_ |= 2;
                  this.serverToken_ = input.readBytes();
                  break;
               case 24:
                  this.bitField0_ |= 4;
                  this.hashcodesum_ = input.readInt64();
                  break;
               case 32:
                  this.bitField0_ |= 8;
                  this.librarySize_ = input.readInt32();
                  break;
               case 42:
                  ByteString bs = input.readBytes();
                  this.bitField0_ |= 16;
                  this.libraryId_ = bs;
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
      return Mothership.internal_static_ClientLibraryState_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_ClientLibraryState_fieldAccessorTable.ensureFieldAccessorsInitialized(ClientLibraryState.class, ClientLibraryState.Builder.class);
   }

   public boolean hasCorpus() {
      return (this.bitField0_ & 1) != 0;
   }

   public int getCorpus() {
      return this.corpus_;
   }

   public boolean hasServerToken() {
      return (this.bitField0_ & 2) != 0;
   }

   public ByteString getServerToken() {
      return this.serverToken_;
   }

   public boolean hasHashcodesum() {
      return (this.bitField0_ & 4) != 0;
   }

   public long getHashcodesum() {
      return this.hashcodesum_;
   }

   public boolean hasLibrarySize() {
      return (this.bitField0_ & 8) != 0;
   }

   public int getLibrarySize() {
      return this.librarySize_;
   }

   public boolean hasLibraryId() {
      return (this.bitField0_ & 16) != 0;
   }

   public String getLibraryId() {
      Object ref = this.libraryId_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.libraryId_ = s;
         }

         return s;
      }
   }

   public ByteString getLibraryIdBytes() {
      Object ref = this.libraryId_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.libraryId_ = b;
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
         output.writeInt32(1, this.corpus_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeBytes(2, this.serverToken_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeInt64(3, this.hashcodesum_);
      }

      if ((this.bitField0_ & 8) != 0) {
         output.writeInt32(4, this.librarySize_);
      }

      if ((this.bitField0_ & 16) != 0) {
         GeneratedMessageV3.writeString(output, 5, this.libraryId_);
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
            size += CodedOutputStream.computeInt32Size(1, this.corpus_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeBytesSize(2, this.serverToken_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeInt64Size(3, this.hashcodesum_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += CodedOutputStream.computeInt32Size(4, this.librarySize_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += GeneratedMessageV3.computeStringSize(5, this.libraryId_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof ClientLibraryState)) {
         return super.equals(obj);
      } else {
         ClientLibraryState other = (ClientLibraryState)obj;
         if (this.hasCorpus() != other.hasCorpus()) {
            return false;
         } else if (this.hasCorpus() && this.getCorpus() != other.getCorpus()) {
            return false;
         } else if (this.hasServerToken() != other.hasServerToken()) {
            return false;
         } else if (this.hasServerToken() && !this.getServerToken().equals(other.getServerToken())) {
            return false;
         } else if (this.hasHashcodesum() != other.hasHashcodesum()) {
            return false;
         } else if (this.hasHashcodesum() && this.getHashcodesum() != other.getHashcodesum()) {
            return false;
         } else if (this.hasLibrarySize() != other.hasLibrarySize()) {
            return false;
         } else if (this.hasLibrarySize() && this.getLibrarySize() != other.getLibrarySize()) {
            return false;
         } else if (this.hasLibraryId() != other.hasLibraryId()) {
            return false;
         } else if (this.hasLibraryId() && !this.getLibraryId().equals(other.getLibraryId())) {
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
         if (this.hasCorpus()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getCorpus();
         }

         if (this.hasServerToken()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getServerToken().hashCode();
         }

         if (this.hasHashcodesum()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + Internal.hashLong(this.getHashcodesum());
         }

         if (this.hasLibrarySize()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getLibrarySize();
         }

         if (this.hasLibraryId()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getLibraryId().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static ClientLibraryState parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (ClientLibraryState)PARSER.parseFrom(data);
   }

   public static ClientLibraryState parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ClientLibraryState)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ClientLibraryState parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (ClientLibraryState)PARSER.parseFrom(data);
   }

   public static ClientLibraryState parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ClientLibraryState)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ClientLibraryState parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (ClientLibraryState)PARSER.parseFrom(data);
   }

   public static ClientLibraryState parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ClientLibraryState)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ClientLibraryState parseFrom(InputStream input) throws IOException {
      return (ClientLibraryState)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ClientLibraryState parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ClientLibraryState)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static ClientLibraryState parseDelimitedFrom(InputStream input) throws IOException {
      return (ClientLibraryState)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static ClientLibraryState parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ClientLibraryState)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static ClientLibraryState parseFrom(CodedInputStream input) throws IOException {
      return (ClientLibraryState)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ClientLibraryState parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ClientLibraryState)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public ClientLibraryState.Builder newBuilderForType() {
      return newBuilder();
   }

   public static ClientLibraryState.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static ClientLibraryState.Builder newBuilder(ClientLibraryState prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public ClientLibraryState.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new ClientLibraryState.Builder() : (new ClientLibraryState.Builder()).mergeFrom(this);
   }

   protected ClientLibraryState.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      ClientLibraryState.Builder builder = new ClientLibraryState.Builder(parent);
      return builder;
   }

   public static ClientLibraryState getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public ClientLibraryState getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   ClientLibraryState(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   ClientLibraryState(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements ClientLibraryStateOrBuilder {
      private int bitField0_;
      private int corpus_;
      private ByteString serverToken_;
      private long hashcodesum_;
      private int librarySize_;
      private Object libraryId_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_ClientLibraryState_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_ClientLibraryState_fieldAccessorTable.ensureFieldAccessorsInitialized(ClientLibraryState.class, ClientLibraryState.Builder.class);
      }

      private Builder() {
         this.serverToken_ = ByteString.EMPTY;
         this.libraryId_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.serverToken_ = ByteString.EMPTY;
         this.libraryId_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (ClientLibraryState.alwaysUseFieldBuilders) {
         }

      }

      public ClientLibraryState.Builder clear() {
         super.clear();
         this.corpus_ = 0;
         this.bitField0_ &= -2;
         this.serverToken_ = ByteString.EMPTY;
         this.bitField0_ &= -3;
         this.hashcodesum_ = 0L;
         this.bitField0_ &= -5;
         this.librarySize_ = 0;
         this.bitField0_ &= -9;
         this.libraryId_ = "";
         this.bitField0_ &= -17;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_ClientLibraryState_descriptor;
      }

      public ClientLibraryState getDefaultInstanceForType() {
         return ClientLibraryState.getDefaultInstance();
      }

      public ClientLibraryState build() {
         ClientLibraryState result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public ClientLibraryState buildPartial() {
         ClientLibraryState result = new ClientLibraryState(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.corpus_ = this.corpus_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            to_bitField0_ |= 2;
         }

         result.serverToken_ = this.serverToken_;
         if ((from_bitField0_ & 4) != 0) {
            result.hashcodesum_ = this.hashcodesum_;
            to_bitField0_ |= 4;
         }

         if ((from_bitField0_ & 8) != 0) {
            result.librarySize_ = this.librarySize_;
            to_bitField0_ |= 8;
         }

         if ((from_bitField0_ & 16) != 0) {
            to_bitField0_ |= 16;
         }

         result.libraryId_ = this.libraryId_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public ClientLibraryState.Builder clone() {
         return (ClientLibraryState.Builder)super.clone();
      }

      public ClientLibraryState.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (ClientLibraryState.Builder)super.setField(field, value);
      }

      public ClientLibraryState.Builder clearField(Descriptors.FieldDescriptor field) {
         return (ClientLibraryState.Builder)super.clearField(field);
      }

      public ClientLibraryState.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (ClientLibraryState.Builder)super.clearOneof(oneof);
      }

      public ClientLibraryState.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (ClientLibraryState.Builder)super.setRepeatedField(field, index, value);
      }

      public ClientLibraryState.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (ClientLibraryState.Builder)super.addRepeatedField(field, value);
      }

      public ClientLibraryState.Builder mergeFrom(Message other) {
         if (other instanceof ClientLibraryState) {
            return this.mergeFrom((ClientLibraryState)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public ClientLibraryState.Builder mergeFrom(ClientLibraryState other) {
         if (other == ClientLibraryState.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasCorpus()) {
               this.setCorpus(other.getCorpus());
            }

            if (other.hasServerToken()) {
               this.setServerToken(other.getServerToken());
            }

            if (other.hasHashcodesum()) {
               this.setHashcodesum(other.getHashcodesum());
            }

            if (other.hasLibrarySize()) {
               this.setLibrarySize(other.getLibrarySize());
            }

            if (other.hasLibraryId()) {
               this.bitField0_ |= 16;
               this.libraryId_ = other.libraryId_;
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

      public ClientLibraryState.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         ClientLibraryState parsedMessage = null;

         try {
            parsedMessage = (ClientLibraryState)ClientLibraryState.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (ClientLibraryState)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasCorpus() {
         return (this.bitField0_ & 1) != 0;
      }

      public int getCorpus() {
         return this.corpus_;
      }

      public ClientLibraryState.Builder setCorpus(int value) {
         this.bitField0_ |= 1;
         this.corpus_ = value;
         this.onChanged();
         return this;
      }

      public ClientLibraryState.Builder clearCorpus() {
         this.bitField0_ &= -2;
         this.corpus_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasServerToken() {
         return (this.bitField0_ & 2) != 0;
      }

      public ByteString getServerToken() {
         return this.serverToken_;
      }

      public ClientLibraryState.Builder setServerToken(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.serverToken_ = value;
            this.onChanged();
            return this;
         }
      }

      public ClientLibraryState.Builder clearServerToken() {
         this.bitField0_ &= -3;
         this.serverToken_ = ClientLibraryState.getDefaultInstance().getServerToken();
         this.onChanged();
         return this;
      }

      public boolean hasHashcodesum() {
         return (this.bitField0_ & 4) != 0;
      }

      public long getHashcodesum() {
         return this.hashcodesum_;
      }

      public ClientLibraryState.Builder setHashcodesum(long value) {
         this.bitField0_ |= 4;
         this.hashcodesum_ = value;
         this.onChanged();
         return this;
      }

      public ClientLibraryState.Builder clearHashcodesum() {
         this.bitField0_ &= -5;
         this.hashcodesum_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasLibrarySize() {
         return (this.bitField0_ & 8) != 0;
      }

      public int getLibrarySize() {
         return this.librarySize_;
      }

      public ClientLibraryState.Builder setLibrarySize(int value) {
         this.bitField0_ |= 8;
         this.librarySize_ = value;
         this.onChanged();
         return this;
      }

      public ClientLibraryState.Builder clearLibrarySize() {
         this.bitField0_ &= -9;
         this.librarySize_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasLibraryId() {
         return (this.bitField0_ & 16) != 0;
      }

      public String getLibraryId() {
         Object ref = this.libraryId_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.libraryId_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getLibraryIdBytes() {
         Object ref = this.libraryId_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.libraryId_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public ClientLibraryState.Builder setLibraryId(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16;
            this.libraryId_ = value;
            this.onChanged();
            return this;
         }
      }

      public ClientLibraryState.Builder clearLibraryId() {
         this.bitField0_ &= -17;
         this.libraryId_ = ClientLibraryState.getDefaultInstance().getLibraryId();
         this.onChanged();
         return this;
      }

      public ClientLibraryState.Builder setLibraryIdBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16;
            this.libraryId_ = value;
            this.onChanged();
            return this;
         }
      }

      public final ClientLibraryState.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (ClientLibraryState.Builder)super.setUnknownFields(unknownFields);
      }

      public final ClientLibraryState.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (ClientLibraryState.Builder)super.mergeUnknownFields(unknownFields);
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
