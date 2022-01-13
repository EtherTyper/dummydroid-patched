package com.google.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

abstract class BinaryReader implements Reader {
   private static final int FIXED32_MULTIPLE_MASK = 3;
   private static final int FIXED64_MULTIPLE_MASK = 7;

   public static BinaryReader newInstance(ByteBuffer buffer, boolean bufferIsImmutable) {
      if (buffer.hasArray()) {
         return new BinaryReader.SafeHeapReader(buffer, bufferIsImmutable);
      } else {
         throw new IllegalArgumentException("Direct buffers not yet supported");
      }
   }

   private BinaryReader() {
   }

   public abstract int getTotalBytesRead();

   public boolean shouldDiscardUnknownFields() {
      return false;
   }

   // $FF: synthetic method
   BinaryReader(Object x0) {
      this();
   }

   private static final class SafeHeapReader extends BinaryReader {
      private final boolean bufferIsImmutable;
      private final byte[] buffer;
      private int pos;
      private final int initialPos;
      private int limit;
      private int tag;
      private int endGroupTag;

      public SafeHeapReader(ByteBuffer bytebuf, boolean bufferIsImmutable) {
         super(null);
         this.bufferIsImmutable = bufferIsImmutable;
         this.buffer = bytebuf.array();
         this.initialPos = this.pos = bytebuf.arrayOffset() + bytebuf.position();
         this.limit = bytebuf.arrayOffset() + bytebuf.limit();
      }

      private boolean isAtEnd() {
         return this.pos == this.limit;
      }

      public int getTotalBytesRead() {
         return this.pos - this.initialPos;
      }

      public int getFieldNumber() throws IOException {
         if (this.isAtEnd()) {
            return Integer.MAX_VALUE;
         } else {
            this.tag = this.readVarint32();
            return this.tag == this.endGroupTag ? Integer.MAX_VALUE : WireFormat.getTagFieldNumber(this.tag);
         }
      }

      public int getTag() {
         return this.tag;
      }

      public boolean skipField() throws IOException {
         if (!this.isAtEnd() && this.tag != this.endGroupTag) {
            switch(WireFormat.getTagWireType(this.tag)) {
            case 0:
               this.skipVarint();
               return true;
            case 1:
               this.skipBytes(8);
               return true;
            case 2:
               this.skipBytes(this.readVarint32());
               return true;
            case 3:
               this.skipGroup();
               return true;
            case 4:
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            case 5:
               this.skipBytes(4);
               return true;
            }
         } else {
            return false;
         }
      }

      public double readDouble() throws IOException {
         this.requireWireType(1);
         return Double.longBitsToDouble(this.readLittleEndian64());
      }

      public float readFloat() throws IOException {
         this.requireWireType(5);
         return Float.intBitsToFloat(this.readLittleEndian32());
      }

      public long readUInt64() throws IOException {
         this.requireWireType(0);
         return this.readVarint64();
      }

      public long readInt64() throws IOException {
         this.requireWireType(0);
         return this.readVarint64();
      }

      public int readInt32() throws IOException {
         this.requireWireType(0);
         return this.readVarint32();
      }

      public long readFixed64() throws IOException {
         this.requireWireType(1);
         return this.readLittleEndian64();
      }

      public int readFixed32() throws IOException {
         this.requireWireType(5);
         return this.readLittleEndian32();
      }

      public boolean readBool() throws IOException {
         this.requireWireType(0);
         return this.readVarint32() != 0;
      }

      public String readString() throws IOException {
         return this.readStringInternal(false);
      }

      public String readStringRequireUtf8() throws IOException {
         return this.readStringInternal(true);
      }

      public String readStringInternal(boolean requireUtf8) throws IOException {
         this.requireWireType(2);
         int size = this.readVarint32();
         if (size == 0) {
            return "";
         } else {
            this.requireBytes(size);
            if (requireUtf8 && !Utf8.isValidUtf8(this.buffer, this.pos, this.pos + size)) {
               throw InvalidProtocolBufferException.invalidUtf8();
            } else {
               String result = new String(this.buffer, this.pos, size, Internal.UTF_8);
               this.pos += size;
               return result;
            }
         }
      }

      public Object readMessage(Class clazz, ExtensionRegistryLite extensionRegistry) throws IOException {
         this.requireWireType(2);
         return this.readMessage(Protobuf.getInstance().schemaFor(clazz), extensionRegistry);
      }

