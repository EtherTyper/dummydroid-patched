package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface TestingProgramOptRequestOrBuilder extends MessageOrBuilder {
   boolean hasPackageName();

   String getPackageName();

   ByteString getPackageNameBytes();

   boolean hasSubscribe();

   boolean getSubscribe();
}
