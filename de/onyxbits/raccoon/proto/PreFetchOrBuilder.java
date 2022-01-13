package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface PreFetchOrBuilder extends MessageOrBuilder {
   boolean hasUrl();

   String getUrl();

   ByteString getUrlBytes();

   boolean hasResponse();

   ByteString getResponse();

   boolean hasEtag();

   String getEtag();

   ByteString getEtagBytes();

   boolean hasTtl();

   long getTtl();

   boolean hasSoftTtl();

   long getSoftTtl();

   boolean hasPreFetchData();

   PreFetchData getPreFetchData();

   PreFetchDataOrBuilder getPreFetchDataOrBuilder();
}
