package de.onyxbits.raccoon.proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface SearchResponseOrBuilder extends MessageOrBuilder {
   List getDocList();

   DocV2 getDoc(int var1);

   int getDocCount();

   List getDocOrBuilderList();

   DocV2OrBuilder getDocOrBuilder(int var1);
}
