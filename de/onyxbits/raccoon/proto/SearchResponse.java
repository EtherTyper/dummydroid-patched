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

public final class SearchResponse extends GeneratedMessageV3 implements SearchResponseOrBuilder {
   private static final long serialVersionUID = 0L;
   public static final int DOC_FIELD_NUMBER = 5;
   private List doc_;
   private byte memoizedIsInitialized;
   private static final SearchResponse DEFAULT_INSTANCE = new SearchResponse();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public SearchResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new SearchResponse(input, extensionRegistry);
      }
   };

   private SearchResponse(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private SearchResponse() {
      this.memoizedIsInitialized = -1;
      this.doc_ = Collections.emptyList();
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new SearchResponse();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private SearchResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 42:
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
      return Mothership.internal_static_SearchResponse_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_SearchResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SearchResponse.class, SearchResponse.Builder.class);
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
         output.writeMessage(5, (MessageLite)this.doc_.get(i));
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
            size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.doc_.get(i));
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof SearchResponse)) {
         return super.equals(obj);
      } else {
         SearchResponse other = (SearchResponse)obj;
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
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getDocList().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static SearchResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (SearchResponse)PARSER.parseFrom(data);
   }

   public static SearchResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (SearchResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static SearchResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (SearchResponse)PARSER.parseFrom(data);
   }

   public static SearchResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (SearchResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static SearchResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (SearchResponse)PARSER.parseFrom(data);
   }

   public static SearchResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (SearchResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static SearchResponse parseFrom(InputStream input) throws IOException {
      return (SearchResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static SearchResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (SearchResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static SearchResponse parseDelimitedFrom(InputStream input) throws IOException {
      return (SearchResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static SearchResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (SearchResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static SearchResponse parseFrom(CodedInputStream input) throws IOException {
      return (SearchResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static SearchResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (SearchResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public SearchResponse.Builder newBuilderForType() {
      return newBuilder();
   }

   public static SearchResponse.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static SearchResponse.Builder newBuilder(SearchResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public SearchResponse.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new SearchResponse.Builder() : (new SearchResponse.Builder()).mergeFrom(this);
   }

   protected SearchResponse.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      SearchResponse.Builder builder = new SearchResponse.Builder(parent);
      return builder;
   }

   public static SearchResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public SearchResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   SearchResponse(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   SearchResponse(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements SearchResponseOrBuilder {
      private int bitField0_;
      private List doc_;
      private RepeatedFieldBuilderV3 docBuilder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_SearchResponse_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_SearchResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SearchResponse.class, SearchResponse.Builder.class);
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
         if (SearchResponse.alwaysUseFieldBuilders) {
            this.getDocFieldBuilder();
         }

      }

      public SearchResponse.Builder clear() {
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
         return Mothership.internal_static_SearchResponse_descriptor;
      }

      public SearchResponse getDefaultInstanceForType() {
         return SearchResponse.getDefaultInstance();
      }

      public SearchResponse build() {
         SearchResponse result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public SearchResponse buildPartial() {
         SearchResponse result = new SearchResponse(this);
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

      public SearchResponse.Builder clone() {
         return (SearchResponse.Builder)super.clone();
      }

      public SearchResponse.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (SearchResponse.Builder)super.setField(field, value);
      }

      public SearchResponse.Builder clearField(Descriptors.FieldDescriptor field) {
         return (SearchResponse.Builder)super.clearField(field);
      }

      public SearchResponse.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (SearchResponse.Builder)super.clearOneof(oneof);
      }

      public SearchResponse.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (SearchResponse.Builder)super.setRepeatedField(field, index, value);
      }

      public SearchResponse.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (SearchResponse.Builder)super.addRepeatedField(field, value);
      }

      public SearchResponse.Builder mergeFrom(Message other) {
         if (other instanceof SearchResponse) {
            return this.mergeFrom((SearchResponse)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public SearchResponse.Builder mergeFrom(SearchResponse other) {
         if (other == SearchResponse.getDefaultInstance()) {
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
                  this.docBuilder_ = SearchResponse.alwaysUseFieldBuilders ? this.getDocFieldBuilder() : null;
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

      public SearchResponse.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         SearchResponse parsedMessage = null;

         try {
            parsedMessage = (SearchResponse)SearchResponse.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (SearchResponse)var8.getUnfinishedMessage();
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

      public SearchResponse.Builder setDoc(int index, DocV2 value) {
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

      public SearchResponse.Builder setDoc(int index, DocV2.Builder builderForValue) {
         if (this.docBuilder_ == null) {
            this.ensureDocIsMutable();
            this.doc_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.docBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public SearchResponse.Builder addDoc(DocV2 value) {
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

      public SearchResponse.Builder addDoc(int index, DocV2 value) {
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

      public SearchResponse.Builder addDoc(DocV2.Builder builderForValue) {
         if (this.docBuilder_ == null) {
            this.ensureDocIsMutable();
            this.doc_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.docBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public SearchResponse.Builder addDoc(int index, DocV2.Builder builderForValue) {
         if (this.docBuilder_ == null) {
            this.ensureDocIsMutable();
            this.doc_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.docBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public SearchResponse.Builder addAllDoc(Iterable values) {
         if (this.docBuilder_ == null) {
            this.ensureDocIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.doc_);
            this.onChanged();
         } else {
            this.docBuilder_.addAllMessages(values);
         }

         return this;
      }

      public SearchResponse.Builder clearDoc() {
         if (this.docBuilder_ == null) {
            this.doc_ = Collections.emptyList();
            this.bitField0_ &= -2;
            this.onChanged();
         } else {
            this.docBuilder_.clear();
         }

         return this;
      }

      public SearchResponse.Builder removeDoc(int index) {
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

      public final SearchResponse.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (SearchResponse.Builder)super.setUnknownFields(unknownFields);
      }

      public final SearchResponse.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (SearchResponse.Builder)super.mergeUnknownFields(unknownFields);
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