      public Object readMessageBySchemaWithCheck(Schema schema, ExtensionRegistryLite extensionRegistry) throws IOException {
         this.requireWireType(2);
         return this.readMessage(schema, extensionRegistry);
      }

      private Object readMessage(Schema schema, ExtensionRegistryLite extensionRegistry) throws IOException {
         int size = this.readVarint32();
         this.requireBytes(size);
         int prevLimit = this.limit;
         int newLimit = this.pos + size;
         this.limit = newLimit;

         Object var7;
         try {
            Object message = schema.newInstance();
            schema.mergeFrom(message, this, extensionRegistry);
            schema.makeImmutable(message);
            if (this.pos != newLimit) {
               throw InvalidProtocolBufferException.parseFailure();
            }

            var7 = message;
         } finally {
            this.limit = prevLimit;
         }

         return var7;
      }

      public Object readGroup(Class clazz, ExtensionRegistryLite extensionRegistry) throws IOException {
         this.requireWireType(3);
         return this.readGroup(Protobuf.getInstance().schemaFor(clazz), extensionRegistry);
      }

      public Object readGroupBySchemaWithCheck(Schema schema, ExtensionRegistryLite extensionRegistry) throws IOException {
         this.requireWireType(3);
         return this.readGroup(schema, extensionRegistry);
      }

      private Object readGroup(Schema schema, ExtensionRegistryLite extensionRegistry) throws IOException {
         int prevEndGroupTag = this.endGroupTag;
         this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);

         Object var5;
         try {
            Object message = schema.newInstance();
            schema.mergeFrom(message, this, extensionRegistry);
            schema.makeImmutable(message);
            if (this.tag != this.endGroupTag) {
               throw InvalidProtocolBufferException.parseFailure();
            }

            var5 = message;
         } finally {
            this.endGroupTag = prevEndGroupTag;
         }

         return var5;
      }

      public ByteString readBytes() throws IOException {
         this.requireWireType(2);
         int size = this.readVarint32();
         if (size == 0) {
            return ByteString.EMPTY;
         } else {
            this.requireBytes(size);
            ByteString bytes = this.bufferIsImmutable ? ByteString.wrap(this.buffer, this.pos, size) : ByteString.copyFrom(this.buffer, this.pos, size);
            this.pos += size;
            return bytes;
         }
      }

      public int readUInt32() throws IOException {
         this.requireWireType(0);
         return this.readVarint32();
      }

      public int readEnum() throws IOException {
         this.requireWireType(0);
         return this.readVarint32();
      }

      public int readSFixed32() throws IOException {
         this.requireWireType(5);
         return this.readLittleEndian32();
      }

      public long readSFixed64() throws IOException {
         this.requireWireType(1);
         return this.readLittleEndian64();
      }

      public int readSInt32() throws IOException {
         this.requireWireType(0);
         return CodedInputStream.decodeZigZag32(this.readVarint32());
      }

      public long readSInt64() throws IOException {
         this.requireWireType(0);
         return CodedInputStream.decodeZigZag64(this.readVarint64());
      }

