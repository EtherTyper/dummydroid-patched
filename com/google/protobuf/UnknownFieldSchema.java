package com.google.protobuf;

import java.io.IOException;

abstract class UnknownFieldSchema {
   abstract boolean shouldDiscardUnknownFields(Reader var1);

   abstract void addVarint(Object var1, int var2, long var3);

   abstract void addFixed32(Object var1, int var2, int var3);

   abstract void addFixed64(Object var1, int var2, long var3);

   abstract void addLengthDelimited(Object var1, int var2, ByteString var3);

   abstract void addGroup(Object var1, int var2, Object var3);

   abstract Object newBuilder();

   abstract Object toImmutable(Object var1);

   abstract void setToMessage(Object var1, Object var2);

   abstract Object getFromMessage(Object var1);

   abstract Object getBuilderFromMessage(Object var1);

   abstract void setBuilderToMessage(Object var1, Object var2);

   abstract void makeImmutable(Object var1);

   final boolean mergeOneFieldFrom(Object unknownFields, Reader reader) throws IOException {
      int tag = reader.getTag();
      int fieldNumber = WireFormat.getTagFieldNumber(tag);
      switch(WireFormat.getTagWireType(tag)) {
      case 0:
         this.addVarint(unknownFields, fieldNumber, reader.readInt64());
         return true;
      case 1:
         this.addFixed64(unknownFields, fieldNumber, reader.readFixed64());
         return true;
      case 2:
         this.addLengthDelimited(unknownFields, fieldNumber, reader.readBytes());
         return true;
      case 3:
         Object subFields = this.newBuilder();
         int endGroupTag = WireFormat.makeTag(fieldNumber, 4);
         this.mergeFrom(subFields, reader);
         if (endGroupTag != reader.getTag()) {
            throw InvalidProtocolBufferException.invalidEndTag();
         }

         this.addGroup(unknownFields, fieldNumber, this.toImmutable(subFields));
         return true;
      case 4:
         return false;
      case 5:
         this.addFixed32(unknownFields, fieldNumber, reader.readFixed32());
         return true;
      default:
         throw InvalidProtocolBufferException.invalidWireType();
      }
   }

   final void mergeFrom(Object unknownFields, Reader reader) throws IOException {
      while(reader.getFieldNumber() != Integer.MAX_VALUE && this.mergeOneFieldFrom(unknownFields, reader)) {
      }

   }

   abstract void writeTo(Object var1, Writer var2) throws IOException;

   abstract void writeAsMessageSetTo(Object var1, Writer var2) throws IOException;

   abstract Object merge(Object var1, Object var2);

   abstract int getSerializedSizeAsMessageSet(Object var1);

   abstract int getSerializedSize(Object var1);
}
