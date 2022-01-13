package de.onyxbits.raccoon.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ListResponse extends GeneratedMessageV3 implements ListResponseOrBuilder {
   private static final long serialVersionUID = 0L;
   public static final int DOC_FIELD_NUMBER = 2;
   private List doc_;
   private byte memoizedIsInitialized;
   private static final ListResponse DEFAULT_INSTANCE = new ListResponse();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public ListResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new ListResponse(input, extensionRegistry);
      }
   };

   private ListResponse(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private ListResponse() {
      this.memoizedIsInitialized = -1;
      this.doc_ = Collections.emptyList();
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new ListResponse();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private ListResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 18:
                  if (!(mutable_bitField0_ & true)) {
                     this.doc_ = new ArrayList();
                     mutable_bitField0_ |= true;
                  }

                  this.doc_.add(input.readMessage(DocV2.PARSER, extensionRegistry));
                  break;
               default:
                  if (!this.parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                     done = true;
                  }
               }
            }
         } catch (InvalidProtocolBufferException var11) {
            throw var11.setUnfinishedMessage(this);
         } catch (IOException var12) {
            throw (new InvalidProtocolBufferException(var12)).setUnfinishedMessage(this);
         } finally {
            if (mutable_bitField0_ & true) {
               this.doc_ = Collections.unmodifiableList(this.doc_);
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_ListResponse_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_ListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ListResponse.class, ListResponse.Builder.class);
   }

   public List getDocList() {
      return this.doc_;
   }

   public List getDocOrBuilderList() {
      return this.doc_;
   }

   public int getDocCount() {
      return this.doc_.size();
   }

   public DocV2 getDoc(int index) {
      return (DocV2)this.doc_.get(index);
   }

   public DocV2OrBuilder getDocOrBuilder(int index) {
      return (DocV2OrBuilder)this.doc_.get(index);
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
      for(int i = 0; i < this.doc_.size(); ++i) {
         output.writeMessage(2, (MessageLite)this.doc_.get(i));
      }

      this.unknownFields.writeTo(output);
   }

   public int getSerializedSize() {
      int size = this.memoizedSize;
      if (size != -1) {
         return size;
      } else {
         size = 0;

         for(int i = 0; i < this.doc_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(2, (MessageLite)this.doc_.get(i));
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof ListResponse)) {
         return super.equals(obj);
      } else {
         ListResponse other = (ListResponse)obj;
         if (!this.getDocList().equals(other.getDocList())) {
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
         if (this.getDocCount() > 0) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getDocList().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static ListResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (ListResponse)PARSER.parseFrom(data);
   }

   public static ListResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ListResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ListResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (ListResponse)PARSER.parseFrom(data);
   }

   public static ListResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ListResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ListResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (ListResponse)PARSER.parseFrom(data);
   }

   public static ListResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ListResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ListResponse parseFrom(InputStream input) throws IOException {
      return (ListResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ListResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ListResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static ListResponse parseDelimitedFrom(InputStream input) throws IOException {
      return (ListResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static ListResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ListResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static ListResponse parseFrom(CodedInputStream input) throws IOException {
      return (ListResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ListResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ListResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public ListResponse.Builder newBuilderForType() {
      return newBuilder();
   }

   public static ListResponse.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static ListResponse.Builder newBuilder(ListResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public ListResponse.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new ListResponse.Builder() : (new ListResponse.Builder()).mergeFrom(this);
   }

   protected ListResponse.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      ListResponse.Builder builder = new ListResponse.Builder(parent);
      return builder;
   }

   public static ListResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public ListResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   ListResponse(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   ListResponse(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements ListResponseOrBuilder {
      private int bitField0_;
      private List doc_;
      private RepeatedFieldBuilderV3 docBuilder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_ListResponse_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_ListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ListResponse.class, ListResponse.Builder.class);
      }

      private Builder() {
         this.doc_ = Collections.emptyList();
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.doc_ = Collections.emptyList();
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (ListResponse.alwaysUseFieldBuilders) {
            this.getDocFieldBuilder();
         }

      }

      public ListResponse.Builder clear() {
         super.clear();
         if (this.docBuilder_ == null) {
            this.doc_ = Collections.emptyList();
            this.bitField0_ &= -2;
         } else {
            this.docBuilder_.clear();
         }

         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_ListResponse_descriptor;
      }

      public ListResponse getDefaultInstanceForType() {
         return ListResponse.getDefaultInstance();
      }

      public ListResponse build() {
         ListResponse result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public ListResponse buildPartial() {
         ListResponse result = new ListResponse(this);
         int from_bitField0_ = this.bitField0_;
         if (this.docBuilder_ == null) {
            if ((this.bitField0_ & 1) != 0) {
               this.doc_ = Collections.unmodifiableList(this.doc_);
               this.bitField0_ &= -2;
            }

            result.doc_ = this.doc_;
         } else {
            result.doc_ = this.docBuilder_.build();
         }

         this.onBuilt();
         return result;
      }

      public ListResponse.Builder clone() {
         return (ListResponse.Builder)super.clone();
      }

      public ListResponse.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (ListResponse.Builder)super.setField(field, value);
      }

      public ListResponse.Builder clearField(Descriptors.FieldDescriptor field) {
         return (ListResponse.Builder)super.clearField(field);
      }

      public ListResponse.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (ListResponse.Builder)super.clearOneof(oneof);
      }

      public ListResponse.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (ListResponse.Builder)super.setRepeatedField(field, index, value);
      }

      public ListResponse.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (ListResponse.Builder)super.addRepeatedField(field, value);
      }

      public ListResponse.Builder mergeFrom(Message other) {
         if (other instanceof ListResponse) {
            return this.mergeFrom((ListResponse)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public ListResponse.Builder mergeFrom(ListResponse other) {
         if (other == ListResponse.getDefaultInstance()) {
            return this;
         } else {
            if (this.docBuilder_ == null) {
               if (!other.doc_.isEmpty()) {
                  if (this.doc_.isEmpty()) {
                     this.doc_ = other.doc_;
                     this.bitField0_ &= -2;
                  } else {
                     this.ensureDocIsMutable();
                     this.doc_.addAll(other.doc_);
                  }

                  this.onChanged();
               }
            } else if (!other.doc_.isEmpty()) {
               if (this.docBuilder_.isEmpty()) {
                  this.docBuilder_.dispose();
                  this.docBuilder_ = null;
                  this.doc_ = other.doc_;
                  this.bitField0_ &= -2;
                  this.docBuilder_ = ListResponse.alwaysUseFieldBuilders ? this.getDocFieldBuilder() : null;
               } else {
                  this.docBuilder_.addAllMessages(other.doc_);
               }
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public ListResponse.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         ListResponse parsedMessage = null;

         try {
            parsedMessage = (ListResponse)ListResponse.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (ListResponse)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      private void ensureDocIsMutable() {
         if ((this.bitField0_ & 1) == 0) {
            this.doc_ = new ArrayList(this.doc_);
            this.bitField0_ |= 1;
         }

      }

      public List getDocList() {
         return this.docBuilder_ == null ? Collections.unmodifiableList(this.doc_) : this.docBuilder_.getMessageList();
      }

      public int getDocCount() {
         return this.docBuilder_ == null ? this.doc_.size() : this.docBuilder_.getCount();
      }

      public DocV2 getDoc(int index) {
         return this.docBuilder_ == null ? (DocV2)this.doc_.get(index) : (DocV2)this.docBuilder_.getMessage(index);
      }

      public ListResponse.Builder setDoc(int index, DocV2 value) {
         if (this.docBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureDocIsMutable();
            this.doc_.set(index, value);
            this.onChanged();
         } else {
            this.docBuilder_.setMessage(index, value);
         }

         return this;
      }

      public ListResponse.Builder setDoc(int index, DocV2.Builder builderForValue) {
         if (this.docBuilder_ == null) {
            this.ensureDocIsMutable();
            this.doc_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.docBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public ListResponse.Builder addDoc(DocV2 value) {
         if (this.docBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureDocIsMutable();
            this.doc_.add(value);
            this.onChanged();
         } else {
            this.docBuilder_.addMessage(value);
         }

         return this;
      }

      public ListResponse.Builder addDoc(int index, DocV2 value) {
         if (this.docBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureDocIsMutable();
            this.doc_.add(index, value);
            this.onChanged();
         } else {
            this.docBuilder_.addMessage(index, value);
         }

         return this;
      }

      public ListResponse.Builder addDoc(DocV2.Builder builderForValue) {
         if (this.docBuilder_ == null) {
            this.ensureDocIsMutable();
            this.doc_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.docBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public ListResponse.Builder addDoc(int index, DocV2.Builder builderForValue) {
         if (this.docBuilder_ == null) {
            this.ensureDocIsMutable();
            this.doc_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.docBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public ListResponse.Builder addAllDoc(Iterable values) {
         if (this.docBuilder_ == null) {
            this.ensureDocIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.doc_);
            this.onChanged();
         } else {
            this.docBuilder_.addAllMessages(values);
         }

         return this;
      }

      public ListResponse.Builder clearDoc() {
         if (this.docBuilder_ == null) {
            this.doc_ = Collections.emptyList();
            this.bitField0_ &= -2;
            this.onChanged();
         } else {
            this.docBuilder_.clear();
         }

         return this;
      }

      public ListResponse.Builder removeDoc(int index) {
         if (this.docBuilder_ == null) {
            this.ensureDocIsMutable();
            this.doc_.remove(index);
            this.onChanged();
         } else {
            this.docBuilder_.remove(index);
         }

         return this;
      }

      public DocV2.Builder getDocBuilder(int index) {
         return (DocV2.Builder)this.getDocFieldBuilder().getBuilder(index);
      }

      public DocV2OrBuilder getDocOrBuilder(int index) {
         return this.docBuilder_ == null ? (DocV2OrBuilder)this.doc_.get(index) : (DocV2OrBuilder)this.docBuilder_.getMessageOrBuilder(index);
      }

      public List getDocOrBuilderList() {
         return this.docBuilder_ != null ? this.docBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.doc_);
      }

      public DocV2.Builder addDocBuilder() {
         return (DocV2.Builder)this.getDocFieldBuilder().addBuilder(DocV2.getDefaultInstance());
      }

      public DocV2.Builder addDocBuilder(int index) {
         return (DocV2.Builder)this.getDocFieldBuilder().addBuilder(index, DocV2.getDefaultInstance());
      }

      public List getDocBuilderList() {
         return this.getDocFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getDocFieldBuilder() {
         if (this.docBuilder_ == null) {
            this.docBuilder_ = new RepeatedFieldBuilderV3(this.doc_, (this.bitField0_ & 1) != 0, this.getParentForChildren(), this.isClean());
            this.doc_ = null;
         }

         return this.docBuilder_;
      }

      public final ListResponse.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (ListResponse.Builder)super.setUnknownFields(unknownFields);
      }

      public final ListResponse.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (ListResponse.Builder)super.mergeUnknownFields(unknownFields);
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