      public void readDoubleList(List target) throws IOException {
         int fieldEndPos;
         int prevPos;
         int prevPos;
         if (target instanceof DoubleArrayList) {
            DoubleArrayList plist = (DoubleArrayList)target;
            switch(WireFormat.getTagWireType(this.tag)) {
            case 1:
               int nextTag;
               do {
                  plist.addDouble(this.readDouble());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  nextTag = this.readVarint32();
               } while(nextTag == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               fieldEndPos = this.readVarint32();
               this.verifyPackedFixed64Length(fieldEndPos);
               prevPos = this.pos + fieldEndPos;

               while(this.pos < prevPos) {
                  plist.addDouble(Double.longBitsToDouble(this.readLittleEndian64_NoCheck()));
               }

               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         } else {
            switch(WireFormat.getTagWireType(this.tag)) {
            case 1:
               do {
                  target.add(this.readDouble());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  prevPos = this.readVarint32();
               } while(prevPos == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               int bytes = this.readVarint32();
               this.verifyPackedFixed64Length(bytes);
               fieldEndPos = this.pos + bytes;

               while(this.pos < fieldEndPos) {
                  target.add(Double.longBitsToDouble(this.readLittleEndian64_NoCheck()));
               }

               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         }
      }

      public void readFloatList(List target) throws IOException {
         int fieldEndPos;
         int prevPos;
         int prevPos;
         if (target instanceof FloatArrayList) {
            FloatArrayList plist = (FloatArrayList)target;
            switch(WireFormat.getTagWireType(this.tag)) {
            case 2:
               fieldEndPos = this.readVarint32();
               this.verifyPackedFixed32Length(fieldEndPos);
               prevPos = this.pos + fieldEndPos;

               while(this.pos < prevPos) {
                  plist.addFloat(Float.intBitsToFloat(this.readLittleEndian32_NoCheck()));
               }
               break;
            case 5:
               int nextTag;
               do {
                  plist.addFloat(this.readFloat());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  nextTag = this.readVarint32();
               } while(nextTag == this.tag);

               this.pos = prevPos;
               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         } else {
            switch(WireFormat.getTagWireType(this.tag)) {
            case 2:
               int bytes = this.readVarint32();
               this.verifyPackedFixed32Length(bytes);
               fieldEndPos = this.pos + bytes;

               while(this.pos < fieldEndPos) {
                  target.add(Float.intBitsToFloat(this.readLittleEndian32_NoCheck()));
               }
               break;
            case 5:
               do {
                  target.add(this.readFloat());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  prevPos = this.readVarint32();
               } while(prevPos == this.tag);

               this.pos = prevPos;
               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         }

      }

      public void readUInt64List(List target) throws IOException {
         int fieldEndPos;
         int prevPos;
         int prevPos;
         if (target instanceof LongArrayList) {
            LongArrayList plist = (LongArrayList)target;
            switch(WireFormat.getTagWireType(this.tag)) {
            case 0:
               int nextTag;
               do {
                  plist.addLong(this.readUInt64());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  nextTag = this.readVarint32();
               } while(nextTag == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               fieldEndPos = this.readVarint32();
               prevPos = this.pos + fieldEndPos;

               while(this.pos < prevPos) {
                  plist.addLong(this.readVarint64());
               }

               this.requirePosition(prevPos);
               break;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         } else {
            switch(WireFormat.getTagWireType(this.tag)) {
            case 0:
               do {
                  target.add(this.readUInt64());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  prevPos = this.readVarint32();
               } while(prevPos == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               int bytes = this.readVarint32();
               fieldEndPos = this.pos + bytes;

               while(this.pos < fieldEndPos) {
                  target.add(this.readVarint64());
               }

               this.requirePosition(fieldEndPos);
               break;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         }

      }

      public void readInt64List(List target) throws IOException {
         int fieldEndPos;
         int prevPos;
         int prevPos;
         if (target instanceof LongArrayList) {
            LongArrayList plist = (LongArrayList)target;
            switch(WireFormat.getTagWireType(this.tag)) {
            case 0:
               int nextTag;
               do {
                  plist.addLong(this.readInt64());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  nextTag = this.readVarint32();
               } while(nextTag == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               fieldEndPos = this.readVarint32();
               prevPos = this.pos + fieldEndPos;

               while(this.pos < prevPos) {
                  plist.addLong(this.readVarint64());
               }

               this.requirePosition(prevPos);
               break;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         } else {
            switch(WireFormat.getTagWireType(this.tag)) {
            case 0:
               do {
                  target.add(this.readInt64());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  prevPos = this.readVarint32();
               } while(prevPos == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               int bytes = this.readVarint32();
               fieldEndPos = this.pos + bytes;

               while(this.pos < fieldEndPos) {
                  target.add(this.readVarint64());
               }

               this.requirePosition(fieldEndPos);
               break;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         }

      }

      public void readInt32List(List target) throws IOException {
         int fieldEndPos;
         int prevPos;
         int prevPos;
         if (target instanceof IntArrayList) {
            IntArrayList plist = (IntArrayList)target;
            switch(WireFormat.getTagWireType(this.tag)) {
            case 0:
               int nextTag;
               do {
                  plist.addInt(this.readInt32());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  nextTag = this.readVarint32();
               } while(nextTag == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               fieldEndPos = this.readVarint32();
               prevPos = this.pos + fieldEndPos;

               while(this.pos < prevPos) {
                  plist.addInt(this.readVarint32());
               }

               this.requirePosition(prevPos);
               break;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         } else {
            switch(WireFormat.getTagWireType(this.tag)) {
            case 0:
               do {
                  target.add(this.readInt32());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  prevPos = this.readVarint32();
               } while(prevPos == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               int bytes = this.readVarint32();
               fieldEndPos = this.pos + bytes;

               while(this.pos < fieldEndPos) {
                  target.add(this.readVarint32());
               }

               this.requirePosition(fieldEndPos);
               break;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         }

      }

      public void readFixed64List(List target) throws IOException {
         int fieldEndPos;
         int prevPos;
         int prevPos;
         if (target instanceof LongArrayList) {
            LongArrayList plist = (LongArrayList)target;
            switch(WireFormat.getTagWireType(this.tag)) {
            case 1:
               int nextTag;
               do {
                  plist.addLong(this.readFixed64());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  nextTag = this.readVarint32();
               } while(nextTag == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               fieldEndPos = this.readVarint32();
               this.verifyPackedFixed64Length(fieldEndPos);
               prevPos = this.pos + fieldEndPos;

               while(this.pos < prevPos) {
                  plist.addLong(this.readLittleEndian64_NoCheck());
               }

               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         } else {
            switch(WireFormat.getTagWireType(this.tag)) {
            case 1:
               do {
                  target.add(this.readFixed64());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  prevPos = this.readVarint32();
               } while(prevPos == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               int bytes = this.readVarint32();
               this.verifyPackedFixed64Length(bytes);
               fieldEndPos = this.pos + bytes;

               while(this.pos < fieldEndPos) {
                  target.add(this.readLittleEndian64_NoCheck());
               }

               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         }
      }

      public void readFixed32List(List target) throws IOException {
         int fieldEndPos;
         int prevPos;
         int prevPos;
         if (target instanceof IntArrayList) {
            IntArrayList plist = (IntArrayList)target;
            switch(WireFormat.getTagWireType(this.tag)) {
            case 2:
               fieldEndPos = this.readVarint32();
               this.verifyPackedFixed32Length(fieldEndPos);
               prevPos = this.pos + fieldEndPos;

               while(this.pos < prevPos) {
                  plist.addInt(this.readLittleEndian32_NoCheck());
               }
               break;
            case 5:
               int nextTag;
               do {
                  plist.addInt(this.readFixed32());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  nextTag = this.readVarint32();
               } while(nextTag == this.tag);

               this.pos = prevPos;
               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         } else {
            switch(WireFormat.getTagWireType(this.tag)) {
            case 2:
               int bytes = this.readVarint32();
               this.verifyPackedFixed32Length(bytes);
               fieldEndPos = this.pos + bytes;

               while(this.pos < fieldEndPos) {
                  target.add(this.readLittleEndian32_NoCheck());
               }
               break;
            case 5:
               do {
                  target.add(this.readFixed32());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  prevPos = this.readVarint32();
               } while(prevPos == this.tag);

               this.pos = prevPos;
               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         }

      }

      public void readBoolList(List target) throws IOException {
         int fieldEndPos;
         int prevPos;
         int prevPos;
         if (target instanceof BooleanArrayList) {
            BooleanArrayList plist = (BooleanArrayList)target;
            switch(WireFormat.getTagWireType(this.tag)) {
            case 0:
               int nextTag;
               do {
                  plist.addBoolean(this.readBool());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  nextTag = this.readVarint32();
               } while(nextTag == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               fieldEndPos = this.readVarint32();
               prevPos = this.pos + fieldEndPos;

               while(this.pos < prevPos) {
                  plist.addBoolean(this.readVarint32() != 0);
               }

               this.requirePosition(prevPos);
               break;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         } else {
            switch(WireFormat.getTagWireType(this.tag)) {
            case 0:
               do {
                  target.add(this.readBool());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  prevPos = this.readVarint32();
               } while(prevPos == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               int bytes = this.readVarint32();
               fieldEndPos = this.pos + bytes;

               while(this.pos < fieldEndPos) {
                  target.add(this.readVarint32() != 0);
               }

               this.requirePosition(fieldEndPos);
               break;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         }

      }

      public void readStringList(List target) throws IOException {
         this.readStringListInternal(target, false);
      }

      public void readStringListRequireUtf8(List target) throws IOException {
         this.readStringListInternal(target, true);
      }

      public void readStringListInternal(List target, boolean requireUtf8) throws IOException {
         if (WireFormat.getTagWireType(this.tag) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
         } else {
            int prevPos;
            if (target instanceof LazyStringList && !requireUtf8) {
               LazyStringList lazyList = (LazyStringList)target;

               int nextTag;
               do {
                  lazyList.add(this.readBytes());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  nextTag = this.readVarint32();
               } while(nextTag == this.tag);

               this.pos = prevPos;
            } else {
               int prevPos;
               do {
                  target.add(this.readStringInternal(requireUtf8));
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  prevPos = this.readVarint32();
               } while(prevPos == this.tag);

               this.pos = prevPos;
            }
         }
      }

      public void readMessageList(List target, Class targetType, ExtensionRegistryLite extensionRegistry) throws IOException {
         Schema schema = Protobuf.getInstance().schemaFor(targetType);
         this.readMessageList(target, schema, extensionRegistry);
      }

      public void readMessageList(List target, Schema schema, ExtensionRegistryLite extensionRegistry) throws IOException {
         if (WireFormat.getTagWireType(this.tag) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
         } else {
            int listTag = this.tag;

            int prevPos;
            int nextTag;
            do {
               target.add(this.readMessage(schema, extensionRegistry));
               if (this.isAtEnd()) {
                  return;
               }

               prevPos = this.pos;
               nextTag = this.readVarint32();
            } while(nextTag == listTag);

            this.pos = prevPos;
         }
      }

      public void readGroupList(List target, Class targetType, ExtensionRegistryLite extensionRegistry) throws IOException {
         Schema schema = Protobuf.getInstance().schemaFor(targetType);
         this.readGroupList(target, schema, extensionRegistry);
      }

      public void readGroupList(List target, Schema schema, ExtensionRegistryLite extensionRegistry) throws IOException {
         if (WireFormat.getTagWireType(this.tag) != 3) {
            throw InvalidProtocolBufferException.invalidWireType();
         } else {
            int listTag = this.tag;

            int prevPos;
            int nextTag;
            do {
               target.add(this.readGroup(schema, extensionRegistry));
               if (this.isAtEnd()) {
                  return;
               }

               prevPos = this.pos;
               nextTag = this.readVarint32();
            } while(nextTag == listTag);

            this.pos = prevPos;
         }
      }

      public void readBytesList(List target) throws IOException {
         if (WireFormat.getTagWireType(this.tag) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
         } else {
            int prevPos;
            int nextTag;
            do {
               target.add(this.readBytes());
               if (this.isAtEnd()) {
                  return;
               }

               prevPos = this.pos;
               nextTag = this.readVarint32();
            } while(nextTag == this.tag);

            this.pos = prevPos;
         }
      }

      public void readUInt32List(List target) throws IOException {
         int fieldEndPos;
         int prevPos;
         int prevPos;
         if (target instanceof IntArrayList) {
            IntArrayList plist = (IntArrayList)target;
            switch(WireFormat.getTagWireType(this.tag)) {
            case 0:
               int nextTag;
               do {
                  plist.addInt(this.readUInt32());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  nextTag = this.readVarint32();
               } while(nextTag == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               fieldEndPos = this.readVarint32();
               prevPos = this.pos + fieldEndPos;

               while(this.pos < prevPos) {
                  plist.addInt(this.readVarint32());
               }

               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         } else {
            switch(WireFormat.getTagWireType(this.tag)) {
            case 0:
               do {
                  target.add(this.readUInt32());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  prevPos = this.readVarint32();
               } while(prevPos == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               int bytes = this.readVarint32();
               fieldEndPos = this.pos + bytes;

               while(this.pos < fieldEndPos) {
                  target.add(this.readVarint32());
               }

               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         }
      }

      public void readEnumList(List target) throws IOException {
         int fieldEndPos;
         int prevPos;
         int prevPos;
         if (target instanceof IntArrayList) {
            IntArrayList plist = (IntArrayList)target;
            switch(WireFormat.getTagWireType(this.tag)) {
            case 0:
               int nextTag;
               do {
                  plist.addInt(this.readEnum());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  nextTag = this.readVarint32();
               } while(nextTag == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               fieldEndPos = this.readVarint32();
               prevPos = this.pos + fieldEndPos;

               while(this.pos < prevPos) {
                  plist.addInt(this.readVarint32());
               }

               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         } else {
            switch(WireFormat.getTagWireType(this.tag)) {
            case 0:
               do {
                  target.add(this.readEnum());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  prevPos = this.readVarint32();
               } while(prevPos == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               int bytes = this.readVarint32();
               fieldEndPos = this.pos + bytes;

               while(this.pos < fieldEndPos) {
                  target.add(this.readVarint32());
               }

               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         }
      }

      public void readSFixed32List(List target) throws IOException {
         int fieldEndPos;
         int prevPos;
         int prevPos;
         if (target instanceof IntArrayList) {
            IntArrayList plist = (IntArrayList)target;
            switch(WireFormat.getTagWireType(this.tag)) {
            case 2:
               fieldEndPos = this.readVarint32();
               this.verifyPackedFixed32Length(fieldEndPos);
               prevPos = this.pos + fieldEndPos;

               while(this.pos < prevPos) {
                  plist.addInt(this.readLittleEndian32_NoCheck());
               }
               break;
            case 5:
               int nextTag;
               do {
                  plist.addInt(this.readSFixed32());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  nextTag = this.readVarint32();
               } while(nextTag == this.tag);

               this.pos = prevPos;
               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         } else {
            switch(WireFormat.getTagWireType(this.tag)) {
            case 2:
               int bytes = this.readVarint32();
               this.verifyPackedFixed32Length(bytes);
               fieldEndPos = this.pos + bytes;

               while(this.pos < fieldEndPos) {
                  target.add(this.readLittleEndian32_NoCheck());
               }
               break;
            case 5:
               do {
                  target.add(this.readSFixed32());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  prevPos = this.readVarint32();
               } while(prevPos == this.tag);

               this.pos = prevPos;
               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         }

      }

      public void readSFixed64List(List target) throws IOException {
         int fieldEndPos;
         int prevPos;
         int prevPos;
         if (target instanceof LongArrayList) {
            LongArrayList plist = (LongArrayList)target;
            switch(WireFormat.getTagWireType(this.tag)) {
            case 1:
               int nextTag;
               do {
                  plist.addLong(this.readSFixed64());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  nextTag = this.readVarint32();
               } while(nextTag == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               fieldEndPos = this.readVarint32();
               this.verifyPackedFixed64Length(fieldEndPos);
               prevPos = this.pos + fieldEndPos;

               while(this.pos < prevPos) {
                  plist.addLong(this.readLittleEndian64_NoCheck());
               }

               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         } else {
            switch(WireFormat.getTagWireType(this.tag)) {
            case 1:
               do {
                  target.add(this.readSFixed64());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  prevPos = this.readVarint32();
               } while(prevPos == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               int bytes = this.readVarint32();
               this.verifyPackedFixed64Length(bytes);
               fieldEndPos = this.pos + bytes;

               while(this.pos < fieldEndPos) {
                  target.add(this.readLittleEndian64_NoCheck());
               }

               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         }
      }

      public void readSInt32List(List target) throws IOException {
         int fieldEndPos;
         int prevPos;
         int prevPos;
         if (target instanceof IntArrayList) {
            IntArrayList plist = (IntArrayList)target;
            switch(WireFormat.getTagWireType(this.tag)) {
            case 0:
               int nextTag;
               do {
                  plist.addInt(this.readSInt32());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  nextTag = this.readVarint32();
               } while(nextTag == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               fieldEndPos = this.readVarint32();
               prevPos = this.pos + fieldEndPos;

               while(this.pos < prevPos) {
                  plist.addInt(CodedInputStream.decodeZigZag32(this.readVarint32()));
               }

               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         } else {
            switch(WireFormat.getTagWireType(this.tag)) {
            case 0:
               do {
                  target.add(this.readSInt32());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  prevPos = this.readVarint32();
               } while(prevPos == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               int bytes = this.readVarint32();
               fieldEndPos = this.pos + bytes;

               while(this.pos < fieldEndPos) {
                  target.add(CodedInputStream.decodeZigZag32(this.readVarint32()));
               }

               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         }
      }

      public void readSInt64List(List target) throws IOException {
         int fieldEndPos;
         int prevPos;
         int prevPos;
         if (target instanceof LongArrayList) {
            LongArrayList plist = (LongArrayList)target;
            switch(WireFormat.getTagWireType(this.tag)) {
            case 0:
               int nextTag;
               do {
                  plist.addLong(this.readSInt64());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  nextTag = this.readVarint32();
               } while(nextTag == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               fieldEndPos = this.readVarint32();
               prevPos = this.pos + fieldEndPos;

               while(this.pos < prevPos) {
                  plist.addLong(CodedInputStream.decodeZigZag64(this.readVarint64()));
               }

               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         } else {
            switch(WireFormat.getTagWireType(this.tag)) {
            case 0:
               do {
                  target.add(this.readSInt64());
                  if (this.isAtEnd()) {
                     return;
                  }

                  prevPos = this.pos;
                  prevPos = this.readVarint32();
               } while(prevPos == this.tag);

               this.pos = prevPos;
               return;
            case 2:
               int bytes = this.readVarint32();
               fieldEndPos = this.pos + bytes;

               while(this.pos < fieldEndPos) {
                  target.add(CodedInputStream.decodeZigZag64(this.readVarint64()));
               }

               return;
            default:
               throw InvalidProtocolBufferException.invalidWireType();
            }
         }
      }

      public void readMap(Map target, MapEntryLite.Metadata metadata, ExtensionRegistryLite extensionRegistry) throws IOException {
         this.requireWireType(2);
         int size = this.readVarint32();
         this.requireBytes(size);
         int prevLimit = this.limit;
         int newLimit = this.pos + size;
         this.limit = newLimit;

         try {
            Object key = metadata.defaultKey;
            Object value = metadata.defaultValue;

            while(true) {
               int number = this.getFieldNumber();
               if (number == Integer.MAX_VALUE) {
                  target.put(key, value);
                  return;
               }

               try {
                  switch(number) {
                  case 1:
                     key = this.readField(metadata.keyType, (Class)null, (ExtensionRegistryLite)null);
                     break;
                  case 2:
                     value = this.readField(metadata.valueType, metadata.defaultValue.getClass(), extensionRegistry);
                     break;
                  default:
                     if (!this.skipField()) {
                        throw new InvalidProtocolBufferException("Unable to parse map entry.");
                     }
                  }
               } catch (InvalidProtocolBufferException.InvalidWireTypeException var14) {
                  if (!this.skipField()) {
                     throw new InvalidProtocolBufferException("Unable to parse map entry.");
                  }
               }
            }
         } finally {
            this.limit = prevLimit;
         }
      }

      private Object readField(WireFormat.FieldType fieldType, Class messageType, ExtensionRegistryLite extensionRegistry) throws IOException {
         switch(fieldType) {
         case BOOL:
            return this.readBool();
         case BYTES:
            return this.readBytes();
         case DOUBLE:
            return this.readDouble();
         case ENUM:
            return this.readEnum();
         case FIXED32:
            return this.readFixed32();
         case FIXED64:
            return this.readFixed64();
         case FLOAT:
            return this.readFloat();
         case INT32:
            return this.readInt32();
         case INT64:
            return this.readInt64();
         case MESSAGE:
            return this.readMessage(messageType, extensionRegistry);
         case SFIXED32:
            return this.readSFixed32();
         case SFIXED64:
            return this.readSFixed64();
         case SINT32:
            return this.readSInt32();
         case SINT64:
            return this.readSInt64();
         case STRING:
            return this.readStringRequireUtf8();
         case UINT32:
            return this.readUInt32();
         case UINT64:
            return this.readUInt64();
         default:
            throw new RuntimeException("unsupported field type.");
         }
      }

      private int readVarint32() throws IOException {
         int i = this.pos;
         if (this.limit == this.pos) {
            throw InvalidProtocolBufferException.truncatedMessage();
         } else {
            byte x;
            if ((x = this.buffer[i++]) >= 0) {
               this.pos = i;
               return x;
            } else if (this.limit - i < 9) {
               return (int)this.readVarint64SlowPath();
            } else {
               int x;
               if ((x = x ^ this.buffer[i++] << 7) < 0) {
                  x ^= -128;
               } else if ((x ^= this.buffer[i++] << 14) >= 0) {
                  x ^= 16256;
               } else if ((x ^= this.buffer[i++] << 21) < 0) {
                  x ^= -2080896;
               } else {
                  int y = this.buffer[i++];
                  x ^= y << 28;
                  x ^= 266354560;
                  if (y < 0 && this.buffer[i++] < 0 && this.buffer[i++] < 0 && this.buffer[i++] < 0 && this.buffer[i++] < 0 && this.buffer[i++] < 0) {
                     throw InvalidProtocolBufferException.malformedVarint();
                  }
               }

               this.pos = i;
               return x;
            }
         }
      }

      public long readVarint64() throws IOException {
         int i = this.pos;
         if (this.limit == i) {
            throw InvalidProtocolBufferException.truncatedMessage();
         } else {
            byte[] buffer = this.buffer;
            byte y;
            if ((y = buffer[i++]) >= 0) {
               this.pos = i;
               return (long)y;
            } else if (this.limit - i < 9) {
               return this.readVarint64SlowPath();
            } else {
               long x;
               int y;
               if ((y = y ^ buffer[i++] << 7) < 0) {
                  x = (long)(y ^ -128);
               } else if ((y ^= buffer[i++] << 14) >= 0) {
                  x = (long)(y ^ 16256);
               } else if ((y ^= buffer[i++] << 21) < 0) {
                  x = (long)(y ^ -2080896);
               } else if ((x = (long)y ^ (long)buffer[i++] << 28) >= 0L) {
                  x ^= 266354560L;
               } else if ((x ^= (long)buffer[i++] << 35) < 0L) {
                  x ^= -34093383808L;
               } else if ((x ^= (long)buffer[i++] << 42) >= 0L) {
                  x ^= 4363953127296L;
               } else if ((x ^= (long)buffer[i++] << 49) < 0L) {
                  x ^= -558586000294016L;
               } else {
                  x ^= (long)buffer[i++] << 56;
                  x ^= 71499008037633920L;
                  if (x < 0L && (long)buffer[i++] < 0L) {
                     throw InvalidProtocolBufferException.malformedVarint();
                  }
               }

               this.pos = i;
               return x;
            }
         }
      }

      private long readVarint64SlowPath() throws IOException {
         long result = 0L;

         for(int shift = 0; shift < 64; shift += 7) {
            byte b = this.readByte();
            result |= (long)(b & 127) << shift;
            if ((b & 128) == 0) {
               return result;
            }
         }

         throw InvalidProtocolBufferException.malformedVarint();
      }

      private byte readByte() throws IOException {
         if (this.pos == this.limit) {
            throw InvalidProtocolBufferException.truncatedMessage();
         } else {
            return this.buffer[this.pos++];
         }
      }

      private int readLittleEndian32() throws IOException {
         this.requireBytes(4);
         return this.readLittleEndian32_NoCheck();
      }

      private long readLittleEndian64() throws IOException {
         this.requireBytes(8);
         return this.readLittleEndian64_NoCheck();
      }

      private int readLittleEndian32_NoCheck() {
         int p = this.pos;
         byte[] buffer = this.buffer;
         this.pos = p + 4;
         return buffer[p] & 255 | (buffer[p + 1] & 255) << 8 | (buffer[p + 2] & 255) << 16 | (buffer[p + 3] & 255) << 24;
      }

      private long readLittleEndian64_NoCheck() {
         int p = this.pos;
         byte[] buffer = this.buffer;
         this.pos = p + 8;
         return (long)buffer[p] & 255L | ((long)buffer[p + 1] & 255L) << 8 | ((long)buffer[p + 2] & 255L) << 16 | ((long)buffer[p + 3] & 255L) << 24 | ((long)buffer[p + 4] & 255L) << 32 | ((long)buffer[p + 5] & 255L) << 40 | ((long)buffer[p + 6] & 255L) << 48 | ((long)buffer[p + 7] & 255L) << 56;
      }

      private void skipVarint() throws IOException {
         if (this.limit - this.pos >= 10) {
            byte[] buffer = this.buffer;
            int p = this.pos;

            for(int i = 0; i < 10; ++i) {
               if (buffer[p++] >= 0) {
                  this.pos = p;
                  return;
               }
            }
         }

         this.skipVarintSlowPath();
      }

      private void skipVarintSlowPath() throws IOException {
         for(int i = 0; i < 10; ++i) {
            if (this.readByte() >= 0) {
               return;
            }
         }

         throw InvalidProtocolBufferException.malformedVarint();
      }

      private void skipBytes(int size) throws IOException {
         this.requireBytes(size);
         this.pos += size;
      }

      private void skipGroup() throws IOException {
         int prevEndGroupTag = this.endGroupTag;
         this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);

         while(this.getFieldNumber() != Integer.MAX_VALUE && this.skipField()) {
         }

         if (this.tag != this.endGroupTag) {
            throw InvalidProtocolBufferException.parseFailure();
         } else {
            this.endGroupTag = prevEndGroupTag;
         }
      }

      private void requireBytes(int size) throws IOException {
         if (size < 0 || size > this.limit - this.pos) {
            throw InvalidProtocolBufferException.truncatedMessage();
         }
      }

      private void requireWireType(int requiredWireType) throws IOException {
         if (WireFormat.getTagWireType(this.tag) != requiredWireType) {
            throw InvalidProtocolBufferException.invalidWireType();
         }
      }

      private void verifyPackedFixed64Length(int bytes) throws IOException {
         this.requireBytes(bytes);
         if ((bytes & 7) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
         }
      }

      private void verifyPackedFixed32Length(int bytes) throws IOException {
         this.requireBytes(bytes);
         if ((bytes & 3) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
         }
      }

      private void requirePosition(int expectedPosition) throws IOException {
         if (this.pos != expectedPosition) {
            throw InvalidProtocolBufferException.truncatedMessage();
         }
      }
   }
}
