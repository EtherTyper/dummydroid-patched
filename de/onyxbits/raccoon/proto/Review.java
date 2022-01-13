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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Review extends GeneratedMessageV3 implements ReviewOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int AUTHORNAME_FIELD_NUMBER = 1;
   private volatile Object authorName_;
   public static final int URL_FIELD_NUMBER = 2;
   private volatile Object url_;
   public static final int SOURCE_FIELD_NUMBER = 3;
   private volatile Object source_;
   public static final int DOCUMENTVERSION_FIELD_NUMBER = 4;
   private volatile Object documentVersion_;
   public static final int TIMESTAMPMSEC_FIELD_NUMBER = 5;
   private long timestampMsec_;
   public static final int STARRATING_FIELD_NUMBER = 6;
   private int starRating_;
   public static final int TITLE_FIELD_NUMBER = 7;
   private volatile Object title_;
   public static final int COMMENT_FIELD_NUMBER = 8;
   private volatile Object comment_;
   public static final int COMMENTID_FIELD_NUMBER = 9;
   private volatile Object commentId_;
   public static final int DEVICENAME_FIELD_NUMBER = 19;
   private volatile Object deviceName_;
   public static final int REPLYTEXT_FIELD_NUMBER = 29;
   private volatile Object replyText_;
   public static final int REPLYTIMESTAMPMSEC_FIELD_NUMBER = 30;
   private long replyTimestampMsec_;
   public static final int AUTHOR_FIELD_NUMBER = 33;
   private DocV2 author_;
   public static final int SENTIMENT_FIELD_NUMBER = 34;
   private Image sentiment_;
   public static final int HELPFULCONTENT_FIELD_NUMBER = 35;
   private int helpfulContent_;
   public static final int THUMBSUPCOUNT_FIELD_NUMBER = 38;
   private long thumbsUpCount_;
   private byte memoizedIsInitialized;
   private static final Review DEFAULT_INSTANCE = new Review();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public Review parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new Review(input, extensionRegistry);
      }
   };

   private Review(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private Review() {
      this.memoizedIsInitialized = -1;
      this.authorName_ = "";
      this.url_ = "";
      this.source_ = "";
      this.documentVersion_ = "";
      this.title_ = "";
      this.comment_ = "";
      this.commentId_ = "";
      this.deviceName_ = "";
      this.replyText_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new Review();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private Review(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  this.authorName_ = bs;
                  break;
               case 18:
                  bs = input.readBytes();
                  this.bitField0_ |= 2;
                  this.url_ = bs;
                  break;
               case 26:
                  bs = input.readBytes();
                  this.bitField0_ |= 4;
                  this.source_ = bs;
                  break;
               case 34:
                  bs = input.readBytes();
                  this.bitField0_ |= 8;
                  this.documentVersion_ = bs;
                  break;
               case 40:
                  this.bitField0_ |= 16;
                  this.timestampMsec_ = input.readInt64();
                  break;
               case 48:
                  this.bitField0_ |= 32;
                  this.starRating_ = input.readInt32();
                  break;
               case 58:
                  bs = input.readBytes();
                  this.bitField0_ |= 64;
                  this.title_ = bs;
                  break;
               case 66:
                  bs = input.readBytes();
                  this.bitField0_ |= 128;
                  this.comment_ = bs;
                  break;
               case 74:
                  bs = input.readBytes();
                  this.bitField0_ |= 256;
                  this.commentId_ = bs;
                  break;
               case 154:
                  bs = input.readBytes();
                  this.bitField0_ |= 512;
                  this.deviceName_ = bs;
                  break;
               case 234:
                  bs = input.readBytes();
                  this.bitField0_ |= 1024;
                  this.replyText_ = bs;
                  break;
               case 240:
                  this.bitField0_ |= 2048;
                  this.replyTimestampMsec_ = input.readInt64();
                  break;
               case 266:
                  DocV2.Builder subBuilder = null;
                  if ((this.bitField0_ & 4096) != 0) {
                     subBuilder = this.author_.toBuilder();
                  }

                  this.author_ = (DocV2)input.readMessage(DocV2.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.author_);
                     this.author_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 4096;
                  break;
               case 274:
                  Image.Builder subBuilder = null;
                  if ((this.bitField0_ & 8192) != 0) {
                     subBuilder = this.sentiment_.toBuilder();
                  }

                  this.sentiment_ = (Image)input.readMessage(Image.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.sentiment_);
                     this.sentiment_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 8192;
                  break;
               case 280:
                  this.bitField0_ |= 16384;
                  this.helpfulContent_ = input.readInt32();
                  break;
               case 304:
                  this.bitField0_ |= 32768;
                  this.thumbsUpCount_ = input.readInt64();
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
      return Mothership.internal_static_Review_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_Review_fieldAccessorTable.ensureFieldAccessorsInitialized(Review.class, Review.Builder.class);
   }

   public boolean hasAuthorName() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getAuthorName() {
      Object ref = this.authorName_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.authorName_ = s;
         }

         return s;
      }
   }

   public ByteString getAuthorNameBytes() {
      Object ref = this.authorName_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.authorName_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasUrl() {
      return (this.bitField0_ & 2) != 0;
   }

   public String getUrl() {
      Object ref = this.url_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.url_ = s;
         }

         return s;
      }
   }

   public ByteString getUrlBytes() {
      Object ref = this.url_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.url_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasSource() {
      return (this.bitField0_ & 4) != 0;
   }

   public String getSource() {
      Object ref = this.source_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.source_ = s;
         }

         return s;
      }
   }

   public ByteString getSourceBytes() {
      Object ref = this.source_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.source_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasDocumentVersion() {
      return (this.bitField0_ & 8) != 0;
   }

   public String getDocumentVersion() {
      Object ref = this.documentVersion_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.documentVersion_ = s;
         }

         return s;
      }
   }

   public ByteString getDocumentVersionBytes() {
      Object ref = this.documentVersion_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.documentVersion_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasTimestampMsec() {
      return (this.bitField0_ & 16) != 0;
   }

   public long getTimestampMsec() {
      return this.timestampMsec_;
   }

   public boolean hasStarRating() {
      return (this.bitField0_ & 32) != 0;
   }

   public int getStarRating() {
      return this.starRating_;
   }

   public boolean hasTitle() {
      return (this.bitField0_ & 64) != 0;
   }

   public String getTitle() {
      Object ref = this.title_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.title_ = s;
         }

         return s;
      }
   }

   public ByteString getTitleBytes() {
      Object ref = this.title_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.title_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasComment() {
      return (this.bitField0_ & 128) != 0;
   }

   public String getComment() {
      Object ref = this.comment_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.comment_ = s;
         }

         return s;
      }
   }

   public ByteString getCommentBytes() {
      Object ref = this.comment_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.comment_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasCommentId() {
      return (this.bitField0_ & 256) != 0;
   }

   public String getCommentId() {
      Object ref = this.commentId_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.commentId_ = s;
         }

         return s;
      }
   }

   public ByteString getCommentIdBytes() {
      Object ref = this.commentId_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.commentId_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasDeviceName() {
      return (this.bitField0_ & 512) != 0;
   }

   public String getDeviceName() {
      Object ref = this.deviceName_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.deviceName_ = s;
         }

         return s;
      }
   }

   public ByteString getDeviceNameBytes() {
      Object ref = this.deviceName_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.deviceName_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasReplyText() {
      return (this.bitField0_ & 1024) != 0;
   }

   public String getReplyText() {
      Object ref = this.replyText_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.replyText_ = s;
         }

         return s;
      }
   }

   public ByteString getReplyTextBytes() {
      Object ref = this.replyText_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.replyText_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasReplyTimestampMsec() {
      return (this.bitField0_ & 2048) != 0;
   }

   public long getReplyTimestampMsec() {
      return this.replyTimestampMsec_;
   }

   public boolean hasAuthor() {
      return (this.bitField0_ & 4096) != 0;
   }

   public DocV2 getAuthor() {
      return this.author_ == null ? DocV2.getDefaultInstance() : this.author_;
   }

   public DocV2OrBuilder getAuthorOrBuilder() {
      return this.author_ == null ? DocV2.getDefaultInstance() : this.author_;
   }

   public boolean hasSentiment() {
      return (this.bitField0_ & 8192) != 0;
   }

   public Image getSentiment() {
      return this.sentiment_ == null ? Image.getDefaultInstance() : this.sentiment_;
   }

   public ImageOrBuilder getSentimentOrBuilder() {
      return this.sentiment_ == null ? Image.getDefaultInstance() : this.sentiment_;
   }

   public boolean hasHelpfulContent() {
      return (this.bitField0_ & 16384) != 0;
   }

   public int getHelpfulContent() {
      return this.helpfulContent_;
   }

   public boolean hasThumbsUpCount() {
      return (this.bitField0_ & '耀') != 0;
   }

   public long getThumbsUpCount() {
      return this.thumbsUpCount_;
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
         GeneratedMessageV3.writeString(output, 1, this.authorName_);
      }

      if ((this.bitField0_ & 2) != 0) {
         GeneratedMessageV3.writeString(output, 2, this.url_);
      }

      if ((this.bitField0_ & 4) != 0) {
         GeneratedMessageV3.writeString(output, 3, this.source_);
      }

      if ((this.bitField0_ & 8) != 0) {
         GeneratedMessageV3.writeString(output, 4, this.documentVersion_);
      }

      if ((this.bitField0_ & 16) != 0) {
         output.writeInt64(5, this.timestampMsec_);
      }

      if ((this.bitField0_ & 32) != 0) {
         output.writeInt32(6, this.starRating_);
      }

      if ((this.bitField0_ & 64) != 0) {
         GeneratedMessageV3.writeString(output, 7, this.title_);
      }

      if ((this.bitField0_ & 128) != 0) {
         GeneratedMessageV3.writeString(output, 8, this.comment_);
      }

      if ((this.bitField0_ & 256) != 0) {
         GeneratedMessageV3.writeString(output, 9, this.commentId_);
      }

      if ((this.bitField0_ & 512) != 0) {
         GeneratedMessageV3.writeString(output, 19, this.deviceName_);
      }

      if ((this.bitField0_ & 1024) != 0) {
         GeneratedMessageV3.writeString(output, 29, this.replyText_);
      }

      if ((this.bitField0_ & 2048) != 0) {
         output.writeInt64(30, this.replyTimestampMsec_);
      }

      if ((this.bitField0_ & 4096) != 0) {
         output.writeMessage(33, this.getAuthor());
      }

      if ((this.bitField0_ & 8192) != 0) {
         output.writeMessage(34, this.getSentiment());
      }

      if ((this.bitField0_ & 16384) != 0) {
         output.writeInt32(35, this.helpfulContent_);
      }

      if ((this.bitField0_ & '耀') != 0) {
         output.writeInt64(38, this.thumbsUpCount_);
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
            size += GeneratedMessageV3.computeStringSize(1, this.authorName_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += GeneratedMessageV3.computeStringSize(2, this.url_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += GeneratedMessageV3.computeStringSize(3, this.source_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += GeneratedMessageV3.computeStringSize(4, this.documentVersion_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += CodedOutputStream.computeInt64Size(5, this.timestampMsec_);
         }

         if ((this.bitField0_ & 32) != 0) {
            size += CodedOutputStream.computeInt32Size(6, this.starRating_);
         }

         if ((this.bitField0_ & 64) != 0) {
            size += GeneratedMessageV3.computeStringSize(7, this.title_);
         }

         if ((this.bitField0_ & 128) != 0) {
            size += GeneratedMessageV3.computeStringSize(8, this.comment_);
         }

         if ((this.bitField0_ & 256) != 0) {
            size += GeneratedMessageV3.computeStringSize(9, this.commentId_);
         }

         if ((this.bitField0_ & 512) != 0) {
            size += GeneratedMessageV3.computeStringSize(19, this.deviceName_);
         }

         if ((this.bitField0_ & 1024) != 0) {
            size += GeneratedMessageV3.computeStringSize(29, this.replyText_);
         }

         if ((this.bitField0_ & 2048) != 0) {
            size += CodedOutputStream.computeInt64Size(30, this.replyTimestampMsec_);
         }

         if ((this.bitField0_ & 4096) != 0) {
            size += CodedOutputStream.computeMessageSize(33, this.getAuthor());
         }

         if ((this.bitField0_ & 8192) != 0) {
            size += CodedOutputStream.computeMessageSize(34, this.getSentiment());
         }

         if ((this.bitField0_ & 16384) != 0) {
            size += CodedOutputStream.computeInt32Size(35, this.helpfulContent_);
         }

         if ((this.bitField0_ & '耀') != 0) {
            size += CodedOutputStream.computeInt64Size(38, this.thumbsUpCount_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof Review)) {
         return super.equals(obj);
      } else {
         Review other = (Review)obj;
         if (this.hasAuthorName() != other.hasAuthorName()) {
            return false;
         } else if (this.hasAuthorName() && !this.getAuthorName().equals(other.getAuthorName())) {
            return false;
         } else if (this.hasUrl() != other.hasUrl()) {
            return false;
         } else if (this.hasUrl() && !this.getUrl().equals(other.getUrl())) {
            return false;
         } else if (this.hasSource() != other.hasSource()) {
            return false;
         } else if (this.hasSource() && !this.getSource().equals(other.getSource())) {
            return false;
         } else if (this.hasDocumentVersion() != other.hasDocumentVersion()) {
            return false;
         } else if (this.hasDocumentVersion() && !this.getDocumentVersion().equals(other.getDocumentVersion())) {
            return false;
         } else if (this.hasTimestampMsec() != other.hasTimestampMsec()) {
            return false;
         } else if (this.hasTimestampMsec() && this.getTimestampMsec() != other.getTimestampMsec()) {
            return false;
         } else if (this.hasStarRating() != other.hasStarRating()) {
            return false;
         } else if (this.hasStarRating() && this.getStarRating() != other.getStarRating()) {
            return false;
         } else if (this.hasTitle() != other.hasTitle()) {
            return false;
         } else if (this.hasTitle() && !this.getTitle().equals(other.getTitle())) {
            return false;
         } else if (this.hasComment() != other.hasComment()) {
            return false;
         } else if (this.hasComment() && !this.getComment().equals(other.getComment())) {
            return false;
         } else if (this.hasCommentId() != other.hasCommentId()) {
            return false;
         } else if (this.hasCommentId() && !this.getCommentId().equals(other.getCommentId())) {
            return false;
         } else if (this.hasDeviceName() != other.hasDeviceName()) {
            return false;
         } else if (this.hasDeviceName() && !this.getDeviceName().equals(other.getDeviceName())) {
            return false;
         } else if (this.hasReplyText() != other.hasReplyText()) {
            return false;
         } else if (this.hasReplyText() && !this.getReplyText().equals(other.getReplyText())) {
            return false;
         } else if (this.hasReplyTimestampMsec() != other.hasReplyTimestampMsec()) {
            return false;
         } else if (this.hasReplyTimestampMsec() && this.getReplyTimestampMsec() != other.getReplyTimestampMsec()) {
            return false;
         } else if (this.hasAuthor() != other.hasAuthor()) {
            return false;
         } else if (this.hasAuthor() && !this.getAuthor().equals(other.getAuthor())) {
            return false;
         } else if (this.hasSentiment() != other.hasSentiment()) {
            return false;
         } else if (this.hasSentiment() && !this.getSentiment().equals(other.getSentiment())) {
            return false;
         } else if (this.hasHelpfulContent() != other.hasHelpfulContent()) {
            return false;
         } else if (this.hasHelpfulContent() && this.getHelpfulContent() != other.getHelpfulContent()) {
            return false;
         } else if (this.hasThumbsUpCount() != other.hasThumbsUpCount()) {
            return false;
         } else if (this.hasThumbsUpCount() && this.getThumbsUpCount() != other.getThumbsUpCount()) {
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
         if (this.hasAuthorName()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getAuthorName().hashCode();
         }

         if (this.hasUrl()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getUrl().hashCode();
         }

         if (this.hasSource()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getSource().hashCode();
         }

         if (this.hasDocumentVersion()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getDocumentVersion().hashCode();
         }

         if (this.hasTimestampMsec()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + Internal.hashLong(this.getTimestampMsec());
         }

         if (this.hasStarRating()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + this.getStarRating();
         }

         if (this.hasTitle()) {
            hash = 37 * hash + 7;
            hash = 53 * hash + this.getTitle().hashCode();
         }

         if (this.hasComment()) {
            hash = 37 * hash + 8;
            hash = 53 * hash + this.getComment().hashCode();
         }

         if (this.hasCommentId()) {
            hash = 37 * hash + 9;
            hash = 53 * hash + this.getCommentId().hashCode();
         }

         if (this.hasDeviceName()) {
            hash = 37 * hash + 19;
            hash = 53 * hash + this.getDeviceName().hashCode();
         }

         if (this.hasReplyText()) {
            hash = 37 * hash + 29;
            hash = 53 * hash + this.getReplyText().hashCode();
         }

         if (this.hasReplyTimestampMsec()) {
            hash = 37 * hash + 30;
            hash = 53 * hash + Internal.hashLong(this.getReplyTimestampMsec());
         }

         if (this.hasAuthor()) {
            hash = 37 * hash + 33;
            hash = 53 * hash + this.getAuthor().hashCode();
         }

         if (this.hasSentiment()) {
            hash = 37 * hash + 34;
            hash = 53 * hash + this.getSentiment().hashCode();
         }

         if (this.hasHelpfulContent()) {
            hash = 37 * hash + 35;
            hash = 53 * hash + this.getHelpfulContent();
         }

         if (this.hasThumbsUpCount()) {
            hash = 37 * hash + 38;
            hash = 53 * hash + Internal.hashLong(this.getThumbsUpCount());
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static Review parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (Review)PARSER.parseFrom(data);
   }

   public static Review parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Review)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Review parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (Review)PARSER.parseFrom(data);
   }

   public static Review parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Review)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Review parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (Review)PARSER.parseFrom(data);
   }

   public static Review parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Review)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Review parseFrom(InputStream input) throws IOException {
      return (Review)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Review parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Review)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static Review parseDelimitedFrom(InputStream input) throws IOException {
      return (Review)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static Review parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Review)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static Review parseFrom(CodedInputStream input) throws IOException {
      return (Review)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Review parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Review)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public Review.Builder newBuilderForType() {
      return newBuilder();
   }

   public static Review.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Review.Builder newBuilder(Review prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public Review.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new Review.Builder() : (new Review.Builder()).mergeFrom(this);
   }

   protected Review.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      Review.Builder builder = new Review.Builder(parent);
      return builder;
   }

   public static Review getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Review getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Review(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   Review(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements ReviewOrBuilder {
      private int bitField0_;
      private Object authorName_;
      private Object url_;
      private Object source_;
      private Object documentVersion_;
      private long timestampMsec_;
      private int starRating_;
      private Object title_;
      private Object comment_;
      private Object commentId_;
      private Object deviceName_;
      private Object replyText_;
      private long replyTimestampMsec_;
      private DocV2 author_;
      private SingleFieldBuilderV3 authorBuilder_;
      private Image sentiment_;
      private SingleFieldBuilderV3 sentimentBuilder_;
      private int helpfulContent_;
      private long thumbsUpCount_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_Review_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_Review_fieldAccessorTable.ensureFieldAccessorsInitialized(Review.class, Review.Builder.class);
      }

      private Builder() {
         this.authorName_ = "";
         this.url_ = "";
         this.source_ = "";
         this.documentVersion_ = "";
         this.title_ = "";
         this.comment_ = "";
         this.commentId_ = "";
         this.deviceName_ = "";
         this.replyText_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.authorName_ = "";
         this.url_ = "";
         this.source_ = "";
         this.documentVersion_ = "";
         this.title_ = "";
         this.comment_ = "";
         this.commentId_ = "";
         this.deviceName_ = "";
         this.replyText_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (Review.alwaysUseFieldBuilders) {
            this.getAuthorFieldBuilder();
            this.getSentimentFieldBuilder();
         }

      }

      public Review.Builder clear() {
         super.clear();
         this.authorName_ = "";
         this.bitField0_ &= -2;
         this.url_ = "";
         this.bitField0_ &= -3;
         this.source_ = "";
         this.bitField0_ &= -5;
         this.documentVersion_ = "";
         this.bitField0_ &= -9;
         this.timestampMsec_ = 0L;
         this.bitField0_ &= -17;
         this.starRating_ = 0;
         this.bitField0_ &= -33;
         this.title_ = "";
         this.bitField0_ &= -65;
         this.comment_ = "";
         this.bitField0_ &= -129;
         this.commentId_ = "";
         this.bitField0_ &= -257;
         this.deviceName_ = "";
         this.bitField0_ &= -513;
         this.replyText_ = "";
         this.bitField0_ &= -1025;
         this.replyTimestampMsec_ = 0L;
         this.bitField0_ &= -2049;
         if (this.authorBuilder_ == null) {
            this.author_ = null;
         } else {
            this.authorBuilder_.clear();
         }

         this.bitField0_ &= -4097;
         if (this.sentimentBuilder_ == null) {
            this.sentiment_ = null;
         } else {
            this.sentimentBuilder_.clear();
         }

         this.bitField0_ &= -8193;
         this.helpfulContent_ = 0;
         this.bitField0_ &= -16385;
         this.thumbsUpCount_ = 0L;
         this.bitField0_ &= -32769;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_Review_descriptor;
      }

      public Review getDefaultInstanceForType() {
         return Review.getDefaultInstance();
      }

      public Review build() {
         Review result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public Review buildPartial() {
         Review result = new Review(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.authorName_ = this.authorName_;
         if ((from_bitField0_ & 2) != 0) {
            to_bitField0_ |= 2;
         }

         result.url_ = this.url_;
         if ((from_bitField0_ & 4) != 0) {
            to_bitField0_ |= 4;
         }

         result.source_ = this.source_;
         if ((from_bitField0_ & 8) != 0) {
            to_bitField0_ |= 8;
         }

         result.documentVersion_ = this.documentVersion_;
         if ((from_bitField0_ & 16) != 0) {
            result.timestampMsec_ = this.timestampMsec_;
            to_bitField0_ |= 16;
         }

         if ((from_bitField0_ & 32) != 0) {
            result.starRating_ = this.starRating_;
            to_bitField0_ |= 32;
         }

         if ((from_bitField0_ & 64) != 0) {
            to_bitField0_ |= 64;
         }

         result.title_ = this.title_;
         if ((from_bitField0_ & 128) != 0) {
            to_bitField0_ |= 128;
         }

         result.comment_ = this.comment_;
         if ((from_bitField0_ & 256) != 0) {
            to_bitField0_ |= 256;
         }

         result.commentId_ = this.commentId_;
         if ((from_bitField0_ & 512) != 0) {
            to_bitField0_ |= 512;
         }

         result.deviceName_ = this.deviceName_;
         if ((from_bitField0_ & 1024) != 0) {
            to_bitField0_ |= 1024;
         }

         result.replyText_ = this.replyText_;
         if ((from_bitField0_ & 2048) != 0) {
            result.replyTimestampMsec_ = this.replyTimestampMsec_;
            to_bitField0_ |= 2048;
         }

         if ((from_bitField0_ & 4096) != 0) {
            if (this.authorBuilder_ == null) {
               result.author_ = this.author_;
            } else {
               result.author_ = (DocV2)this.authorBuilder_.build();
            }

            to_bitField0_ |= 4096;
         }

         if ((from_bitField0_ & 8192) != 0) {
            if (this.sentimentBuilder_ == null) {
               result.sentiment_ = this.sentiment_;
            } else {
               result.sentiment_ = (Image)this.sentimentBuilder_.build();
            }

            to_bitField0_ |= 8192;
         }

         if ((from_bitField0_ & 16384) != 0) {
            result.helpfulContent_ = this.helpfulContent_;
            to_bitField0_ |= 16384;
         }

         if ((from_bitField0_ & '耀') != 0) {
            result.thumbsUpCount_ = this.thumbsUpCount_;
            to_bitField0_ |= 32768;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public Review.Builder clone() {
         return (Review.Builder)super.clone();
      }

      public Review.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (Review.Builder)super.setField(field, value);
      }

      public Review.Builder clearField(Descriptors.FieldDescriptor field) {
         return (Review.Builder)super.clearField(field);
      }

      public Review.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (Review.Builder)super.clearOneof(oneof);
      }

      public Review.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (Review.Builder)super.setRepeatedField(field, index, value);
      }

      public Review.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (Review.Builder)super.addRepeatedField(field, value);
      }

      public Review.Builder mergeFrom(Message other) {
         if (other instanceof Review) {
            return this.mergeFrom((Review)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public Review.Builder mergeFrom(Review other) {
         if (other == Review.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasAuthorName()) {
               this.bitField0_ |= 1;
               this.authorName_ = other.authorName_;
               this.onChanged();
            }

            if (other.hasUrl()) {
               this.bitField0_ |= 2;
               this.url_ = other.url_;
               this.onChanged();
            }

            if (other.hasSource()) {
               this.bitField0_ |= 4;
               this.source_ = other.source_;
               this.onChanged();
            }

            if (other.hasDocumentVersion()) {
               this.bitField0_ |= 8;
               this.documentVersion_ = other.documentVersion_;
               this.onChanged();
            }

            if (other.hasTimestampMsec()) {
               this.setTimestampMsec(other.getTimestampMsec());
            }

            if (other.hasStarRating()) {
               this.setStarRating(other.getStarRating());
            }

            if (other.hasTitle()) {
               this.bitField0_ |= 64;
               this.title_ = other.title_;
               this.onChanged();
            }

            if (other.hasComment()) {
               this.bitField0_ |= 128;
               this.comment_ = other.comment_;
               this.onChanged();
            }

            if (other.hasCommentId()) {
               this.bitField0_ |= 256;
               this.commentId_ = other.commentId_;
               this.onChanged();
            }

            if (other.hasDeviceName()) {
               this.bitField0_ |= 512;
               this.deviceName_ = other.deviceName_;
               this.onChanged();
            }

            if (other.hasReplyText()) {
               this.bitField0_ |= 1024;
               this.replyText_ = other.replyText_;
               this.onChanged();
            }

            if (other.hasReplyTimestampMsec()) {
               this.setReplyTimestampMsec(other.getReplyTimestampMsec());
            }

            if (other.hasAuthor()) {
               this.mergeAuthor(other.getAuthor());
            }

            if (other.hasSentiment()) {
               this.mergeSentiment(other.getSentiment());
            }

            if (other.hasHelpfulContent()) {
               this.setHelpfulContent(other.getHelpfulContent());
            }

            if (other.hasThumbsUpCount()) {
               this.setThumbsUpCount(other.getThumbsUpCount());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public Review.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         Review parsedMessage = null;

         try {
            parsedMessage = (Review)Review.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (Review)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasAuthorName() {
         return (this.bitField0_ & 1) != 0;
      }

      public String getAuthorName() {
         Object ref = this.authorName_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.authorName_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getAuthorNameBytes() {
         Object ref = this.authorName_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.authorName_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Review.Builder setAuthorName(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.authorName_ = value;
            this.onChanged();
            return this;
         }
      }

      public Review.Builder clearAuthorName() {
         this.bitField0_ &= -2;
         this.authorName_ = Review.getDefaultInstance().getAuthorName();
         this.onChanged();
         return this;
      }

      public Review.Builder setAuthorNameBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.authorName_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasUrl() {
         return (this.bitField0_ & 2) != 0;
      }

      public String getUrl() {
         Object ref = this.url_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.url_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getUrlBytes() {
         Object ref = this.url_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.url_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Review.Builder setUrl(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.url_ = value;
            this.onChanged();
            return this;
         }
      }

      public Review.Builder clearUrl() {
         this.bitField0_ &= -3;
         this.url_ = Review.getDefaultInstance().getUrl();
         this.onChanged();
         return this;
      }

      public Review.Builder setUrlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.url_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasSource() {
         return (this.bitField0_ & 4) != 0;
      }

      public String getSource() {
         Object ref = this.source_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.source_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getSourceBytes() {
         Object ref = this.source_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.source_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Review.Builder setSource(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.source_ = value;
            this.onChanged();
            return this;
         }
      }

      public Review.Builder clearSource() {
         this.bitField0_ &= -5;
         this.source_ = Review.getDefaultInstance().getSource();
         this.onChanged();
         return this;
      }

      public Review.Builder setSourceBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.source_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasDocumentVersion() {
         return (this.bitField0_ & 8) != 0;
      }

      public String getDocumentVersion() {
         Object ref = this.documentVersion_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.documentVersion_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDocumentVersionBytes() {
         Object ref = this.documentVersion_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.documentVersion_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Review.Builder setDocumentVersion(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.documentVersion_ = value;
            this.onChanged();
            return this;
         }
      }

      public Review.Builder clearDocumentVersion() {
         this.bitField0_ &= -9;
         this.documentVersion_ = Review.getDefaultInstance().getDocumentVersion();
         this.onChanged();
         return this;
      }

      public Review.Builder setDocumentVersionBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.documentVersion_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasTimestampMsec() {
         return (this.bitField0_ & 16) != 0;
      }

      public long getTimestampMsec() {
         return this.timestampMsec_;
      }

      public Review.Builder setTimestampMsec(long value) {
         this.bitField0_ |= 16;
         this.timestampMsec_ = value;
         this.onChanged();
         return this;
      }

      public Review.Builder clearTimestampMsec() {
         this.bitField0_ &= -17;
         this.timestampMsec_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasStarRating() {
         return (this.bitField0_ & 32) != 0;
      }

      public int getStarRating() {
         return this.starRating_;
      }

      public Review.Builder setStarRating(int value) {
         this.bitField0_ |= 32;
         this.starRating_ = value;
         this.onChanged();
         return this;
      }

      public Review.Builder clearStarRating() {
         this.bitField0_ &= -33;
         this.starRating_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasTitle() {
         return (this.bitField0_ & 64) != 0;
      }

      public String getTitle() {
         Object ref = this.title_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.title_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getTitleBytes() {
         Object ref = this.title_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.title_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Review.Builder setTitle(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 64;
            this.title_ = value;
            this.onChanged();
            return this;
         }
      }

      public Review.Builder clearTitle() {
         this.bitField0_ &= -65;
         this.title_ = Review.getDefaultInstance().getTitle();
         this.onChanged();
         return this;
      }

      public Review.Builder setTitleBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 64;
            this.title_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasComment() {
         return (this.bitField0_ & 128) != 0;
      }

      public String getComment() {
         Object ref = this.comment_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.comment_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getCommentBytes() {
         Object ref = this.comment_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.comment_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Review.Builder setComment(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 128;
            this.comment_ = value;
            this.onChanged();
            return this;
         }
      }

      public Review.Builder clearComment() {
         this.bitField0_ &= -129;
         this.comment_ = Review.getDefaultInstance().getComment();
         this.onChanged();
         return this;
      }

      public Review.Builder setCommentBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 128;
            this.comment_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasCommentId() {
         return (this.bitField0_ & 256) != 0;
      }

      public String getCommentId() {
         Object ref = this.commentId_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.commentId_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getCommentIdBytes() {
         Object ref = this.commentId_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.commentId_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Review.Builder setCommentId(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 256;
            this.commentId_ = value;
            this.onChanged();
            return this;
         }
      }

      public Review.Builder clearCommentId() {
         this.bitField0_ &= -257;
         this.commentId_ = Review.getDefaultInstance().getCommentId();
         this.onChanged();
         return this;
      }

      public Review.Builder setCommentIdBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 256;
            this.commentId_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasDeviceName() {
         return (this.bitField0_ & 512) != 0;
      }

      public String getDeviceName() {
         Object ref = this.deviceName_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.deviceName_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDeviceNameBytes() {
         Object ref = this.deviceName_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.deviceName_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Review.Builder setDeviceName(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 512;
            this.deviceName_ = value;
            this.onChanged();
            return this;
         }
      }

      public Review.Builder clearDeviceName() {
         this.bitField0_ &= -513;
         this.deviceName_ = Review.getDefaultInstance().getDeviceName();
         this.onChanged();
         return this;
      }

      public Review.Builder setDeviceNameBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 512;
            this.deviceName_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasReplyText() {
         return (this.bitField0_ & 1024) != 0;
      }

      public String getReplyText() {
         Object ref = this.replyText_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.replyText_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getReplyTextBytes() {
         Object ref = this.replyText_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.replyText_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Review.Builder setReplyText(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1024;
            this.replyText_ = value;
            this.onChanged();
            return this;
         }
      }

      public Review.Builder clearReplyText() {
         this.bitField0_ &= -1025;
         this.replyText_ = Review.getDefaultInstance().getReplyText();
         this.onChanged();
         return this;
      }

      public Review.Builder setReplyTextBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1024;
            this.replyText_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasReplyTimestampMsec() {
         return (this.bitField0_ & 2048) != 0;
      }

      public long getReplyTimestampMsec() {
         return this.replyTimestampMsec_;
      }

      public Review.Builder setReplyTimestampMsec(long value) {
         this.bitField0_ |= 2048;
         this.replyTimestampMsec_ = value;
         this.onChanged();
         return this;
      }

      public Review.Builder clearReplyTimestampMsec() {
         this.bitField0_ &= -2049;
         this.replyTimestampMsec_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasAuthor() {
         return (this.bitField0_ & 4096) != 0;
      }

      public DocV2 getAuthor() {
         if (this.authorBuilder_ == null) {
            return this.author_ == null ? DocV2.getDefaultInstance() : this.author_;
         } else {
            return (DocV2)this.authorBuilder_.getMessage();
         }
      }

      public Review.Builder setAuthor(DocV2 value) {
         if (this.authorBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.author_ = value;
            this.onChanged();
         } else {
            this.authorBuilder_.setMessage(value);
         }

         this.bitField0_ |= 4096;
         return this;
      }

      public Review.Builder setAuthor(DocV2.Builder builderForValue) {
         if (this.authorBuilder_ == null) {
            this.author_ = builderForValue.build();
            this.onChanged();
         } else {
            this.authorBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 4096;
         return this;
      }

      public Review.Builder mergeAuthor(DocV2 value) {
         if (this.authorBuilder_ == null) {
            if ((this.bitField0_ & 4096) != 0 && this.author_ != null && this.author_ != DocV2.getDefaultInstance()) {
               this.author_ = DocV2.newBuilder(this.author_).mergeFrom(value).buildPartial();
            } else {
               this.author_ = value;
            }

            this.onChanged();
         } else {
            this.authorBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 4096;
         return this;
      }

      public Review.Builder clearAuthor() {
         if (this.authorBuilder_ == null) {
            this.author_ = null;
            this.onChanged();
         } else {
            this.authorBuilder_.clear();
         }

         this.bitField0_ &= -4097;
         return this;
      }

      public DocV2.Builder getAuthorBuilder() {
         this.bitField0_ |= 4096;
         this.onChanged();
         return (DocV2.Builder)this.getAuthorFieldBuilder().getBuilder();
      }

      public DocV2OrBuilder getAuthorOrBuilder() {
         if (this.authorBuilder_ != null) {
            return (DocV2OrBuilder)this.authorBuilder_.getMessageOrBuilder();
         } else {
            return this.author_ == null ? DocV2.getDefaultInstance() : this.author_;
         }
      }

      private SingleFieldBuilderV3 getAuthorFieldBuilder() {
         if (this.authorBuilder_ == null) {
            this.authorBuilder_ = new SingleFieldBuilderV3(this.getAuthor(), this.getParentForChildren(), this.isClean());
            this.author_ = null;
         }

         return this.authorBuilder_;
      }

      public boolean hasSentiment() {
         return (this.bitField0_ & 8192) != 0;
      }

      public Image getSentiment() {
         if (this.sentimentBuilder_ == null) {
            return this.sentiment_ == null ? Image.getDefaultInstance() : this.sentiment_;
         } else {
            return (Image)this.sentimentBuilder_.getMessage();
         }
      }

      public Review.Builder setSentiment(Image value) {
         if (this.sentimentBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.sentiment_ = value;
            this.onChanged();
         } else {
            this.sentimentBuilder_.setMessage(value);
         }

         this.bitField0_ |= 8192;
         return this;
      }

      public Review.Builder setSentiment(Image.Builder builderForValue) {
         if (this.sentimentBuilder_ == null) {
            this.sentiment_ = builderForValue.build();
            this.onChanged();
         } else {
            this.sentimentBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 8192;
         return this;
      }

      public Review.Builder mergeSentiment(Image value) {
         if (this.sentimentBuilder_ == null) {
            if ((this.bitField0_ & 8192) != 0 && this.sentiment_ != null && this.sentiment_ != Image.getDefaultInstance()) {
               this.sentiment_ = Image.newBuilder(this.sentiment_).mergeFrom(value).buildPartial();
            } else {
               this.sentiment_ = value;
            }

            this.onChanged();
         } else {
            this.sentimentBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 8192;
         return this;
      }

      public Review.Builder clearSentiment() {
         if (this.sentimentBuilder_ == null) {
            this.sentiment_ = null;
            this.onChanged();
         } else {
            this.sentimentBuilder_.clear();
         }

         this.bitField0_ &= -8193;
         return this;
      }

      public Image.Builder getSentimentBuilder() {
         this.bitField0_ |= 8192;
         this.onChanged();
         return (Image.Builder)this.getSentimentFieldBuilder().getBuilder();
      }

      public ImageOrBuilder getSentimentOrBuilder() {
         if (this.sentimentBuilder_ != null) {
            return (ImageOrBuilder)this.sentimentBuilder_.getMessageOrBuilder();
         } else {
            return this.sentiment_ == null ? Image.getDefaultInstance() : this.sentiment_;
         }
      }

      private SingleFieldBuilderV3 getSentimentFieldBuilder() {
         if (this.sentimentBuilder_ == null) {
            this.sentimentBuilder_ = new SingleFieldBuilderV3(this.getSentiment(), this.getParentForChildren(), this.isClean());
            this.sentiment_ = null;
         }

         return this.sentimentBuilder_;
      }

      public boolean hasHelpfulContent() {
         return (this.bitField0_ & 16384) != 0;
      }

      public int getHelpfulContent() {
         return this.helpfulContent_;
      }

      public Review.Builder setHelpfulContent(int value) {
         this.bitField0_ |= 16384;
         this.helpfulContent_ = value;
         this.onChanged();
         return this;
      }

      public Review.Builder clearHelpfulContent() {
         this.bitField0_ &= -16385;
         this.helpfulContent_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasThumbsUpCount() {
         return (this.bitField0_ & '耀') != 0;
      }

      public long getThumbsUpCount() {
         return this.thumbsUpCount_;
      }

      public Review.Builder setThumbsUpCount(long value) {
         this.bitField0_ |= 32768;
         this.thumbsUpCount_ = value;
         this.onChanged();
         return this;
      }

      public Review.Builder clearThumbsUpCount() {
         this.bitField0_ &= -32769;
         this.thumbsUpCount_ = 0L;
         this.onChanged();
         return this;
      }

      public final Review.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (Review.Builder)super.setUnknownFields(unknownFields);
      }

      public final Review.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (Review.Builder)super.mergeUnknownFields(unknownFields);
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
